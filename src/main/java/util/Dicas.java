package util;

import java.util.Random;

public class Dicas {
    private String palavra;
    private char[] palavraRelevada;
    private Random rand = new Random();

    public Dicas(String palavra) {
        this.palavra = palavra;
        palavraRelevada = palavra.toCharArray();

        for (int i = 1; i < palavraRelevada.length - 1; i++) {
            palavraRelevada[i] = '.';
        }

    }

    public String mostrarDica(){
        String dica = new String(palavraRelevada);

        for (int i = 1; i < palavraRelevada.length - 1; i++) {
            int randomIndex = rand.nextInt(palavraRelevada.length);

            if (palavraRelevada[randomIndex] == '.') {
                palavraRelevada[randomIndex] = palavra.charAt(randomIndex);
                break;
            }
        }
        return dica;
    }
}
