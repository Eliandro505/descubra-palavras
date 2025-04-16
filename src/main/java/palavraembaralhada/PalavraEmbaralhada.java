package palavraembaralhada;

import util.Dicas;
import util.Palavras;
import java.util.Scanner;

public class PalavraEmbaralhada {
    public static void main(String[] args) {
        Palavras palavras = new Palavras();
        String palavraEscolhida = palavras.retornarPalavra();
        String palavraEmbaralhada = palavras.embaralharPalavra(palavraEscolhida);
        Dicas dica = new Dicas(palavraEscolhida);

        System.out.printf("Digite [dica] para receber uma dica. \nDigite [0] para desistir\n");

        Scanner scan = new Scanner(System.in);
        System.out.printf("[------] ");
        while (true) {
            System.out.printf("Adivinhe a seguinte palavra: %s // ", palavraEmbaralhada.toLowerCase());
            String entrada = scan.nextLine().toLowerCase();
            if (entrada.equals("0")) break;
            else if (entrada.equals("dica")) {
                Palavras.printPadronizado(dica.mostrarDica());
                System.out.printf("[------] ");
            }
            else if (entrada.equals(palavraEscolhida.toLowerCase())) {
                Palavras.printPadronizado("ACERTOU");
                break;
            }
            else System.out.printf("[ERRADO] ");
        }

    }
}