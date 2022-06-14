//https://codeforces.com/problemset/problem/432/B

#include <stdio.h>

typedef struct {
  int home;
  int away;
  int timesHomeColor;
  int timesAwayColor;
  int id;
} Team;


int main() {
  int n;   //num teams
  scanf("%d", &n);
  Team arr[n];
  for (int i=0; i<n; i++) {
    scanf("%d %d", &arr[i].home, &arr[i].away);
    arr[i].id = i;
    arr[i].timesHomeColor = n-1;
    arr[i].timesAwayColor = n-1;
  }

  for (int i=0; i<n; i++) {
    for(int j=i; j<n; j++) {
      if (arr[i].home == arr[j+1].away) {
        arr[j+1].timesHomeColor++;
        arr[j+1].timesAwayColor--;
      }
      if (arr[i].away == arr[j+1].home) {
        arr[i].timesHomeColor++;
        arr[i].timesAwayColor--;
      }
    }
  }


  for (int i=0; i<n; i++) {
    printf("%d %d\n", arr[i].timesHomeColor, arr[i].timesAwayColor);
  }


  return 0;
}
