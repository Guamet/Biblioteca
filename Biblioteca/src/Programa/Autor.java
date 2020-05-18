package Programa;

import java.util.*;

/**
 * 
 */
public class Autor {
	
    private String nombre;
    private String nacionalidad;
    private Date fechaNacimiento;
    
    /**
     * Default constructor
     */
    public Autor(String nombre, String nacionalidad, Date fechaNacimiento) {
    	setNombre(nombre);
    	setNacionalidad(nacionalidad);
    	setFechaNacimiento(fechaNacimiento);    	
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}