package pt.ulusofona.lp2.deisiGreatGame;

public class EfeitoSecundario extends Abismo {

    public EfeitoSecundario(int posicao) {
        super(posicao);
        iD = 6;
        titulo = "Efeitos secundários";
        imagem = "Harry_Styles.png";
    }

    public EfeitoSecundario(int posicao, int nrPassagens) {
        super(posicao, nrPassagens);
        iD = 6;
        titulo = "Efeitos secundários";
        imagem = "Harry_Styles.png";

    }

    @Override
    public String mensagem(Programmer player) {

        for(Ferramenta f : player.getFerramentas()){
            if(f.getiD() == 1){
                player.removerFerramenta(f);
                return "\"If you ever find yourself lost in the dark and you can't see I'll be the light to guide you\"\n" +
                        "Usaste a ajuda do Bruno Mars!";
            }
        }

        player.recuar2JogadasAtras();
        return "\"Don't blame me for falling\" - Harry Styles\n" +
                "Recua para a casa em que estavas há duas jogadas!";
    }
}
