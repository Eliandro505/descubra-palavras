package util;

public class Pontuacao {
    private int pontos = 1000;
    private long tempoInicial;
    private long tempoFinal;

    public Pontuacao() {
        iniciarPontuacao();
    }

    private void iniciarPontuacao(){
        tempoInicial = System.currentTimeMillis();
    }

    public void removerPontos() {
        this.pontos -= 250;
    }

    public String getPontos() {
        tempoFinal = System.currentTimeMillis();
        pontos -= (int) (tempoFinal-tempoInicial) / 1000;
        if (pontos < 0) pontos = 0;
        return ("Seus pontos: "+pontos);
    }
}
