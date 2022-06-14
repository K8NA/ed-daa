// O programa deverá receber um conjunto de palavras ordenadas
// associadas a uma dada sequência de ordem das letras
// e determinar qual é essa sequência.

import java.util.*;
import java.io.*;

public class DAA029 {
  static int MAX = 26;
  static int n;
  static String words[] = new String[101];
  static boolean connected[] = new boolean[MAX];
  static ArrayList<Character> output = new ArrayList<Character>();
  static boolean adj[][] = new boolean[MAX][MAX];    // Matriz de adjacencias
  static boolean visited[] = new boolean[MAX]; // Que nos ja foram visitados?

  static void buildGraph(String[] words) {
    for (int i=0; i<n-1; i++)
      for (int c=0; c < (int)words[i].length() &&
                    c < (int)words[i+1].length(); c++)
        if (words[i].charAt(c) != words[i+1].charAt(c)) {
          adj[words[i].charAt(c)-'A'][words[i+1].charAt(c)-'A'] = true;
          connected[words[i].charAt(c)-'A'] = true;
          connected[words[i+1].charAt(c)-'A'] = true;
          break;
        }
  }

  static void dfs(int v) {
    visited[v] = true;
    for (int j=0; j<MAX; j++)
      if (adj[v][j] && !visited[j])
        dfs(j);
    output.add(0, (char)v);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    for (int i=0; i<n; i++)
      words[i] = in.next();

    buildGraph(words);

    for (int i=0; i<MAX; i++) {
      if (connected[i] && !visited[i])
        dfs(i);
    }

    for (int j : output) {
      System.out.print((char)(j+'A'));
    }
    System.out.println();
  }
}
