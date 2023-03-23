
import java.util.Scanner;

public class ED201 {

   static void sets(int v[], int dur, int best, int sum) {
      // array de booleanos para representar o conjunto
      boolean used[] = new boolean[v.length];
      System.out.println(goSets(0, v, used, dur, best, sum)); // chamar funcao recursiva

   }

   // Gera todos os subconjuntos a partir da posicao 'cur'
   static int goSets(int cur, int v[], boolean used[], int dur, int best, int sum) {
      if (cur == v.length) {  // Caso base: terminamos o conjunto
         for (int i=0; i<v.length; i++) {
            if (used[i])
              sum += v[i];
         }
         if (sum > best && sum <= dur) {
           best = sum;
         }
         sum = 0;
      } else {                  // Se nao terminamos, continuar a gerar
         used[cur] = true;      // Subconjuntos que incluem o elemento actual
         best = goSets(cur+1, v, used, dur, best, sum);// Chamada recursiva
         used[cur] = false;     // Subconjuntos que nao incluem o el. actual
         best = goSets(cur+1, v, used, dur, best, sum);// Chamada recursiva
      }
      return best;
   }


   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int dur = in.nextInt();          //duration of the trip
      int n = in.nextInt();            //n of songs
      int d_song[] = new int[n];       //duration of each song

      for (int i=0; i<n; i++) {
        d_song[i] = in.nextInt();
      }

      int best=0, sum=0;

      sets(d_song, dur, best, sum);
    }
}
