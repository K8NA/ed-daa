
import java.util.Scanner;

public class ED007 {

  public static int balanced(String s) {
    MyStack<Character> str = new LinkedListStack<Character>();
    int i;
    for (i=0; i<=(s.length()-1); i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == ')' || s.charAt(i) == ']') {
        if (s.charAt(i) == '(' || s.charAt(i) == '[') {
          str.push(s.charAt(i));
        }
        if (s.charAt(i) == ')' || s.charAt(i) == ']') {
          if (str.top() == null) return i;
          if (s.charAt(i) == ')' && str.top() != '(')
            return i;
          if (s.charAt(i) == ']' && str.top() != '[')
            return i;
          str.pop();
        }
      }
    }
    if (str.isEmpty())
      return -1;
    else
      return -2;
  }

  public static void main(String[] args) {

    Scanner stdin = new Scanner(System.in);

    int n = stdin.nextInt();
    stdin.nextLine();
    SinglyLinkedList<String> list = new SinglyLinkedList<String>();

    for (int i=0; i<n; i++) {
      list.addLast(stdin.nextLine());
    }

    for (int i=0; i<n; i++) {
      if (balanced(list.getFirst()) >= 0)
        System.out.println("Erro na posicao " + balanced(list.getFirst()));
      else if (balanced(list.getFirst()) == -2)
        System.out.println("Ficam parenteses por fechar");
      else
        System.out.println("Expressao bem formada");
      list.removeFirst();
    }

  }

}
