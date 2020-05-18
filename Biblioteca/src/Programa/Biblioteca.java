package Programa;

import java.util.*;

/**
 * 
 */
public class Biblioteca {

	public int privilegios; //0 = Invitado, 1 = Usuario, 2 = Bibliotecario.
	private ArrayList<Catalogo> material = new ArrayList<Catalogo>();
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    /**
     * Default constructor
     */
    public Biblioteca() {
    	//SE CREAN USUARIOS BASICOS
    	usuarios.add(new Bibliotecario("Bibliotecario","45678912A","Bibliotecario"));
    	usuarios.add(new Registrado("Usuario","45678912A","Usuario"));
    	usuarios.add(new Invitados("Invitado","45678912A"));
    	//SE CREA MATERIAL
    	
    	
    }
	public ArrayList<Catalogo> getMaterial() {
		return material;
	}
	public void setMaterial(ArrayList<Catalogo> material) {
		this.material = material;
	}
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
//////LISTAS
	
	//USUARIOS
	
	public void añadirUsuario(Usuario us) {
		usuarios.add(us);
	}
	
	public void eliminarUsuario(int pos) {
		usuarios.remove(pos);
	}
	
	//CATALOGO
	
//////DEZPLEGABLES
    
	public String[] libros() {
		int cont = 0;
		TreeSet<String> titulos = new TreeSet<String>();
		for(int i = 0;i<this.getMaterial().size();i++) {
			if(this.getMaterial().get(i) instanceof Libros) {
				//titulos.add(((Libros)this.getMaterial().get(i)).getTitulo());
			}
		}
		String[] dev = new String[titulos.size()];
		for(String element: titulos) {
			dev[cont++] = element;
		}
		return dev;
	}
	
	public String[] librosGenero() {
		int cont = 0;
		TreeSet<String> generos = new TreeSet<String>();
		for(int i = 0;i<this.getMaterial().size();i++) {
			if(this.getMaterial().get(i) instanceof Libros) {
				//generos.add(((Libros)this.getMaterial().get(i)).getGenero().toString());
			}
		}
		String[] dev = new String[generos.size()];
		for(String element: generos) {
			dev[cont++] = element;
		}
		return dev;
	}
	
	public String[] librosAutor() {
		int cont = 0;
		TreeSet<String> autores = new TreeSet<String>();
		for(int i = 0;i<this.getMaterial().size();i++) {
			if(this.getMaterial().get(i) instanceof Libros) {
				//autores.add(((Libros)this.getMaterial().get(i)).getAutor().getNombre());
			}
		}
		String[] dev = new String[autores.size()];
		for(String element: autores) {
			dev[cont++] = element;
		}
		return dev;
	}
	
	public Catalogo[] revistas() {
		int cont = 0;
		for(int i = 0;i<this.getMaterial().size();i++) {
			if(this.getMaterial().get(i) instanceof Revistas) {
				cont++;
			}
		}
		Catalogo[] dev = new Catalogo[cont];
		cont = 0;
		for(int i = 0;i<this.getMaterial().size();i++) {
			if(this.getMaterial().get(i) instanceof Revistas) {
				dev[cont++] = this.getMaterial().get(i);
			}
		}
		return dev;
	}
	
	public Catalogo[] periodicos() {
		int cont = 0;
		for(int i = 0;i<this.getMaterial().size();i++) {
			if(this.getMaterial().get(i) instanceof Periodicos) {
				cont++;
			}
		}
		Catalogo[] dev = new Catalogo[cont];
		cont = 0;
		for(int i = 0;i<this.getMaterial().size();i++) {
			if(this.getMaterial().get(i) instanceof Periodicos) {
				dev[cont++] = this.getMaterial().get(i);
			}
		}
		return dev;
	}





}