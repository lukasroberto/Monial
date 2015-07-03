package br.com.grupofortress.main;

import br.com.grupofortress.controller.Universal;
import java.util.TimerTask;
import propriedades.Propriedades;

public class Principal {

    private static final int intervaloTime = Integer.parseInt(Propriedades.getProp().getProperty("intervalotime"));
    private static final int qtqTimer = Integer.parseInt(Propriedades.getProp().getProperty("qtqtimer"));

    private static LeitorSamm n;
    private static int conta = 0;

    public static void main(String[] args) {

        n = new LeitorSamm();
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                n.verificaEventosBD();
            }
        }, 5000, intervaloTime);

    }

}
