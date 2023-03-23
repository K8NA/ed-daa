import java.util.Scanner;

public class Losango {

    static void line(char a, char b, int n, int k) {
      //a - ponto, b - cardinal
      //n - numero de carateres
      //k - numero de cardinais
      int pontos = (n-k)/2;
      int i;
      //print ate ao meio da linha
      if(n != k) {
        for (i=0; i<(n/2); i++) {
          if(i<pontos) {
            System.out.print(a);
          } else {
            System.out.print(b);
          }
        }
        //print depois do meio
        for (i=n/2; i<n; i++) {
          if(i<n-pontos) {
            System.out.print(b);
          } else {
            System.out.print(a);
          }
        }
      } else { //print o cardinal do meio
        for (i=0; i<n; i++)
          System.out.print(b);
      }
      System.out.println("");
    }


    static void losango(int n) {
      int k=-1; //numero de cardinais
      for (int i=0; i<n; i++) {
        if (i<=n/2) {
          k += 2;
          line('.', '#', n, k);
        } else {
          k -= 2;
          line('.', '#', n, k);
        }
      }
    }


    public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);

      int N = stdin.nextInt();
      losango(N);
    }
}
