package hiloTestear;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloSleep implements Runnable {

    private int nombre;
    private int duraci�n;

    /**
     * 16
     *
     * @param args the command line arguments 17
     */
   /* public static void main(String[] args) {

        // Lanzamos dos hilos de forma concurrente que duren un tiempo aleatorio:
        Random aleatorio = new Random(1337);

        for (int i = 0; i < 2; i++) {

            // Un hilo tendr� un tiempo de ejecuci�n comprendido entre los 0 y 10 segundos.
            new Thread(new Hilo(i, aleatorio.nextInt(10000))).start();

        }

    }*/

    public HiloSleep(int nombre, int duraci�n) {

        this.nombre = nombre;

        this.duraci�n = duraci�n;

    }

    /**
     * 34 M�todo que contiene las acciones que har� el hilo cuando se ejecute.
     * 35
     */
    @Override
    public void run() {

        System.out.println("Soy el hilo " + this.nombre + " y he iniciado mi ejecuci�n.");

        System.out.println("Soy el hilo " + this.nombre + " y voy a parar mi ejecuci�n " + this.duraci�n + " ms.");

        try {

            Thread.sleep(this.duraci�n);

        } catch (InterruptedException ex) { // Sleep puede lanzar una excepci�n que aborte la ejecuci�n del hilo.

            Logger.getLogger(HiloSleep.class.getName()).log(Level.SEVERE, null, ex);

        }

        System.out.println("Soy el hilo " + this.nombre + " y contin�o mi ejecuci�n.");

        System.out.println("Soy el hilo " + this.nombre + " y he finalizado mi ejecuci�n.");

    }

}
