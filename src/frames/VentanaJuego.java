package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Main;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaJuego extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JLabel labelDibujo;
	private JLabel labelMensaje;
	
	private JPanel panel;

	/**
	 * Create the frame.
	 */
	public VentanaJuego() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 337);
		contentPane = new Textuta();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel = new JPanel();
		panel.setBounds(10, 11, 414, 31);
		contentPane.add(panel);
		panel.setLayout(null);
		
	

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 414, 31);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe Script", Font.BOLD, 19));

		textField = new JTextField();
		textField.setBounds(193, 204, 47, 49);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		contentPane.add(textField);
		textField.setColumns(10);

		btnNewButton = new JButton("Enter");
		btnNewButton.setBounds(182, 264, 70, 23);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.p.Juego();
			}
			
		});
		contentPane.add(btnNewButton);
		
		labelDibujo = new JLabel("");
		labelDibujo.setBounds(54, 39, 335, 156);
		labelDibujo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(labelDibujo);
		
		labelMensaje = new JLabel("New label");
		labelMensaje.setBounds(10, 230, 162, 31);
		labelMensaje.setFont(new Font("Segoe Script", Font.PLAIN, 14));
		labelMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(labelMensaje);
		setVisible(true);
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}
	public JLabel getLabelDibujo() {
		return labelDibujo;
	}
	public JLabel getLabelMensaje() {
		return labelMensaje;
	}
	public JPanel getPanel() {
		return panel;
	}
}
