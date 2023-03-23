public class Palindrome {

  static boolean isPalindrome(String str) {
    int size = str.length();
    for(int i=0; i<(size/2); i++) {
      if (str.charAt(i) != str.charAt(size-i-1))
        return false;
    }
    return true;
  }

  public static void main(String[] args) {

    String str1 = "hello";
    String str2 = "bob";
    System.out.println(isPalindrome(str1));
    System.out.println(isPalindrome(str2));

  }
}
