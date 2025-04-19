package util;

import java.util.Random;

public class Dicas {
    private String[] palavras;
    private char[] palavraRelevada;
    private char[][] palavrasReveladas;
    private Random rand = new Random();

    public Dicas(String palavra) {
        this(new String[] {palavra});
    }

    public Dicas(String[] palavras) {
        this.palavras = palavras;
        this.palavrasReveladas = new char[palavras.length][];

        for (int i = 0; i < palavras.length; i++) {
            palavraRelevada = palavras[i].toCharArray();

            for (int j = 1; j < palavraRelevada.length - 1; j++) {
                palavraRelevada[j] = '.';
            }
            palavrasReveladas[i] = palavraRelevada;
        }
   }

   public void mostrarDica() {
       for (int i = 0; i < palavrasReveladas.length; i++) {
           String dica = new String(palavrasReveladas[i]);

           for (int j = 0; j < palavrasReveladas[i].length; j++) {
               int randomIndex = rand.nextInt(palavrasReveladas[i].length);
               if (palavrasReveladas[i][randomIndex] == '.') {
                   palavrasReveladas[i][randomIndex] = palavras[i].charAt(randomIndex);
                   break;
               }
           }
           Palavras.printPadronizado(dica);
       }
   }
}
