import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ranking implements Serializable {
    private List<Usuario> usuarios;
    private int pontuacao;

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
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ranking.dat"))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            System.out.println("Erro ao salvar ranking: " + e.getMessage());
        }
    }

    private List<Usuario> carregarRanking() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ranking.dat"))) {
            return (List<Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
    private void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

}