import java.util.Scanner;

public class Palindromos {

  static boolean isPalindrome(String str) {

    str = str.replaceAll("\\W","");
    str = str.toLowerCase();
    int size = str.length();

    for(int i=0; i<(size/2); i++) {
      if (str.charAt(i) != str.charAt(size-i-1))
        return false;
    }
    return true;
  }

  public static void main(String[] args) {

    Scanner stdin = new Scanner(System.in);
    int i;

    int n = stdin.nextInt();
    boolean result[] = new boolean[n+1];

    for (i=0; i<=n; i++) {
      String frase = stdin.nextLine();
      result[i] = isPalindrome(frase);
    }

    System.out.println(""+n);

    for (i=1; i<=n; i++) {
      if (result[i] == true)
        System.out.println("sim");
      else
        System.out.println("nao");
    }
  }

}
