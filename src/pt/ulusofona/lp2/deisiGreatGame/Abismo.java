package pt.ulusofona.lp2.deisiGreatGame;

public abstract class Abismo extends Comando {

    private int nrPassagens;

    public Abismo(int posicao) {
        super(posicao);
        identificador = 0;
    }

    public Abismo(int posicao, int nrPassagens) {
        super(posicao);
        this.nrPassagens = nrPassagens;
        identificador = 0;
    }

    public int getNrPassagens() {
        return nrPassagens;
    }

    public void aumentaNrPassagensAbismos() {
        nrPassagens++;
    }

    public abstract String mensagem(Programmer player);
}
