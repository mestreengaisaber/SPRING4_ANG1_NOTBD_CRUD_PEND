package com.javacodegeeks.examples.controller;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

public class Film {

	@NotEmpty
	private String title;
	
	@NotNull
	private Integer year;
	
	@NotEmpty
	private String director;
        
        
        
	private Integer prioridadProceso;
        private String nombreProceso;

	private Film() {
		
	}
	
	public Film(String title, Integer year, String director) {
		this.title = title;
		this.year = year;
		this.director = director;
	}
        //constructor proceso 
        public Film(String nombreProceso, Integer prioridadProceso) {
		this.nombreProceso = nombreProceso;
		this.prioridadProceso = prioridadProceso;
		
	}
        

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getDirector() {
		return director;
	}

    /**
     * @return the prioridadProceso
     */
    public Integer getPrioridadProceso() {
        return prioridadProceso;
    }

    /**
     * @param prioridadProceso the prioridadProceso to set
     */
    public void setPrioridadProceso(Integer prioridadProceso) {
        this.prioridadProceso = prioridadProceso;
    }

    /**
     * @return the nombreProceso
     */
    public String getNombreProceso() {
        return nombreProceso;
    }

    /**
     * @param nombreProceso the nombreProceso to set
     */
    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
    }
	
	

}
