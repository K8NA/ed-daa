//Diogo Ribeiro 2020/2021
import java.util.Scanner;

public class ED005{
	private static int operate(int a, int b, char op){
		switch(op){
			case '+' :	//System.out.println(a + "+" + b + "=" + (a+b));
						return a+b;
			case '-' :	//System.out.println(a + "-" + b + "=" + (a-b));
						return a-b;
			case '*' :	//System.out.println(a + "*" + b + "=" + (a*b));
						return a*b;
			case '/' : 	//System.out.println(a + "/" + b + "=" + (a/b));
						return a/b;
		}
		return 0;
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), a, b, c;
		in.nextLine();
		String words[];
		char l;

		outerloop:
		for(int i=0; i<n; i++){
			LinkedListStack<Integer> pilha = new LinkedListStack<>();
			words = in.nextLine().split(" ");
			for(int j=0; j<words.length; j++){
				l = words[j].charAt(0);
				if(l >= '0' && l <= '9')	// Se for um digito
					pilha.push(Integer.parseInt(words[j]));
				else{						// Se for um operador
					if(pilha.size() > 1){	// Se tiver pelo menos dois elementos na pilha
						b = pilha.pop();
						a = pilha.pop();
						c = operate(a, b, l);
						pilha.push(c);
					}
					else{
						System.out.println("Expressao Incorrecta");
						continue outerloop;
					}
				}
			}
			if(pilha.size() == 1)
				System.out.println(pilha.top());
			else{
				System.out.println("Expressao Incorrecta");
			}
		}
	}
}
