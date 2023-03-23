import java.util.Scanner;

public class Estatisticas {

   public static int amplitude(int[] v) {
     int max = v[0];
     int min = v[0];
     int amplitude=0;

     for (int i=1; i<v.length; i++) {
       if(max < v[i])
        max = v[i];
       else if(min > v[i])
        min = v[i];
     }
     
     return amplitude = max - min;
   }

   public static double media(int[] v) {
     double soma=0, media=0;
     for (int i=0; i<v.length; i++)
       soma = soma + v[i];

     media = soma/(v.length);
     return media;
   }

   public static void main(String[] args) {

      Scanner stdin = new Scanner(System.in);

      int n = stdin.nextInt();
      int v[] = new int[n];

      for (int i=0; i<n; i++)
        v[i] = stdin.nextInt();

      System.out.printf("%.2f\n", media(v));
      System.out.println(amplitude(v));
   }
}
