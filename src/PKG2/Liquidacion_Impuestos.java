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

import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Liquidacion_Impuestos {

	public JFrame frame;
	ResultSet lista_marcas = null;
	public static String Marca ="";
	public static String Linea ="";
	public static String Modelo ="";
	public static String Servicio_publico ="";
	public static String Traslado_Cuenta ="";
	public static String Pronto_Pago;
	private JTextField textField;
	public static String Valor ="";


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
		frame.setBounds(100, 100, 450, 429);
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
		comboBox.setBounds(275, 133, 93, 22);
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
		comboBox_1.setBounds(275, 166, 93, 22);
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
		
		
		JLabel lblNewLabel_4 = new JLabel("Seleccion el Modelo:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(20, 203, 245, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(275, 199, 93, 22);
		frame.getContentPane().add(comboBox_2);
		comboBox_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			comboBox_2.removeAllItems();
			Linea= comboBox_1.getSelectedItem().toString();
		
			String [] Modelos = crud.Modelo(Marca, Linea);

   		 	for (int i = 0; i < Modelos.length; i++) {
   		 	comboBox_2.addItem(Modelos[i]);
  	        
  	        }
		
			
			}
				
		
		});
		JLabel lblNewLabel_5 = new JLabel("Es su auto de Servicio Publico?");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(20, 236, 245, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(275, 232, 93, 22);
		frame.getContentPane().add(comboBox_3);
		comboBox_3.addItem("Si");
		comboBox_3.addItem("No");
		
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
		int year = randomDate.getYear()+1900;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		String gg = randomDate.toString();
	
		lblNewLabel_7.setText( "Fecha de ultimo Pago: " +formato.format(randomDate) );
		
		JLabel lblNewLabel_8 = new JLabel("Aplica usted para el translado de Cuenta?");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(20, 273, 245, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(275, 269, 93, 22);
		frame.getContentPane().add(comboBox_4);
		comboBox_4.addItem("Si");
		comboBox_4.addItem("No");
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.setBounds(176, 356, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_9 = new JLabel("Introduzca el valor de su Vehiculo:");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(20, 310, 245, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(275, 307, 93, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date dd = new Date();
				int year2comp = dd.getYear()+1900;
				
				if(year2comp - year ==0 ) {
					Pronto_Pago = "Si";
				}else {
					Pronto_Pago = "No";
				}
				Servicio_publico = comboBox_3.getSelectedItem().toString();
				Traslado_Cuenta = comboBox_4.getSelectedItem().toString();
				Modelo = comboBox_2.getSelectedItem().toString();
				Valor = textField.getText();
				
				TOTAL_PAGAR tt = new TOTAL_PAGAR();
				tt.frame.setVisible(true);;
			}	
			
		});
	

	}
}
