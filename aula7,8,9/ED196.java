
public class ED196 {
  public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b) {
    while (!q.isEmpty()) {
      for (int i=0; i<q.size(); i+=2) {
        String nome = q.dequeue();
        String op = q.dequeue();

        if (op.equals("X")) {
          if (a.size() < b.size())
            a.enqueue(nome);
          else if (a.size() > b.size())
            b.enqueue(nome);
        }
        else if (op.equals("B"))
          b.enqueue(nome);
        else
          a.enqueue(nome);
       }
     }
   }


  public static void main(String[] args) {
     MyQueue<String> q = new LinkedListQueue<String>();
     MyQueue<String> a = new LinkedListQueue<String>();
     MyQueue<String> b = new LinkedListQueue<String>();

     q.enqueue("Luis"); q.enqueue("B"); q.enqueue("Pedro"); q.enqueue("A");
     q.enqueue("Luisa"); q.enqueue("A"); q.enqueue("Joao"); q.enqueue("X");
     q.enqueue("Jose"); q.enqueue("X"); q.enqueue("Miguel"); q.enqueue("B");

     System.out.println("q: " + q);
     System.out.println("a: " + a);
     System.out.println("b: " + b);
     process(q,a,b);
     System.out.println("\n");
     System.out.println("q: " + q);
     System.out.println("a: " + a);
     System.out.println("b: " + b);
  }
}
