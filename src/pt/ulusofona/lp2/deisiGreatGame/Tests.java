package pt.ulusofona.lp2.deisiGreatGame;

import org.junit.Test;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;

import static junit.framework.TestCase.assertEquals;

import static junit.framework.TestCase.*;

public class Tests {

    @Test //teste do createincialboard com 2 jogadores e mover 5 posições
    public void testGameManager1() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        try {
            gameManager.createInitialBoard(playerInfo, 20);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        assertTrue(gameManager.moveCurrentPlayer(5));
    }

    @Test //teste do createInicialBoard com doi jogares e mover um jogador um valor negativo
    public void testGameManager2() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        try {
            gameManager.createInitialBoard(playerInfo, 20);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        assertFalse(gameManager.moveCurrentPlayer(-1));
    }

    @Test //teste do createinicialboard com dois jogadores e mover o jogador
    public void testGameManager3() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        try {
            gameManager.createInitialBoard(playerInfo, 20);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        assertFalse(gameManager.moveCurrentPlayer(7));
    }

    @Test //teste do createinicialboard com dois jogadores e mover um jogador posições a mais do que o tabuleiro tem
    public void testGameManager4() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        try {
            gameManager.createInitialBoard(playerInfo, 5);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        assertTrue(gameManager.moveCurrentPlayer(6));
    }

    @Test
    public void testGameManager5() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        try {
            gameManager.createInitialBoard(playerInfo, 20);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        assertTrue(gameManager.moveCurrentPlayer(6));
        playerInfo[0][1] = "";
        //assertFalse(gameManager.createInitialBoard(playerInfo, 15));
    }

    @Test //teste do createinicalboard com 3 jogadores e mover 6 posições
    public void testGameManager6() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[3][4];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        playerInfo[2][0] = "456";
        playerInfo[2][1] = "Osvaldo";
        playerInfo[2][2] = "Java;kotlin";
        playerInfo[2][3] = "Blue";
        try {
            gameManager.createInitialBoard(playerInfo, 20);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        assertTrue(gameManager.moveCurrentPlayer(6));
    }

