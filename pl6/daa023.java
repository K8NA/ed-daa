import java.util.Scanner;
import java.util.TreeMap;

public class daa023 {
    static TreeMap<String, Integer> mapa;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        mapa = new TreeMap<String, Integer>();
        map();

        for (int i = 0; i < n; i++) {
            String s = scan.next();
            if (mapa.get(s) == null) {
                // System.out.println(0);
            } else {
                // System.out.println(mapa.get(s));
            }
        }
    }

    static void map() {
        String s = "";
        int total = 0;
        for (char a = 'a'; a <= 'z'; a++) {

            // System.out.println(s + a);
            // s += a;
            mapa.put(s += a, total + 1);
            total++;
            for (char b = (char) (a + 1); b <= 'z'; b++) {

                // System.out.println(s + b);
                // s += b;
                mapa.put(s += b, total + 1);
                total++;
                for (char c = (char) (b + 1); c <= 'z'; c++) {

                    // System.out.println(s + c);
                    // s += c;
                    mapa.put(s += c, total + 1);
                    total++;
                    for (char d = (char) (c + 1); d <= 'z'; d++) {

                        // System.out.println(s + d);
                        // s += d;
                        mapa.put(s += d, total + 1);
                        total++;
                        for (char e = (char) (d + 1); e <= 'z'; e++) {

                            // System.out.println(s + e);
                            mapa.put(s += e, total + 1);
                            total++;
                        }
                        s = "";
                        s = s + a + b + c;
                    }
                    s = "";
                    s = s + a + b;
                }
                s = "";
                s += a;
            }
            s = "";
        }
        // System.out.println(total);
    }
}