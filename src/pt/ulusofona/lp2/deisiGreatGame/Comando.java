package pt.ulusofona.lp2.deisiGreatGame;

public abstract class Comando {
    protected int iD;
    protected String titulo;
    protected int posicao;
    protected String imagem;
    protected int identificador;

    public Comando(int posicao) {
        this.posicao = posicao;
    }

    public Comando() {
    }

    public String getImagem() {
        return imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getiD() {
        return iD;
    }

    public int getPosicao() {
        return posicao;
    }

    public int getIdentificador() {
        return identificador;
    }

    public boolean abismo(){
        return identificador == 0;
    }

    public boolean ferramenta(){
        return identificador == 1;
    }

    public abstract String mensagem(Programmer player);
}