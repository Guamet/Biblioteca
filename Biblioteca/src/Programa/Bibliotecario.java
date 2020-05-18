package Programa;

import java.util.*;

/**
 * 
 */
public class Bibliotecario extends Usuario {
	
    private String password;

    /**
     * Default constructor
     */
    public Bibliotecario(String nombre, String DNI, String password) {
    	super(nombre,DNI);
    	setPassword(password);
    }
    
    public void AnadirMaterial() {
        // TODO implement here
    }

    public void QuitarMaterial() {
        // TODO implement here
    }

    public void EstablecerPenalizacion() {
        // TODO implement here
    }

    public void QuitarPenalizacion() {
        // TODO implement here
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}