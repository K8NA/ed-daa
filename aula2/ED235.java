
import java.util.Scanner;

class ED235 {

  public static void triangle(int a) {
    for (int i=0; i<a; i++) {
      for (int j=0; j<a-i; j++)
        System.out.print("#");
      for (int j=0; j<i; j++)
          System.out.print(".");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    int tam[] = new int[n];

    for (int i=0; i<n; i++) {
      tam[i] = in.nextInt();
    }

    for (int i=0; i<n; i++) {
      triangle(tam[i]);
    }

  }
}
