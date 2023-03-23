
import java.util.Scanner;
import java.util.Arrays;

class ED250 {
  public static void main(String[] args) {

      Scanner in = new Scanner(System.in);

      int n = in.nextInt();   //n de carateres diferentes

      String str = in.next(); //frase a considerar
      String difchar="";      //frase com carateres diferentes
      String max="";          //frase com tamanho maximo
      String temp="";         //estado atual da frase

      int j=0;
      for (int i=0; i<str.length(); i++) {
        j=i;
        while((difchar.length() != n+1) && j<str.length()) {
          if(Character.isLetter(str.charAt(j)) &&
            (difchar.indexOf(Character.toLowerCase(str.charAt(j)))==-1)) {
                difchar = difchar + Character.toLowerCase(str.charAt(j));
          }

          if(difchar.length() == n+1)
            break;

          temp = temp + str.charAt(j);
          j++;
        }

        if (max.length() < temp.length())
          max = temp;

        temp="";
        difchar="";
      }

      System.out.println(max.length());
      System.out.println(max);
  }
}
