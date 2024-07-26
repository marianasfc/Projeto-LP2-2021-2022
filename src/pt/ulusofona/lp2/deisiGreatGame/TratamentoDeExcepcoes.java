package pt.ulusofona.lp2.deisiGreatGame;

public class TratamentoDeExcepcoes extends Ferramenta {

    public TratamentoDeExcepcoes(int posicao) {
        super(posicao);
        iD = 3;
        titulo = "Tratamento de Excepções";
        imagem = "Maroon5.png";
    }

    public TratamentoDeExcepcoes() {
        super();
        iD = 3;
        titulo = "Tratamento de Excepções";
        imagem = "Maroon5.png";
    }

    @Override
    public String mensagem(Programmer player) {

        return "Ganhaste a ajuda dos Maroon5!";
    }
}
