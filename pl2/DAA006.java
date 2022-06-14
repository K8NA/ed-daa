/*Dadas as coordenadas de um quadrado e um círculo,
descobrir qual a área da zona da interseção entre eles.
*/

import java.util.Scanner;
import java.lang.Math.*;

public class DAA006 {

  public static double intersecao (double qx, double qy, double ql,
                                  double cx, double cy, double cr) {
    if ((qx + ql <= cx - cr) || (cx + cr <= qx) ||
        (cy - cr >= qy + ql) || (qy >= cy + cr))
      return 0;  //nao se intersetam

    if ((cx + cr <= qx + ql) && (cx - cr >= qx) &&
        (cy + cr <= qy + ql) && (cy - cr >= qy))
      return Math.PI * cr * cr;  //circulo está dentro do quadrado

    if (Math.sqrt((qx - cx)*(qx - cx) + (qy + ql - cy)*(qy + ql - cy)) <= cr &&
       Math.sqrt((qx + ql - cx)*(qx + ql - cx) + (qy + ql - cy)*(qy + ql - cy)) <= cr &&
       Math.sqrt((qx - cx)*(qx - cx) + (qy - cy)*(qy - cy)) <= cr &&
       Math.sqrt((qx + ql - cx)*(qx + ql - cx) + (qy - cy)*(qy - cy)) <= cr)
      return (ql * ql); //quadrado está dentro do circulo

    double area = 0;
    if (ql > 0.001)
      area = area + intersecao(qx, qy, ql/2, cx, cy, cr)
                  + intersecao(qx + ql/2, qy, ql/2, cx, cy, cr)
                  + intersecao(qx + ql/2, qy + ql/2, ql/2, cx, cy, cr)
                  + intersecao(qx, qy + ql/2, ql/2, cx, cy, cr);
    return area;
  }

  public static void main(String[] args) {
    FastScanner in = new FastScanner(System.in);
    int n = in.nextInt();
    double[] res = new double[n];

    for (int i=0; i<n; i++) {
        int qx = in.nextInt();
        int qy = in.nextInt();
        int ql = in.nextInt();
        int cx = in.nextInt();
        int cy = in.nextInt();
        int cr = in.nextInt();

        res[i] = intersecao(qx, qy, ql, cx, cy, cr);
    }

    for (int i=0; i<n; i++) {
      //FastPrint.out.format("%.4f", res[i]);
      FastPrint.out.println(res[i]);
    }
    FastPrint.out.close();
  }
}
