import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomizarPerguntas {
    private RandomizarPerguntas() {

    }

    public static Pergunta[] randomizar(Pergunta[] perguntas) {
        // cópia para não modificar o array original
        Pergunta[] copia = Arrays.copyOf(perguntas, perguntas.length);

        // Collections.shuffle
        List<Pergunta> listaPerguntas = Arrays.asList(copia);
        Collections.shuffle(listaPerguntas);

        return copia;
    }

    public static Pergunta[] randomizarDoBanco() {
        return randomizar(BancoPerguntas.getPerguntas());
    }
}