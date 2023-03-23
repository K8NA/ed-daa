/* -----------------------------------
  Estruturas de Dados 2020/2021
  Triagem de Manchester [ED098]
----------------------------------- */

import java.util.Scanner;
import java.util.LinkedList;

// Classe para representar um Doente
class Doente {
    public String nome;     // Nome
    public int chegada;     // Tempo de chegada
    public int atendimento; // Tempo que demora a ser atendido
    public int entrada;     // Tempo em que comecou a ser atendido

    // Construtor: inicializa os atributos
    Doente(String n, int c, int a) {
        nome        = n;
        chegada     = c;
        atendimento = a;
        entrada     = -1;
    }
}

// Classe para representar uma fila de atendimento de uma cor (necessaria para criar array)
// (nota: Java nao permite criacao direta de array de genericos)
class FilaAtendimento {
    public MyQueue<Doente> fila;

    FilaAtendimento() {
        fila = new LinkedListQueue<Doente>();
    }
}

// Classe para representar uma equipa da urgencia
class Equipa {
    int indice;
    int numDoentes;       // Numero de doentes que atenderam
    int totalAtendimento; // Total de tempo passado a atender
    int livre;            // Tempo em que ficam livres para poder atender novo doente

    Equipa(int i) {
        indice = i;
        numDoentes       = 0;
        totalAtendimento = 0;
        livre            = 0;
    }

    // Novo doente d comecou a ser atendido num dado tempo t nesta equipa
    void novoDoente(Doente d, int t) {
        numDoentes ++;
        totalAtendimento += d.atendimento;
        livre= t + d.atendimento; //volta a estar livre passados atendimento mins
    }
}

// Classe principal que contem o metodo main
class ED098 {
    // Constantes que nao mudam durante o programa: numero de cores e seus nomes
    private static final int NUM_CORES = 5;
    private static final String[] CORES = {"Vermelho","Laranja","Amarelo","Verde","Azul"};

    private static int tempo;
    private static int numEquipas;               // Numero de equipas
    private static int numDoentes;               // Numero total de doentes
    private static FilaAtendimento emEspera[];   // Array com uma fila para cada cor
    private static LinkedList<Doente> atendidos; // Lista de doentes ja atendidos
    private static MyQueue<Equipa> equipa;             // Equipas da urgencia disponiveis
    private static MyQueue<Equipa> NotAvailable;    //Equipas de urgencia ocupadas

    // Metodo para devolver indice de uma cor representada pela string s
    private static int indiceCor(String s) {
        switch (s){
            case "Vermelho": return 0;
            case "Laranja": return 1;
            case "Amarelo": return 2;
            case "Verde": return 3;
            case "Azul": return 4;
        }
        return -1;
    }

    // Ler os doentes a partir do input e coloca-los nas respetivas filas
    private static void lerDoentes(Scanner in) {
        while (in.hasNext()) {
            String nome     = in.next();
            String cor      = in.next();
            int chegada     = in.nextInt();
            int atendimento = in.nextInt();
            //System.out.printf("Li [%s,%s,%d,%d]%n", nome, cor, chegada, atendimento);

            //criar paciente:
            Doente D = new Doente(nome, chegada, atendimento);
            //adicionar o doente à fila consoante a cor
            emEspera[indiceCor(cor)].fila.enqueue(D);
            numDoentes++;
        }
    }


    // Mostrar numero de doentes em cada cor (necessario para flag==0)
    private static void mostrarCores() {
        System.out.println("------------");
        System.out.println("Cores     ND");
        System.out.println("------------");
        for (int i=0; i<5; i++)
            System.out.printf("%8s %3d%n", CORES[i], emEspera[i].fila.size());
        System.out.println("------------");
        System.out.printf("%s %d%n","Numero doentes atendidos:", numDoentes);
    }


    // Mostrar estatisticas dos doentes atendidos (necessario para flag==1 e flag==2)
    private static void mostrarAtendidos() {
        System.out.println("---------------------------");
        System.out.println("Lista dos doentes atendidos");
        System.out.println("---------------------------");
        // itera sobre todos os doentes jÃ¡ atendidos (instruÃ§Ã£o for-each)
        double espera=0, media=0;
        for (Doente d : atendidos) {
            System.out.printf("%s %d %d %d%n", d.nome, d.chegada, d.entrada-d.chegada, d.entrada+d.atendimento);
            espera += d.entrada-d.chegada;

        }
        System.out.println("---------------------------");
        media= espera/atendidos.size();
        System.out.printf("%s %.1f%n","Tempo medio de espera:", media);
    }

