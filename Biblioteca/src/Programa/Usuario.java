package Programa;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Usuario implements Serializable{
	
	private String nombre;
	private String DNI;

    /**
     * Default constructor
     */
    public Usuario(String nombre, String DNI) {
    	this.nombre = nombre;
    	this.DNI = DNI;
    }

    /**
     * 
     */
    public void ConsultarCatalogo() {
        // TODO implement here
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}
	
	
	@Override
	public String toString() {
		String dev = "";
		dev+=this.getNombre()+"\n";
		dev+=this.getDNI()+"\n";
		dev+="---------------------\n";
		return dev;
	}
	

}