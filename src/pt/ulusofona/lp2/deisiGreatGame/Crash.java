package pt.ulusofona.lp2.deisiGreatGame;

public class Crash extends Abismo {

    public Crash(int posicao) {
        super(posicao);
        iD = 4;
        titulo = "Crash (aka Rebentanço)";
        imagem = "Ali_Gatie.png";
    }

    public Crash(int posicao, int nrPassagens) {
        super(posicao, nrPassagens);
        iD = 4;
        titulo = "Crash (aka Rebentanço)";
        imagem = "Ali_Gatie.png";
    }

    @Override
    public String mensagem(Programmer player) {

        player.recuarAteCasaInicial();
        return "\"Welcome back...It's been a while\" - Ali Gatie\n" +
                "Recua até a casa inicial!";
    }
}
