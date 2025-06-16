import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz {
    private Pergunta[] perguntas;
    private Usuario usuario;

    public Quiz(Pergunta[] perguntas, Usuario usuario) {
        this.perguntas = perguntas;
        this.usuario = usuario;
    }

    public void iniciar() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\n===== Iniciando o Quiz =====\n");

        int contador = 1;

        for (Pergunta pergunta : perguntas) {
            System.out.println("Pergunta " + contador + ": " + pergunta.getEnunciado());
            String[] opcoes = pergunta.getOpcoes();

            char letra = 'A';
            for (int i = 0; i < opcoes.length; i++) {
                System.out.println(letra + ") " + opcoes[i]); letra++;
            }

            System.out.println("⏳ Você tem 40 segundos para responder!");

            String respostaUsuario = null;
            long tempoLimite = 40000;
            long inicio = System.currentTimeMillis();

            try {
                while ((System.currentTimeMillis() - inicio) < tempoLimite && !reader.ready()) {
                    Thread.sleep(100);
                }

                if (reader.ready()) {
                    respostaUsuario = reader.readLine();
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

            if (respostaUsuario == null || respostaUsuario.trim().isEmpty()) {
                System.out.println("❌ Tempo esgotado! Pergunta anulada.\n");
            } else {
                try {
                    char respostaLetra = respostaUsuario.trim().toUpperCase().charAt(0);
                    int resposta = respostaLetra - 'A';

                    if (resposta < 0 || resposta >= opcoes.length) {
                        System.out.println("❌ Opção inválida.\n");
                    } else if (pergunta.verificarResposta(resposta)) {
                        System.out.println("✅ Resposta correta!\n");
                        usuario.adicionarPontos(1);
                    } else {
                        System.out.println("❌ Resposta incorreta.");
                        char letraCorreta = (char) ('A' + pergunta.getRespostaCorreta());
                        System.out.println("Resposta correta: " + letraCorreta + " - " + opcoes[pergunta.getRespostaCorreta()] + "\n");

                    }
                } catch (Exception e) {
                    System.out.println("❌ Entrada inválida. Resposta desconsiderada.\n");
                }
            }

            contador++;
        }

        System.out.println("===== Quiz finalizado! =====");
        System.out.println("Pontuação final de " + usuario.getNome() + ": " + usuario.getPontuacao() + " pontos\n");
    }
}