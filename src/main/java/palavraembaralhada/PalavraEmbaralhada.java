package palavraembaralhada;

import util.Dicas;
import util.Palavras;
import util.Pontuacao;

import java.util.Scanner;

public class PalavraEmbaralhada {
    private Scanner scan;
    private Palavras palavra;
    private Pontuacao pontos;
    private Dicas dica;
    private String palpite= "";

    public void run() {
        iniciarJogo();

        while (true) {
            palpite = lerEntrada();
            if (palpite.equals("0")) break;
            boolean acertou = processarPalpite(palpite);
            if (acertou) break;
        }
    }

    private void iniciarJogo() {
        palavra = new Palavras(1);
        pontos = new Pontuacao();
        dica = new Dicas(palavra.palavraEscolhida);
        scan = new Scanner(System.in);
        System.out.printf("Digite [dica] para receber uma dica. \nDigite [0] para desistir\n");
        System.out.printf("[------] ");
    }

    private String lerEntrada() {
        System.out.printf("Adivinhe a seguinte palavra: %s // ", palavra.palavraEmbaralhada.toLowerCase());
        return scan.nextLine().toLowerCase();
    }

    private boolean processarPalpite(String palpite) {
        if (palpite.equals("dica")) {
            pontos.removerPontos();
            dica.mostrarDica();
            System.out.printf("[------] ");
        } else if (palpite.equals(palavra.palavraEscolhida.toLowerCase())) {
            Palavras.printPadronizado("ACERTOU");
            Palavras.printPadronizado(pontos.retornarPontuacao());
            return true;
        } else System.out.printf("[ERRADO] ");
        return false;
    }
}