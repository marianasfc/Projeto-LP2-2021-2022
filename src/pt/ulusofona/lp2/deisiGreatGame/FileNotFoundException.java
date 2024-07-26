package pt.ulusofona.lp2.deisiGreatGame;

public class FileNotFoundException extends Abismo {

    public FileNotFoundException(int posicao) {
        super(posicao);
        iD = 3;
        titulo = "File Not Found Exception";
        imagem = "Ed_Sheeran.png";
    }

    public FileNotFoundException(int posicao, int nrPassagens) {
        super(posicao, nrPassagens);
        iD = 3;
        titulo = "File Not Found Exception";
        imagem = "Ed_Sheeran.png";
    }

    @Override
    public String mensagem(Programmer player) {

        for(Ferramenta f : player.getFerramentas()){
            if(f.getiD() == 3){
                player.removerFerramenta(f);
                return "\"I was there for you in your darkest times\"\n" +
                        "Usaste a ajuda dos Maroon5!";
            }
            if(f.getiD() == 5){
                player.removerFerramenta(f);
                return "\"You held me down, but I got up\"\n" +
                        "Usaste a ajuda da Kate Perry!";
            }
        }
        player.recuar(3);
        return "\"Maybe I came on too strong\" - Ed Sheeran\n" +
                "Recua três casas!";
    }
}
