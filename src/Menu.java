import java.util.Scanner;

public class Menu {
    public int exibir() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n** Warming the mind with Java **");
        System.out.println("1. Começar o Quiz");
        System.out.println("2. Ver Ranking");
        System.out.println("3. Sair");
        System.out.println("\n⏳ Você tem 40 segundos para responder cada pergunta. Caso não responda, ela será ANULADA! ⏳");

        System.out.print("\nEscolha uma opção: ");
        return scanner.nextInt();
    }
}
