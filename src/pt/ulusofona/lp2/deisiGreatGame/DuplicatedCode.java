package pt.ulusofona.lp2.deisiGreatGame;

public class DuplicatedCode extends Abismo {

    public DuplicatedCode(int posicao) {
        super(posicao);
        iD = 5;
        titulo = "Duplicated Code";
        imagem = "Miley_Cyrus.png";
    }

    public DuplicatedCode(int posicao, int nrPassagens) {
        super(posicao, nrPassagens);
        iD = 5;
        titulo = "Duplicated Code";
        imagem = "Miley_Cyrus.png";
    }

    @Override
    public String mensagem(Programmer player) {
        for(Ferramenta f : player.getFerramentas()){
            if(f.getiD() == 0){
                player.removerFerramenta(f);
                return "\"I know there is hope in these waters\"\n" +
                        "Usaste a ajuda da Adele";
            }
        }
        player.retiraValorDado();
        return "\"I came in like a wrecking ball\" - Miley Cyrus\n" +
                "Recua até a casa anterior!";
    }
}
