
import java.util.Scanner;

class Processo {
  public String nome;  // nome do processo
  public int tempo;    // tempo restante do processo

  Processo(String n, int t) {
    nome = n;
    tempo = t;
  }
}

class ED237 {
  private static String nomepr; // nome do processo
  private static int temporest; // tempo restante do processo
  private static int tempoiter; // tempo de iteracao
  private static int nproc;     // n de processos
  private static int tempoatual;
  private static int niter;     //n de itercaoes
  private static MyQueue<Processo> emEspera;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    emEspera = new LinkedListQueue<Processo>();

    tempoatual = 0;
    niter = 0;

    tempoiter = in.nextInt();
    nproc = in.nextInt();

    for (int i=0; i<nproc; i++) {
      Processo pr = new Processo ("",0);
      nomepr = in.next();
      temporest = in.nextInt();
      pr.nome = nomepr;
      pr.tempo = temporest;
      emEspera.enqueue(pr);
    }


    while (!emEspera.isEmpty()) {
      Processo pr = new Processo ("",0);
      pr = emEspera.dequeue();
      niter++;
      if (pr.tempo <= tempoiter) {
        tempoatual += pr.tempo;
        pr.tempo = 0;
        System.out.println(pr.nome + " " + tempoatual + " " + niter);
      } else {
        tempoatual += tempoiter;
        pr.tempo -= tempoiter;
        emEspera.enqueue(pr);
      }
    }

  }
}
