package hiloTestear;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloSleep implements Runnable {

    private int nombre;
    private int duración;

    /**
     * 16
     *
     * @param args the command line arguments 17
     */
   /* public static void main(String[] args) {

        // Lanzamos dos hilos de forma concurrente que duren un tiempo aleatorio:
        Random aleatorio = new Random(1337);

        for (int i = 0; i < 2; i++) {

            // Un hilo tendrá un tiempo de ejecución comprendido entre los 0 y 10 segundos.
            new Thread(new Hilo(i, aleatorio.nextInt(10000))).start();

        }

    }*/

    public HiloSleep(int nombre, int duración) {

        this.nombre = nombre;

        this.duración = duración;

    }

    /**
     * 34 Método que contiene las acciones que hará el hilo cuando se ejecute.
     * 35
     */
    @Override
    public void run() {

        System.out.println("Soy el hilo " + this.nombre + " y he iniciado mi ejecución.");

        System.out.println("Soy el hilo " + this.nombre + " y voy a parar mi ejecución " + this.duración + " ms.");

        try {

            Thread.sleep(this.duración);

        } catch (InterruptedException ex) { // Sleep puede lanzar una excepción que aborte la ejecución del hilo.

            Logger.getLogger(HiloSleep.class.getName()).log(Level.SEVERE, null, ex);

        }

        System.out.println("Soy el hilo " + this.nombre + " y continúo mi ejecución.");

        System.out.println("Soy el hilo " + this.nombre + " y he finalizado mi ejecución.");

    }

}
