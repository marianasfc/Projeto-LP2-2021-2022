package pt.ulusofona.lp2.deisiGreatGame;

public class IDE extends Ferramenta {

    public IDE(int posicao) {
        super(posicao);
        iD = 4;
        titulo = "IDE";
        imagem = "Selena_Gomez.png";
    }

    public IDE() {
        super();
        iD = 4;
        titulo = "IDE";
        imagem = "Selena_Gomez.png";
    }

    @Override
    public String mensagem(Programmer player) {

        return "Ganhaste a ajuda da Selena Gomez!";
    }
}
