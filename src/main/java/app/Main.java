package app;

import cacapalavras.CacaPalavras;
import palavraembaralhada.PalavraEmbaralhada;
import util.ModoInfinito;
import util.Palavras;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.printf("Por favor, informe qual jogo deseja executar:\n" +
                "[1] Caça-palavras\n" +
                "[2] Palavra Embaralhada\n");
        while (true) {
            System.out.printf("[R] ");
            String entrada = scan.nextLine();
            System.out.println();
            if (entrada.equals("1")) {
                do {
                    CacaPalavras.main(new String[]{});
                } while (ModoInfinito.continuarGame(1));
                break;
            } else if (entrada.equals("2")) {
                while(true) {
                    PalavraEmbaralhada.main(new String[]{});
                    if(!ModoInfinito.continuarGame(2)) break;
                }
                break;
            } else {
                Palavras.printPadronizado("❌❌ Erro! ❌❌");
                Palavras.printPadronizado(" [1] ou [2] ");
            }
        }
    }
}