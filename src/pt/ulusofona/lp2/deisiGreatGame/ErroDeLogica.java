package pt.ulusofona.lp2.deisiGreatGame;

public class ErroDeLogica extends Abismo {

    public ErroDeLogica(int posicao) {
        super(posicao);
        iD = 1;
        titulo = "Erro de lógica";
        imagem = "Rihanna.png";
    }

    public ErroDeLogica(int posicao, int nrPassagens) {
        super(posicao, nrPassagens);
        iD = 1;
        titulo = "Erro de lógica";
        imagem = "Rihanna.png";
    }

    @Override
    public String mensagem(Programmer player) {
        for(Ferramenta f : player.getFerramentas()){
            if(f.getiD() == 2){
                player.removerFerramenta(f);
                return "\"It's time for me to take it, I'm the boss right now\"\n" +
                        "Usaste a ajuda da Demi Lovato!";
            }
            if(f.getiD() == 5){
                player.removerFerramenta(f);
                return "\"you're not gonna break my soul\"\n" +
                        "Usaste a ajuda da Kate Perry!";
            }
        }
        player.retirarMetadeValorDado();
        return "\"Just gonna stand here and watch you burn\" - Rihanna\n" +
                "Recua metade do valor que calhou no dado";
    }
}
