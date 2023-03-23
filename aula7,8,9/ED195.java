
public class ED195 {

  public static boolean balanced(String s) {
    MyStack<Character> str = new LinkedListStack<Character>();
    for (int i=0; i<=(s.length()-1); i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == '[') {
        str.push(s.charAt(i));
      }
      if (s.charAt(i) == ')' || s.charAt(i) == ']') {
        if (str.top() == null) return false;
        if (s.charAt(i) == ')' && str.top() != '(')
          return false;
        if (s.charAt(i) == ']' && str.top() != '[')
          return false;
        str.pop();
      }
    }
    if (str.isEmpty())
      return true;
    else
      return false;
  }

  public static void main(String[] args) {

     System.out.println(balanced("([()])"));
     System.out.println(balanced("[()()]"));
     System.out.println(balanced("(()]"));
     System.out.println(balanced("[()[])"));
     System.out.println(balanced("[()[]"));

  }

}
