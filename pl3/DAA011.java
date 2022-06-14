/*Dado um conjunto de N distâncias, e P perguntas (queries),
cada uma indicando um número Ki de dias, calcular, para cada pergunta,
qual o caminho que minimiza a maior distância num único dia.
*/
import java.io.*;
import java.util.*;

public class DAA011 {
  public static boolean greedy (int v[], int n, int q, int max) {
    int i, j=0, sum=0, f=0;
    for (i=0; i<q; i++) {
      while (j < n && sum <= max) {
        sum = sum + v[j];
        j++;
        if (j == n && sum > max && i == (q-1)) //?? explain
          f = 1;
      }
      sum = 0; j--;
    }
    if (f == 1 || (i == q && j < n-1)) return false;
    else return true;
  }

  public static int bsearch (int v[], int n, int q) {
    int low = 1;
    int high = 0;
    int middle;
    for (int i=0; i<n; i++)
      high = high + v[i];

    while (low < high) {
      middle = low + (high - low) / 2;
      if (greedy(v, n, q, middle))
        high = middle;
      else
        low = middle + 1;
    }
    return low;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt(); //n de distancias
    int v[] = new int[n]; //array de distancias
    for (int i=0; i<n; i++) {
      v[i] = in.nextInt();
    }

    int q = in.nextInt(); //numero de queries
    int p[] = new int[q]; //array de particoes
    for (int j=0; j<q; j++) {
      p[j] = in.nextInt();
    }

    for (int i=0; i<q; i++) {
      System.out.println(bsearch(v, n, p[i]));
    }
  }
}
