import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;

class ED240 {
    public static String[] paths(BTree<Integer> t) {
    	int min = min(t.getRoot());
    	LinkedList<String> tmp = new LinkedList<>();
    	paths(t.getRoot(), "", min, tmp);
    	String[] ans = new String[tmp.size()];
    	int pos = 0;
    	for (String s : tmp)
    	    ans[pos++] = s;
    	return ans;
   }

    private static int min(BTNode<Integer> n) {
    	if (n == null) return Integer.MAX_VALUE;
    	int tmp = Math.min(min(n.getLeft()), min(n.getRight()));
    	return Math.min(n.getValue(), tmp);
    }

    private static void paths(BTNode<Integer> n, String path, int min, LinkedList<String> tmp) {
    	if (n == null) return;
    	if (min == n.getValue()) {
    	    if (path.equals("")) tmp.add("R");
    	    else tmp.add(path);
      }
    	paths(n.getLeft(), path + "E", min, tmp);
    	paths(n.getRight(), path + "D", min, tmp);
    }

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	for (int i=0; i<n; i++) {
    	    BTree<Integer> t = LibBTree.readIntTree(in);
    	    System.out.println("paths = " + Arrays.toString(paths(t)));
	    }
    }
}
