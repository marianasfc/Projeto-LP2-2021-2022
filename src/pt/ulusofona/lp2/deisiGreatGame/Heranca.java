package pt.ulusofona.lp2.deisiGreatGame;

public class Heranca extends Ferramenta {

    public Heranca(int posicao) {
        super(posicao);
        iD = 0;
        titulo = "Herança";
        imagem = "Adele.png";
    }

    public Heranca() {
        super();
        iD = 0;
        titulo = "Herança";
        imagem = "Adele.png";
    }

    @Override
    public String mensagem(Programmer player) {

        return "Ganhaste a ajuda da Adele!";
    }
}
