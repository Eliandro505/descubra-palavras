package util;

public class Pontuacao {
    int pontos = 1000;
    long tempoInicial;
    long tempoFinal;

    public void iniciarPontuacao(){
        tempoInicial = System.currentTimeMillis();
    }

    public void removerPontos() {
        this.pontos -= 250;
    }

    public String retornarPontuacao() {
        tempoFinal = System.currentTimeMillis();
        pontos -= (int) (tempoFinal-tempoInicial) / 1000;
        if (pontos < 0) pontos = 0;
        return ("Seus pontos: "+pontos);
    }
}
