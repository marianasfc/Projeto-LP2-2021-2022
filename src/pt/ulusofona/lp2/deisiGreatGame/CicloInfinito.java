package pt.ulusofona.lp2.deisiGreatGame;

public class CicloInfinito extends Abismo {
    Programmer programmer;

    public CicloInfinito(int posicao) {
        super(posicao);
        iD = 8;
        titulo = "Ciclo infinito";
        imagem = "Justin_Bieber.png";
    }

    public CicloInfinito(int posicao, int nrPassagens) {
        super(posicao, nrPassagens);
        iD = 8;
        titulo = "Ciclo infinito";
        imagem = "Justin_Bieber.png";
    }

    @Override
    public String mensagem(Programmer player) {
        for (Ferramenta f : player.getFerramentas()) {
            if (f.getiD() == 1) {
                player.removerFerramenta(f);
                return "\"You can count on me... " +
                        "I'ma leave the door open\"\n" +
                        "Usaste a ajuda do Bruno Mars!";
            }
        }

        if(programmer != null){
            programmer.cicloInfinito();
            player.cicloInfinito();
            programmer = player;
            return "\"I need you to stay\" - Justin Bieber\n" +
                    "Salvaste o jogador que aqui estava e como consequência tens de ficar aqui parado";
        }else{
            programmer = player;
            programmer.cicloInfinito();
            return "\"Is it too late now to say sorry?\" - Justin Bieber\n" +
                    "Fica parado na casa em que te encontras até que outro jogador caia nesta casa";
        }
    }
}