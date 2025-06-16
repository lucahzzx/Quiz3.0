import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

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

        for (int i = 0; i < perguntas.length; i++) {
            Pergunta pergunta = perguntas[i];
            System.out.println("Pergunta " + (i+1) + ": " + pergunta.getEnunciado());

            char opcaoLetra = 'A';
            for (String opcao : pergunta.getOpcoes()) {
                System.out.println(opcaoLetra + ") " + opcao);
                opcaoLetra++;
            }

            System.out.println("⏳ Você tem 40 segundos para responder!");

            String respostaUsuario = lerResposta(reader, 40000);

            processarResposta(pergunta, respostaUsuario);
        }

        exibirResultadoFinal();
    }

    private String lerResposta(BufferedReader reader, long tempoLimite) {
        try {
            long inicio = System.currentTimeMillis();
            while ((System.currentTimeMillis() - inicio) < tempoLimite && !reader.ready()) {
                Thread.sleep(100);
            }
            return reader.ready() ? reader.readLine() : null;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void processarResposta(Pergunta pergunta, String respostaUsuario) {
        if (respostaUsuario == null || respostaUsuario.trim().isEmpty()) {
            System.out.println("❌ Tempo esgotado! (Será listada para revisão)\n");
            usuario.adicionarPerguntaErrada(pergunta);
            return;
        }

        try {
            char respostaLetra = respostaUsuario.trim().toUpperCase().charAt(0);
            int respostaIndex = respostaLetra - 'A';

            if (respostaIndex < 0 || respostaIndex >= pergunta.getOpcoes().length) {
                System.out.println("❌ Opção inválida. Use A, B, C ou D.\n");
            } else if (pergunta.verificarResposta(respostaIndex)) {
                System.out.println("✅ Resposta correta!\n");
                usuario.adicionarPontos(1);
            } else {
                System.out.println("❌ Resposta incorreta. (Será listada para revisão)\n");
                usuario.adicionarPerguntaErrada(pergunta);
            }
        } catch (Exception e) {
            System.out.println("❌ Entrada inválida. Use apenas A, B, C ou D.\n");
        }
    }

    private void exibirResultadoFinal() {
        System.out.println("\n===== Resultado Final =====");
        System.out.println("Pontuação: " + usuario.getPontuacao() + "/" + perguntas.length + "\n");

        List<Pergunta> erradas = usuario.getPerguntasErradas();
        if (!erradas.isEmpty()) {
            System.out.println("📚 Questões para Revisão:");
            System.out.println("(Consulte seu material nestas páginas)\n");

            for (int i = 0; i < erradas.size(); i++) {
                Pergunta p = erradas.get(i);
                System.out.println((i+1) + ". " + p.getEnunciado());
                System.out.println("   📖 Referência: " + p.getReferenciaEstudo() + "\n");
            }
        } else {
            System.out.println("🎉 Parabéns! Você acertou todas as questões!");
        }
    }
}