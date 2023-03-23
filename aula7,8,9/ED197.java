
public class ED197 {
  public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b) {
    MyQueue<Integer> q = new LinkedListQueue<Integer>();

    while (!a.isEmpty() && !b.isEmpty()) {
      if (a.first() <= b.first())
        q.enqueue(a.dequeue());
      else
        q.enqueue(b.dequeue());
    }

    if (a.isEmpty())
      while (!b.isEmpty())
        q.enqueue(b.dequeue());

    if (b.isEmpty())
      while (!a.isEmpty())
        q.enqueue(a.dequeue());

    return q;
  }


  public static void main(String[] args) {
     MyQueue<Integer> a = new LinkedListQueue<>();
     MyQueue<Integer> b = new LinkedListQueue<>();

     for (int i=1; i<=9; i++)
        a.enqueue(i);
     System.out.println(a);

     for (int j=8; j<=12; j++)
        b.enqueue(j);
     System.out.println(b);

     System.out.println("\n");
     System.out.println("q: " + merge(a,b));
     System.out.println("a: " + a);
     System.out.println("b: " + b);


  }
}
