// -----------------------------------------------------------
// Estruturas de Dados 2020/2021 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2021/
// -----------------------------------------------------------
// Classe com um no generico
// Ultima alteracao: 03/04/2018
// -----------------------------------------------------------

public class Pair<A,B> {
   private A first;
   private B second;

   // Construtor
   Pair(A a, B b) {
      first = a;
      second = b;
   }

   // Getters e Setters
   public A getFirst() { return first; }
   public B getSecond()  { return second; }
   public void setFirst(A a) { first = a; }
   public void setSecond(B b)  { second = b; }

   public String toString() {
     String str = "(" + getFirst() + "," + getSecond() + ")";
     return str;
   }
}
