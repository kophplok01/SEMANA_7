package PKG1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;

public class AGREG_INTERFAZ {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AGREG_INTERFAZ window = new AGREG_INTERFAZ();
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
	public AGREG_INTERFAZ() {
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
		
		JLabel lblNewLabel = new JLabel("AGREGAR NUEVO AUTO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 31, 414, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Nueva Marca");
		btnNewButton.setBounds(48, 111, 137, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				AGG_NV_MARCA frame2 = new AGG_NV_MARCA();
				frame2.frame.setVisible(true);
					
					
			}
			
			
		});
		
		JButton btnNewButton_1 = new JButton("Nueva Linea");
		btnNewButton_1.setBounds(232, 111, 149, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				AGG_NV_LINEA frame3 = new AGG_NV_LINEA();
				frame3.frame.setVisible(true);
					
					
			}
			
			
		});

	}
}
