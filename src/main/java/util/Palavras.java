package util;

import java.util.Random;

public class Palavras {
    private Random rand = new Random();
    private String palavraEscolhida;
    private String palavraEmbaralhada;
    private String[] palavrasEscolhidas;
    private String[] palavras = {"Cachorro", "Amigo", "Rápido", "Escola", "Mundo",
            "Futuro", "Lágrima", "Verão", "Coração", "Árvore",
            "Livro", "Janela", "Mesa", "Estrada", "Sol",
            "Mar", "Cidade", "Sorriso", "Feliz", "Amor",
            "Paz", "Luz", "Sombra", "Caminho", "Estrela",
            "Vento", "Gato", "Lutar", "Reino", "Céu", "Fruta"};

    public Palavras(int quantidadePalavras) {
        this.palavrasEscolhidas = retornarPalavras(quantidadePalavras);
        this.palavraEscolhida = palavrasEscolhidas[0];
        this.palavraEmbaralhada = embaralharPalavra(palavraEscolhida);
    }

    private String[] retornarPalavras(int quantidadePalavras) {
        String[] palavrasEscolhidas = new String[quantidadePalavras];

        for (int i = 0; i < quantidadePalavras; i++) {
            palavrasEscolhidas[i] = palavras[rand.nextInt(palavras.length)];
        }

        return palavrasEscolhidas;
    }

    private String embaralharPalavra(String palavra) {
        char[] palavraArray = palavra.toCharArray();
        for (int i = 0; i < palavraArray.length; i++) {
            int indexAleatorio = rand.nextInt(palavraArray.length);
            char temp = palavraArray[i];
            palavraArray[i] = palavraArray[indexAleatorio];
            palavraArray[indexAleatorio] = temp;
        }
        return new String(palavraArray);
    }

    public static void printPadronizado(String palavra) {
        int tracosTotais = 42 - palavra.length() - 2;
        int tracosAtras = tracosTotais / 2;
        int tracosFrente = tracosTotais - tracosAtras;
        System.out.println("-".repeat(tracosAtras) + " [" + palavra + "] " + "-".repeat(tracosFrente));
    }

    public static void instrucoesPadrao() {
        printPadronizado("Digite [dica] para receber dicas");
        printPadronizado("Digite [0] para desistir");
    }

    public String getPalavraEscolhida() { return palavraEscolhida; }

    public String getPalavraEmbaralhada() { return palavraEmbaralhada; }

    public String[] getPalavrasEscolhidas() { return palavrasEscolhidas; }
}