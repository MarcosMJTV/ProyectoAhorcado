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
		int n = r.nextInt(Main.palabras.size());
		String palabraSecreta = Main.palabras.get(n);
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
				if(guiones[i] == letra) {
					Main.ventana.getLabelMensaje().setText("letra usada");
				}
				guiones[i] = letra;
				acertada = true;
				
			}
		}
		if (!acertada) {
			Main.ventana.getLabelMensaje().setText("letra correcta");
			if(Main.dificultad == Difilcultades.FACIL) {
				Main.intentos -= 1;
			}else if(Main.dificultad == Difilcultades.MEDIO) {
				Main.intentos -= 2;
			}else if(Main.dificultad == Difilcultades.DIFICIL) {
				Main.intentos -= 4;
			}
			Main.ventana.getLabelDibujo().setIcon(Main.dibujos.get(9 - Main.intentos));
			if (Main.intentos == 1) {
				Main.hot2.close();
				Main.ventana.getbotonReiniciar().setVisible(true);
				Main.ventana.getBotonSalir().setVisible(true);
				Main.hot3 = Main.ReproducirSonido(Main.direc2+"bad.wav", 1f);
				Main.ventana.getLabelMensaje().setVisible(false);
				Main.ventana.getTextField().setVisible(false);
				Main.ventana.getLblNewLabel().setText(palabra);
				return;
			}
		} else {
			boolean won = !hayGuiones(guiones);
			if (won == true) {
				Main.hot2.close();
				Main.ventana.getbotonReiniciar().setVisible(true);
				Main.ventana.getBotonSalir().setVisible(true);
				Main.hot3 = Main.ReproducirSonido(Main.direc2+"victoria.wav", 1f);
				Main.ventana.getLabelDibujo().setIcon(new ImageIcon(Main.direc2 + "ganador.png"));
				Main.ventana.getLabelMensaje().setVisible(false);
				Main.ventana.getTextField().setVisible(false);
				Main.ventana.getLblNewLabel().setText(palabra);
			}
		}

		Main.ventana.getLblNewLabel().setText(getTextoEspaciado());
	}
	
	public String getTextoEspaciado() {
		char[] espaciado = new char[(guiones.length*2)-1];
		for(int i = 0; i < espaciado.length; i++) {
			if(i%2 == 1) {
				espaciado[i] = ' ';
			}
			else {
				espaciado[i] = guiones[i/2];
			}
		}
		
		return new String(espaciado);
	}
}
