// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 180)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (inscritos.contains(usuario)) {
            println("${usuario.nome} já está matriculado nesta formação.")
        } else {
            inscritos.add(usuario)
            println("${usuario.nome} foi matriculado na formação $nome.")
        }
    }

    fun registrarNota(usuario: Usuario, conteudo: ConteudoEducacional, nota: Int) {
        if (inscritos.contains(usuario)) {
            println("Nota $nota registrada para ${usuario.nome} no conteúdo ${conteudo.nome}.")
        } else {
            println("${usuario.nome} não está matriculado nesta formação.")
        }
    }

    fun listarInscritos() {
        if (inscritos.isNotEmpty()) {
            println("Inscritos na formação $nome:")
            inscritos.forEach { println("- ${it.nome}") }
        } else {
            println("Não há inscritos nesta formação.")
        }
    }
}

fun main() {
    val usuarios = listOf(
        Usuario("Alice", "alice@gmail.com"),
        Usuario("Bob", "bob@hotmail.com"),
        Usuario("Carol", "carol@yahoo.com"),
        Usuario("David", "david@outlook.com"),
        Usuario("Eve", "eve@aol.com")
    )

    val conteudos = listOf(
        ConteudoEducacional("Introdução ao Kotlin", 120),
        ConteudoEducacional("Fundamentos de programação", 90),
        ConteudoEducacional("Desenvolvimento mobile", 180),
        ConteudoEducacional("Arquitetura de software", 150),
        ConteudoEducacional("Inteligência artificial", 240)
    )

    val formacao1 = Formacao("Desenvolvimento Android", Nivel.INTERMEDIARIO, listOf(conteudos[0], conteudos[2], conteudos[3]))
    val formacao2 = Formacao("Programação básica", Nivel.BASICO, listOf(conteudos[1], conteudos[3]))
    val formacao3 = Formacao("Inteligência artificial avançada", Nivel.DIFICIL, listOf(conteudos[4]))

    formacao1.listarInscritos()
    formacao1.matricular(usuarios[0])
    formacao1.matricular(usuarios[0])
    formacao1.matricular(usuarios[1])
    formacao1.listarInscritos()
    formacao1.registrarNota(usuarios[0], conteudos[0], 8)
    formacao1.registrarNota(usuarios[1], conteudos[1], 7)

    formacao2.listarInscritos()
    formacao2.matricular(usuarios[2])
    formacao3.matricular(usuarios[3])
    formacao3.matricular(usuarios[4])
    formacao3.listarInscritos()
    formacao2.registrarNota(usuarios[2], conteudos[1], 9)
    formacao3.registrarNota(usuarios[3], conteudos[4], 10)
    formacao3.registrarNota(usuarios[4], conteudos[4], 9) 
}
