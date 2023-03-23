import java.util.Scanner;

public class ED006 {
  public static void main(String[] args) {
    String nome = "Carlos";

    Scanner stdin = new Scanner(System.in);

    int n = stdin.nextInt();           //numero de jogos
    stdin.nextLine();

    for (int i=0; i<n; i++) {
      CircularLinkedList<String> list = new CircularLinkedList<String>();
      String line = stdin.nextLine();
      int w = (line.split(" ")).length; //numero de palavras
      int k = stdin.nextInt();

      for (int j=0; j<k; j++) {
        String kid = stdin.next();      //nomes
        Node<String> newNode = new Node<String>(kid, null);
        list.addLast(kid);
      }
      stdin.nextLine();

      while (k>1) {
        for (int a=0; a<w-1; a++)
          list.rotate();
        list.removeFirst();
        k--;
      }

      if (list.getFirst().equals(nome))
        System.out.println("O " + nome + " nao se livrou");
      else
        System.out.println("O " + nome + " livrou-se (coitado do " + list.getFirst() + "!)");
    }
  }
}
