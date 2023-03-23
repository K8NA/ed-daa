import java.util.Scanner;

public class ReadNumbers {

   // Escrever os numeros guardados num array no stdout
   static void writeArray(int v[]) {
      for (int i=0; i<v.length; i++)
         System.out.println("v[" + i + "] = " + v[i]);
   }

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

   public static void main(String[] args) {

      Scanner stdin = new Scanner(System.in);

      int n = stdin.nextInt();   // Ler a quantidade de numeros que se seguem
      int v[] = new int[n];     // Cria um novo array com espaço para n inteiros

      for (int i=0; i<n; i++)    // Ler os numeros a partir do stdin
         v[i] = stdin.nextInt();

      writeArray(v);             // Chamar procedimento que escreve
      System.out.println(amplitude(v));
   }
}
