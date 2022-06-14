// Exemplo de ordenacao de 10 numeros inteiros
// ----------------------------------
// Pedro Ribeiro (DCC/FCUP) - 11/10/2020
// ----------------------------------

#include <stdio.h>
#include <stdlib.h>

// Funcao para comparar dois elementos de um array (necessaria para o qsort)
// Esta funcao deve devolver:
//  - numero < 0 se elemento "a" for menor que elemento "b"
//  - numero > 0 se elemento "a" for maior que elemento "b"
//  - zero, se elemento "a" for igual ao elemento "b"
int compare_int(const void *a, const void *b) {
  int i1 = *((int *)a);
  int i2 = *((int *)b);

  if (i1 < i2) return -1;
  if (i1 > i2) return +1;
  return 0;
}

int main() {
  int i;
  // Um array exemplo 
  int v[10] = {33, 4, 28, 18, 15, 2, 8, 17, 42, 39};
  
  printf(" Antes de ordenar: ");
  for (i=0; i<10; i++)
    printf("%d ", v[i]);
  putchar('\n');
  
  // Chamada ao sort padrao da linguagem C
  // qsort(array, quantidade_elementos, tamanho_um_elemento, funcao_comparar)
  qsort(v, 10, sizeof(int), compare_int);
  
  printf("Depois de ordenar: ");
  for (i=0; i<10; i++)
    printf("%d ", v[i]);
  putchar('\n');

  return 0;
}
