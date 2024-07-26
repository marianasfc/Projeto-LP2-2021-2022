package pt.ulusofona.lp2.deisiGreatGame

import junit.framework.TestCase
import org.junit.Test
import kotlin.test.assertEquals

class Testskt {

    @Test //teste do createincialboard com 2 jogadores e mover 5 posições
    fun testGameManager1() {
        val gameManager = GameManager()
        val playerInfo = Array(2) { arrayOfNulls<String>(4) }
        playerInfo[0][0] = "123"
        playerInfo[0][1] = "Mateo"
        playerInfo[0][2] = "Python;C++;Assembley"
        playerInfo[0][3] = "Green"
        playerInfo[1][0] = "69"
        playerInfo[1][1] = "Melinda"
        playerInfo[1][2] = "Java"
        playerInfo[1][3] = "Purple"
        try {
            gameManager.createInitialBoard(playerInfo, 20)
        } catch (ex: InvalidInitialBoardException) {
            println(ex.message)
        }
        TestCase.assertTrue(gameManager.moveCurrentPlayer(5))
    }

    @Test //teste do createincialboard com 2 jogadores e mover 5 posições
    fun testGameManager2() {
        val gameManager = GameManager()
        val playerInfo = Array(2) { arrayOfNulls<String>(4) }
        playerInfo[0][0] = "123"
        playerInfo[0][1] = "Mateo"
        playerInfo[0][2] = "Python;C++;Assembley"
        playerInfo[0][3] = "Green"
        playerInfo[1][0] = "69"
        playerInfo[1][1] = "Melinda"
        playerInfo[1][2] = "Java"
        playerInfo[1][3] = "Purple"

        try {
            gameManager.createInitialBoard(playerInfo, 20)
        } catch (ex: InvalidInitialBoardException) {
            println(ex.message)
        }

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)
        val result = commandGetFn.invoke(gameManager, listOf("PLAYER", "Mateo"))
        assertEquals(result,"123 | Mateo | 1 | No tools | Assembley; C++; Python | Em Jogo")
        val result1 = commandGetFn.invoke(gameManager, listOf("PLAYER", "Joao"))
        assertEquals(result1,"Inexistent player")
        val result2 = commandGetFn.invoke(gameManager, listOf("POLYGLOTS"))
        assertEquals(result2,"Mateo:3")
        val result3 = commandGetFn.invoke(gameManager, listOf("PLAYERS_BY_LANGUAGE", "Python"))
        assertEquals(result3,"Mateo")

    }

    @Test //teste do createincialboard com 2 jogadores e mover 5 posições
    fun testGameManager3() {
        val gameManager = GameManager()
        val playerInfo = Array(2) { arrayOfNulls<String>(4) }
        val abyssesAndTools = Array(2) { arrayOfNulls<String>(3) }
        playerInfo[0][0] = "123"
        playerInfo[0][1] = "Mateo"
        playerInfo[0][2] = "Python;C++;Assembley"
        playerInfo[0][3] = "Green"
        playerInfo[1][0] = "69"
        playerInfo[1][1] = "Melinda"
        playerInfo[1][2] = "Java"
        playerInfo[1][3] = "Purple"
        abyssesAndTools[0][0] = "0"
        abyssesAndTools[0][1] = "8"
        abyssesAndTools[0][2] = "5"
        abyssesAndTools[1][0] = "1"
        abyssesAndTools[1][1] = "0"
        abyssesAndTools[1][2] = "2"
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools)
        } catch (ex: InvalidInitialBoardException) {
            println(ex.message)
        }
        gameManager.moveCurrentPlayer(1)
        gameManager.reactToAbyssOrTool()
        gameManager.moveCurrentPlayer(4)
        gameManager.reactToAbyssOrTool()
        gameManager.moveCurrentPlayer(3)
        gameManager.reactToAbyssOrTool()
        gameManager.moveCurrentPlayer(4)
        gameManager.reactToAbyssOrTool()

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)
        val result = commandGetFn.invoke(gameManager, listOf("MOST_USED_ABYSSES","1"))
        assertEquals(result,"Ciclo infinito:2")
        val result1 = commandGetFn.invoke(gameManager, listOf("MOST_USED_POSITIONS","1"))
        assertEquals(result1,"5:2")

    }

    @Test //teste do createincialboard com 2 jogadores e mover 5 posições
    fun testGameManager4() {
        val gameManager = GameManager()
        val playerInfo = Array(2) { arrayOfNulls<String>(4) }
        val abyssesAndTools = Array(2) { arrayOfNulls<String>(3) }
        playerInfo[0][0] = "123"
        playerInfo[0][1] = "Mateo"
        playerInfo[0][2] = "Python;C++;Assembley"
        playerInfo[0][3] = "Green"
        playerInfo[1][0] = "69"
        playerInfo[1][1] = "Melinda"
        playerInfo[1][2] = "Java"
        playerInfo[1][3] = "Purple"
        abyssesAndTools[0][0] = "0"
        abyssesAndTools[0][1] = "8"
        abyssesAndTools[0][2] = "5"
        abyssesAndTools[1][0] = "1"
        abyssesAndTools[1][1] = "0"
        abyssesAndTools[1][2] = "2"
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools)
        } catch (ex: InvalidInitialBoardException) {
            println(ex.message)
        }
        gameManager.moveCurrentPlayer(1)
        gameManager.reactToAbyssOrTool()
        gameManager.moveCurrentPlayer(4)
        gameManager.reactToAbyssOrTool()
        gameManager.moveCurrentPlayer(3)
        gameManager.reactToAbyssOrTool()
        gameManager.moveCurrentPlayer(4)
        gameManager.reactToAbyssOrTool()

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.POST)
        val result = commandGetFn.invoke(gameManager, listOf("MOVE","3"))
        assertEquals(result,"\"I need you to stay\" - Justin Bieber\n" +
                "Salvaste o jogador que aqui estava e como consequência tens de ficar aqui parado")
        val result1 = commandGetFn.invoke(gameManager, listOf("ABYSS","1","2"))
        assertEquals(result1,"Position is occupied")

    }

    @Test //teste do createincialboard com 2 jogadores e mover 5 posições
    fun testGameManager5() {
        val gameManager = GameManager()
        val playerInfo = Array(2) { arrayOfNulls<String>(4) }
        val abyssesAndTools = Array(2) { arrayOfNulls<String>(3) }
        playerInfo[0][0] = "123"
        playerInfo[0][1] = "Mateo"
        playerInfo[0][2] = "Python;C++;Assembley"
        playerInfo[0][3] = "Green"
        playerInfo[1][0] = "69"
        playerInfo[1][1] = "Melinda"
        playerInfo[1][2] = "Java"
        playerInfo[1][3] = "Purple"
        abyssesAndTools[0][0] = "0"
        abyssesAndTools[0][1] = "7"
        abyssesAndTools[0][2] = "5"
        abyssesAndTools[1][0] = "1"
        abyssesAndTools[1][1] = "0"
        abyssesAndTools[1][2] = "2"
        try {
            gameManager.createInitialBoard(playerInfo, 20, abyssesAndTools)
        } catch (ex: InvalidInitialBoardException) {
            println(ex.message)
        }
        gameManager.moveCurrentPlayer(1)
        gameManager.reactToAbyssOrTool()
        gameManager.moveCurrentPlayer(4)
        gameManager.reactToAbyssOrTool()
        gameManager.moveCurrentPlayer(3)
        gameManager.reactToAbyssOrTool()
        gameManager.moveCurrentPlayer(4)
        gameManager.reactToAbyssOrTool()

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)
        val result = commandGetFn.invoke(gameManager, listOf("MOST_USED_ABYSSES","1"))
        assertEquals(result,"Blue Screen of Death:1")

    }

}