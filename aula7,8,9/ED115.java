import java.util.Scanner;
import java.util.LinkedList;
​
​//Vitor Bizarro
//Falha um teste  para a flag 2
//Comecei a fazer a flag 1 de modo errado
//(com uma fila de clientes própria pra classe, o que é desnecessário)
// mas não compromete a flag 2

class Caixa {
    public int rapidez;
    public int numclientes;
    public int totalprodutos;
    public int uprodutos;
    public int fim;
    public MyQueue<Cliente> clientes;
    Caixa(int n) {
      	rapidez = n;
        fim = 0;
        numclientes = 0;
        totalprodutos = 0;
        clientes = new LinkedListQueue<Cliente>();
    }
}
​
class Cliente {
    public String nome;
    public int chegada;
    public int produtos;
​
    Cliente(String x, int y, int z){
      nome = x;
      chegada = y;
      produtos = z;
    }
}
​
class ED115 {
  private static MyQueue<Cliente> clientes;
  private static Caixa[] caixas;
  private static int tempo;
  private static int ncaixas;
  private static int nclientes;
​
  private static void ler(Scanner in){
    String nome;
    int schegada, nprodutos;
    clientes = new LinkedListQueue<Cliente>();
    for (int i = 0; i < nclientes; i++){
      nome = in.next();
      schegada = in.nextInt();
      nprodutos = in.nextInt();
      Cliente b = new Cliente(nome, schegada, nprodutos);
      clientes.enqueue(b);
    }
  }
​
  private static void flag2(){
    while (!clientes.isEmpty()){
       Cliente c = clientes.dequeue();
       tempo = c.chegada;
       //Fazer todas as movimentações até logo antes do tempo do próximo cliente
       for (int k = 0; k < ncaixas; k++){
           while (caixas[k].fim < tempo && !caixas[k].clientes.isEmpty()){
                caixas[k].clientes.dequeue();
                  if (!caixas[k].clientes.isEmpty()){
                    caixas[k].fim += 10 + (caixas[k].clientes.first().produtos*caixas[k].rapidez);
                  }
                }
              }
       //Para efeito de comparação do tamanho da fila e do número de produtos do último
       int maximo = 100000;
       int maximo2 = 100000;
       int repetiu = 0;
       //Achar a fila com menos clientes
       for (int i = 0; i < ncaixas; i++){
           if (caixas[i].clientes.size() == maximo){
             repetiu++;
           }
           else if (caixas[i].clientes.size() < maximo){
             maximo = caixas[i].clientes.size();
             repetiu = 0;
           }
         }
       //Caso só haja uma fila, adicionar o cliente
       if (repetiu == 0){
         for (int j = 0; j < ncaixas; j++){
            if (caixas[j].clientes.size() == maximo){
               caixas[j].numclientes++;
               caixas[j].uprodutos = c.produtos;
               caixas[j].totalprodutos += c.produtos;
               if (caixas[j].clientes.isEmpty()){
                 caixas[j].fim = c.chegada + 10 + (c.produtos*caixas[j].rapidez);
               }
               caixas[j].clientes.enqueue(c);
             }
         }
       }
       //Caso contrário, procurar também pelo que tem menos produtos no fim
       else {
        for (int j = 0; j < ncaixas; j++){
           if (caixas[j].uprodutos < maximo2 && caixas[j].clientes.size() == maximo){
             maximo2 = caixas[j].uprodutos;
           }
         }
         //Achar o de ordem mais baixa e adicionar
        for (int i = 0; i < ncaixas; i++){
            if (caixas[i].uprodutos == maximo2 && caixas[i].clientes.size() == maximo){
              caixas[i].numclientes++;
              caixas[i].uprodutos = c.produtos;
              caixas[i].totalprodutos += c.produtos;
              if (caixas[i].clientes.isEmpty()){
                caixas[i].fim = c.chegada + 10 + (c.produtos*caixas[i].rapidez);
              }
              caixas[i].clientes.enqueue(c);
              break;
           }
         }
       }
     }
    imprime();
  }
    private static void imprime(){
      for(int i = 0; i < ncaixas; i++){
        System.out.println("Caixa #" + (i+1) + ": " + caixas[i].numclientes + " " + caixas[i].totalprodutos);
      }
    }
​
    private static void flag1(){
      tempo = clientes.first().chegada;
      while (!clientes.isEmpty()){
        if (tempo < clientes.first().chegada) tempo = clientes.first().chegada;
        tempo += 10 + (clientes.first().produtos*caixas[0].rapidez);
        System.out.println(clientes.first().nome + " " + clientes.first().chegada + " " + tempo);
        clientes.dequeue();
      }
    }
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int flag = in.nextInt();
    ncaixas = in.nextInt();
    int rapidez;
    caixas = new Caixa[1000];
    for (int i = 0; i < ncaixas; i++){
      rapidez = in.nextInt();
      caixas[i] = new Caixa(rapidez);
    }
    tempo = 0;
    nclientes = in.nextInt();
    ler(in);
    if (flag == 1) flag1();
    else flag2();
    return;
  }
}
