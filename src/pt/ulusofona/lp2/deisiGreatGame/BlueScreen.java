package pt.ulusofona.lp2.deisiGreatGame;

public class BlueScreen extends Abismo {

    public BlueScreen(int posicao) {
        super(posicao);
        iD = 7;
        titulo = "Blue Screen of Death";
        imagem = "Marshmello.png";
    }

    public BlueScreen(int posicao, int nrPassagens) {
        super(posicao, nrPassagens);
        iD = 7;
        titulo = "Blue Screen of Death";
        imagem = "Marshmello.png";
    }

    @Override
    public String mensagem(Programmer player) {

        player.estadoDerrotado();
        return "\"I think that we both know the way that this story ends\" - Marshmello\n" +
                "Tiveste azar, perdeste o jogo!";
    }
}