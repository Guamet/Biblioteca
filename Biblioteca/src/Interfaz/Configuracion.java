package Interfaz;

import Programa.Biblioteca;
import Programa.Bibliotecario;
import Programa.Registrado;
import Programa.Usuario;
import Interfaz.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Configuracion extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Nombre;
	private JTextField textField_DNI;
	private JTextField textField_Contraseña;
	private JComboBox Tipos_Usuarios;
	private int eliminar_Usuario = 1;
	private JTextArea textArea;

	public Configuracion(JFrame f) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				f.setEnabled(true);
			}
		});
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 863, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConfiguracion = new JLabel("Configuraci\u00F3n");
		lblConfiguracion.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 24));
		lblConfiguracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfiguracion.setBounds(307, 11, 219, 41);
		contentPane.add(lblConfiguracion);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBorder(new LineBorder(UIManager.getColor("Button.light"), 2, true));
		panel.setBounds(10, 95, 827, 114);
		contentPane.add(panel);
		panel.setLayout(null);
		
		String[] usuarios = {"Registrado", "Bibliotecario"};
		Tipos_Usuarios = new JComboBox(usuarios);
		Tipos_Usuarios.setSelectedIndex(-1);
		Tipos_Usuarios.setBounds(10, 40, 101, 20);
		panel.add(Tipos_Usuarios);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 15, 46, 20);
		panel.add(lblNewLabel_1);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(176, 40, 147, 20);
		panel.add(textField_Nombre);
		textField_Nombre.setColumns(10);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombreDeUsuario.setBounds(176, 15, 147, 20);
		panel.add(lblNombreDeUsuario);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDni.setBounds(396, 15, 34, 20);
		panel.add(lblDni);
		
		textField_DNI = new JTextField();
		textField_DNI.setColumns(10);
		textField_DNI.setBounds(396, 40, 106, 20);
		panel.add(textField_DNI);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a:");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContraseña.setBounds(576, 15, 106, 20);
		panel.add(lblContraseña);
		
		textField_Contraseña = new JTextField();
		textField_Contraseña.setColumns(10);
		textField_Contraseña.setBounds(576, 40, 132, 20);
		panel.add(textField_Contraseña);
		
		JButton btnConfirm = new JButton("Confirmar");
		btnConfirm.setBackground(new Color(204, 255, 153));
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirm.setBounds(716, 80, 101, 23);
		panel.add(btnConfirm);
		btnConfirm.addActionListener(new Boton_Confirmar_Registro());
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBackground(new Color(204, 102, 102));
		btnEliminar.setBounds(607, 80, 101, 23);
		panel.add(btnEliminar);
		btnEliminar.addActionListener(new Boton_Eliminar());
		
		JLabel lblNewLabel = new JLabel("Registrar Nuevo Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 58, 173, 26);
		contentPane.add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBounds(664, 240, 173, 119);
		contentPane.add(scroll);
		textArea.setText(Usuarios_Registrados());
		
		JLabel lblNewLabel_2 = new JLabel("Usuarios Registrados");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(664, 215, 173, 26);
		contentPane.add(lblNewLabel_2);
		
		setVisible(true);
	}
	
	private class Boton_Confirmar_Registro implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(Tipos_Usuarios.getSelectedIndex() == -1) {
				
				JOptionPane.showMessageDialog(null, "Seleccione un tipo de Usuario", "Aviso!", JOptionPane.WARNING_MESSAGE);
			} else if(textField_Nombre.getText().length() == 0) {
				
				JOptionPane.showMessageDialog(null, "Introduce un Nombre de Usuario", "Aviso!", JOptionPane.WARNING_MESSAGE);
			} else if((textField_DNI.getText().length() == 0) || (textField_DNI.getText().length() != 9)) {
				
				JOptionPane.showMessageDialog(null, "Introduce un DNI valido", "Aviso!", JOptionPane.WARNING_MESSAGE);
			} else if(textField_Contraseña.getText().length() == 0) {
				
				JOptionPane.showMessageDialog(null, "Introduce una Contraseña", "Aviso!", JOptionPane.WARNING_MESSAGE);
			} else if(Comprobar_Nombre()) {
				
				JOptionPane.showMessageDialog(null, "Ya existe un Usuario con ese nombre", "Aviso!", JOptionPane.WARNING_MESSAGE);
			} else if(Comprobar_DNI()) {
				
				JOptionPane.showMessageDialog(null, "Ya existe un Usuario con ese DNI", "Aviso!", JOptionPane.WARNING_MESSAGE);
			} else if(Tipos_Usuarios.getSelectedIndex() == 0) {

				Interfaz.b1.añadirUsuario(new Registrado(textField_Nombre.getText(),textField_DNI.getText(),textField_Contraseña.getText()));
				JOptionPane.showMessageDialog(null, "Se ha registrado el Usuario correctamente", "Registro Completado!", JOptionPane.INFORMATION_MESSAGE);
				textArea.setText(Usuarios_Registrados());
				
			} else if(Tipos_Usuarios.getSelectedIndex() == 1) {
				
				Interfaz.b1.añadirUsuario(new Bibliotecario(textField_Nombre.getText(),textField_DNI.getText(),textField_Contraseña.getText()));
				JOptionPane.showMessageDialog(null, "Se ha registrado el Usuario correctamente", "Registro Completado!", JOptionPane.INFORMATION_MESSAGE);
				textArea.setText(Usuarios_Registrados());
			}

        }
		
    }
	
	private class Boton_Eliminar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			Comprobar_Nombre();
			
			if(Tipos_Usuarios.getSelectedIndex() == -1) {
				
				JOptionPane.showMessageDialog(null, "Seleccione un tipo de Usuario", "Aviso!", JOptionPane.WARNING_MESSAGE);
			} else if(textField_Nombre.getText().length() == 0) {
				
				JOptionPane.showMessageDialog(null, "Introduce un Nombre de Usuario para ELIMINAR", "Aviso!", JOptionPane.WARNING_MESSAGE);
			} else if((textField_DNI.getText().length() == 0) || (textField_DNI.getText().length() != 9)) {
				
				JOptionPane.showMessageDialog(null, "Introduce un DNI valido para ELIMINAR", "Aviso!", JOptionPane.WARNING_MESSAGE);
			} else if (eliminar_Usuario <= 1){
				
				JOptionPane.showMessageDialog(null, "No se ha encontrado el Usuario", "Aviso!", JOptionPane.WARNING_MESSAGE);
			} else {
				
				Interfaz.b1.eliminarUsuario(eliminar_Usuario);
				JOptionPane.showMessageDialog(null, "Se ha eliminado el Usuario correctamente", "Registro Completado!", JOptionPane.INFORMATION_MESSAGE);
			}
        }
    }
	
	private boolean Comprobar_Nombre() {
		
		for(int i = 0;i<Interfaz.b1.getUsuarios().size();i++) {
			if(Interfaz.b1.getUsuarios().get(i).getNombre().compareTo(textField_Nombre.getText()) == 0) {
				eliminar_Usuario = i;
				return true;
			}
		}
		return false;
	}
	
	private boolean Comprobar_DNI() {
		
		for(int i = 0;i<Interfaz.b1.getUsuarios().size();i++) {
			if(Interfaz.b1.getUsuarios().get(i).getDNI().compareTo(textField_DNI.getText()) == 0) {
				return true;
			}
		}
		return false;
	}
	
	private String Usuarios_Registrados() {
		
		String res = "---------------------\n";
		for(Usuario u : Interfaz.b1.getUsuarios()) {
			res+=u.toString();
		}
		return res;
	}
}
