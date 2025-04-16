package cacapalavras;

import util.Dicas;

import java.util.Scanner;
import java.util.TreeMap;

public class CacaPalavras {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.definirDificuldade();
        String[] respostasCorretas = new String[tabuleiro.palavrasEscolhidas.length];
        char [][] tabuleiroUm = tabuleiro.criarTabuleiro();
        String palpite = "";
        boolean[] palpitesCorretos = new boolean[tabuleiro.palavrasEscolhidas.length];
        int acertos = 0;
        tabuleiro.imprimirTabuleiro(tabuleiroUm);

        System.out.printf("Digite [dica] + [1,2 ou 3] para receber uma dica. \nDigite [0] para desistir\n");

        Dicas dicaPrimeira = new Dicas(tabuleiro.palavrasEscolhidas[0]);
        Dicas dicaSegunda = null;
        Dicas dicaTerceira = null;
        if(tabuleiro.palavrasEscolhidas.length > 1) {
            dicaSegunda = new Dicas(tabuleiro.palavrasEscolhidas[1]);
        }
        if(tabuleiro.palavrasEscolhidas.length == 3) {
            dicaTerceira = new Dicas(tabuleiro.palavrasEscolhidas[2]);
        }

        while (acertos < tabuleiro.palavrasEscolhidas.length) {
            System.out.print("------[Digite um palpite: ");
            palpite = scan.nextLine().toLowerCase();
            boolean acertouPalavra = false;

            if (palpite.equals("0")) break;
            else if (palpite.equals("dica")) {
                System.out.printf("--------------- [%s] ---------------\n", dicaPrimeira.mostrarDica());
                if(tabuleiro.palavrasEscolhidas.length > 1) {
                    System.out.printf("--------------- [%s] ---------------\n", dicaSegunda.mostrarDica());
                    if(tabuleiro.palavrasEscolhidas.length == 3) {
                        System.out.printf("--------------- [%s] ---------------\n", dicaTerceira.mostrarDica());
                    }
                }
                acertouPalavra = true;
            }


            for (int i = 0; i < tabuleiro.palavrasEscolhidas.length; i++) {
                if (!palpitesCorretos[i] && tabuleiro.palavrasEscolhidas[i].toLowerCase().equals(palpite)) {
                    palpitesCorretos[i] = true;
                    acertos++;
                    acertouPalavra = true;
                    respostasCorretas[i] = tabuleiro.palavrasEscolhidas[i];
                    System.out.println("------[🎉🎉 Acertou uma! 🎉🎉]------");
                    System.out.println("------[⬇\uFE0F⬇\uFE0F Encontradas! ⬇\uFE0F⬇\uFE0F]------");
                    mostrarPlacar(respostasCorretas);
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

    private static void mostrarPlacar(String[] palavras) {
        for (int i = 0; i < palavras.length; i++) {
            if (palavras[i] != null){
                System.out.printf("--------------- [%s] ---------------\n", palavras[i]);
            } else System.out.printf("--------------- [?] ---------------\n");
        }
    }
}
