package cacapalavras;

import util.Dicas;
import util.Palavras;

import java.util.Scanner;
import java.util.TreeMap;

public class CacaPalavras {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();

        while(true) {
            tabuleiro.definirDificuldade();
            String[] respostasCorretas = new String[tabuleiro.palavrasEscolhidas.length];
            char[][] tabuleiroUm = tabuleiro.criarTabuleiro();
            String palpite = "";
            boolean[] palpitesCorretos = new boolean[tabuleiro.palavrasEscolhidas.length];
            int acertos = 0;
            tabuleiro.imprimirTabuleiro(tabuleiroUm);

            System.out.printf("Digite [dica] + [1, 2 ou 3] para receber uma dica. \nDigite [0] para desistir\n");

            Dicas dicaPrimeira = new Dicas(tabuleiro.palavrasEscolhidas[0]);
            Dicas dicaSegunda = null;
            Dicas dicaTerceira = null;
            if (tabuleiro.palavrasEscolhidas.length > 1) {
                dicaSegunda = new Dicas(tabuleiro.palavrasEscolhidas[1]);
            }
            if (tabuleiro.palavrasEscolhidas.length == 3) {
                dicaTerceira = new Dicas(tabuleiro.palavrasEscolhidas[2]);
            }

            while (acertos < tabuleiro.palavrasEscolhidas.length) {
                System.out.print("------[Digite um palpite: ");
                palpite = scan.nextLine().toLowerCase();
                boolean acertouPalavra = false;

                if (palpite.equals("0")) break;
                else if (palpite.equals("dica")) {
                    Palavras.printPadronizado(dicaPrimeira.mostrarDica());
                    if (tabuleiro.palavrasEscolhidas.length > 1) {
                        Palavras.printPadronizado(dicaSegunda.mostrarDica());
                        if (tabuleiro.palavrasEscolhidas.length == 3) {
                            Palavras.printPadronizado(dicaTerceira.mostrarDica());
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
                        Palavras.printPadronizado("🎉 Acertou 🎉");
                        Palavras.printPadronizado("Palavras Encontradas");
                        mostrarPlacar(respostasCorretas);
                        break;
                    }
                }

                if (!acertouPalavra) {
                    Palavras.printPadronizado("❌ Palavra Errada! ❌");
                }
            }
            if (palpite.equals("0")) {
                Palavras.printPadronizado("\uD83D\uDC80 Você desistiu! \uD83D\uDC80");
                break;
            }
            else Palavras.printPadronizado("\uD83C\uDFC6 Parabéns XDD \uD83C\uDFC6");
        }
    }

    private static void mostrarPlacar(String[] palavras) {
        for (int i = 0; i < palavras.length; i++) {
            if (palavras[i] != null){
                Palavras.printPadronizado(palavras[i]);
            } else Palavras.printPadronizado("?");
        }
    }
}
