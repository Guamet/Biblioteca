package Interfaz;

import Programa.*;
import Interfaz.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Interfaz_Biblioteca extends JFrame {

	private JPanel contentPane;
	private int userType;
	private JLabel lblUserType;
	private JButton btnPrestamo;
	private JButton btnDevolucion;
	private JButton btnConfiguracion;
	private JButton btnEliminar;
	private JButton btnAñadir;
	private JButton btnCerrarSesion;
	private JFrame g;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Interfaz_Biblioteca(JFrame f, int tipoUsuario) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				
				Cerrar();
			}
		});
		
		g = f;
		userType = tipoUsuario;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 874, 553);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea Material = new JTextArea();
		Material.setBounds(445, 109, 362, 295);
		Material.setEditable(false);
		contentPane.add(Material);
		
		JLabel lblNewLabel = new JLabel("Material Disponible");
		lblNewLabel.setBounds(542, 78, 172, 28);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(149, 11, 526, 39);
		panel.setBorder(new LineBorder(SystemColor.textHighlight, 2, true));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("Biblioteca");
		label_1.setBounds(207, 7, 112, 29);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		panel.add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(625, 427, 181, 76);
		lblNewLabel_1.setIcon(new ImageIcon("src/Imagenes/ulpgclargo(1).gif"));
		contentPane.add(lblNewLabel_1);
		
		btnPrestamo = new JButton("Realizar Prestamo");
		btnPrestamo.setBounds(32, 447, 132, 44);
		btnPrestamo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(btnPrestamo);
		btnPrestamo.addActionListener(new Boton_Prestamo());
		
		btnDevolucion = new JButton("Realizar Devoluci\u00F3n");
		btnDevolucion.setBounds(190, 447, 132, 44);
		btnDevolucion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(btnDevolucion);
		
		btnConfiguracion = new JButton("Configuraci\u00F3n");
		btnConfiguracion.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConfiguracion.setForeground(Color.RED);
		btnConfiguracion.setBackground(Color.ORANGE);
		btnConfiguracion.setBounds(10, 20, 129, 23);
		contentPane.add(btnConfiguracion);
		btnConfiguracion.addActionListener(new Boton_Configuracion());
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(704, 11, 132, 39);
		panel_1.setBackground(UIManager.getColor("activeCaption"));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblUserType = new JLabel("");
		lblUserType.setBounds(0, 0, 132, 39);
		panel_1.add(lblUserType);
		lblUserType.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblUserType.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnAñadir = new JButton("A\u00F1adir Material");
		btnAñadir.setBounds(32, 415, 132, 23);
		contentPane.add(btnAñadir);
		btnAñadir.setVisible(false);
		
		btnEliminar = new JButton("Eliminar Material");
		btnEliminar.setBounds(190, 415, 132, 23);
		contentPane.add(btnEliminar);
		btnEliminar.setVisible(false);
		
		btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesion.setBounds(704, 58, 132, 23);
		contentPane.add(btnCerrarSesion);
		btnCerrarSesion.addActionListener(new Boton_Cerrar_Sesion());
		
		

		Comprobar_Tipo_Usuario();
		
		
		
		setVisible(true);
	
	}
	
		private void Comprobar_Tipo_Usuario() {
			if(userType == 0) {
				
				lblUserType.setText("Invitado");
				btnPrestamo.setVisible(false);
				btnDevolucion.setVisible(false);
				btnConfiguracion.setVisible(false);
			} else if(userType == 1) {
				
				lblUserType.setText("Usuario");
				btnConfiguracion.setVisible(false);
			} else if(userType == 2) {
				
				lblUserType.setText("Bibliotecario");
				btnAñadir.setVisible(true);
				btnEliminar.setVisible(true);
			}
		}
		
		private class Boton_Prestamo implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				new Prestamo(Interfaz_Biblioteca.this);
				setEnabled(false);
	        }
	    } 
		
		private class Boton_Cerrar_Sesion implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				//Interfaz newInterfaz = new Interfaz();
				setVisible(false);
				g.setVisible(true);
	        }
	    }
		
		private class Boton_Configuracion implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				new Configuracion(Interfaz_Biblioteca.this);
				setEnabled(false);
	        }
	    }
		
		private void Cerrar() {
			String botones[] = {"Sí", "No"};
			int eleccion = JOptionPane.showOptionDialog(this, "¿Desea cerrar la aplicación?", "Cerrar Progama", 0, 0, null, botones, this);
			if(eleccion == JOptionPane.YES_OPTION) {
				try {
		    		
		    		ObjectOutputStream escribir_usuarios = new ObjectOutputStream(new FileOutputStream("Backup_Usuarios.dat"));
		    		escribir_usuarios.writeObject(Interfaz.b1.getUsuarios());
		    		System.out.println(Interfaz.b1.getUsuarios().get(0).toString());
		    		System.out.println(Interfaz.b1.getUsuarios().get(1).toString());
		    		System.out.println(Interfaz.b1.getUsuarios().get(2).toString());
		    		System.out.println(Interfaz.b1.getUsuarios().get(3).toString());
		    		escribir_usuarios.close();
		    	} catch(Exception e) {}
				
				System.exit(0);
			}
		}
}
