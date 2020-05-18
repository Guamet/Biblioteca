package Programa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Pruebas {

	public static void main(String[] args) {
		
		
		Genero gen = Genero.Cientifico;
		Date dat = new Date();
		Autor aut = new Autor("autor","español",dat);
		Libros prueba = new Libros(gen,aut, "titulo", "editorial", 1,3);
		System.out.println(prueba);
		
		
		
		Biblioteca b = new Biblioteca();
		
		try {
    		
    		ObjectOutputStream escribir_usuarios = new ObjectOutputStream(new FileOutputStream("Backup_Usuarios.dat"));
    		escribir_usuarios.writeObject(b.getUsuarios());
    		escribir_usuarios.close();
    	} catch(Exception e) {}
		
		try {
			
		ObjectInputStream recuperar_usuarios = new ObjectInputStream(new FileInputStream("Backup_Usuarios.dat"));
		ArrayList<Usuario> usuarios_backup = (ArrayList<Usuario>) recuperar_usuarios.readObject();
		recuperar_usuarios.close();
			
		for(Usuario u : usuarios_backup) {
			System.out.println(u);
		}
		
		} catch(Exception e) {}
		
		System.out.println("Hola");

	}

}