    // Mostrar estatisticos das equipas (necessario para flag==2)
    private static void mostrarEquipas() {
        System.out.println("-----------------------");
        System.out.println("Equipa NDoentes MediaTA");
        System.out.println("-----------------------");

        Equipa[] sorted = new Equipa[numEquipas];
        while (!equipa.isEmpty()) {
            for (int i=equipa.first().indice; i<numEquipas && !equipa.isEmpty(); i++) {
                //sort de equipa para imprimir por ordem:
                Equipa E = equipa.dequeue();
                if (E.indice == i) sorted[i] = E;
                else equipa.enqueue(E);
            }
        }
        for (int i=0; i<numEquipas; i++){
            double media= (double)sorted[i].totalAtendimento/sorted[i].numDoentes;
            System.out.printf("%6d %8d %7.1f%n", i, sorted[i].numDoentes, media );
        }
    }

    //ver se no momento em questão a equipa está livre, se sim coloca-la na lista das livres
    private static void refresh(){
        int k = NotAvailable.size();
        for (int i=0; i<k; i++){
            Equipa E = NotAvailable.dequeue();
            if (E.livre<=tempo) equipa.enqueue(E);
            else NotAvailable.enqueue(E);
        }
    }


    // Qual a cor mais prioritaria com doente ainda por ser atendido no tempo atual?
    private static int proximoDoente() {
        for (int i=0; i<5; i++){
            if (emEspera[i].fila.isEmpty()) continue;
            if (emEspera[i].fila.first().chegada <= tempo) return i;
        }
        return -1;
    }

    private static Equipa proximaEquipaLivre(){
        if (equipa.size() == 1) return equipa.dequeue();
        int min=tempo, indice=numEquipas;
        //ver qual a equipa que está à mais tempo livre
        // no caso de empate, escolher a que tem um indice menor
        for (int i=0; i< equipa.size();i++){
            Equipa E = equipa.dequeue();
            if (E.livre<min) {
                min = E.livre;
                indice = E.indice;
            }
            if (E.livre==min){
                if (E.indice<indice)
                    indice = E.indice;
            }
            equipa.enqueue(E);
        }
        //obter a equipa cujo indice corresponde ao encontrado durante o ciclo anterior
        for (int i=0, k=equipa.size(); i<k; i++){
            Equipa E = equipa.dequeue();
            if (E.indice == indice)
                return E;
            else equipa.enqueue(E);
        }
        return null;
    }

    // Simular processo de atendimento pelas varias equipas medicas
    //processo de passagem do tempo no main
    private static void simular() {
        refresh();
        if (proximoDoente() == -1 ) return;
        if (equipa.isEmpty()) return;
        while (!equipa.isEmpty() && proximoDoente() != -1) {
            Doente D = emEspera[proximoDoente()].fila.dequeue();
            D.entrada = tempo;
            //Equipa E = equipa.dequeue();
            Equipa E = proximaEquipaLivre();
            E.novoDoente(D, tempo);
            NotAvailable.enqueue(E);
            atendidos.add(D);
            refresh();
        }
    }

    // Inicializar variaveis
    private static void inicializar() {
        numDoentes = 0;

        emEspera = new FilaAtendimento[NUM_CORES];
        for (int i=0; i<NUM_CORES;i++)
            emEspera[i] = new FilaAtendimento();

        atendidos = new LinkedList<Doente>();

        equipa = new LinkedListQueue<>();
        NotAvailable = new LinkedListQueue<>();
        for (int i=0; i<numEquipas; i++){
            Equipa E= new Equipa(i);
            equipa.enqueue(E);
        }
    }

    // ----------------------------------------------------------------

    // Funcao principal chamada no inicio do codigo
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int flag   = in.nextInt();
        numEquipas = in.nextInt();

        inicializar();
        lerDoentes(in);

        if (flag==0) {
            mostrarCores();
        } else {
            tempo = 0;
            while (atendidos.size() < numDoentes) {
                simular();
                tempo++;
            }
            while (!NotAvailable.isEmpty()) {
                refresh();
                tempo++;
            }
            if (flag==2) mostrarEquipas();
            mostrarAtendidos();
        }
    }
}
