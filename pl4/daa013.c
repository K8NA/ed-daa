/*Dado um conjunto de N segmentos com coordenadas [Li, Ri] e um número M,
descobrir qual a menor quantidade de segmentos que cobrem o segmento [0,M].
*/
#include <stdio.h>
#include <stdlib.h>

typedef struct {
  int l; //inicio
  int r; //fim
} Segmento;

int compare_int(const void *a, const void *b) {
  int i1 = *((int *)a);
  int i2 = *((int *)b);

  if (i1 < i2) return -1;
  if (i1 > i2) return +1;
  return 0;
}

int main() {

  int m; //tamanho do segmento a cobrir
  int n; //quantidade de segmentos a considerar

  scanf("%d", &m);
  scanf("%d", &n);

  Segmento seg[n];

  for (int i=0; i<n; i++) {
    scanf("%d %d", &seg[i].l, &seg[i].r);
  }

  //ordenar por ordem crescente do seu inicio
  qsort(seg, n, sizeof(Segmento), compare_int);

  int end=0; //vamos cobrir [0, end]
  int i;
  int count=0; //num minimo de segmentos para cobrir [0, m]

  do {
    int melhor=0;
    for(i=0; i<n; i++) {
      if (seg[i].l <= end)
        if (seg[i].r > seg[melhor].r)
          melhor = i;
    }
    end = seg[melhor].r;
    count++;
  } while (end < m);

  printf("%d\n", count);

  return 0;
}
