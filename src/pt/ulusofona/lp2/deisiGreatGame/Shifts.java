package pt.ulusofona.lp2.deisiGreatGame;

import java.util.ArrayList;
import java.util.Arrays;

public class Shifts {
    ArrayList<Programmer> players = new ArrayList<>();
    Programmer playerOn;
    int turns;


    public Programmer getPlayerOn() {
        return playerOn;
    }

    public int getTurns() {
        return turns;
    }

    public ArrayList<Programmer> getPlayers() {
        return players;
    }

    public Shifts(ArrayList<Programmer> players, Programmer playerOn) {
        this.players.addAll(players);
        this.playerOn = playerOn;
        turns = 1;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public void turnsUp() {
        turns++;
    }

    public void turnsShift(){
        ArrayList<Programmer> turns = new ArrayList<>();
        for (int i = 1; i < players.size(); i++){
            turns.add(players.get(i));
        }
        turns.add(players.get(0));
        players.clear();
        players = turns;
        verificarJogadores();
        playerOn = players.get(0);
    }

    public void verificarJogadores(){
        ArrayList<Programmer> jogador = new ArrayList<>();
        for(Programmer p : players){
            if(p.isEstado()){
                jogador.add(p);
            }
        }
        players.clear();
        players = jogador;
    }
}