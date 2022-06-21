package ar.com.interfazconversor;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class InterfazConversor extends JFrame {

	private JPanel contentPane;
	private JTextField txtCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazConversor frame = new InterfazConversor();
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
	public InterfazConversor () {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.setTitle("Conversor de Divisas");
		this.setLocationRelativeTo(null);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JComboBox cbDe = new JComboBox();
		cbDe.setModel(new DefaultComboBoxModel(new String[] {"ARS"}));
		cbDe.setBounds(289, 97, 95, 22);
		getContentPane().add(cbDe);
		
		JComboBox cbA = new JComboBox();
		cbA.setModel(new DefaultComboBoxModel(new String[] {"USD", "EURO"}));
		cbA.setBounds(289, 157, 95, 22);
		getContentPane().add(cbA);
		
		JLabel lblDe = new JLabel("De");
		lblDe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDe.setBounds(83, 101, 46, 14);
		getContentPane().add(lblDe);
		
		JLabel lblA = new JLabel("A");
		lblA.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblA.setBounds(83, 161, 46, 14);
		getContentPane().add(lblA);
		
		txtCantidad = new JTextField();
		txtCantidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantidad.setToolTipText("");
		txtCantidad.setBounds(289, 33, 95, 20);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCantidad.setBounds(83, 35, 68, 14);
		getContentPane().add(lblCantidad);
		
		JButton btnButton = new JButton("Convertir");
		btnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Double tipo;
				Double cantidad = Double.parseDouble(txtCantidad.getText());
				if(cbDe.getSelectedItem().toString() == "ARS" && cbA.getSelectedItem().toString() == "USD") {
					tipo = cantidad / 211.61;
					JOptionPane.showInputDialog(this, "Tu cantidad es: "+ tipo.toString());
				}
				else if(cbDe.getSelectedItem().toString() == "ARS" && cbA.getSelectedItem().toString() == "EURO") {
					tipo = cantidad*100.0 / 222.21;
					JOptionPane.showInputDialog(this, "Tu cantidad es: "+ tipo.toString());
				}
				
			}
		});
		btnButton.setBounds(171, 211, 89, 23);
		getContentPane().add(btnButton);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
	}
	
	public String aDivisa(double cantidad, String moneda) {
		return "$ " + Math.round(cantidad* 100.0)/100.0 + " "+ moneda;	
	}
	
}
