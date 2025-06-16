public class Pergunta {
    private String enunciado;
    private String[] opcoes;
    private int respostaCorreta;

    public Pergunta(String enunciado, String[] opcoes, int respostaCorreta) {
        this.enunciado = enunciado;
        this.opcoes = opcoes;
        this.respostaCorreta = respostaCorreta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String[] getOpcoes() {
        return opcoes;
    }

    public int getRespostaCorreta() {
        return respostaCorreta;
    }

    public boolean verificarResposta(int respostaUsuario) {
        return respostaUsuario == respostaCorreta;
    }
}