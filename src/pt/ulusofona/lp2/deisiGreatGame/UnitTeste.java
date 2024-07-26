package pt.ulusofona.lp2.deisiGreatGame;

public class UnitTeste extends Ferramenta {

    public UnitTeste(int posicao) {
        super(posicao);
        iD = 2;
        titulo = "Testes unitários";
        imagem = "Demi_Lovato.png";
    }

    public UnitTeste() {
        super();
        iD = 2;
        titulo = "Testes unitários";
        imagem = "Demi_Lovato.png";
    }

    @Override
    public String mensagem(Programmer player) {

        return "Ganhaste a ajuda da Demi Lovato!";
    }
}
