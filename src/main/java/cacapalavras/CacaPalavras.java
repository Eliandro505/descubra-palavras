package cacapalavras;

import util.Dicas;
import util.Palavras;
import util.Pontuacao;

import java.util.Scanner;

public class CacaPalavras {
    public void run() {
        Scanner scan = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();
        Pontuacao pontos = new Pontuacao();

        tabuleiro.definirDificuldade();
        String[] respostasCorretas = new String[tabuleiro.palavras.palavrasEscolhidas.length];
        char[][] tabuleiroUm = tabuleiro.criarTabuleiro();
        String palpite = "";
        boolean[] palpitesCorretos = new boolean[tabuleiro.palavras.palavrasEscolhidas.length];
        int acertos = 0;
        tabuleiro.imprimirTabuleiro(tabuleiroUm);

        System.out.printf("Digite [dica] + [1, 2 ou 3] para receber uma dica. \nDigite [0] para desistir\n");

        Dicas dicas = new Dicas(tabuleiro.palavras.palavrasEscolhidas);

        while (acertos < tabuleiro.palavras.palavrasEscolhidas.length) {
            System.out.print("------[Digite um palpite: ");
            palpite = scan.nextLine().toLowerCase();
            boolean acertouPalavra = false;

            if (palpite.equals("0")) break;
            else if (palpite.equals("dica")) {
                pontos.removerPontos();
                dicas.mostrarDica();
                acertouPalavra = true;
            }


            for (int i = 0; i < tabuleiro.palavras.palavrasEscolhidas.length; i++) {
                if (!palpitesCorretos[i] && tabuleiro.palavras.palavrasEscolhidas[i].toLowerCase().equals(palpite)) {
                    palpitesCorretos[i] = true;
                    acertos++;
                    acertouPalavra = true;
                    respostasCorretas[i] = tabuleiro.palavras.palavrasEscolhidas[i];
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
        if (palpite.equals("0")) Palavras.printPadronizado("\uD83D\uDC80 Você desistiu! \uD83D\uDC80");
        else {
            Palavras.printPadronizado(pontos.retornarPontuacao());
            Palavras.printPadronizado("\uD83C\uDFC6 Parabéns XDD \uD83C\uDFC6");
        }
    }

    private void mostrarPlacar(String[] palavras) {
        for (int i = 0; i < palavras.length; i++) {
            if (palavras[i] != null){
                Palavras.printPadronizado(palavras[i]);
            } else Palavras.printPadronizado("?");
        }
    }
}
