package pt.ulusofona.lp2.deisiGreatGame;

public class AjudaDoProfessor extends Ferramenta {
    public AjudaDoProfessor(int posicao) {
        super(posicao);
        iD = 5;
        titulo = "Ajuda do professor";
        imagem = "Kate_Perry.png";
    }

    public AjudaDoProfessor() {
        super();
        iD = 5;
        titulo = "Ajuda do professor";
        imagem = "Kate_Perry.png";
    }

    @Override
    public String mensagem(Programmer player) {
        return "Ganhaste a ajuda da Kate Perry!";
    }
}
