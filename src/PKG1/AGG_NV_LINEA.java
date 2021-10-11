package PKG1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AGG_NV_LINEA {

	JFrame frame;
	private JTextField textField;
	ResultSet lista_marcas = null;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AGG_NV_LINEA window = new AGG_NV_LINEA();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AGG_NV_LINEA() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Agregar Nueva Linea");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 28, 414, 14);
		frame.getContentPane().add(lblNewLabel);
		CRUD crud = new CRUD();

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(300, 71, 86, 22);
		frame.getContentPane().add(comboBox);
		
		try {
			lista_marcas = crud.LISTA_DE_MARCAS();
			while (lista_marcas.next()) {
				
				comboBox.addItem(lista_marcas.getString("MARCA"));
				
			}
		}catch(SQLException e) {JOptionPane.showMessageDialog(null, e.getMessage());}
		
	
		
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione la Marca:");
		lblNewLabel_1.setBounds(57, 75, 146, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Introduzca el nombre de la nueva linea: ");
		lblNewLabel_2.setBounds(57, 104, 233, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(300, 104, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar Nueva Linea");
		btnNewButton.setBounds(146, 208, 144, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Introduzca el a\u00F1o de inicio del modelo:");
		lblNewLabel_3.setBounds(57, 138, 233, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(300, 135, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Introduzca el a\u00F1o final del Modelo:");
		lblNewLabel_4.setBounds(57, 173, 233, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBounds(300, 166, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String marca = comboBox.getSelectedItem().toString();
				String linea = textField.getText();
				String Modelo_Ini = textField_1.getText();
				String Modelo_Fin = textField_2.getText();
				crud.REGISTRAR_LINEA(marca, linea, Modelo_Ini, Modelo_Fin);
				System.exit(0);
						
			}
			
			
		});
	}
}
