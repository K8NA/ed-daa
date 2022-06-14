/*Dada uma sequência de N bakugans, descrita pelas energias Ei de cada um deles,
bem como uma série de F fotos, cada uma indicando as posições Ai e Bi,
calcular, para cada foto, a soma das energias dos bakugans
com posições no intervalo [Ai, Bi].
*/

#include <stdio.h>
int main() {
  int n; //n de bakugans
  int e; //energia de um bakugan
  int f; //n de fotos
  int a, b; //pos inicial e final da foto

  scanf("%d", &n);

  int energ[n]; //energias dos bakugans
  int soma_acc[n+1]; //somas acumuladas das energias

  for (int i=0; i<n; i++) {
    scanf("%d", &e);
    energ[i] = e;
  }

  for (int i=1; i<=n; i++) {
    soma_acc[i] = energ[i-1] + soma_acc[i-1];
  }

  scanf("%d", &f);
  for (int i=0; i<f; i++) {
    scanf("%d %d", &a, &b);
    printf("%d\n", soma_acc[b] - soma_acc[a-1]);
  }
  return 0;
}
