package PKG1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class D1 {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					D1 window = new D1();
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
	public D1() {
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
		
		JLabel lblNewLabel = new JLabel("SISTEMA DE GESTION DE LIQUIDACIONES POR IMPUESTO AL VEHICULO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 25, 414, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione la operacion a realizar:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(20, 85, 404, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Agregar Auto");
		btnNewButton.setBounds(74, 128, 110, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AGREG_INTERFAZ frame2 = new AGREG_INTERFAZ();
				frame2.frame.setVisible(true);
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Modificar Auto");
		btnNewButton_1.setBounds(248, 128, 110, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Eliminar Auto");
		btnNewButton_2.setBounds(74, 169, 110, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Salir");
		btnNewButton_3.setBounds(248, 169, 110, 23);
		frame.getContentPane().add(btnNewButton_3);
	}

}
