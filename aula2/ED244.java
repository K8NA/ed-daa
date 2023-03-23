import java.util.Scanner;

public class ED244 {
    public static int primos(int min, int max) {
        int[] num = new int[max + 1];
        int count = 0;

        for (int i=0; i<=max; i++)
          num[i] = 1;
        
        //crivo
        for (int k=2; k*k<=max; k++)
          if (num[k] == 1)
            for (int a = k*k; a <= max; a += k)
              num[a] = 0;

        //verificar no intervalo dado
        for (int b = min; b <= max; b++)
          if (num[b] == 1)
            count++;

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int min = in.nextInt();
        int max = in.nextInt();

        System.out.println(primos(min, max));
    }
}
