import java.util.Scanner;

class Matrix {
   int data[][]; // os elementos da matriz em si
   int rows;     // numero de linhas
   int cols;     // numero de colunas

   // construtor padrao de matriz
   Matrix(int r, int c) {
      data = new int[r][c];
      rows = r;
      cols = c;
   }

   // Ler os rows x cols elementos da matriz
   public void read(Scanner in) {
      for (int i=0; i<rows; i++)
         for (int j=0; j<cols; j++)
            data[i][j] = in.nextInt();
   }

   // Representacao em String da matrix
   public String toString() {
      String ans = "";
      for (int i=0; i<rows; i++) {
         for (int j=0; j<cols; j++)
            ans += data[i][j] + " ";
         ans += "\n";
      }
      return ans;
   }


    public static Matrix identity(int n) {
      Matrix m = new Matrix (n, n);

      for (int i=0; i<m.rows; i++)
         for (int j=0; j<m.cols; j++) {
            if (i == j)
              m.data[i][j] = 1;
            else m.data[i][j] = 0;
          }

      return m;
    }

    public Matrix transpose() {
      Matrix m = new Matrix (cols, rows);

      for (int i=0; i<rows; i++)
         for (int j=0; j<cols; j++)
              m.data[j][i] = data[i][j];
      return m;

    }

    public Matrix sum(Matrix m) {
      Matrix m1 = new Matrix (rows, cols);

      for (int i=0; i<rows; i++)
         for (int j=0; j<cols; j++)
            m1.data[i][j] = m.data[i][j] + data[i][j];
      return m1;
    }

    public Matrix multiply(Matrix m) {
      Matrix m1 = new Matrix (rows, m.cols);

      int k=0, sum=0; //k is columns of m
      for (int i=0; i<rows; i++) {
        while (k < m.cols) {
         for (int j=0; j<cols; j++) {
           sum = (data[i][j] * m.data[j][k]) + sum;
         }
         m1.data[i][k] = sum;
         k++; sum=0;
       }
       k=0;
      }

      return m1;
    }

}
