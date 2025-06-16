import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ranking implements Serializable {
    private String ARQUIVO_RANKING = "ranking.dat";
    private List<Usuario> usuarios;


    public Ranking() {
        usuarios = carregarRanking();
    }

    public void adicionarUsuario(Usuario novoUsuario) {
        boolean usuarioExiste = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(novoUsuario.getNome())) {
                usuarioExiste = true;
                if (novoUsuario.getPontuacao() > usuario.getPontuacao()) {
                    usuario.setPontuacao(novoUsuario.getPontuacao());


                }
                break;
            }
        }

        if (!usuarioExiste) {
            usuarios.add(novoUsuario);
        }

        salvarRanking();
    }

    public void exibirRanking() {
        System.out.println("\n===== Ranking =====");
        usuarios.stream()
                .sorted((u1, u2) -> Integer.compare(u2.getPontuacao(), u1.getPontuacao()))
                .forEach(u -> System.out.println(u.getNome() + " - " + u.getPontuacao() + " pontos"));
    }

    private void salvarRanking() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(ARQUIVO_RANKING))) {

            // Cria uma cópia sem as perguntas erradas para serialização
            List<Usuario> usuariosParaSalvar = new ArrayList<>();
            for (Usuario u : usuarios) {
                Usuario usuarioSimples = new Usuario(u.getNome());
                usuarioSimples.setPontuacao(u.getPontuacao());
                usuariosParaSalvar.add(usuarioSimples);
            }

            oos.writeObject(usuariosParaSalvar);
        } catch (IOException e) {
            System.err.println("Erro ao salvar ranking: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private List<Usuario> carregarRanking() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ranking.dat"))) {
            return (List<Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }


}
