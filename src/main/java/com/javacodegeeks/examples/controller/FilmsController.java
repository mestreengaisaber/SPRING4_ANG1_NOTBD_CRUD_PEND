package com.javacodegeeks.examples.controller;
import hiloTestear.HiloSleep;
import hiloTestear.join.HiloPadreJoin;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/films")
public class FilmsController {

	private static final List<Film> DUMMY_FILMS = new ArrayList<Film>();
	private static final List<Film> PROCESOS_FILMS = new ArrayList<Film>();
        
	static {
                DUMMY_FILMS.add(new Film("Ernest y Spring4", 2017, "Bob"));
		DUMMY_FILMS.add(new Film("12 years a slave", 2013, "Steve McQueen"));
		DUMMY_FILMS.add(new Film("Argo", 2012, "Ben Affleck"));
		DUMMY_FILMS.add(new Film("The Artist", 2011, "Michel Hazanavicius"));
		DUMMY_FILMS.add(new Film("The King's speech", 2010, "Tom Hooper"));
		DUMMY_FILMS.add(new Film("The Hurt Locker", 2009, "Kathryn Bigelow"));
		DUMMY_FILMS.add(new Film("Slumdog Millionaire", 2008, "Danny Boyle"));
		DUMMY_FILMS.add(new Film("No Country for Old Men", 2007, "Joel y Ethan Coen"));
	}
	
        static {
                PROCESOS_FILMS.add(new Film("proceso1", 1));
                PROCESOS_FILMS.add(new Film("proceso2", 2));
		
	}
	
        
	@RequestMapping(method = RequestMethod.GET)
	public List<Film> getFilms() {
            //ejemplos a probar del hilo .. descomentar 
            /*System.out.println("Ejemplo1  en Java de concurrencia aleatoria con dos hilos haciendo uso de sleep()");
            llamarAlHiloSleep();
            System.out.println("Fin hilo");
            
            System.out.println("Ejemplo3 en Java de un hilo que no espera a que termine la ejecución de otro, El método join()");
            //metemos datos correctos : 
            llamarAlHiloEj3Join();
            System.out.println("Fin hilo3 ");*/
            
        return DUMMY_FILMS;
            
	}
        
        @RequestMapping(method = RequestMethod.PUT)
	public void actualizar(@PathVariable("id") Long id, @Valid  Film film){
          
            
        }
	
	@RequestMapping(method = RequestMethod.POST)
	public void addFilm(@RequestBody @Valid Film film) {
		DUMMY_FILMS.add(film);
	}
	
        
        public void llamarAlHiloSleep(){
        // Lanzamos dos hilos de forma concurrente que duren un tiempo aleatorio:
        Random aleatorio = new Random(1337);

        for (int i = 0; i < 2; i++) {

            // Un hilo tendrá un tiempo de ejecución comprendido entre los 0 y 10 segundos.
            new Thread(new HiloSleep(i, aleatorio.nextInt(10000))).start();

        }
        }
        
        void llamarAlHiloEj3Join(){
       // Lanzamos dos hilos de forma concurrente:
        Thread hilo = new Thread(new HiloPadreJoin()); // El hilo está instanciado pero todavía no está listo para ejecutarse.
        hilo.start(); // Ahora sí que el primer hilo se ejecuta

        }
}