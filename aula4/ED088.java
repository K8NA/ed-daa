import java.util.Scanner;

// Classe para representar um jogo
class GameLife {
    final char DEAD  = '.';  // Constante que indica uma celula morta
    final char ALIVE = 'O';  // Constante que indica uma celula viva
    private int rows, cols;  // Numero de linhas e colunas
    private char m[][];      // Matriz para representar o estado do jogo
    private char maux[][];   // matriz auxiliar

    // Construtor: inicializa as variaveis tendo em conta a dimensao dada
    GameLife(int r, int c) {
    	rows = r;
    	cols = c;
    	m = new char[r][c];
      maux = new char[r][c];
    }

    // Metodo para ler o estado inicial para a matriz m[][]
    public void read(Scanner in) {
      for (int i=0; i<rows; i++)
        m[i] = in.next().toCharArray();
    }

    // Metodo para escrever a matriz m[][]
    public void write() {
      for (int i=0; i<rows; i++) {
        for (int j=0; j<cols; j++)
          System.out.print(m[i][j]);
        System.out.println();
      }
    }

    // Deve devolver o numero de celulas vivas que sao vizinhas de (y,x)
    private int countAlive(int y, int x) {
    	int count=0;
      for (int i=y-1; i<=y+1; i++)
      	for (int j=x-1; j<=x+1; j++)
          if (i>=0 && i<rows && j>=0 && j<cols)
      		  if (m[i][j] == ALIVE && !(i==y && j==x))
      			   count++;
      return count;
    }


    // Deve fazer uma iteracao: cria nova geracao a partir da actual
    // copiando nova geraçao para uma matriz aux
    public void iterate() {
      for (int i=0; i<rows; i++) {
        for (int j=0; j<cols; j++) {
          int a = countAlive(i,j);
          //regras:
          if (a < 2 && m[i][j] == ALIVE)
    		    maux[i][j] = DEAD;
          else if (a >= 4 && m[i][j] == ALIVE)
    		    maux[i][j] = DEAD;
          else if ((a == 2 || a == 3) && m[i][j] == ALIVE)
    		    maux[i][j] = ALIVE;
          else if (a == 3 && m[i][j] == DEAD)
    		    maux[i][j] = ALIVE;
          else
    		    maux[i][j] = m[i][j];
         }
      }
      // passa para matriz original
      for (int k=0; k<rows; k++)
        for (int l=0; l<cols; l++)
          m[k][l] = maux[k][l];
    }

}


// Classe principal com o main()
public class ED088 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Ler linhas, colunas e numero de iteracoes
    int rows = in.nextInt();
    int cols = in.nextInt();
    int n    = in.nextInt();

    // Criar objecto para conter o jogo e ler estado inicial
    GameLife g = new GameLife(rows, cols);
    g.read(in);

    for(int i=0; i<n; i++) {
      g.iterate();
    }

    g.write();
  }
}
