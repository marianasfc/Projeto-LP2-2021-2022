package pt.ulusofona.lp2.deisiGreatGame;

public enum ProgrammerColor {
    PURPLE("Purple"), BLUE ("Blue"), GREEN ("Green"), BROWN ("Brown");
    String cor;

    ProgrammerColor(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor.toString();
    }

    @Override
    public String toString() {
        return cor;
    }
}