    @Test //teste do createinicalboard com 4 jogadores e mover 6 posições
    public void testGameManager7() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[4][4];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        playerInfo[2][0] = "456";
        playerInfo[2][1] = "Osvaldo";
        playerInfo[2][2] = "Java;kotlin";
        playerInfo[2][3] = "Blue";
        playerInfo[3][0] = "75";
        playerInfo[3][1] = "Carla";
        playerInfo[3][2] = "Assembley;C";
        playerInfo[3][3] = "Brown";
        try {
            gameManager.createInitialBoard(playerInfo, 20);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        assertTrue(gameManager.moveCurrentPlayer(6));
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(Erro de sintaxe) sem ferramenta (recuar 1 casa)
    public void testGameManager8() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[1][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "0";
        abyssesAndTools[0][2] = "3";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(2);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(2,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(Erro de lógica) sem ferramenta (recuar metade do valor do dado)
    public void testGameManager9() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[1][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "1";
        abyssesAndTools[0][2] = "3";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(2);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(2,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(Exception) sem ferramenta (recuar 2 casa)
    public void testGameManager10() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[1][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "2";
        abyssesAndTools[0][2] = "3";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(2);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(1,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(File not found exception) sem ferramenta (recuar 3 casas)
    public void testGameManager11() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[1][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "3";
        abyssesAndTools[0][2] = "6";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(5);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(3,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(crash) sem ferramenta (recuar até casa inicial)
    public void testGameManager12() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[1][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "4";
        abyssesAndTools[0][2] = "6";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(5);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(1,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(duplicated code) sem ferramenta (recuar valor do dado)
    public void testGameManager13() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[1][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "5";
        abyssesAndTools[0][2] = "6";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(5);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(1,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(efeitos secundários) sem ferramenta (recuar 2 jogadas antes)
    public void testGameManager14() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[1][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "6";
        abyssesAndTools[0][2] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(2);
        gameManager.moveCurrentPlayer(2);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(1,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(blue screen of death) sem ferramenta (derrotado)
    public void testGameManager15() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[1][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "7";
        abyssesAndTools[0][2] = "6";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(5);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        System.out.println(gameManager.getProgrammers());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(ciclo infinito) sem ferramenta (não acontece nada)
    public void testGameManager16() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[1][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "8";
        abyssesAndTools[0][2] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(5,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(segmentation fault) sem ferramenta (recuar 3 casas)
    public void testGameManager17() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[1][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "9";
        abyssesAndTools[0][2] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(6);
        gameManager.reactToAbyssOrTool();
        assertEquals(5,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(Erro de sintaxe) com ferramenta (IDE)
    public void testGameManager18() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "0";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "4";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(5,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(Erro de sintaxe) com ferramenta (ajuda do professor)
    public void testGameManager19() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "0";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "5";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(5,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(Erro de sintaxe) com ferramenta (herança) - recuar
    public void testGameManager20() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "0";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(4,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(Erro de lógica) com ferramenta (testes unitarios)
    public void testGameManager21() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "1";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "2";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(5,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(Erro de lógica) com ferramenta (ajuda do professor)
    public void testGameManager22() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "1";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "5";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(5,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(Erro de lógica) com ferramenta (herança) - recuar
    public void testGameManager23() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "1";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(4,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(exception) com ferramenta (ajuda do professor)
    public void testGameManager24() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "2";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "5";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(5,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(exception) com ferramenta (tratamento de excepções)
    public void testGameManager25() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "2";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "3";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(5,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(exception) com ferramenta (herança) - recuar
    public void testGameManager26() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "2";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(3,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(File not found) com ferramenta (ajuda do professor)
    public void testGameManager27() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "3";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "5";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(5,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test  //teste do createinicialboard com 2 jogadores e abismos(File not found) com ferramenta (tratamento de exceções)
    public void testGameManager28() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "3";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "3";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(5,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test  //teste do createinicialboard com 2 jogadores e abismos(File not found) com ferramenta (herança) - recuar
    public void testGameManager29() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "3";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(2,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(duplicated code) com ferramenta (herança)
    public void testGameManager30() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "5";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(5,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(duplicated code) com ferramenta (ajuda do professor)
    public void testGameManager31() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "5";
        abyssesAndTools[0][2] = "6";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "5";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(5);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(4,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(efeito secundário) com ferramenta (programação funcional)
    public void testGameManager32() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "6";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "1";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(5,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(efeito secundário) com ferramenta (herança)
    public void testGameManager33() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "6";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(1,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(ciclo infinito) com ferramenta (programação funcional)
    public void testGameManager34() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "8";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "1";
        abyssesAndTools[1][2] = "2";

        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(5,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do createinicialboard com 2 jogadores e abismos(ciclo infinito) com ferramenta (herança)
    public void testGameManager35() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "8";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        assertEquals(5,gameManager.getShift().getPlayerOn().getPosicao());
    }

    @Test //teste do getimagepng
    public void testGameManager36() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[1][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "8";
        abyssesAndTools[0][2] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        assertEquals("Grammy.png",gameManager.getImagePng(20));
    }

    @Test //teste do getimagepng
    public void testGameManager37() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[1][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "8";
        abyssesAndTools[0][2] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        assertEquals("Justin_Bieber.png",gameManager.getImagePng(5));
    }

    @Test //teste do getimagepng
    public void testGameManager38() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[1][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "8";
        abyssesAndTools[0][2] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        assertEquals(gameManager.getImagePng(7),"Red_Carpet.png");
    }

    @Test //teste do gettitle
    public void testGameManager39() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[1][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "8";
        abyssesAndTools[0][2] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        assertEquals("Ciclo infinito",gameManager.getTitle(5));
    }

    @Test //teste do gettitle
    public void testGameManager40() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[1][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "8";
        abyssesAndTools[0][2] = "5";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        assertNull(gameManager.getTitle(7));
    }

    @Test //teste do getProgrammers
    public void testGameManager41() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[1][4];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        try {
            gameManager.createInitialBoard(playerInfo, 20);
            fail("Deveria ter lançado uma exception!");
        }
        catch (InvalidInitialBoardException ex){
           assertEquals("Número de jogadores inválido!", ex.getMessage());
        }
    }

    @Test //teste do saveGame e loadGame com o getGameResults e o getAuthorsPanel
    public void testGameManager42() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "8";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();

        assertTrue(gameManager.saveGame(new File("teste")));

        assertTrue(gameManager.loadGame(new File("teste")));

        gameManager.getAuthorsPanel();

        gameManager.getGameResults();

    }

    @Test //teste do saveGame e loadGame com o BlueScreen
    public void testGameManager43() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "7";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();

        assertTrue(gameManager.saveGame(new File("teste")));

        assertTrue(gameManager.loadGame(new File("teste")));

    }

    @Test //teste do saveGame e loadGame com o Efeitos secundários
    public void testGameManager44() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "6";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();

        assertTrue(gameManager.saveGame(new File("teste")));

        assertTrue(gameManager.loadGame(new File("teste")));

    }

    @Test //teste do saveGame e loadGame com o Duplicated Code
    public void testGameManager45() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "5";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();

        assertTrue(gameManager.saveGame(new File("teste")));

        assertTrue(gameManager.loadGame(new File("teste")));

    }

    @Test //teste do saveGame e loadGame com o Crash
    public void testGameManager46() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "4";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();

        assertTrue(gameManager.saveGame(new File("teste")));

        assertTrue(gameManager.loadGame(new File("teste")));

    }

    @Test //teste do saveGame e loadGame com o Erro de sintaxe
    public void testGameManager47() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "0";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();

        assertTrue(gameManager.saveGame(new File("teste")));

        assertTrue(gameManager.loadGame(new File("teste")));

    }

    @Test //teste do saveGame e loadGame com o Erro de lógica
    public void testGameManager48() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "1";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();

        assertTrue(gameManager.saveGame(new File("teste")));

        assertTrue(gameManager.loadGame(new File("teste")));

    }

    @Test //teste do saveGame e loadGame com o Exception
    public void testGameManager49() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "2";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();

        assertTrue(gameManager.saveGame(new File("teste")));

        assertTrue(gameManager.loadGame(new File("teste")));

    }

    @Test //teste do saveGame e loadGame com o File Not Found Exception
    public void testGameManager50() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "3";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();

        assertTrue(gameManager.saveGame(new File("teste")));

        assertTrue(gameManager.loadGame(new File("teste")));

    }

    @Test //teste do saveGame e loadGame com o Segmentation Fault
    public void testGameManager51() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "9";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();

        assertTrue(gameManager.saveGame(new File("teste")));

        assertTrue(gameManager.loadGame(new File("teste")));

    }

    @Test //teste do saveGame e loadGame com o Segmentation Fault
    public void testGameManager52() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "1";
        abyssesAndTools[0][1] = "9";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();

        assertTrue(gameManager.saveGame(new File("teste")));

        assertTrue(gameManager.loadGame(new File("teste")));

    }

    @Test //teste do saveGame e loadGame com a Herança
    public void testGameManager53() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "2";
        abyssesAndTools[0][1] = "9";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "0";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();

        assertTrue(gameManager.saveGame(new File("teste")));

        assertTrue(gameManager.loadGame(new File("teste")));

    }

    @Test //teste do saveGame e loadGame com a Programação Funcional
    public void testGameManager54() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "9";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "1";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();

        assertTrue(gameManager.saveGame(new File("teste")));

        assertTrue(gameManager.loadGame(new File("teste")));

    }

    @Test //teste do saveGame e loadGame com os Testes unitários
    public void testGameManager55() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "9";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "2";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();

        assertTrue(gameManager.saveGame(new File("teste")));

        assertTrue(gameManager.loadGame(new File("teste")));

    }

    @Test //teste do saveGame e loadGame com o Tratamento de Excepções
    public void testGameManager56() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "9";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "3";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();

        assertTrue(gameManager.saveGame(new File("teste")));

        assertTrue(gameManager.loadGame(new File("teste")));

    }

    @Test //teste do saveGame e loadGame com o IDE
    public void testGameManager57() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "9";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "4";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();

        assertTrue(gameManager.saveGame(new File("teste")));

        assertTrue(gameManager.loadGame(new File("teste")));

    }

    @Test //teste do saveGame e loadGame com a Ajuda Do Professor
    public void testGameManager58() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "9";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "5";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }
        gameManager.moveCurrentPlayer(1);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(3);
        gameManager.reactToAbyssOrTool();
        gameManager.moveCurrentPlayer(4);
        gameManager.reactToAbyssOrTool();

        assertTrue(gameManager.saveGame(new File("teste")));

        assertTrue(gameManager.loadGame(new File("teste")));

    }

    @Test //teste do saveGame e loadGame com o adicionaAbismo e id 0
    public void testGameManager59() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "9";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "5";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }

        assertTrue(gameManager.saveGame(new File("teste")));

        assertTrue(gameManager.loadGame(new File("teste")));

    }

    @Test //teste do saveGame e loadGame com o adicionaAbismo e id 0
    public void testGameManager60() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "9";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "5";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }

        gameManager.adicionaAbismo(3,"1");

        assertTrue(gameManager.saveGame(new File("teste")));

        assertTrue(gameManager.loadGame(new File("teste")));

    }

    @Test //teste do saveGame e loadGame com o adicionaAbismo e id 0
    public void testGameManager61() {
        GameManager gameManager = new GameManager();
        String[][] playerInfo = new String[2][4];
        String [][] abyssesAndTools = new String[2][3];
        playerInfo[0][0] = "123";
        playerInfo[0][1] = "Mateo";
        playerInfo[0][2] = "Python;C++;Assembley";
        playerInfo[0][3] = "Green";
        playerInfo[1][0] = "69";
        playerInfo[1][1] = "Melinda";
        playerInfo[1][2] = "Java";
        playerInfo[1][3] = "Purple";
        abyssesAndTools[0][0] = "0";
        abyssesAndTools[0][1] = "9";
        abyssesAndTools[0][2] = "5";
        abyssesAndTools[1][0] = "1";
        abyssesAndTools[1][1] = "5";
        abyssesAndTools[1][2] = "2";
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools);
        }
        catch(InvalidInitialBoardException ex) {
            System.out.println(ex.getMessage());
        }

        gameManager.adicionaAbismo(4,"2");

        assertTrue(gameManager.saveGame(new File("teste")));

        assertTrue(gameManager.loadGame(new File("teste")));

    }
}