
import java.util.Scanner;

class ED243 {

  public static boolean safePizza(int[] a, int[] b) {
    for (int i=0; i<a.length; i++) {
      for (int j=0; j<b.length; j++) {
        if (a[i] == b[j])
          return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int safePizza=0;                 //n de pizzas aceitaveis
    int nIngBan = in.nextInt();      //n ingredientes banned
    int ingBan[] = new int[nIngBan]; //ingredientes banned
    for (int i=0; i<nIngBan; i++) {
      ingBan[i] = in.nextInt();
    }

    int nPizzas = in.nextInt();    //n pizzas
    for(int j=0; j<nPizzas; j++) {
      int nIng = in.nextInt();     //n ingredientes numa pizza
      int ing[] = new int[nIng]; //ingredientes duma pizza
      for (int t=0; t<nIng; t++) {
        ing[t] = in.nextInt();
      }
      if(safePizza(ingBan, ing)) safePizza++;
    }

    System.out.println(safePizza);
  }

}
