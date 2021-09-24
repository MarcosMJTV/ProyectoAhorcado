package dominio;

import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;

import frames.VentanaJuego;
import main.Main;

public class Proceso {
	public String palabra = getPalabraSecreta();
	public char[] guiones = Guiones();

	public Proceso() {

	}

	public String getPalabraSecreta() {
		Random r = new Random();
		int n = r.nextInt(Main.palabras.length);
		String palabraSecreta = Main.palabras[n];
		return palabraSecreta;
	}

	public char[] Guiones() {
		char[] palabraGuiones = palabra.toCharArray();
		for (int i = 1; i < palabraGuiones.length - 1; i++) {
			palabraGuiones[i] = '_';
		}

		return palabraGuiones;
	}

	public boolean hayGuiones(char[] array) {
		for (char l : array) {
			if (l == '_')
				return true;
		}
		return false;
	}

	public void Juego() {
		Main.ventana.getTextField().requestFocus();
		if (Main.ventana.getTextField().getText().equals("")) {
			return;
		}

		char letra = Main.ventana.getTextField().getText().charAt(0);
		Main.ventana.getTextField().setText("");
		Main.ventana.getLabelMensaje().setText("");
		boolean acertada = false;
		for (int i = 0; i < palabra.length(); i++) {
			if (palabra.charAt(i) == letra) {
				guiones[i] = letra;
				acertada = true;
			}
		}
		if (!acertada) {
			Main.ventana.getLabelMensaje().setText("letra correcta");
			--Main.intentos;
			Main.ventana.getLabelDibujo().setIcon(Main.dibujos.get(9 - Main.intentos));
			if (Main.intentos == 1) {
				System.out.println("ldkjfklsjdf");
				Main.ventana.getPanel().setVisible(false);
				Main.ventana.getLabelMensaje().setVisible(false);
				Main.ventana.getBtnNewButton().setVisible(false);
				Main.ventana.getTextField().setVisible(false);
				Main.ventana.getLblNewLabel().setVisible(false);
			}
		} else {
			boolean won = !hayGuiones(guiones);
			if (won == true) {
				Main.ventana.getLabelDibujo().setIcon(new ImageIcon(Main.direc2 + "ganador.png"));
				Main.ventana.getPanel().setVisible(false);
				Main.ventana.getLabelMensaje().setVisible(false);
				Main.ventana.getBtnNewButton().setVisible(false);
				Main.ventana.getTextField().setVisible(false);
				Main.ventana.getLblNewLabel().setVisible(false);
			}
		}

		Main.ventana.getLblNewLabel().setText(new String(guiones));
	}
}
