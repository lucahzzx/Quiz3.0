import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {
    private String nome;
    private int pontuacao;
    private List<Pergunta> perguntasErradas;


    public Usuario(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
        this.perguntasErradas = new ArrayList<>();
    }


    public void adicionarPerguntaErrada(Pergunta pergunta) {
        perguntasErradas.add(pergunta);
    }

    public List<Pergunta> getPerguntasErradas() {
        return perguntasErradas;
    }


    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void adicionarPontos(int pontos) {
        this.pontuacao += pontos;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}