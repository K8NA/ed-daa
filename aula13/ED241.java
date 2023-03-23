import java.util.Scanner;

class ED241 {
      public static void main(String[] args) {
  	    Scanner in = new Scanner(System.in);
  	    int f = in.nextInt();

  	    BSTree<String> t = new BSTree<>();
  	    BSTMap<String, Integer> total = new BSTMap<>();
  	    BSTMap<String, Integer> aceites = new BSTMap<>();
  	    BSTMap<String, BSTree<String>> resolvidos = new BSTMap<>();

	      int n = in.nextInt();

	      for (int i=0; i<n; i++) {
      		String nome = in.next();
      		String problema = in.next();
      		String resultado = in.next();

      		t.insert(nome);

      		if (total.get(problema) == null)
            total.put(problema, 1);
      		else
            total.put(problema, total.get(problema) + 1);

      		if (resultado.equals("Accepted")) {
      		    if (aceites.get(problema) == null)
                aceites.put(problema, 1);
      		    else
                aceites.put(problema, aceites.get(problema) + 1);

      		    if (resolvidos.get(nome) == null)
      			    resolvidos.put(nome, new BSTree<String>());

      		    resolvidos.get(nome).insert(problema);
		      }
	      }

  	    if (f==1) {
  		      System.out.println(t.numberNodes());
  	    } else if (f==2) {
  		      int max = 0;
  		      String prob = "NONE";
  		      for (String k : total.keys())
  		        if (total.get(k) > max) {
    	           max  = total.get(k);
    	           prob = k;
  		        }
  		      System.out.println(prob + " " + max);
  	    } else if (f==3) {
        		for (String k : total.keys())
        		    if (aceites.get(k) / (double)total.get(k) >= 0.5)
        			     System.out.println(k);
  	    } else if (f==4) {
        		for (String k : resolvidos.keys())
        		    if (resolvidos.get(k).numberNodes() == total.size())
        			     System.out.println(k);
  	    }
	  }
}
