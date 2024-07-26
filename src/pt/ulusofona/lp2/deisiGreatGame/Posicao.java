package pt.ulusofona.lp2.deisiGreatGame;

public class Posicao {
    private int nrPosicao;
    private int nrPassagens = 0;

    public Posicao(int nrPosicao) {
        this.nrPosicao = nrPosicao;
    }

    public int getNrPosicao() {
        return nrPosicao;
    }

    public int getNrPassagens() {
        return nrPassagens;
    }

    public void aumentaNrPassagens() {
        nrPassagens++;
    }
}
