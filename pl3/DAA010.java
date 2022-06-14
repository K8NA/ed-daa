/* Dada um conjunto S de N números inteiros, e uma sequência de Q perguntas,
cada uma indicando um número Pi, descobrir qual é a soma de dois números
diferentes de S que está mais próxima do número Pi de cada pergunta.
*/
import java.io.*;
import java.util.*;

public class DAA010 {

  public static int upperBound(int somas[], int key, int low, int high) {
    int middle = 0;
    int max = high;
    while (low < high) {
      middle = low + (high - low) / 2;
      if (somas[middle] >= key)
        high = middle;
      else
        low = middle + 1;
    }
    if (low < max && somas[low] >= key)
      low++;
    if (low == 0)
      return somas[0];
    return somas[low-1];
  }

  public static int lowerBound(int somas[], int key, int low, int high) {
    int middle = 0;
    int max = high;
    while (low < high) {
      middle = low + (high - low) / 2;
      if (somas[middle] < key)
        low = middle + 1;
      else
        high = middle;
    }
    if (low < max && somas[low] <= key)
      low++;
    if (low == 0)
      return somas[0];
    return somas[low-1];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt(); //tamanho do conjunto
    int v[] = new int[n]; //numeros distinos a considerar
    for (int i=0; i<n; i++) {
      v[i] = in.nextInt();
    }

    int q = in.nextInt(); //n de perguntas
    int p[] = new int[q]; //num aos que queremos encontrar somas mais proximas
    for (int j=0; j<q; j++) {
      p[j] = in.nextInt();
    }

    int m = n*n; //num maximo de somas possiveis
    int temp[] = new int[m];
    int c=0;

    for (int i=0; i<n-1; i++) {
      for (int j=i+1; j<n; j++) {
        temp[c] = v[i] + v[j];
        c++; //numero final das combinacoes de somas
      }
    }

    int somas[] = new int[c]; //somas de cada par dos numeros
    for (int i=0; i<c; i++) {
      somas[i] = temp[i];
    }

    Arrays.sort(somas);
    int aux1, aux2;

    for(int i=0; i<q; i++) {
      aux1 = lowerBound(somas, p[i], 0, c);
      aux2 = upperBound(somas, p[i], 0, c);

      if (p[i]-aux1 < aux2-p[i])
        System.out.println(aux1);

      else if (p[i]-aux1 > aux2-p[i])
        System.out.println(aux2);

      else if ((p[i]-aux1 == aux2-p[i]) && (aux1 != aux2))
        System.out.println(aux1 + " " + aux2);

      else
        System.out.println(aux1);
    }
  }
}
