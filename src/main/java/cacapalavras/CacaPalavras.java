package cacapalavras;

import java.util.Scanner;
import java.util.TreeMap;

public class CacaPalavras {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.definirDificuldade();
        char [][] tabuleiroUm = tabuleiro.criarTabuleiro();
        boolean[] palpitesCorretos = new boolean[tabuleiro.palavrasEscolhidas.length];
        int acertos = 0;
        tabuleiro.imprimirTabuleiro(tabuleiroUm);

        while (acertos < tabuleiro.palavrasEscolhidas.length) {
            System.out.print("------[Digite um palpite: ");
            String palpite = scan.nextLine().toLowerCase();

            boolean acertouPalavra = false;
            for (int i = 0; i < tabuleiro.palavrasEscolhidas.length; i++) {
                if (!palpitesCorretos[i] && tabuleiro.palavrasEscolhidas[i].toLowerCase().equals(palpite)) {
                    palpitesCorretos[i] = true;
                    acertos++;
                    acertouPalavra = true;
                    System.out.println("------[🎉🎉 Acertou uma! 🎉🎉]------");
                    break;
                }
            }

            if (!acertouPalavra) {
                System.out.println("------[❌❌ Errouuu ops! ❌❌]------");
            }
        }
        System.out.println("------[\uD83C\uDFC6\uD83C\uDFC6 Parabéns XDD \uD83C\uDFC6\uD83C\uDFC6]---------");
    }
}
