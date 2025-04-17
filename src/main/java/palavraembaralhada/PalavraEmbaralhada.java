package palavraembaralhada;

import util.Dicas;
import util.Palavras;
import util.Pontuacao;

import java.util.Scanner;

public class PalavraEmbaralhada {
    public void run() {
        Palavras palavra = new Palavras(1);
        Pontuacao pontos = new Pontuacao();
        Dicas dica = new Dicas(palavra.palavraEscolhida);

        System.out.printf("Digite [dica] para receber uma dica. \nDigite [0] para desistir\n");

        Scanner scan = new Scanner(System.in);
        System.out.printf("[------] ");
        while (true) {
            System.out.printf("Adivinhe a seguinte palavra: %s // ", palavra.palavraEmbaralhada.toLowerCase());
            String entrada = scan.nextLine().toLowerCase();
            if (entrada.equals("0")) break;
            else if (entrada.equals("dica")) {
                pontos.removerPontos();
                Palavras.printPadronizado(dica.mostrarDica());
                System.out.printf("[------] ");
            }
            else if (entrada.equals(palavra.palavraEscolhida.toLowerCase())) {
                Palavras.printPadronizado("ACERTOU");
                Palavras.printPadronizado(pontos.retornarPontuacao());
                break;
            }
            else System.out.printf("[ERRADO] ");
        }

    }
}