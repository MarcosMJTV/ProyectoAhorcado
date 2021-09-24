package dominio;

import java.util.Random;
import java.util.Scanner;

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
			Main.ventana.getLabelDibujo().setIcon(Main.dibujos.get(3 - Main.intentos));
			if (Main.intentos == 0) {
				System.out.println("сссс");
				Main.ventana.getLabelMensaje().setText("");
				Main.ventana.getLabelMensaje().setText("has perdido");
			}
		} else {
			boolean won = !hayGuiones(guiones);
			if (won == true) {
				System.out.println("gggg");
				Main.ventana.getLabelMensaje().setText("has ganado!!!!!");

			}
		}

		Main.ventana.getLblNewLabel().setText(new String(guiones));
	}
}
