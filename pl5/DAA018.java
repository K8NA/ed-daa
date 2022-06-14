/*Dado um conjunto de N moedas e uma série de P perguntas,
cada uma indicando uma quantia Qi, indicar qual o menor número de moedas
necessário para fazer cada quantia, e quais as moedas a usar em cada caso.
*/
import java.io.*;
import java.util.*;

public class DAA018 {
  public static final int INF = 10001;

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();  //n de tipos de moedas
    int tipos[] = new int[n];
    for (int i=0; i<n; i++)
      tipos[i] = in.nextInt();

    int p = in.nextInt(); //n de perguntas
    int quant[] = new int[p];
    for (int i=0; i<p; i++)
      quant[i] = in.nextInt();  //quantia que queremos criar

    int coins[] = new int[INF]; //num minimo para criar uma quantia
    coins[0] = 0;

    int use[] = new int[INF]; //respostas
    int i, j;

    for (int l=0; l<p; l++) { //imprimir para cada pergunta (int l)
      for (i=1; i<=quant[l]; i++) {
        coins[i] = INF;
        for (j=0; j<n; j++) {
          if (tipos[j] <= i && ((1 + coins[i-tipos[j]]) < coins[i])) {
            coins[i] = 1 + coins[i-tipos[j]];
            use[i] = tipos[j];
          }
        }
      }
      //exemplo do formato: 13: [2] 5 8
      System.out.print(quant[l] + ": [" + coins[quant[l]] + "] ");
      int s = quant[l];
      for (int k=0; k<coins[quant[l]]; k++) {
        if (k == coins[quant[l]]-1)
          System.out.print(use[s]); //para nao ter spacebar depois do ult numero
        else
          System.out.print(use[s] + " ");
        s = s - use[s];
      }
      System.out.println();
    }
  }
}
