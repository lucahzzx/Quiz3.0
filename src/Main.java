import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ranking ranking = new Ranking();

        while (true) {
            Menu menu = new Menu();
            int opcao = menu.exibir();



            if (opcao == 1) {
                System.out.print("Digite seu nome para registro: ");
                String nome = scanner.next();
                Usuario usuario = new Usuario(nome);

                Pergunta[] perguntas = BancoPerguntas.getPerguntas();
                Quiz quiz = new Quiz(perguntas, usuario);
                quiz.iniciar();

                ranking.adicionarUsuario(usuario);
            } else if (opcao == 2) {
                ranking.exibirRanking();
            } else if (opcao == 3) {
                System.out.println("Até logo!");
                break;
            } else {
                System.out.println("Opção inválida.");

            }
        }
    }
}