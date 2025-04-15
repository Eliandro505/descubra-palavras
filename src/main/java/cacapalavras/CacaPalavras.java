package cacapalavras;

import java.util.Scanner;
import java.util.TreeMap;

public class CacaPalavras {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.definirDificuldade();
        char [][] tabuleiroUm = tabuleiro.criarTabuleiro();
        String palpite = "";
        boolean[] palpitesCorretos = new boolean[tabuleiro.palavrasEscolhidas.length];
        int acertos = 0;
        tabuleiro.imprimirTabuleiro(tabuleiroUm);

        System.out.printf("Digite [dica] para receber uma dica. \nDigite [0] para desistir\n");

        while (acertos < tabuleiro.palavrasEscolhidas.length) {
            System.out.print("------[Digite um palpite: ");
            palpite = scan.nextLine().toLowerCase();
            if (palpite.equals("0")) break;

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
        if (palpite.equals("0")) System.out.println("------[\uD83D\uDC80\uD83D\uDC80 Você desistiu! \uD83D\uDC80\uD83D\uDC80]---------");
        else System.out.println("------[\uD83C\uDFC6\uD83C\uDFC6 Parabéns XDD \uD83C\uDFC6\uD83C\uDFC6]---------");
    }
}
