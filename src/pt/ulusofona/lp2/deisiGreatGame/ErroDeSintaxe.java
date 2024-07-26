package pt.ulusofona.lp2.deisiGreatGame;

public class ErroDeSintaxe extends Abismo {


    public ErroDeSintaxe(int posicao) {
        super(posicao);
        iD = 0;
        titulo = "Erro de sintaxe";
        imagem = "Britney_Spears.png";
    }

    public ErroDeSintaxe(int posicao, int nrPassagens) {
        super(posicao, nrPassagens);
        iD = 0;
        titulo = "Erro de sintaxe";
        imagem = "Britney_Spears.png";
    }

    @Override
    public String mensagem(Programmer player) {

        for(Ferramenta f : player.getFerramentas()){
            if(f.getiD() == 4){
                player.removerFerramenta(f);
                return "\"You saved my life again\"\n" +
                        "Usaste a ajuda da Selena Gomez!";
            }
            if(f.getiD() == 5){
                player.removerFerramenta(f);
                return "\"So keep calm, I'ma stick around\"\n" +
                        "Usaste a ajuda da Kate Perry!";
            }
        }

        player.recuar(1);
        return "\"Oops, I did it again...\" - Britney Spears!\n" +
                "Recua uma casa!";

    }


}
