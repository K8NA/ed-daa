
import java.util.Scanner;
import java.util.*;

class ED236 {
  public static void main(String[] args) {

    // SinglyLinkedList<Character> b = new SinglyLinkedList<>();
    //
    //   b.addLast('a');
    //   b.addLast('b');
    //   b.addLast('c');
    //   b.addLast('d');
    //   b.addLast('e');
    //
    //   b.shift(2);
    //   System.out.println(b);

    SinglyLinkedList<Integer> a = new SinglyLinkedList<>();

      a.addLast(2);//
      a.addLast(2);
      a.addLast(1);//
      a.addLast(2);
      a.addLast(3);//
      a.addLast(1);
      a.addLast(4);//
      a.addLast(1);
      a.addLast(4);//

      SinglyLinkedList<Integer> b = a;

      System.out.println(a);
      // a.removeOdd();
      // System.out.println("remove odd: should be 2,1,3,4,4  vs  " + a);
      a.removeEven();  // 2,2,1,1
      System.out.println("remove even: should be 2,2,1,1  vs  " + a);




  }
}
