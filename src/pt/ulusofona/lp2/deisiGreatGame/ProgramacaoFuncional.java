package pt.ulusofona.lp2.deisiGreatGame;

public class ProgramacaoFuncional extends Ferramenta {

    public ProgramacaoFuncional(int posicao) {
        super(posicao);
        iD = 1;
        titulo = "Programação Funcional";
        imagem = "Bruno_Mars.png";
    }

    public ProgramacaoFuncional() {
        super();
        iD = 1;
        titulo = "Programação Funcional";
        imagem = "Bruno_Mars.png";
    }

    @Override
    public String mensagem(Programmer player) {

        return "Ganhaste a ajuda do Bruno Mars!";
    }
}
