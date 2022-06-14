// Exemplo de ordenacao customizada de pessoas
// Primeiro por ordem crescente da idade, e em caso de empate por
// ordem crescente alfabetica do nome
// ----------------------------------
// Pedro Ribeiro (DCC/FCUP) - 11/10/2020
// ----------------------------------

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_STRINGS 500
#define MAX_LENGTH  30

// Tipo para guardar uma pessoa
typedef struct {
  int age;
  char name[MAX_LENGTH+1]; // (+1) Espaco para o '\0' no final da string
} Person;

// Funcao para comparar dois elementos de um array (necessaria para o qsort)
// Esta funcao deve devolver:
//  - numero < 0 se elemento "a" for menor que elemento "b"
//  - numero > 0 se elemento "a" for maior que elemento "b"
//  - zero, se elemento "a" for igual ao elemento "b"
int comparePerson(const void *a, const void *b) {
  Person *p1 = (Person *)a;
  Person *p2 = (Person *)b;

  if (p1->age < p2->age) return -1;
  if (p1->age > p2->age) return +1;
  // strcmp e uma funcao que ja existe no C - veja o manual se nao conhece
  return strcmp(p1->name, p2->name);
}

int main() {
  int i, n;
  Person v[MAX_STRINGS];
  
  // Ler n nomes
  scanf("%d", &n);
  for (i=0; i<n; i++)
    scanf("%d %s", &v[i].age, v[i].name);

  // Chamada ao sort padrao da linguagem C
  // qsort(array, quantidade_elementos, tamanho_um_elemento, funcao_comparar)
  qsort(v, n, sizeof(Person), comparePerson);
  
  for (i=0; i<n; i++)
    printf("%d %s\n", v[i].age, v[i].name);
  
  return 0;
}
