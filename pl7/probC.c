#include <stdio.h>

int elegante(char arr[], char new[], int n) {
  if (n == 0) return n;
  for (int i=0; i<n; i=i+2) { //go to every odd position
    if (arr[i] == arr[i+1]) { //if next char is equal
      new[i] = arr[i+1];
      n--; //reduce size of arr
      i--; //set i as the position we are at, again
    }
  }
  if (n % 2 == 0)
    return n;
  else
    return (n-1); //reduce size by one because its already elegant,
                  //apart from the parity of string
}

int main() {
  int n;     //num de chars em s
  scanf("%d", &n);
  char s[n]; //palavra s
  char new[n];
  scanf("%s", s);

  int aux = elegante(s, new, n);
  printf("%d\n", n - aux);

  return 0;
}
