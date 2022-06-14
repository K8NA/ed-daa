import java.util.*;
public class SieveOfEratosthenes {
    void sieveOfEratosthenes(int limit) {
      boolean[] output = new boolean[limit + 1];
      for (int x = 0; x <= limit; x++) {
         output[x] = true;
      }
      output[0] = false;
      output[1] = false;

      for (int i=2; i<=Math.pow(limit, 0.5); i++) {
       if (output[i] == true) {
         for (int j=(int)Math.pow(i, 2); j<=limit; j=j+i)
           output[j] = false;
       }
      }

      List<Integer> result = new ArrayList<Integer>();
      for (int i=0; i<output.length; i++) {
        if (output[i] == true)
          result.add(i);
      }
      System.out.println(Arrays.toString(result.toArray()));
    }

    public static void main(String[] args) {
        int n = 7;
        SieveOfEratosthenes g = new SieveOfEratosthenes();
        g.sieveOfEratosthenes(n);
        // should return [2, 3, 5, 7]
    }
}
