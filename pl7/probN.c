#include <stdio.h>

int elegante(char arr[], char new[], int n) {
  int flag = 0, j=1;
  char temp = '!';
  int k = n;
  new[0] = arr[0];
  if (n == 0) return n;
  for (int i=0; i<k; i++) { //go to every odd position
    printf("\nn: %d flag: %d\n", n, flag);
    if (flag == 1) {
      if (temp != arr[i+1]) {
        new[j] = arr[i+1];
        flag = 0;
        j++;
        printf("%d\n", n);
      } else {
        n--;
        continue; }
    }
    if ((i+1) % 2 != 0) {
      if (arr[i] == arr[i+1]) { //if next char is equal
        temp = arr[i];
        n--; //reduce size of arr
        flag = 1;
        printf("%d\n", n);
        continue; //set i as the position we are at, again
      }
    }
    new[j] = arr[i+1];
    j++;
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
