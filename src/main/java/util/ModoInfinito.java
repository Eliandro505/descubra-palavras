package util;

import java.util.Scanner;

public class ModoInfinito {
    public static Boolean continuarGame(int game) {
        Scanner scan = new Scanner(System.in);

        if (game == 1) Palavras.printPadronizado("Outro tabuleiro será gerado");
        else if (game == 2) Palavras.printPadronizado("Outra palavra será gerada");

        Palavras.printPadronizado("Digite [0] se quiser parar");
        System.out.printf("////////// ");
        String escolha = scan.nextLine();

        if (escolha.equals("0")) {
            Palavras.printPadronizado("Obrigado por Jogar <3<3<3");
            return false;
        }

        return true;
    }

}
