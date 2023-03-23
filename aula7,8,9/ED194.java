
public class ED194 {
  public static void reverse(MyStack<Integer> s, int n) {
    int[] elem = new int[n];

    for(int i=0; i<n; i++)
      elem[i] = s.pop();

    for(int j=0; j<n; j++)
      s.push(elem[j]);

  }

  public static void main(String[] args) {
     MyStack<Integer> s = new LinkedListStack<Integer>();

     for (int i=5; i>0; i--)
        s.push(i);
     System.out.println(s);
     reverse(s, 3);
     System.out.println(s);
  }

}
