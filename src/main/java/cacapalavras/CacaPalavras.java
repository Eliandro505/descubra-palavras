package cacapalavras;

import util.Dicas;
import util.Palavras;
import util.Pontuacao;

import java.util.Scanner;

public class CacaPalavras {
    private Scanner scan;
    private Tabuleiro tabuleiro;
    private Dicas dicas;
    private Pontuacao pontos;
    private String[] respostasCorretas;
    private char[][] tabuleiroUm;
    private boolean[] palpitesCorretos;
    private int acertos = 0;
    private String palpite = "";

    public void run() {
        iniciarJogo();

        while (acertos < tabuleiro.palavras.palavrasEscolhidas.length) {
            palpite = lerPalpite();
            if (palpite.equals("0")) break;
            processarPalpite(palpite);
        }

        exibirResultadoFinal(palpite);
    }

    private void iniciarJogo() {
        scan = new Scanner(System.in);
        tabuleiro = new Tabuleiro();
        pontos = new Pontuacao();
        tabuleiro.definirDificuldade();
        respostasCorretas = new String[tabuleiro.palavras.palavrasEscolhidas.length];
        tabuleiroUm = tabuleiro.criarTabuleiro();
        palpitesCorretos = new boolean[tabuleiro.palavras.palavrasEscolhidas.length];
        tabuleiro.imprimirTabuleiro(tabuleiroUm);
        Palavras.printPadronizado("Digite [dica] para receber dicas");
        Palavras.printPadronizado("Digite [0] para desistir");
        dicas = new Dicas(tabuleiro.palavras.palavrasEscolhidas);
    }

    private void mostrarPlacar(String[] palavras) {
        for (int i = 0; i < palavras.length; i++) {
            if (palavras[i] != null){
                Palavras.printPadronizado(palavras[i]);
            } else Palavras.printPadronizado("?");
        }
    }

    private String lerPalpite() {
        System.out.print("------[Digite um palpite: ");
        return scan.nextLine().toLowerCase();
    }

    private void  processarPalpite(String palpite) {
        if (palpite.equals("dica")) {
            pontos.removerPontos();
            dicas.mostrarDica();
            return;
        }

        for (int i = 0; i < tabuleiro.palavras.palavrasEscolhidas.length; i++) {
            if (!palpitesCorretos[i] && tabuleiro.palavras.palavrasEscolhidas[i].toLowerCase().equals(palpite)) {
                palpitesCorretos[i] = true;
                acertos++;
                respostasCorretas[i] = tabuleiro.palavras.palavrasEscolhidas[i];
                Palavras.printPadronizado("🎉 Acertou 🎉");
                Palavras.printPadronizado("Palavras Encontradas");
                mostrarPlacar(respostasCorretas);
                return;
            }
        }
        Palavras.printPadronizado("❌ Palavra Errada! ❌");
    }

    private void exibirResultadoFinal(String palpite) {
        if (palpite.equals("0")) Palavras.printPadronizado("\uD83D\uDC80 Você desistiu! \uD83D\uDC80");
        else {
            Palavras.printPadronizado(pontos.retornarPontuacao());
            Palavras.printPadronizado("\uD83C\uDFC6 Parabéns XDD \uD83C\uDFC6");
        }
    }
}
