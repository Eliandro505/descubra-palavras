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

        while (acertos < tabuleiro.getPalavras().length) {
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
        respostasCorretas = new String[tabuleiro.getPalavras().length];
        tabuleiroUm = tabuleiro.criarTabuleiro();
        palpitesCorretos = new boolean[tabuleiro.getPalavras().length];
        tabuleiro.imprimirTabuleiro(tabuleiroUm);
        Palavras.instrucoesPadrao();
        dicas = new Dicas(tabuleiro.getPalavras());
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
        } else {
            for (int i = 0; i < tabuleiro.getPalavras().length; i++) {
                if (!palpitesCorretos[i] && tabuleiro.getPalavras()[i].toLowerCase().equals(palpite)) {
                    palpitesCorretos[i] = true;
                    acertos++;
                    respostasCorretas[i] = tabuleiro.getPalavras()[i];
                    Palavras.printPadronizado("🎉 Acertou 🎉");
                    Palavras.printPadronizado("Palavras Encontradas");
                    mostrarPlacar(respostasCorretas);
                    return;
                }
            }
            Palavras.printPadronizado("❌ Palavra Errada! ❌");
        }
    }

    private void exibirResultadoFinal(String palpite) {
        if (palpite.equals("0")) Palavras.printPadronizado("\uD83D\uDC80 Você desistiu! \uD83D\uDC80");
        else {
            Palavras.printPadronizado(pontos.getPontos());
            Palavras.printPadronizado("\uD83C\uDFC6 Parabéns XDD \uD83C\uDFC6");
        }
    }
}
