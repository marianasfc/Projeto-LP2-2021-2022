package pt.ulusofona.lp2.deisiGreatGame;

public abstract class Ferramenta extends Comando {

    public Ferramenta(int posicao) {
        super(posicao);
        identificador = 1;
    }

    public Ferramenta() {
    }
}
