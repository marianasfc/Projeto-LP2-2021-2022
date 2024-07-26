package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;

public class SegmentationFault extends Abismo {
    ArrayList<Programmer> players = new ArrayList<>();

    public SegmentationFault(int posicao, ArrayList<Programmer> players) {
        super(posicao);
        iD = 9;
        titulo = "Segmentation Fault";
        imagem = "Shawn_Mendes.png";
        this.players.addAll(players);
    }

    public SegmentationFault(int posicao, int nrPassagens, ArrayList<Programmer> players) {
        super(posicao, nrPassagens);
        this.players = players;
    }

    @Override
    public String mensagem(Programmer player) {
        for(Programmer p : players){
            if(player.getPosicao() == p.getPosicao()){
                if(player.getName().equals(p.getName())){
                    continue;
                }
                player.recuar(3);
                p.recuar(3);
                return "\"Please have mercy on me take it easy on my heart\" - Shawn Mendes\n" +
                        "Ambos recuam 3 casas!";
            }
        }

        return "\"I promise that one day I'll be around\" - Shawn Mendes\n" +
                "Tiveste sorte, como não está mais ninguém nesta casa, não te acontece nada!";
    }
}
