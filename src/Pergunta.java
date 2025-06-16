import java.io.Serializable;

public class Pergunta implements Serializable {

    private String enunciado;
    private String[] opcoes;
    private int respostaCorreta;
    private String referenciaEstudo;

    public Pergunta(String enunciado, String[] opcoes, int respostaCorreta, String referenciaEstudo) {
        this.enunciado = enunciado;
        this.opcoes = opcoes;
        this.respostaCorreta = respostaCorreta;
        this.referenciaEstudo = referenciaEstudo;
    }

    // Getters
    public String getEnunciado() {
        return enunciado;
    }

    public String[] getOpcoes() {
        return opcoes;
    }

    public String getReferenciaEstudo() {
        return referenciaEstudo;
    }

    public boolean verificarResposta(int resposta) {
        return resposta == respostaCorreta;
    }
}