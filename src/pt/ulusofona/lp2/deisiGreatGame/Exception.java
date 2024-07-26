package pt.ulusofona.lp2.deisiGreatGame;

public class Exception extends Abismo {

    public Exception(int posicao) {
        super(posicao);
        iD = 2;
        titulo = "Exception";
        imagem = "Beyoncé.png";
    }

    public Exception(int posicao, int nrPassagens) {
        super(posicao, nrPassagens);
        iD = 2;
        titulo = "Exception";
        imagem = "Beyoncé.png";
    }

    @Override
    public String mensagem(Programmer player) {

        for(Ferramenta f : player.getFerramentas()){
            if(f.getiD() == 3){
                player.removerFerramenta(f);
                return "\"everything gona be alright\"\n" +
                        "Usaste a ajuda dos Maroon5!";
            }
            if(f.getiD() == 5){
                player.removerFerramenta(f);
                return "\"The party don't stop\"\n" +
                        "Usaste a ajuda da Kate Perry!";
            }
        }

        player.recuar(2);
        return "\"Everything you had got destroyed\" - Beyoncé\n" +
                "Recua duas casas!";
    }
}
