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
public class HiloPadreJoin implements Runnable {

    @Override
    public void run() {
       /* System.out.println("Soy el hilo padre y he iniciado mi ejecución para crear un hilo hijo.");
        Thread hiloQueFinalizaAntes = new Thread(new HiloHijoJoin()); // Creamos el hijo.
        hiloQueFinalizaAntes.start(); // El proceso hijo empieza a estar listo.
        System.out.println("Soy el hilo padre y he finalizado mi ejecución."); // El padre no espera por el hijo.*/
       
        System.out.println("Soy el hilo padre y he iniciado mi ejecución para crear un hilo hijo.");
        Thread hiloQueFinalizaAntes = new Thread(new HiloHijoJoin()); // Creamos el hijo.
        hiloQueFinalizaAntes.start(); // El proceso hijo empieza a estar listo.
        try {
        
        hiloQueFinalizaAntes.join(); // Ahora el padre espera a que el hijo finalice antes su ejecución.
        } catch (InterruptedException e) { // Join puede lanzar una interrupción al igual que sleep.
        System.out.println(e);
        return;
        }
        System.out.println("Soy el hilo padre y he finalizado mi ejecución."); // El padre no espera por el hijo.
    }
    
    
}
