/*Dada uma pirâmide com N camadas, e as pedras em falta nas camadas da pirâmide,
calcular o número de maneiras diferentes de subir a pirâmide até ao topo,
começando por qualquer pedra da primeira camada, evitando as pedras em falta.
*/
#include <stdio.h>
int main() {
  int n; //num de pedras na 1ª camada == num de niveis da piramide
  int d; //num de pedras em falta
  long long m=0; //resposta - num de maneiras diferentes de subir

  scanf("%d", &n);
  scanf("%d", &d);

  long long count[n+1][n+1]; //caminhos possiveis a partir de uma pedra
  int est[n+1][n+1];   //array das pedras estragadas
  int cam; //indice da camada
  int pos; //indice da posicao

  //inicializar tudo a zero
  for (int i=0; i<=n; i++) {
    for (int j=0; j<=n; j++) {
      est[i][j] = 0;
      count[i][j] = 0;
    }
  }

  count[1][1] = 1;

  for (int i=1; i<=d; i++) {
    scanf("%d %d", &cam, &pos);
    est[n-cam+1][pos] = 1; //assegurar que os indices sao os do enunciado
    if (cam == n && pos == 1)
      count[1][1] = 0; //se a pedra estragada esta no topo, nao ha caminhos
  }

  //preencher a piramide com somas do que esta acima e acima+esquerda
  for (int i=1; i<=n; i++) {
    for (int j=1; j<=i; j++) {
      if (est[i][j] != 1) { //se nao esta estragada
        count[i][j] = count[i][j] + count[i-1][j];
        count[i][j] = count[i][j] + count[i-1][j-1];
      }
    }
  }

  for (int j=0; j<=n; j++)
    m = m + count[n][j]; //percorrer a linha do fundo e somar todas as maneiras
  printf("%lld\n", m);
  return 0;
}
