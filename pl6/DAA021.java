import java.io.*;
import java.util.*;

public class DAA021 {

  public static void main(String args[]) {
    FastScanner in = new FastScanner(System.in);
    TreeMap<Integer,Integer> map = new TreeMap<>();

    int energia = 0;
    int count = 0;
    String format;
    int add = in.nextInt();
  	int rem = in.nextInt();

  	for (int i=0; i<(add+rem); i++) {
      format = in.next();
      if (format.equals("BAK")) {
        energia = in.nextInt();
        if (map.containsKey(energia)) {
          count = map.get(energia);
          map.put(energia, count+1);
        } else map.put(energia, 1);
      } else if (format.equals("MAX")) {
        FastPrint.out.println(map.lastKey());
        count = map.get(map.lastKey());
        map.put(map.lastKey(), count-1);
        if (map.get(map.lastKey()) == 0)
          map.remove(map.lastKey());
      } else {
        FastPrint.out.println(map.firstKey());
        count = map.get(map.firstKey());
        map.put(map.firstKey(), count-1);
        if(map.get(map.firstKey()) == 0)
            map.remove(map.firstKey());
      }
    }
    FastPrint.out.close();
  }

}
