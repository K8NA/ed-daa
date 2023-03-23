import java.util.Scanner;

public class Count {
   public static void main(String[] args) {

      Scanner stdin = new Scanner(System.in);

      // Ciclo para numerar as linhas do input
      // Usar .hasNext() e .next() para palavras separadas aka tokens
      int counter = 0;
      while (stdin.hasNextLine()) {
         counter++;
         String s = stdin.nextLine();
         System.out.println(counter + ": " + s);
      }
   }
}
