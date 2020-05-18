package Interfaz;


import Programa.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.border.SoftBevelBorder;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	private JTextField textField_UserName;
	private JPasswordField passwordField;
	public static final Biblioteca b1 = new Biblioteca();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			
			ObjectInputStream recuperar_usuarios = new ObjectInputStream(new FileInputStream("Backup_Usuarios.dat"));
			ArrayList<Usuario> usuarios_backup = (ArrayList<Usuario>) recuperar_usuarios.readObject();
			recuperar_usuarios.close();
				
			for(int i = 3; i < usuarios_backup.size(); i++) {
				b1.añadirUsuario(usuarios_backup.get(i));
			}
		} catch(Exception e) {}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interfaz() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Cerrar();
			}
		});
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 794, 492);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.textHighlight, 2, true));
		panel.setBounds(89, 77, 381, 244);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_UserName = new JLabel("Nombre de Usuario:");
		lbl_UserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_UserName.setBounds(27, 91, 131, 19);
		panel.add(lbl_UserName);
		
		textField_UserName = new JTextField();
		textField_UserName.setBounds(192, 92, 130, 20);
		panel.add(textField_UserName);
		textField_UserName.setColumns(10);
		
		JLabel lbl_Pass = new JLabel("Contrase\u00F1a:");
		lbl_Pass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Pass.setBounds(27, 121, 79, 19);
		panel.add(lbl_Pass);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(192, 123, 130, 20);
		panel.add(passwordField);
		
		JButton Boton_Login = new JButton("Iniciar Sesi\u00F3n");
		Boton_Login.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Boton_Login.setBounds(217, 160, 105, 23);
		panel.add(Boton_Login);
		Boton_Login.addActionListener(new Boton_Login());
		
		JLabel lbl_InicioSesion = new JLabel("Inicio de Sesi\u00F3n");
		lbl_InicioSesion.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 22));
		lbl_InicioSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_InicioSesion.setBounds(120, 11, 131, 29);
		panel.add(lbl_InicioSesion);
		
		JButton Boton_Invitado = new JButton("Entrar como Invitado");
		Boton_Invitado.setBounds(217, 194, 146, 23);
		panel.add(Boton_Invitado);
		Boton_Invitado.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.textHighlight, 2, true));
		panel_1.setBounds(89, 11, 526, 39);
		contentPane.add(panel_1);
		
		JLabel lbl_Title = new JLabel("Biblioteca");
		panel_1.add(lbl_Title);
		lbl_Title.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lbl_Title.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src/Imagenes/ulpgc.gif"));
		lblNewLabel.setBounds(552, 234, 201, 208);
		contentPane.add(lblNewLabel);
		Boton_Invitado.addActionListener(new Boton_Invitado());
		
        setVisible(true);
		
	}
	
	 private class Boton_Login implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				Login_Check();
			
	        }
	    }
	 
	 private class Boton_Invitado implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Has iniciado sesión como invitado");
				b1.privilegios = 0;
				new Interfaz_Biblioteca(Interfaz.this, b1.privilegios);
				setVisible(false);
	        }
	    }
	 
	 private int Login_Check() {
		 
		 String userName = textField_UserName.getText();
		 String password = String.valueOf(passwordField.getPassword());
		 
			if((userName.length() == 0) || (password.length() == 0)) {
	        	JOptionPane.showMessageDialog(null, "Introduzca un usuario y contraseña", "Aviso!", JOptionPane.WARNING_MESSAGE);
			} else {
				for(int i = 0;i<b1.getUsuarios().size();i++) {
					if(b1.getUsuarios().get(i).getNombre().compareTo(userName) == 0) {
						if(b1.getUsuarios().get(i) instanceof Bibliotecario) {
							if(((Bibliotecario)b1.getUsuarios().get(i)).getPassword().compareTo(password) == 0) {
								b1.privilegios = 2;
								new Interfaz_Biblioteca(Interfaz.this, 2);
								setVisible(false);
								System.out.println("Has iniciado sesión como bibliotecario");
								textField_UserName.setText("");
								passwordField.setText("");
								return 0;
							}else {
								JOptionPane.showMessageDialog(null, "Introduzca un usuario y contraseña validos", "Aviso!", JOptionPane.WARNING_MESSAGE);
								return 0;
							}						
						}else if(b1.getUsuarios().get(i) instanceof Registrado){
							if(((Registrado)b1.getUsuarios().get(i)).getPassword().compareTo(password) == 0) {
								b1.privilegios = 1;
								new Interfaz_Biblioteca(Interfaz.this, 1);
								setVisible(false);
								System.out.println("Has iniciado sesión como usuario");
								textField_UserName.setText("");
								passwordField.setText("");
								return 0;
							}else {
								JOptionPane.showMessageDialog(null, "Introduzca un usuario y contraseña validos", "Aviso!", JOptionPane.WARNING_MESSAGE);
								return 0;
							}
							
						}else {
							b1.privilegios = 0;
							new Interfaz_Biblioteca(Interfaz.this, b1.privilegios);
							setVisible(false);
							System.out.println("Has iniciado sesión como invitado");
							return 0;
						}
					}
				}
					JOptionPane.showMessageDialog(null, "No se ha encontrado un Usuario con ese Nombre y Contraseña", "Aviso!", JOptionPane.WARNING_MESSAGE);
			}
			return 0;
	 }
	 
	 private void Cerrar() {
			String botones[] = {"Sí", "No"};
			int eleccion = JOptionPane.showOptionDialog(this, "¿Desea cerrar la aplicación?", "Cerrar Progama", 0, 0, null, botones, this);
			if(eleccion == JOptionPane.YES_OPTION) {
				try {
		    		
					ObjectOutputStream escribir_usuarios = new ObjectOutputStream(new FileOutputStream("Backup_Usuarios.dat"));
		    		escribir_usuarios.writeObject(b1.getUsuarios());
		    		System.out.println(Interfaz.b1.getUsuarios().get(1).toString());
		    		System.out.println(Interfaz.b1.getUsuarios().get(2).toString());
		    		System.out.println(Interfaz.b1.getUsuarios().get(3).toString());
		    		escribir_usuarios.close();
		    	} catch(Exception e) {}
				
				System.exit(0);
			}
		}
}

