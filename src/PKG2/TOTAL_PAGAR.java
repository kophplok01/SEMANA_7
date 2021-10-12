package PKG2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import PKG3.Cliente_Login;

import java.awt.Font;
import javax.swing.JButton;

public class TOTAL_PAGAR {

	JFrame frame;
	public static double v;
	public static double descuento;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TOTAL_PAGAR window = new TOTAL_PAGAR();
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
	public TOTAL_PAGAR() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 384, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pago de Impuestos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 316, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("El impuesto a pagar por el auto");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 61, 348, 14);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setText("Auto: "+ Liquidacion_Impuestos.Marca+ ", Linea "+ Liquidacion_Impuestos.Linea+", Modelo "+Liquidacion_Impuestos.Modelo);
		
		JButton btnNewButton = new JButton("Pagar");
		btnNewButton.setBounds(150, 351, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 86, 348, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_2.setText("Propietario: "+Cliente_Login.nomyap+",   Numero de Id:"+Cliente_Login.Nr_Ced);
		
		JLabel lblNewLabel_3 = new JLabel("Descuento por pronto Pago: "+Liquidacion_Impuestos.Pronto_Pago);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 111, 348, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Descuento por traslado de cuenta: "+Liquidacion_Impuestos.Traslado_Cuenta);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 136, 348, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Descuento por auto de Servicio Publico: "+Liquidacion_Impuestos.Servicio_publico);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 161, 348, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Valor del Vehiculo: "+Liquidacion_Impuestos.Valor);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(10, 186, 348, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		v = Double.valueOf(Liquidacion_Impuestos.Valor);
		double cc = v*0.01;
		
		JLabel lblNewLabel_7 = new JLabel("Impuesto a pagar: "+cc);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(10, 211, 348, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Impuesto a pagar con Descuento por Pronto Pago:");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(10, 236, 348, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Impuesto a pagar con descuento por traslado:");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(10, 261, 348, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Impuesto a pagar por auto del servicio publico:");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(10, 286, 348, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Impuesto a pagar con descuentos aplicados: ");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(10, 311, 348, 14);
		frame.getContentPane().add(lblNewLabel_11);
		
		
	
		if (Liquidacion_Impuestos.Pronto_Pago.equals("Si")) {
			
		 descuento = descuento+0.1;
		 double p1 = cc*descuento;
		 double p12 = cc-p1;
		 lblNewLabel_8.setText("Impuesto a pagar con Descuento por Pronto Pago: "+String.valueOf(p12)+" COP");
		 
		}
		
		if (Liquidacion_Impuestos.Traslado_Cuenta.equals("Si")) {
			
			 descuento = descuento+0.15;
			 double p1 = cc*descuento;
			 double p12 = cc-p1;
			 lblNewLabel_9.setText("Impuesto a pagar con descuento por traslado: "+String.valueOf(p12)+" COP");
		}
		if (Liquidacion_Impuestos.Servicio_publico.equals("Si")) {
			
			 descuento = descuento+0.05;
			 double p1 = cc*descuento;
			 double p12 = cc-p1;
			 lblNewLabel_10.setText("Impuesto a pagar por auto del servicio publico: "+String.valueOf(p12)+" COP");
		}
		double pp = cc*descuento;
		double total = cc-pp;
	
		 lblNewLabel_11.setText("Total a pagar con descuentos aplicados: "+String.valueOf(total)+" COP");
		
	}
}
