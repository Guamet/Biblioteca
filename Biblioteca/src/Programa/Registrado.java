package Programa;

import java.util.*;

/**
 * 
 */
public class Registrado extends Usuario {
	
	private String password;
    private Integer diasPenalizado;
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();

    /**
     * Default constructor
     */
    public Registrado(String nombre, String DNI, String password) {
    	super(nombre,DNI);
    	this.password = password;
    }

    /**
     * 
     */

    public void RealizarPrestamo() {
        // TODO implement here
    }

    public void RealizarReserva() {
        // TODO implement here
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getDiasPenalizado() {
		return diasPenalizado;
	}

	public void setDiasPenalizado(Integer diasPenalizado) {
		this.diasPenalizado = diasPenalizado;
	}

}