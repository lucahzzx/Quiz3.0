public class BancoPerguntas {
    public static Pergunta[] getPerguntas() {
        return new Pergunta[]{
                new Pergunta("Qual é a função do operador + em Java?", new String[]{"Subtração", "Multiplicação", "Adição", "Comparação"}, 2, "Leia as páginas "),
                new Pergunta("O que o operador % retorna em uma operação?", new String[]{"O quociente da divisão", "O resto da divisão", "A soma dos operandos", "O produto dos operandos"}, 1, "Leia as páginas"),
                new Pergunta("Qual operador é usado para verificar se dois valores são iguais em Java?", new String[]{"=", "==", "=!=", "!="}, 1,"Leia as páginas"),
                new Pergunta("Qual é o operador lógico que retorna verdadeiro se pelo menos uma das expressões for verdadeira?", new String[]{"&&", "||", "!", "=="}, 1,"Leia as páginas"),
                new Pergunta("Qual é o operador relacional que verifica se um valor é maior ou igual a outro?", new String[]{">", "<", ">=", "<="}, 2,"Leia as páginas"),
                new Pergunta("Qual é a função do operador ! em Java?", new String[]{"Negar uma expressão booleana", "Atribuir valor a uma variável", "Comparar dois valores", "Realizar uma operação aritmética"}, 0,"Leia as páginas"),
                new Pergunta("Qual é o operador usado para realizar uma operação de divisão em Java?", new String[]{"*", "/", "%", "+"}, 1,"Leia as páginas"),
                new Pergunta("Qual operador é utilizado para verificar se dois valores são diferentes em Java?", new String[]{"==", "!=", "=", "<>"}, 1,"Leia as páginas"),
                new Pergunta("Qual é o operador que retorna verdadeiro se ambas as expressões forem verdadeiras?", new String[]{"&&", "||", "!", "=="}, 0,"Leia as páginas"),
                new Pergunta("Qual é o operador usado para atribuir um valor a uma variável em Java?", new String[]{"=", "==", ":=", "->"}, 0,"Leia as páginas"),
                new Pergunta("int a = 5; int b = 2; System.out.println(a + b);", new String[]{"52", "7", "3", "Erro de compilação"}, 1,"Leia as páginas"),
                new Pergunta("int resultado = 10 % 4; System.out.println(resultado);", new String[]{"2", "3", "0", "4"}, 0,"Leia as páginas"),
                new Pergunta("int x = 8; int y = 12; System.out.println(x > y);", new String[]{"true", "false", "1", "Erro"}, 1,"Leia as páginas"),
                new Pergunta("if (5 < 10) System.out.println(\"x é menor que y\"); else System.out.println(\"x é maior ou igual a y\");", new String[]{"x é maior ou igual a y", "x é menor que y", "x == y", "Erro de compilação"}, 1,"Leia as páginas"),
                new Pergunta("boolean flag = (4 > 3) && (10 < 5); System.out.println(flag);", new String[]{"true", "false", "1", "Erro"}, 1,"Leia as páginas"),
                new Pergunta("int a = 6; if (a % 2 == 0) System.out.println(\"Par\"); else System.out.println(\"Ímpar\");", new String[]{"Sempre imprime Ímpar", "Sempre imprime Par", "Imprime Par se o número for par", "Erro de sintaxe"}, 2,"Leia as páginas"),
                new Pergunta("int x = 3; int y = 3; System.out.println(x == y);", new String[]{"true", "false", "0", "Erro"}, 0,"Leia as páginas"),
                new Pergunta("if ((5 < 10) || (10 < 5)) System.out.println(\"Condição verdadeira\"); else System.out.println(\"Condição falsa\");", new String[]{"Condição verdadeira", "Condição falsa", "Erro de compilação", "Nenhuma saída"}, 0,"Leia as páginas"),
                new Pergunta("int a = 10; a = a * 2; System.out.println(a);", new String[]{"20", "10", "2", "Erro"}, 0,"Leia as páginas"),
                new Pergunta("int a = 7; int b = 3; System.out.println(a / b);", new String[]{"2.33", "2", "3", "Erro (divisão por zero)"}, 1,"Leia as páginas")
        };

    }
}
