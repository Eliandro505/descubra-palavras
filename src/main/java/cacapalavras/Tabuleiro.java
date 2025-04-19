package cacapalavras;

import java.util.Random;
import java.util.Scanner;
import util.Palavras;

public class Tabuleiro {
    Integer tamanho;
    Palavras palavras;
    Random rand = new Random();

    public void definirDificuldade() {
        System.out.println("Escolha a dificuldade do jogo");
        System.out.print("[Qualquer valor diferente resultará em um tabuleiro FÁCIL]\n" +
                "[1] Fácil (15x15 - 2 palavras) \n[2] Médio (20x20 - 4 palavras) \n[3] Difícil (25x25 - 6 palavras)\n" +
                "////////// ");
        String valor = new Scanner(System.in).nextLine();
        try {
            int intValor = Integer.parseInt(valor);
            if (intValor >= 1 && intValor  <= 3) {
                palavras = new Palavras(intValor*2);
                if (intValor == 2) tamanho = 20;
                else if (intValor == 3) tamanho = 25;
                else tamanho = 15;
            } else {
                palavras = new Palavras(2);
                tamanho = 15;
            }
        } catch (NumberFormatException e) {
            palavras = new Palavras(2);
            tamanho = 15;
        }
    }

    public char[][] criarTabuleiro() {
        char[][] tabuleiro = new char[tamanho][tamanho];
        inserirPalavras(tabuleiro, palavras.palavrasEscolhidas);
        for (int x = 0; x < tamanho; x++){
            for (int y = 0; y < tamanho; y++){
                if (tabuleiro[x][y] == '\0') {
                    tabuleiro[x][y] = (char) ('a' + rand.nextInt(25));
                }
            }
        }
        return tabuleiro;
    }

    private void definirSentidoInsercao(int sentido, char[][] tabuleiro, String palavra) {
        int linha, coluna;
        boolean podeInserir = false;

        while(!podeInserir) {
            if (sentido == 1) {
                linha = rand.nextInt(tamanho);
                coluna = rand.nextInt(tamanho - palavra.length());
            } else if (sentido == 2) {
                linha = rand.nextInt(tamanho - palavra.length());
                coluna = rand.nextInt(tamanho);
            } else {
                linha = rand.nextInt(tamanho - palavra.length());
                coluna = rand.nextInt(tamanho - palavra.length());
            }

            podeInserir = verificarInsercao(sentido, tabuleiro, palavra, linha, coluna);

            if (podeInserir) {
                for (int i = 0; i < palavra.length(); i++) {
                    int proximaLinha = linha;
                    int proximaColuna = coluna;

                    if (sentido == 1) {
                        proximaColuna += i;
                    } else if (sentido == 2) {
                        proximaLinha += i;
                    } else {
                        proximaLinha += i;
                        proximaColuna += i;
                    }
                    tabuleiro[proximaLinha][proximaColuna] = palavra.charAt(i);
                }
            }
        }
    }

    private boolean verificarInsercao(int sentido, char[][] tabuleiro, String palavra, int linha, int coluna) {
        for (int i = 0; i < palavra.length(); i++) {
            int proximaLinha = linha;
            int proximaColuna = coluna;

            if (sentido == 1) {
                proximaColuna += i;
            } else if (sentido == 2) {
                proximaLinha += i;
            } else {
                proximaLinha += i;
                proximaColuna += i;
            }

            if (tabuleiro[proximaLinha][proximaColuna] != '\0') {
                return false;
            }
        }
        return true;
    }

    private void inserirPalavras(char[][] tabuleiro, String[] palavrasEscolhidas) {
        for (String palavraEscolhida : palavrasEscolhidas) {
            definirSentidoInsercao(rand.nextInt(3), tabuleiro, palavraEscolhida);
        }
    }

    public void imprimirTabuleiro(char[][] tabuleiro) {
        for (int x = 0; x < tamanho; x++){
            for (int y = 0; y < tamanho; y++){
                System.out.printf("%c ", tabuleiro[x][y]);
            }
            System.out.printf("%n");
        }
        System.out.printf("%n");
    }
}
