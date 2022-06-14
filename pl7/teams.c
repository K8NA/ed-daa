//https://codeforces.com/problemset/problem/432/A

#include <stdio.h>
#include <math.h>

/*rules:
a person cant participate more than 5 times
a team has 3 people
each person is only a part of 1 team
*/

#define MAXN 2001
#define MAXK 5

int main() {

  int n;   //num students
  int k;   //min number of times each team has to participate
  int teams=0; //max number of teams that can be formed

  scanf("%d %d", &n, &k);
  int size = n;
  int part[n];

  for (int i=0; i<n; i++) {
    scanf("%d", &part[i]);
    if ((part[i] + k) > 5) {
      size--;
    }
  }

  teams = ceil(size / 3);
  printf("%d\n", teams);

  return 0;
}
