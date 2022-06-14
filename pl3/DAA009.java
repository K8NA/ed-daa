/* Dado um fragmento de ADN alienígena, produzir uma listagem das letras 
que aparecem menos uma vez, ordenada por ordem decrescente da sua frequência
(número de occorrências) e em caso de empate pela ordem
em que aparecem primeiro no fragmento (primeira ocorrência de cada letra).
*/
import java.io.*;
import java.util.*;

class Letra implements Comparable<Letra> {
    public int freq; //frequencia de ocorrencia da letra
    public int pos;  //posicao da primeira ocorrencia no array
    public char rep; //representacao da letra

    Letra(int f, int p, char r) {
      freq = f;
      pos = p;
      rep = r;
    }

    @Override
     public int compareTo(Letra l) {
       if (freq < l.freq) return 1;
       if (freq > l.freq) return -1;
       if (pos <= l.pos) return -1;
       if (pos > l.pos) return 1;
       return 0;
     }
}

public class DAA009 {
  public static void main(String args[]) {
  Scanner stdin = new Scanner(System.in);

  int n=1; //num of unique letters
	Letra v[] = new Letra[26]; //descricao da cada letra do alfabeto

  String adn = stdin.nextLine();

  char r = adn.charAt(0);
  v[0] = new Letra(1, 0, r);

  outerloop:
  for(int i=1; i<adn.length(); i++) {
    r = adn.charAt(i);
    for (int j=0; j<n; j++) {
      if (v[j].rep == r) {
        v[j].freq++;
        continue outerloop;
      }
    }
    v[n] = new Letra(1, i, r); //i = posicao da 1ª ocorrencia
    n++;
  }

  Letra dna[] = new Letra[n]; //array só para letras presentes no input
  for(int k=0; k<n; k++) {
    dna[k] = v[k];
  }

	Arrays.sort(dna);

	for (int c = 0; c < n; c++)
	    System.out.println(dna[c].rep + " " + dna[c].freq);
  }
}
