/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiloTestear.join;

/**
 *
 * @author USER
 */
public class HiloHijoJoin implements Runnable {

    @Override
    public void run() {
        System.out.println("Soy el hilo hijo y he iniciado mi ejecución.");

        try {

            Thread.sleep(500);

        } catch (InterruptedException e) {

            System.out.println(e);

            return;

        }

        System.out.println("Soy el hilo hijo y he finalizado mi ejecución.");

    }

}
