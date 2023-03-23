import java.util.Scanner;

class Matrix {
   char data[][]; // os elementos da matriz em si
   int rows;     // numero de linhas
   int cols;     // numero de colunas

   // construtor padrao de matriz
   Matrix(int r, int c) {
      data = new char[r][c];
      rows = r;
      cols = c;
   }

   // Ler os rows x cols elementos da matriz
   public void read(Scanner in) {
      for (int i=0; i<rows; i++) {
        String line = in.next();
        for (int j=0; j<cols; j++)
          data[i][j] = line.charAt(j);
      }
   }

   // Representacao em String da matrix
   public String toString() {
      String ans = "";
      for (int i=0; i<rows; i++) {
         for (int j=0; j<cols; j++)
            ans += data[i][j];
         ans += "\n";
      }
      return ans;
   }
}

public class ED216 {
  public static void main( String[] args) {
    Scanner in = new Scanner(System.in);

    int lin = in.nextInt();
    int col = in.nextInt();
    Matrix m = new Matrix(lin, col);
    m.read(in);


    int tam    = 0; //tam atual
    int maxtam = 0; //tam max
  	int num    = 0; //numero de conjuntos de maxtam

    for (int i=0; i<lin; i++) {
     for (int j=0; j<col; j++) {
       if (m.data[i][j] == '#')
         tam++;
       else {
         if (maxtam < tam) {
          maxtam = tam;
          num = 1;
         }
         else if (maxtam == tam)
           num++;
         tam = 0;
       }
     }
     if (maxtam < tam) { //if streak ends at the end of the line
      maxtam = tam;
      num = 1;
     }
     else if (maxtam == tam)
       num++;
     tam = 0;
    }


    for (int i=0; i<col; i++) {
     for (int j=0; j<lin; j++) {
       if (m.data[j][i] == '#')
         tam++;
       else {
         if (maxtam < tam) {
          maxtam = tam;
          num = 1;
         }
         else if (maxtam == tam)
           num++;
         tam = 0;
       }
     }
     if (maxtam < tam) {
      maxtam = tam;
      num = 1;
     }
     else if (maxtam == tam)
       num++;
     tam = 0;
    }

    System.out.println(maxtam + " " + num);

  }
}
