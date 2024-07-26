package pt.ulusofona.lp2.deisiGreatGame;

public class InvalidInitialBoardException extends java.lang.Exception {
    String mensagem;
    Comando comando;


    public InvalidInitialBoardException(String mensagem) {
        this.mensagem = mensagem;
    }

    public InvalidInitialBoardException(String mensagem, Comando comando) {
        this.mensagem = mensagem;
        this.comando = comando;
    }

    public String getMessage() {
        return mensagem;
    }

    public boolean isInvalidAbyss() {
        return  false;
    }

    public boolean isInvalidTool() {
        return  false;
    }

    public String getTypeId(){
        return "" + comando.getiD();
    }
}
