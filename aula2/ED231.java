
import java.util.Scanner;


class ED231 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int dias = in.nextInt();
    int casos[] = new int[dias];

    for (int i=0; i<dias; i++)
      casos[i] = in.nextInt();

    int flag = in.nextInt();


    if (flag == 1) {

      int valor = casos[1]-casos[0];
      int menor = valor;
      int maior = valor;

      for (int i=2; i<dias; i++) {
        valor = casos[i]-casos[i-1];

        if (valor < menor)
          menor = valor;

        if (valor > maior)
          maior = valor;
      }

      System.out.print(menor + " " + maior + "\n");

    }


    else if (flag == 2) {
      int nper   =0;   // numero de periodos
      int maxtam =0; // maior tamanho de um periodo
      int per    =0;
      double subidas=0;
      for (int i=1; i<dias; i++) {
        subidas = ((double)(casos[i]) - (double)(casos[i-1])) / (double)(casos[i-1]);
        if (subidas <= 0.05) {
          per++;
        }
        else {
          if (per > 0) {
            nper++;
            if (maxtam < per)
              maxtam = per;
            per=0;
          }
        }
      }
      if (per > 0) { //in case the longer period is the last
        nper++;
        if (maxtam < per)
          maxtam = per;
        per=0;
      }

      System.out.print(nper + " " + maxtam + "\n");
    }


    else if (flag == 3) {
      int nhash=0;
      for (int i=casos[dias-1]/100; i>0; i--) { //altura, linhas
        for (int j=0; j<dias; ++j) { //colunas
          nhash = casos[j]/100;
          if (i<=nhash)
            System.out.print("#");
          else
            System.out.print(".");
        }
        System.out.println();
      }
    }

  }
}
