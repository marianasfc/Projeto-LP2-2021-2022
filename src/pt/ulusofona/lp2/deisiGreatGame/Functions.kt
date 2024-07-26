package pt.ulusofona.lp2.deisiGreatGame

    fun router(): Function1<CommandType, Function2<GameManager, List<String>, String?>> {
        return ::getCommmandType
    }

    fun getCommmandType(type: CommandType): Function2<GameManager, List<String>, String?> {
        when (type) {
            CommandType.GET -> return ::getFunGet
            CommandType.POST -> return ::getFunPost
        }
    }

    fun getFunPost(manager: GameManager, list: List<String>): String? {
        when (list[0]) {
            "MOVE" -> return getPostMove(manager, list[1])
            "ABYSS" -> return getPostAbyss(manager, list[1], list[2])
            else -> return null
        }
    }

    fun getFunGet(manager: GameManager, list: List<String>): String? {
        when (list[0]) {
            "POLYGLOTS" -> return getPolyglots(manager)
            "PLAYER" -> return getPlayers(manager, list[1])
            "PLAYERS_BY_LANGUAGE" -> return getPlayersByLanguage(manager, list[1])
            "MOST_USED_ABYSSES" -> return getMostUsedAbysses(manager, list[1])
            "MOST_USED_POSITIONS" -> return getMostUsedPositions(manager, list[1])
            else -> return null

        }
    }

    fun getPlayers(manager: GameManager, nome: String): String? {
        val player = manager.getProgrammers(true)
        val jogadores: String = player.filter { Programmer.primeiroNome(it.name) == nome }
            .map { it.toString() }
            .distinct().toString()

        if (jogadores == "[]") {
            return "Inexistent player"
        }
        return jogadores.replace("[", "").replace("]", "")

    }

    fun getPlayersByLanguage(manager: GameManager, linguagem: String): String? {
        val jogador = manager.getProgrammers(true)
        val jogadores: String = jogador.filter { Programmer.existeLinguagem(it.linguagemF(), linguagem) }
            .map { it.name }
            .toString()

        return jogadores.replace("[", "").replace("]", "").replace(", ",",")
    }

    fun getPolyglots (manager: GameManager): String? {
        val jogador = manager.getProgrammers(true)
        val jogadores: String = jogador.filter { it.getLinguagemFav().size > 1 }
            .sortedWith { i , j -> i.getLinguagemFav().size - j.getLinguagemFav().size }
            .map { it.name + ":" + it.linguagemFav.size }
            .joinToString ("\n")

        return jogadores
    }

    fun getMostUsedPositions(manager: GameManager, resultado: String) : String?{
        val jogador = manager.posicoes
        val res = resultado.toInt()
        return jogador.filter { it.nrPassagens > 0 }
            .sortedWith{i, j -> j.nrPassagens - i.nrPassagens}
            .take(res)
            .joinToString ("\n") {it.nrPosicao.toString() + ":" + it.nrPassagens}
    }

    fun getMostUsedAbysses(manager: GameManager, resultado: String) : String?{
        val jogador = manager.comandos
        val res = resultado.toInt()
        return jogador.filter { it.getIdentificador() == 0 }
            .sortedWith{ i, j ->  (j as Abismo).nrPassagens - (i as Abismo).nrPassagens }
            .distinctBy { it.getTitulo() }
            .take(res)
            .joinToString ("\n") {it.getTitulo() + ":" + (it as Abismo).nrPassagens}
    }

    fun getPostMove(gameManager: GameManager, nrPosicoes: String): String{
        var res : String? = ""
        gameManager.moveCurrentPlayer(nrPosicoes.toInt())
        res = gameManager.reactToAbyssOrTool()
        return res ?: "OK"
}

    fun getPostAbyss(gameManager: GameManager, idAbismo : String,nrPosicoes: String): String{
        if(gameManager.posicaoOcupada(nrPosicoes.toInt())){
            return "Position is occupied"
        }
        gameManager.adicionaAbismo(nrPosicoes.toInt(), idAbismo)
        return "OK"
    }





