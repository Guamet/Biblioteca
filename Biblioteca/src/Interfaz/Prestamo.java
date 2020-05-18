package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JList;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Label;

public class Prestamo extends JFrame {

	private JPanel contentPane;
	private JComboBox Material;
	private JLabel lblGenero;
	private JComboBox comboBox_Generos;
	private JButton btnNewButton;
	private JComboBox comboBox_Tematica;

	/**
	 * Create the frame.
	 */
	public Prestamo(JFrame f) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				f.setEnabled(true);
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 735, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Prestamos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(266, 11, 131, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de Material");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 81, 131, 14);
		contentPane.add(lblNewLabel_1);
		
		String[] tiposMaterial = {"Libros" , "Revistas", "Periodicos", "Portatiles"};
		Material = new JComboBox(tiposMaterial);
		Material.setSelectedIndex(-1);
		Material.setBounds(10, 106, 131, 20);
		contentPane.add(Material);
		Material.addActionListener(new comboBox_Listener());
		
		String[] Generos = {"Acción" , "Comedia", "Fantasía", "Humor"};
		comboBox_Generos = new JComboBox(Generos);
		comboBox_Generos.setSelectedIndex(-1);
		comboBox_Generos.setBounds(170, 106, 131, 20);
		contentPane.add(comboBox_Generos);;
		comboBox_Generos.setVisible(false);
		
		String[] Tematicas = {"wdawd" , "dwadaw", "wdadaw", "fawfw"};
		comboBox_Tematica = new JComboBox(Tematicas);
		comboBox_Tematica.setSelectedIndex(-1);
		comboBox_Tematica.setBounds(170, 106, 131, 20);
		contentPane.add(comboBox_Tematica);
		comboBox_Tematica.setVisible(false);
		
		lblGenero = new JLabel("Generos");
		lblGenero.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblGenero.setBounds(170, 81, 131, 14);
		contentPane.add(lblGenero);
		lblGenero.setVisible(false);
		
		btnNewButton = new JButton("Confirmar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(204, 255, 153));
		btnNewButton.setBounds(578, 204, 131, 37);
		contentPane.add(btnNewButton);
		
		
		
		
		setVisible(true);
	}
	
	private class comboBox_Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(Material.getSelectedIndex() == 0) {

				comboBox_Tematica.setVisible(false);
				lblGenero.setVisible(true);
				comboBox_Generos.setVisible(true);
				lblGenero.setText("Generos");
				comboBox_Tematica.setSelectedIndex(-1);
				
			} else if (Material.getSelectedIndex() == 1){
				
				comboBox_Generos.setVisible(false);
				comboBox_Tematica.setVisible(true);
				lblGenero.setText("Tematica");
				comboBox_Generos.setSelectedIndex(-1);
			} else {
				
				comboBox_Tematica.setVisible(false);
				lblGenero.setVisible(false);
				comboBox_Generos.setVisible(false);
			}
        }
    } 
}
