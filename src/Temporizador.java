import java.util.TimerTask;
import java.util.Timer;

public class Temporizador {
    private static Timer timer;
    private boolean tempoEsgotado;

    public Temporizador() {
        this.tempoEsgotado = false;

    }

    public void iniciarTemporizador(int segundos) {
        tempoEsgotado = false;
        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tempoEsgotado = true;
                System.out.println("\n Tempo Esgotado. ");
            }
        }, segundos * 1000);

    }
}
