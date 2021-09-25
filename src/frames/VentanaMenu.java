package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Main;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Font;

public class VentanaMenu extends JFrame {

	private JPanel contentPane;
	private JLabel labelTitulo;
	
	
	
	private JRadioButton radio1;
	private JRadioButton radio2;
	private JRadioButton radio3;
	private JLabel lblNewLabel;
	private JButton boton;

	
	public VentanaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 374);
		contentPane = new Textuta();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelTitulo = new JLabel("");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(59, 94, 316, 92);
		labelTitulo.setIcon(new ImageIcon(Main.direc2+"titulo.png"));
		contentPane.add(labelTitulo);
		
		boton = new JButton("Jugar");
		boton.setBounds(307, 270, 89, 23);
		contentPane.add(boton);
		
		radio1 = new JRadioButton("Facil");
		radio1.setBounds(29, 226, 109, 23);
		radio1.setOpaque(false);
		contentPane.add(radio1);
		
		radio2 = new JRadioButton("Medio");
		radio2.setBounds(29, 252, 109, 23);
		radio2.setOpaque(false);
		contentPane.add(radio2);
		
		radio3 = new JRadioButton("Dificil");
		radio3.setBounds(29, 278, 109, 23);
		radio3.setOpaque(false);
		contentPane.add(radio3);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(radio1);
		grupo.add(radio2);
		grupo.add(radio3);
		
		lblNewLabel = new JLabel("Dificultad:");
		lblNewLabel.setFont(new Font("Segoe Script", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 197, 128, 22);
		contentPane.add(lblNewLabel);
		setVisible(true);
		
		
		
	}

	public JPanel getContentPane() {
		return contentPane;
	}
	public JLabel getlabelTitulo() {
		return labelTitulo;
	}
	public JRadioButton getRadio1() {
		return radio1;
	}
	public JRadioButton getRadio2() {
		return radio2;
	}
	public JRadioButton getRadio3() {
		return radio3;
	}
	public JButton getBoton() {
		return boton;
	}
}
