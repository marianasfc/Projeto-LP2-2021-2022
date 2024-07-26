package pt.ulusofona.lp2.deisiGreatGame;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class GameManager {
    int worldSize;
    ArrayList<Programmer> players = new ArrayList<>();
    ArrayList<Comando> comandos = new ArrayList<>();
    ArrayList<Posicao> posicoes = new ArrayList<>();
    Shifts shift;

    public GameManager() {

    }

    void createInitialBoard(String[][] playerInfo, int worldSize) throws InvalidInitialBoardException {
        players.clear();
        int size = playerInfo.length;
        this.worldSize = worldSize;
        posicoes = posicoes();
        if (size == 2) {

            if (worldSize < 4) {

                throw new InvalidInitialBoardException("Tamanho de tabuleiro inválido tendo em conta o número de jogadores!");
            }

            int id1 = Integer.parseInt(playerInfo[0][0]);
            int id2 = Integer.parseInt(playerInfo[1][0]);
            if (id1 == id2 || id1 < 0 || id2 < 0) {
                throw new InvalidInitialBoardException("Id de jogador inválido!");
            }
            String nome1 = playerInfo[0][1];
            String nome2 = playerInfo[1][1];
            if (nome1 == null || nome1.length() == 0 || nome2 == null || nome2.length() == 0) {
                throw new InvalidInitialBoardException("Nome de jogador inválido!");
            }
            String linguagemFavP1 = playerInfo[0][2];
            String linguagemFav1[] = linguagemFavP1.split(";");
            ArrayList<String> linguagemFavF1 = new ArrayList<>(Arrays.asList(linguagemFav1));
            Collections.sort(linguagemFavF1);

            String linguagemFavP2 = playerInfo[1][2];
            String linguagemFav2[] = linguagemFavP2.split(";");
            ArrayList<String> linguagemFavF2 = new ArrayList<>(Arrays.asList(linguagemFav2));
            Collections.sort(linguagemFavF2);

            String cor1 = playerInfo[0][3];
            String cor2 = playerInfo[1][3];

            if ((!cor1.equals("Purple") && !cor1.equals("Green") && !cor1.equals("Brown") && !cor1.equals("Blue")) ||
                    (!cor2.equals("Purple") && !cor2.equals("Green") && !cor2.equals("Brown") && !cor2.equals("Blue"))) {
                throw new InvalidInitialBoardException("Cor de jogador inválida!");
            }
            Programmer player1 = new Programmer(id1, nome1, linguagemFavF1, ProgrammerColor.valueOf(cor1.toUpperCase()));
            Programmer player2 = new Programmer(id2, nome2, linguagemFavF2, ProgrammerColor.valueOf(cor2.toUpperCase()));
            players.add(player1);
            players.add(player2);

            players.sort(Comparator.comparingInt(Programmer::getId));
            shift = new Shifts(players, players.get(0));
        }

        if (size == 3) {

            if (worldSize < 6) {
                throw new InvalidInitialBoardException("Tamanho de tabuleiro inválido tendo em conta o número de jogadores!");
            }

            int id1 = Integer.parseInt(playerInfo[0][0]);
            int id2 = Integer.parseInt(playerInfo[1][0]);
            int id3 = Integer.parseInt(playerInfo[2][0]);
            if (id1 == id2 || id1 == id3 || id2 == id3 || id1 < 0 || id2 < 0 || id3 < 0) {
                throw new InvalidInitialBoardException("Id de jogador inválido!");
            }
            String nome1 = playerInfo[0][1];
            String nome2 = playerInfo[1][1];
            String nome3 = playerInfo[2][1];
            if (nome1 == null || nome1.length() == 0 || nome2 == null || nome2.length() == 0 || nome3 == null || nome3.length() == 0) {
                throw new InvalidInitialBoardException("Nome de jogador inválido!");
            }
            String linguagemFavP1 = playerInfo[0][2];
            String linguagemFav1[] = linguagemFavP1.split(";");
            ArrayList<String> linguagemFavF1 = new ArrayList<>(Arrays.asList(linguagemFav1));
            Collections.sort(linguagemFavF1);

            String linguagemFavP2 = playerInfo[1][2];
            String linguagemFav2[] = linguagemFavP2.split(";");
            ArrayList<String> linguagemFavF2 = new ArrayList<>(Arrays.asList(linguagemFav2));
            Collections.sort(linguagemFavF2);

            String linguagemFavP3 = playerInfo[2][2];
            String linguagemFav3[] = linguagemFavP3.split(";");
            ArrayList<String> linguagemFavF3 = new ArrayList<>(Arrays.asList(linguagemFav3));
            Collections.sort(linguagemFavF3);

            String cor1 = playerInfo[0][3];
            String cor2 = playerInfo[1][3];
            String cor3 = playerInfo[2][3];

            if ((!cor1.equals("Purple") && !cor1.equals("Green") && !cor1.equals("Brown") && !cor1.equals("Blue")) ||
                    (!cor2.equals("Purple") && !cor2.equals("Green") && !cor2.equals("Brown") && !cor2.equals("Blue"))
                    || (!cor3.equals("Purple") && !cor3.equals("Green") && !cor3.equals("Brown") && !cor3.equals("Blue"))) {
                throw new InvalidInitialBoardException("Cor de jogador inválida!");
            }

            Programmer player1 = new Programmer(id1, nome1, linguagemFavF1, ProgrammerColor.valueOf(cor1.toUpperCase()));
            Programmer player2 = new Programmer(id2, nome2, linguagemFavF2, ProgrammerColor.valueOf(cor2.toUpperCase()));
            Programmer player3 = new Programmer(id3, nome3, linguagemFavF3, ProgrammerColor.valueOf(cor3.toUpperCase()));
            players.add(player1);
            players.add(player2);
            players.add(player3);

            players.sort(Comparator.comparingInt(Programmer::getId));
            shift = new Shifts(players, players.get(0));
        }
        if (size == 4) {

            if (worldSize < 8) {
                throw new InvalidInitialBoardException("Tamanho de tabuleiro inválido tendo em conta o número de jogadores!");
            }

            int id1 = Integer.parseInt(playerInfo[0][0]);
            int id2 = Integer.parseInt(playerInfo[1][0]);
            int id3 = Integer.parseInt(playerInfo[2][0]);
            int id4 = Integer.parseInt(playerInfo[3][0]);
            if (id1 == id2 || id1 == id3 || id1 == id4 || id2 == id3 || id2 == id4 || id3 == id4
                    || id1 < 0 || id2 < 0 || id3 < 0 || id4 < 0) {
                throw new InvalidInitialBoardException("Id de jogador inválido!");
            }
            String nome1 = playerInfo[0][1];
            String nome2 = playerInfo[1][1];
            String nome3 = playerInfo[2][1];
            String nome4 = playerInfo[3][1];
            if (nome1 == null || nome1.length() == 0 || nome2 == null || nome2.length() == 0 ||
                    nome3 == null || nome3.length() == 0 || nome4 == null || nome4.length() == 0) {
                throw new InvalidInitialBoardException("Nome de jogador inválido!");
            }
            String linguagemFavP1 = playerInfo[0][2];
            String linguagemFav1[] = linguagemFavP1.split(";");
            ArrayList<String> linguagemFavF1 = new ArrayList<>(Arrays.asList(linguagemFav1));
            Collections.sort(linguagemFavF1);

            String linguagemFavP2 = playerInfo[1][2];
            String linguagemFav2[] = linguagemFavP2.split(";");
            ArrayList<String> linguagemFavF2 = new ArrayList<>(Arrays.asList(linguagemFav2));
            Collections.sort(linguagemFavF2);

            String linguagemFavP3 = playerInfo[2][2];
            String linguagemFav3[] = linguagemFavP3.split(";");
            ArrayList<String> linguagemFavF3 = new ArrayList<>(Arrays.asList(linguagemFav3));
            Collections.sort(linguagemFavF3);

            String linguagemFavP4 = playerInfo[3][2];
            String linguagemFav4[] = linguagemFavP4.split(";");
            ArrayList<String> linguagemFavF4 = new ArrayList<>(Arrays.asList(linguagemFav4));
            Collections.sort(linguagemFavF4);

            String cor1 = playerInfo[0][3];
            String cor2 = playerInfo[1][3];
            String cor3 = playerInfo[2][3];
            String cor4 = playerInfo[3][3];

            if ((!cor1.equals("Purple") && !cor1.equals("Green") && !cor1.equals("Brown") && !cor1.equals("Blue"))
                    || (!cor2.equals("Purple") && !cor2.equals("Green") && !cor2.equals("Brown") && !cor2.equals("Blue"))
                    || (!cor3.equals("Purple") && !cor3.equals("Green") && !cor3.equals("Brown") && !cor3.equals("Blue"))
                    || (!cor4.equals("Purple") && !cor4.equals("Green") && !cor4.equals("Brown") && !cor4.equals("Blue"))) {
                throw new InvalidInitialBoardException("Cor de jogador inválida!");
            }

            Programmer player1 = new Programmer(id1, nome1, linguagemFavF1, ProgrammerColor.valueOf(cor1.toUpperCase()));
            Programmer player2 = new Programmer(id2, nome2, linguagemFavF2, ProgrammerColor.valueOf(cor2.toUpperCase()));
            Programmer player3 = new Programmer(id3, nome3, linguagemFavF3, ProgrammerColor.valueOf(cor3.toUpperCase()));
            Programmer player4 = new Programmer(id4, nome4, linguagemFavF4, ProgrammerColor.valueOf(cor4.toUpperCase()));
            players.add(player1);
            players.add(player2);
            players.add(player3);
            players.add(player4);

            players.sort(Comparator.comparingInt(Programmer::getId));
            shift = new Shifts(players, players.get(0));
        }
        if (size < 2 || size > 4) {
            throw new InvalidInitialBoardException("Número de jogadores inválido!");
        }

    }

    public void createInitialBoard(String[][] playerInfo, int worldSize, String[][] abyssesAndTools) throws InvalidInitialBoardException {
        createInitialBoard(playerInfo, worldSize);
        comandos.clear();
        if(abyssesAndTools == null){
            return;
        }
        for (String[] abyssesAndTool : abyssesAndTools) {
            int identificador = Integer.parseInt(abyssesAndTool[0]);
            int id = Integer.parseInt(abyssesAndTool[1]);
            int posicao = Integer.parseInt(abyssesAndTool[2]);
            switch (identificador) {
                case 0:
                    switch (id) {
                        case 0:
                            Comando abismo1 = new ErroDeSintaxe(posicao);
                            comandos.add(abismo1);
                            break;
                        case 1:
                            Comando abismo2 = new ErroDeLogica(posicao);
                            comandos.add(abismo2);
                            break;
                        case 2:
                            Comando abismo3 = new Exception(posicao);
                            comandos.add(abismo3);
                            break;
                        case 3:
                            Comando abismo4 = new FileNotFoundException(posicao);
                            comandos.add(abismo4);
                            break;
                        case 4:
                            Comando abismo5 = new Crash(posicao);
                            comandos.add(abismo5);
                            break;
                        case 5:
                            Comando abismo6 = new DuplicatedCode(posicao);
                            comandos.add(abismo6);
                            break;
                        case 6:
                            Comando abismo7 = new EfeitoSecundario(posicao);
                            comandos.add(abismo7);
                            break;
                        case 7:
                            Comando abismo8 = new BlueScreen(posicao);
                            comandos.add(abismo8);
                            break;
                        case 8:
                            Comando abismo9 = new CicloInfinito(posicao);
                            comandos.add(abismo9);
                            break;
                        case 9:
                            Comando abismo10 = new SegmentationFault(posicao, players);
                            comandos.add(abismo10);
                            break;
                        default:
                            throw new InvalidInitialBoardException("Abismo inválido!");
                    }
                    break;
                case 1:
                    switch (id) {
                        case 0:
                            Comando ferramenta1 = new Heranca(posicao);
                            comandos.add(ferramenta1);
                            break;
                        case 1:
                            Comando ferramenta2 = new ProgramacaoFuncional(posicao);
                            comandos.add(ferramenta2);
                            break;
                        case 2:
                            Comando ferramenta3 = new UnitTeste(posicao);
                            comandos.add(ferramenta3);
                            break;
                        case 3:
                            Comando ferramenta4 = new TratamentoDeExcepcoes(posicao);
                            comandos.add(ferramenta4);
                            break;
                        case 4:
                            Comando ferramenta5 = new IDE(posicao);
                            comandos.add(ferramenta5);
                            break;
                        case 5:
                            Comando ferramenta6 = new AjudaDoProfessor(posicao);
                            comandos.add(ferramenta6);
                            break;
                        default:
                            throw new InvalidInitialBoardException("Ferramenta onválida!");
                    }
                    break;
                default:
                    throw new InvalidInitialBoardException("Comando inválido!");
            }
        }
    }

    public String getImagePng(int position) {
        for (Comando comando : comandos) {
            if (position == comando.getPosicao()) {
                return comando.getImagem();
            }
        }
        if (position == worldSize) {
            return "Grammy.png";
        }

        return "Red_Carpet.png";
    }

    public String getTitle(int position) {
        for (Comando comando : comandos) {
            if (position == comando.getPosicao()) {
                return comando.getTitulo();
            }
        }
        return null;
    }

    public List<Programmer> getProgrammers(boolean includeDefeated) {
        if (!includeDefeated) {
            ArrayList<Programmer> playersTemp = new ArrayList<>();
            for (Programmer p : players) {
                if (p.isEstado()) {
                    playersTemp.add(p);
                }
            }
            return playersTemp;
        }
        return players;
    }

    public List<Programmer> getProgrammers(int position) {
        if (position < 0 || position > worldSize) {
            return null;
        }
        ArrayList<Programmer> playerPos = new ArrayList<>();
        for (Programmer p : players) {
            if (p.getPosicao() == position && p.isEstado()) {
                playerPos.add(p);
            }
        }
        return playerPos;
    }

    public List<Programmer> getProgrammers() {
        return players;
    }

    public String getProgrammersInfo() {
        StringBuilder jogador = new StringBuilder();
        ArrayList<Programmer> ordem = new ArrayList<>(shift.getPlayers());
        ordem.sort(Comparator.comparingInt(Programmer::getId));
        for (Programmer p : ordem) {
            String nome = p.getName();
            String ferramenta = p.ferramentasList();
            jogador.append(nome).append(" : ").append(ferramenta).append(" | ");
        }

        return jogador.substring(0, jogador.length() - 3);

    }

    public int getCurrentPlayerID() {
        return shift.getPlayerOn().getId();
    }

    public boolean moveCurrentPlayer(int nrPositions) {
        if (gameIsOver()) {
            return false;
        }
        if (nrPositions < 1 || nrPositions > 6) {
            return false;
        } else if (shift.getPlayerOn().isVerificaCicloInfinito()) {
            return false;
        } else {
            shift.getPlayerOn().movePosition(nrPositions, worldSize);
            aumentaNrPassagens();
            return true;
        }
    }

    public Shifts getShift() {
        return shift;
    }

    public boolean gameIsOver() {
        if (shift.getPlayers().size() == 1) {
            return true;
        }
        for (Programmer p : players) {
            if (p.getPosicao() == worldSize) {
                return true;
            }
        }
        return false;
    }

    public List<String> getGameResults() {
        players.sort(Comparator.comparingInt(Programmer::getPosicao).reversed().thenComparing(Programmer::getName));
        ArrayList<String> resultado = new ArrayList<>();
        String titulo = "O GRANDE JOGO DO DEISI";
        resultado.add(titulo);
        String enter1 = "";
        resultado.add(enter1);
        String nrTurnos1 = "NR. DE TURNOS";
        resultado.add(nrTurnos1);
        String nrTurnos2 = Integer.toString(shift.getTurns());
        resultado.add(nrTurnos2);
        String enter2 = "";
        resultado.add(enter2);
        String vencedor1 = "VENCEDOR";
        resultado.add(vencedor1);
        String vencedor2 = players.get(0).getName();
        resultado.add(vencedor2);
        String enter3 = "";
        resultado.add(enter3);
        String vencedor3 = "RESTANTES";
        resultado.add(vencedor3);
        String mensagemFinal = "";
        for (int p = 1; p < players.size(); p++) {
            String vencedor4 = players.get(p).getName() + ' ' + players.get(p).getPosicao();
            resultado.add(vencedor4);
        }
        return resultado;
    }

    public String reactToAbyssOrTool() {

        String mensagem = "";
        for (Comando comando : comandos) {
            if (shift.playerOn.getPosicao() == comando.getPosicao()) {
                if (comando.getIdentificador() == 1) {
                    shift.playerOn.adicionarFerramenta((Ferramenta) comando);
                    mensagem = comando.mensagem(shift.getPlayerOn());
                    shift.turnsShift();
                    shift.turnsUp();
                    return mensagem;
                }
                if (comando.getPosicao() == shift.getPlayerOn().getPosicao()) {
                    ((Abismo) comando).aumentaNrPassagensAbismos();
                }
                mensagem = comando.mensagem(shift.getPlayerOn());
                shift.turnsShift();
                shift.turnsUp();
                return mensagem;
            }
        }
        shift.turnsShift();
        shift.turnsUp();
        return null;
    }

    public ArrayList<Posicao> posicoes() {
        ArrayList<Posicao> posicoes = new ArrayList<>();
        for (int i = 0; i < worldSize; i++) {
            Posicao posicao = new Posicao(i);
            posicoes.add(posicao);
        }
        return posicoes;
    }

    public boolean posicaoOcupada(int posicao) {
        for (Comando comando : comandos) {
            if (comando.getPosicao() == posicao) {
                if (comando.abismo() || comando.ferramenta()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void adicionaAbismo(int posicao, String id) {
        if (!posicaoOcupada(posicao)) {
            int identificador = Integer.parseInt(id);
            Comando comando = switch (identificador) {
                case 0 -> new ErroDeSintaxe(posicao);
                case 1 -> new ErroDeLogica(posicao);
                case 2 -> new Exception(posicao);
                case 3 -> new FileNotFoundException(posicao);
                case 4 -> new Crash(posicao);
                case 5 -> new DuplicatedCode(posicao);
                case 6 -> new EfeitoSecundario(posicao);
                case 7 -> new BlueScreen(posicao);
                case 8 -> new CicloInfinito(posicao);
                case 9 -> new SegmentationFault(posicao, players);
                default -> new ErroDeLogica(posicao);
            };
            comandos.add(comando);
        }
    }

    public void aumentaNrPassagens() {
        for (Posicao posicao : posicoes) {
            if (posicao.getNrPosicao() == shift.getPlayerOn().getPosicao()) {
                posicao.aumentaNrPassagens();
            }
        }
    }

    public ArrayList<Programmer> ordenaProgramadores(ArrayList<Programmer> programmers, Programmer jogadorAtual){
        ArrayList<Programmer> listaFinal = new ArrayList<>();
        ArrayList<Programmer> jogadorTemp = new ArrayList<>();
        jogadorTemp.addAll(programmers);
        jogadorTemp.remove(jogadorAtual);
        listaFinal.add(jogadorAtual);
        listaFinal.addAll(jogadorTemp);
        return listaFinal;
    }

    public boolean cicloInfinitoVerificar(String ciclo) {
        return ciclo.equals("Sim");
    }

    public boolean loadGame(File file) {
        players.clear();
        comandos.clear();
        FileInputStream ficheiro;
        try {
            ficheiro = new FileInputStream(file);

        } catch (java.io.FileNotFoundException e) {
            return false;
        }
        Scanner ficheiroLido = new Scanner(ficheiro);
        String linhaLida = ficheiroLido.nextLine();
        worldSize = Integer.parseInt(linhaLida);

        linhaLida = ficheiroLido.nextLine();
        int nrJogadores = Integer.parseInt(linhaLida);
        for (int i = 0; i < nrJogadores; i++) {
            linhaLida = ficheiroLido.nextLine();
            String[] jogadorInfo = linhaLida.split("//");
            String nome = jogadorInfo[0];
            String id = jogadorInfo[1];
            String cor = jogadorInfo[2].toUpperCase();
            String linguagens = jogadorInfo[3];
            String posicao = jogadorInfo[4];
            String valorDado = jogadorInfo[5];
            String ferramentas = jogadorInfo[6];
            String cicloInfinito = jogadorInfo[7];
            String estado = jogadorInfo[8];
            Programmer jogador = new Programmer(nome, Integer.parseInt(id), ProgrammerColor.valueOf(cor),
                    Programmer.linguagensProgram(linguagens), Integer.parseInt(posicao),
                    Programmer.converterValorDadoArray(valorDado), Programmer.listaFerramentas(ferramentas),
                    cicloInfinitoVerificar(cicloInfinito), Programmer.estado(estado));
            players.add(jogador);
        }

        linhaLida = ficheiroLido.nextLine();
        String[] turnos = linhaLida.split("//");
        Programmer jogador = new Programmer();
        for (Programmer p : players) {
            if (turnos[0].equals(p.getName())) {
                jogador = p;
            }
        }
        players = ordenaProgramadores(players, jogador);
        shift = new Shifts(players, jogador);
        shift.setTurns(Integer.parseInt(turnos[1]));

        linhaLida = ficheiroLido.nextLine();
        int nrAbisFerra = Integer.parseInt(linhaLida);
        for (int i = 0; i < nrAbisFerra; i++) {
            linhaLida = ficheiroLido.nextLine();
            String[] comando = linhaLida.split("//");
            int identificador = Integer.parseInt(comando[0]);
            int id = Integer.parseInt(comando[1]);
            String posicao = comando[2];
            String nrPassagens = comando[3];

            if (identificador == 0) {
                switch (id) {
                    case 0 -> {
                        Comando abismo1 = new ErroDeSintaxe(Integer.parseInt(posicao), Integer.parseInt(nrPassagens));
                        comandos.add(abismo1);
                    }
                    case 1 -> {
                        Comando abismo2 = new ErroDeLogica(Integer.parseInt(posicao), Integer.parseInt(nrPassagens));
                        comandos.add(abismo2);
                    }
                    case 2 -> {
                        Comando abismo3 = new Exception(Integer.parseInt(posicao), Integer.parseInt(nrPassagens));
                        comandos.add(abismo3);
                    }
                    case 3 -> {
                        Comando abismo4 = new FileNotFoundException(Integer.parseInt(posicao), Integer.parseInt(nrPassagens));
                        comandos.add(abismo4);
                    }
                    case 4 -> {
                        Comando abismo5 = new Crash(Integer.parseInt(posicao), Integer.parseInt(nrPassagens));
                        comandos.add(abismo5);
                    }
                    case 5 -> {
                        Comando abismo6 = new DuplicatedCode(Integer.parseInt(posicao), Integer.parseInt(nrPassagens));
                        comandos.add(abismo6);
                    }
                    case 6 -> {
                        Comando abismo7 = new EfeitoSecundario(Integer.parseInt(posicao), Integer.parseInt(nrPassagens));
                        comandos.add(abismo7);
                    }
                    case 7 -> {
                        Comando abismo8 = new BlueScreen(Integer.parseInt(posicao), Integer.parseInt(nrPassagens));
                        comandos.add(abismo8);
                    }
                    case 8 -> {
                        Comando abismo9 = new CicloInfinito(Integer.parseInt(posicao), Integer.parseInt(nrPassagens));
                        comandos.add(abismo9);
                    }
                    case 9 -> {
                        Comando abismo10 = new SegmentationFault(Integer.parseInt(posicao), Integer.parseInt(nrPassagens), players);
                        comandos.add(abismo10);
                    }
                    default -> {
                        Comando abismo10 = new SegmentationFault(Integer.parseInt(posicao), Integer.parseInt(nrPassagens), players);
                        comandos.add(abismo10);
                    }
                }
            }
            if (identificador == 1) {
                switch (id) {
                    case 0 -> {
                        Comando ferramenta1 = new Heranca(Integer.parseInt(posicao));
                        comandos.add(ferramenta1);
                    }
                    case 1 -> {
                        Comando ferramenta2 = new ProgramacaoFuncional(Integer.parseInt(posicao));
                        comandos.add(ferramenta2);
                    }
                    case 2 -> {
                        Comando ferramenta3 = new UnitTeste(Integer.parseInt(posicao));
                        comandos.add(ferramenta3);
                    }
                    case 3 -> {
                        Comando ferramenta4 = new TratamentoDeExcepcoes(Integer.parseInt(posicao));
                        comandos.add(ferramenta4);
                    }
                    case 4 -> {
                        Comando ferramenta5 = new IDE(Integer.parseInt(posicao));
                        comandos.add(ferramenta5);
                    }
                    case 5 -> {
                        Comando ferramenta6 = new AjudaDoProfessor(Integer.parseInt(posicao));
                        comandos.add(ferramenta6);
                    }
                    default -> {
                        Comando ferramenta6 = new AjudaDoProfessor(Integer.parseInt(posicao));
                        comandos.add(ferramenta6);
                    }
                }
            }
        }
        return true;
    }

    public boolean saveGame(File file) {
        try {
            BufferedWriter ficheiro = new BufferedWriter(new FileWriter(file));
            ficheiro.write(worldSize + "");
            ficheiro.newLine();
            ficheiro.write(players.size() + "");
            ficheiro.newLine();
            for (Programmer jogador : players) {
                ficheiro.write(jogador.getName() + "");
                ficheiro.write("//");
                ficheiro.write(jogador.getId() + "");
                ficheiro.write("//");
                ficheiro.write(jogador.getColor().toString() + "");
                ficheiro.write("//");
                ficheiro.write(jogador.linguagemF() + "");
                ficheiro.write("//");
                ficheiro.write(jogador.getPosicao() + "");
                ficheiro.write("//");
                ficheiro.write(jogador.getValorDado() + "");
                ficheiro.write("//");
                ficheiro.write(jogador.ferramentasList() + "");
                ficheiro.write("//");
                ficheiro.write(jogador.cicloInfinitoString() + "");
                ficheiro.write("//");
                ficheiro.write(jogador.estadoString() + "");
                ficheiro.newLine();
            }
            ficheiro.write(shift.getPlayerOn().getName() + "");
            ficheiro.write("//");
            ficheiro.write(shift.getTurns() + "");
            ficheiro.newLine();
            ficheiro.write(comandos.size() + "");
            ficheiro.newLine();
            for (Comando comando : comandos) {
                ficheiro.write(comando.getIdentificador() + "");
                ficheiro.write("//");
                ficheiro.write(comando.getiD() + "");
                ficheiro.write("//");
                ficheiro.write(comando.getPosicao() + "");
                ficheiro.write("//");
                if (comando.ferramenta()) {
                    ficheiro.write("0");
                }
                if (comando.abismo()) {
                    ficheiro.write(((Abismo) comando).getNrPassagens() + "");
                }
                ficheiro.newLine();
            }
            ficheiro.close();

        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public JPanel getAuthorsPanel() {
        JPanel panel = new JPanel();
        panel.setBounds(50, 70, 500, 500);
        JLabel text2 = new JLabel("Trabalho realizado por:");
        JLabel text3 = new JLabel("- Mariana Carvalho (a22001926)");
        JLabel text4 = new JLabel("- Gonçalo Matias (a22008333)");
        JLabel text5 = new JLabel("                                         ");
        JLabel text6 = new JLabel("\"We don't compete with the Grammys.\"");
        JLabel text7 = new JLabel("\"The Grammys compete with us.\"");
        panel.add(text2);
        panel.add(text3);
        panel.add(text4);
        panel.add(text5);
        panel.add(text6);
        panel.add(text7);
        return panel;
    }

}