package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public class Programmer {
    private int id;
    private String nome;
    private ArrayList<String> linguagemFav = new ArrayList<>();
    private ArrayList<Ferramenta> ferramentas;
    private ArrayList<Integer> todosValoresDado = new ArrayList<>();
    private ProgrammerColor cor;
    private int posicao = 1;
    private boolean estado = true;
    private int valorDado = 0;
    private boolean verificaCicloInfinito;

    public Programmer(int id, String nome, ArrayList<String> linguagemFav, ProgrammerColor cor) {
        this.id = id;
        this.nome = nome;
        this.linguagemFav = linguagemFav;
        this.cor = cor;
        ferramentas = new ArrayList<>();
        todosValoresDado.add(0);
        todosValoresDado.add(0);
        verificaCicloInfinito = false;
    }

    public Programmer() {
    }

    public Programmer(String nome, int id, ProgrammerColor cor, ArrayList<String> linguagemFav, int posicao, ArrayList<Integer> todosValoresDado, ArrayList<Ferramenta> ferramentas, boolean verificaCicloInfinito, boolean estado ) {
        this.id = id;
        this.nome = nome;
        this.linguagemFav = linguagemFav;
        this.ferramentas = ferramentas;
        this.todosValoresDado = todosValoresDado;
        this.cor = cor;
        this.posicao = posicao;
        this.estado = estado;
        this.verificaCicloInfinito = verificaCicloInfinito;
    }

    public String linguagemF() {
        String ling = "";
        for (String linguagem : linguagemFav) {
            ling += linguagem + "; ";
        }
        return ling.substring(0, ling.length() - 2);
    }

    public int getPosicao() {
        return posicao;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return nome;
    }

    public boolean isEstado() {
        return estado;
    }

    public int getValorDado() {
        return valorDado;
    }

    public ProgrammerColor getColor() {
        return cor;
    }

    public boolean isVerificaCicloInfinito() {
        return verificaCicloInfinito;
    }

    public ArrayList<Ferramenta> getFerramentas() {
        return ferramentas;
    }

    public ArrayList<String> getLinguagemFav() {
        return linguagemFav;
    }

    public String ferramentasList() {
        if (ferramentas == null || ferramentas.size() == 0) {
            return "No tools";
        }
        StringBuilder ferr = new StringBuilder();
        for (Ferramenta ferramenta : ferramentas) {
            ferr.append(ferramenta.getTitulo()).append(";");
        }
        return ferr.substring(0, ferr.length() - 1);
    }

    public boolean movePosition(int moveUp, int boardsize) {
        valorDado = moveUp;
        todosValoresDado.add(valorDado);
        if (posicao + moveUp < boardsize) {
            posicao += moveUp;
            return true;
        }
        int difference = (posicao + moveUp) - boardsize;
        int extra = boardsize - posicao;
        posicao += extra;
        posicao -= difference;
        return true;
    }

    public void estadoDerrotado() {
        estado = false;
    }

    public void recuar(int pos) {
        posicao -= pos;
    }

    public void recuarAteCasaInicial() {
        posicao = 1;
    }

    public void retiraValorDado() {
        posicao -= valorDado;
    }

    public void retirarMetadeValorDado() {
        int pos = valorDado / 2;
        posicao -= pos;
    }

    public void recuar2JogadasAtras() {
        posicao -= todosValoresDado.get(todosValoresDado.size() - 1);
        posicao -= todosValoresDado.get(todosValoresDado.size() - 2);
    }

    public void cicloInfinito() {
        if (!verificaCicloInfinito) {
            verificaCicloInfinito = true;
            return;
        }
        verificaCicloInfinito = false;
    }

    public String cicloInfinitoString() {
        if (verificaCicloInfinito) {
            return "Sim";
        }
        return "Não";
    }

    public String estadoString() {
        if (estado) {
            return "Sim";
        }
        return "Não";
    }



    public void adicionarFerramenta(Ferramenta ferramenta) {
        for (Ferramenta f : ferramentas) {
            if (f.getiD() == ferramenta.getiD()) {
                if (f.getTitulo().equals(ferramenta.getTitulo())) {
                    return;
                }
            }
        }
        ferramentas.add(ferramenta);
    }

    public void removerFerramenta(Ferramenta ferramenta) {
        for (Ferramenta f : ferramentas) {
            if (f.getiD() == ferramenta.getiD()) {
                ferramentas.remove(f);
                return;
            }
        }
    }

    public static ArrayList<String> linguagensProgram(String linguagens){
        String[] linguagem = linguagens.split(";");
        ArrayList<String> allLinguagens = new ArrayList<>(Arrays.asList(linguagem));
        Collections.sort(allLinguagens);
        return allLinguagens;
    }

    public static String primeiroNome(String nome){
        String[] nome1 = nome.split(" ");
        return nome1[0];
    }

    public static Boolean existeLinguagem(String linguagem, String linguagemEscolhida){
        ArrayList<String> allLinguagens = linguagensProgram(linguagem);
        for(String linguagens : allLinguagens){
            if(linguagens.trim().equals(linguagemEscolhida.trim())){
              return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> converterValorDadoArray(String valorDado){
        String[] valoresDado = valorDado.split(";");
        ArrayList<Integer> allValorDado = new ArrayList<Integer>();
        for(String valores : valoresDado){
            allValorDado.add(Integer.parseInt(valores));
        }
        return allValorDado;
    }

    public static ArrayList<Ferramenta> listaFerramentas(String ferramenta){
        String[] ferramentas = ferramenta.split(";");
        ArrayList<Ferramenta> allFerramentas = new ArrayList<>();
        for(String f : ferramentas){
            switch (f){
                case "Herança" :
                    Ferramenta ferramenta1 = new Heranca();
                    allFerramentas.add(ferramenta1);
                case "Programação Funcional":
                    Ferramenta ferramenta2 = new ProgramacaoFuncional();
                    allFerramentas.add(ferramenta2);
                case "Unit Teste":
                    Ferramenta ferramenta3 = new UnitTeste();
                    allFerramentas.add(ferramenta3);
                case "Tratamento de excepções" :
                    Ferramenta ferramenta4 = new TratamentoDeExcepcoes();
                    allFerramentas.add(ferramenta4);
                case "IDE":
                    Ferramenta ferramenta5 = new IDE();
                    allFerramentas.add(ferramenta5);
                case "Ajuda do professor" :
                    Ferramenta ferramenta6 = new AjudaDoProfessor();
                    allFerramentas.add(ferramenta6);
            }
        }
        return allFerramentas;
    }

    public static boolean estado(String estado){
        return estado.equals("Sim");
    }

    public String booleanToString() {
        if (estado) {
            return "Em Jogo";
        } else {
            return "Derrotado";
        }
    }

    public String toString() {
        return id + " | " + nome + " | " + posicao + " | " + ferramentasList() + " | " + linguagemF() + " | " + booleanToString();
    }
}