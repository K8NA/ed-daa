import java.util.Scanner;
import java.util.LinkedList;

class Bombeiro {
  public String nome;
  public int eventos; //n de eventos
  public int minutos; //n de minutos trabalhados

  Bombeiro(String n, int e, int m) {
    nome    = n;
    eventos = e;
    minutos = m;
  }

  public String toString() {
     return "" + nome + " " + eventos + " " + minutos;
  }
}

class Evento {
  int minpart;
  DoublyLinkedList <Bombeiro> bombeiros;

  Evento() {
    minpart = 0;
    bombeiros = new DoublyLinkedList<>();
  }
}

class FilaEvento {
    public MyQueue<Bombeiro> fila;

    FilaEvento() {
	     fila = new LinkedListQueue<Bombeiro>();
    }
}


class ED095 {
  private static int numBomb;
  private static FilaEvento emEspera;
  private static String nome;
  private static int id, num, mincheg;
  private static String evento;
  private static Evento[] eventos;
  private static int tempo;
  private static Bombeiro b, b2;


  private static void flag1(Scanner in) {
    int numeventos=0;
    evento = in.next();
    while (!evento.equals("FIM")) {
      if (evento.equals("PARTIDA"))
        numeventos++;
      evento = in.next();
    }
    System.out.println("Ocorreram " + numeventos + " eventos");
  }

  private static void flag2(Scanner in) {
    for (int i=0; i<numBomb; i++) {
      nome = in.next();
      b = new Bombeiro(nome,0,0);
      emEspera.fila.enqueue(b);
    }
    System.out.println("Bombeiros Destacados");

    evento = in.next();

    while (!evento.equals("FIM")) {
      b2 = new Bombeiro("",0,0);
      id = in.nextInt();

      if (evento.equals("PARTIDA")) {
        System.out.println("EVENTO " + id);
        eventos[id] = new Evento();
        num = in.nextInt(); //n de bombeiros necessarios para evento
        if (num > emEspera.fila.size()) {
          num = emEspera.fila.size();
        }
        if (emEspera.fila.size() == 0)
          System.out.println("Nenhum");

        if (emEspera.fila.size() > 0) {
          for (int i=0; i<num; i++) {
            b2 = emEspera.fila.dequeue();
            System.out.println(b2.nome);
            eventos[id].bombeiros.addFirst(b2);
          }
        }
        eventos[id].minpart = in.nextInt();  //hora de partida em minutos
      }

      if (evento.equals("CHEGADA")) {
        mincheg = in.nextInt(); //hora de chegada em minutos
        int size = eventos[id].bombeiros.size(); //very important
        for (int i=0; i < size; i++) {
          b2 = eventos[id].bombeiros.getLast();
          b2.eventos++;
          eventos[id].bombeiros.removeLast();
          emEspera.fila.enqueue(b2);
        }
       }
       evento = in.next();
      }
  }

  private static void flag3(Scanner in) {
    for (int i=0; i<numBomb; i++) {
      nome = in.next();
      b = new Bombeiro(nome,0,0);
      emEspera.fila.enqueue(b);
    }

    evento = in.next();

    System.out.println("Listagem de Bombeiros");

    while (!evento.equals("FIM")) {
      b2 = new Bombeiro("",0,0);
      id = in.nextInt();

      if (evento.equals("PARTIDA")) {
        eventos[id] = new Evento();
        num = in.nextInt(); //n de bombeiros necessarios para evento
        if (num > emEspera.fila.size()) {
          num = emEspera.fila.size();
        }

        if (emEspera.fila.size() > 0) {
          for (int i=0; i<num; i++) {
            b2 = emEspera.fila.dequeue();
            eventos[id].bombeiros.addFirst(b2);
          }
        }
        eventos[id].minpart = in.nextInt();  //hora de partida em minutos
      }

      if (evento.equals("CHEGADA")) {
        mincheg = in.nextInt(); //hora de chegada em minutos
        int size = eventos[id].bombeiros.size(); //very important
        for (int i=0; i < size; i++) {
          tempo = mincheg - eventos[id].minpart;
          b2 = eventos[id].bombeiros.getLast();
          b2.minutos += tempo;
          b2.eventos++;
          eventos[id].bombeiros.removeLast();
          emEspera.fila.enqueue(b2);
        }
       }
       evento = in.next();
      }
      int size2 = emEspera.fila.size();
      for (int j=0; j<size2; j++) {
        b = emEspera.fila.dequeue();
        System.out.println(b.nome + " " + b.eventos + " " + b.minutos);
      }

  }



  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int flag   = in.nextInt();

    //inicializar:
    numBomb = in.nextInt();

    emEspera = new FilaEvento();
    nome=""; id=0; num=0; mincheg=0;
    eventos = new Evento[500];


    if (flag == 1) {
      flag1(in);
    }

    else if (flag == 2) {
      flag2(in);
    }

    else if (flag == 3) {
      flag3(in);
    }

    else System.out.println("flag invalido");
  }
}
