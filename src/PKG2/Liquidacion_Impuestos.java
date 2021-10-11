package PKG2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import PKG1.CRUD;
import javax.swing.JComboBox;
import PKG3.Cliente_Login;

public class Liquidacion_Impuestos {

	public JFrame frame;
	ResultSet lista_marcas = null;
	public static String Marca ="";
	public static String Linea ="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Liquidacion_Impuestos window = new Liquidacion_Impuestos();
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
	public Liquidacion_Impuestos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.POPUP);
		frame.setBounds(100, 100, 450, 383);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema de pago de liquidacion por impuestos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Modulo Cliente");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(20, 36, 404, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Seleccione la Marca de su Automovil:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 137, 255, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(275, 133, 76, 22);
		frame.getContentPane().add(comboBox);
		CRUD crud = new CRUD();
		try {
			lista_marcas = crud.LISTA_DE_MARCAS();
			while (lista_marcas.next()) {
				
				comboBox.addItem(lista_marcas.getString("MARCA"));
				
			}
		}catch(SQLException e) {JOptionPane.showMessageDialog(null, e.getMessage());}

	
		
		JLabel lblNewLabel_3 = new JLabel("Seleccione la Linea:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(20, 170, 245, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(275, 166, 76, 22);
		frame.getContentPane().add(comboBox_1);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBox_1.removeAllItems();
				Marca= comboBox.getSelectedItem().toString();
				try {
					
					
					lista_marcas = crud.LISTA_DE_LINEAS(Marca);
					while (lista_marcas.next()) {
						
						comboBox_1.addItem(lista_marcas.getString("LINEA"));
						
					}
				}catch(SQLException e2) {JOptionPane.showMessageDialog(null, e2.getMessage());}
				
			
				
			}
		});
		
		comboBox_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			Linea= comboBox_1.getSelectedItem().toString();
		
			crud.Modelo(Marca, Linea);
				
			
			}
				
		
		});

		
		
		JLabel lblNewLabel_4 = new JLabel("Seleccion el Modelo:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(20, 203, 245, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(275, 199, 76, 22);
		frame.getContentPane().add(comboBox_2);
		
		JLabel lblNewLabel_5 = new JLabel("Es su auto de Servicio Publico?");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(20, 236, 245, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(275, 232, 76, 22);
		frame.getContentPane().add(comboBox_3);
		
		JLabel lblNewLabel_6 = new JLabel("Nombres y apellidos:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(20, 83, 404, 14);
		frame.getContentPane().add(lblNewLabel_6);
		lblNewLabel_6.setText("Nombres y Apellidos: "+Cliente_Login.nomyap);
		
		JLabel lblNewLabel_7 = new JLabel("Fecha de Ultimo Pago:");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(20, 108, 404, 14);
		frame.getContentPane().add(lblNewLabel_7);
		Fecha_Aleatoria F_AL = new Fecha_Aleatoria();
		Date randomDate = F_AL.randomDate("2020-05-01", "2021-05-01");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		String gg = randomDate.toString();
	
		lblNewLabel_7.setText( "Fecha de ultimo Pago: " +formato.format(randomDate) );
	

	}
}
