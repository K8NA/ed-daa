// Dado o estado de várias culturas de micróbios (indicados por uma matriz de células),
// descobrir qual o tamanho do maior micróbio em cada uma delas, ou seja,
// qual o tamanho do maior conjunto conexo de células em cada caso.

import java.util.*;
import java.io.*;

public class DAA026 {
   static int lin;
   static int col;
   static char matriz[][];
   static boolean visitado[][];

   //tam do segmento que inclui a celula (x,y)
   static int size (int x, int y) {
      if (x<0 || x>=lin || y<0 || y>=col) return 0; //fora dos limites
      if (matriz[x][y] == '.') return 0;            //celula vazia
      if (visitado[x][y]) return 0;                 //celula ja visitada
      int count = 1;                                //celula nao vazia
      visitado[x][y] = true;                        //marcar como visitada
       count += size(x-1, y);
       count += size(x-1, y+1);
       count += size(x-1, y-1);
       count += size(x+1, y);
       count += size(x+1, y+1);
       count += size(x+1, y-1);
       count += size(x, y+1);
       count += size(x, y-1);
      return count;
   }

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int max = 0;
      int n = in.nextInt(); //casos a considerar
      for (int k=0; k<n; k++) {
        lin = in.nextInt();
        col = in.nextInt();
        matriz   = new char[lin][col];
        visitado = new boolean[lin][col];
        for (int i=0; i<lin; i++)
          matriz[i] = in.next().toCharArray();
        for (int l=0; l<lin; l++) {
          for (int c=0; c<col; c++) {
            int cur = size(l,c);
            if (max < cur)
              max = cur;
          }
        }
        System.out.println(max);
        max = 0;
        for (int a=0; a<lin; a++)
          for (int b=0; b<col; b++)
            visitado[a][b] = false;
      }
    }
}
