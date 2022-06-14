
import java.io.*;
import java.util.*;

public class Lottery {
  public static final int INF = 1000000;

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int tipos[] = {1,5,10,20,100};

    int n = in.nextInt();  //n dollars to withdraw

    int coins[] = new int[INF]; //num minimo para criar uma quantia
    coins[0] = 0;

    int i, j;

    for (i=1; i<=n; i++) {
      coins[i] = INF;
      for (j=0; j<tipos.length; j++) {
        if (tipos[j] <= i && ((1 + coins[i-tipos[j]]) < coins[i])) {
          coins[i] = 1 + coins[i-tipos[j]];
        }
      }
    }

    System.out.println(coins[n]);

  }
}
