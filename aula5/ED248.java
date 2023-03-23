

public class ED248 {
  public static void main(String[] args) {
    int n = 1000000;
  	IntSet s = new BooleanArrayIntSet(n); // Criar array de booleanos para numeros no intervalo [1,n]
  	boolean tmp;

  	System.out.println("Adicionando todos os numeros entre 1 e " + n + "...");
  	for (int i=1; i<=n; i++)
  	    tmp = s.add(i);

  	System.out.println("Adicionando novamente todos os numeros entre 1 e " + n + "...");
  	for (int i=1; i<=n; i++)
  	    tmp = s.add(i);

  	System.out.println("Verificando se todos os numeros entre 1 e " + n + " existem...");
  	for (int i=1; i<=n; i++)
  	    tmp = s.contains(i);

  	System.out.println("Removendo todos os numeros entre 1 e " + n + "...");
  	for (int i=1; i<=n; i++)
  	    tmp = s.remove(i);


    IntSet s1 = new BooleanArrayIntSet(10);
    IntSet s2 = new BooleanArrayIntSet(10);

    for (int i=1; i<=5; i++)
      s1.add(i);
    System.out.println("s1 = " + s1 + " | tamanho = " + s1.size());

    for (int i=3; i<=7; i++)
      s2.add(i);
    System.out.println("s2 = " + s2 + " | tamanho = " + s2.size());

    IntSet s3 = s1.intersection(s2);
    System.out.println("s3 = " + s3 + " | tamanho = " + s3.size());

    IntSet s4 = s2.intersection(s1);
    System.out.println("s4 = " + s4 + " | tamanho = " + s4.size());

    System.out.println("s1.equals(s2) = " + s1.equals(s2));
    System.out.println("s3.equals(s4) = " + s3.equals(s4));

  }
}
