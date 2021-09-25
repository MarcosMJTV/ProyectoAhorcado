package main;

import dominio.Difilcultades;
import dominio.Proceso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import frames.VentanaJuego;
import frames.VentanaMenu;

import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

public class Main {
	public static ArrayList<String> palabras = new ArrayList<>();
	public static int intentos = 9;
	// public static int intentos = 3;
	public static Proceso p;
	public static VentanaJuego ventana;
	public static VentanaMenu ven;
	public static ArrayList<ImageIcon> dibujos = new ArrayList<>();
	public static String direc = "C:\\Users\\marco\\Documents\\WorkSpace\\ProyectoGochAhorcado\\src\\recursos\\imaAho\\";
	public static String direc2 = "C:\\Users\\marco\\Documents\\WorkSpace\\ProyectoGochAhorcado\\src\\recursos\\";
	public static Clip hot;
	public static Clip hot2;
	public static Clip hot3;
	public static Difilcultades dificultad = Difilcultades.FACIL;

	public static void main(String[] args) {
		for (int i = 9; i > 0; i--) {

			dibujos.add(new ImageIcon(direc + "imaAho_" + i + ".png"));
		}

		File file = new File(direc2 + "palabras.txt");

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			while ((st = br.readLine()) != null) {
				palabras.add(st);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		IniciarMenu();

	}

	public static void IniciarJuego() {

		intentos = 9;
		hot.close();
		hot2 = ReproducirSonido(direc2 + "Mfondo.wav", 1f);
		ventana = new VentanaJuego();
		ventana.getLabelDibujo().setIcon(dibujos.get(0));
		ventana.getLblNewLabel().setText(p.getTextoEspaciado());
		ventana.getLabelMensaje().setText("");
		ventana.getbotonReiniciar().setVisible(false);
		ventana.getBotonSalir().setVisible(false);
		ventana.getbotonReiniciar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				IniciarMenu();
				hot3.close();
				ventana.setVisible(false);
				ventana.dispose();
			}

		});
		ventana.getBotonSalir().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ventana.setVisible(false);
				ventana.dispose();
				System.exit(0);
			}

		});

	}

	public static void IniciarMenu() {
		p = new Proceso();
		hot = ReproducirSonido(direc2 + "8bitYoa.wav", 0.8f);
		ven = new VentanaMenu();
		ven.getBoton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (ven.getRadio1().isSelected()) {
					dificultad = Difilcultades.FACIL;
				} else if (ven.getRadio2().isSelected()) {
					dificultad = Difilcultades.MEDIO;
				} else if (ven.getRadio3().isSelected()) {
					dificultad = Difilcultades.DIFICIL;
				}
				IniciarJuego();
				ven.setVisible(false);
				ven.dispose();
			}

		});
	}

	public static Clip ReproducirSonido(String nombreSonido, float volumen) {
		Clip clip = null;
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			setVolume(volumen, clip);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			System.out.println("Error al reproducir el sonido.");
		}
		return clip;
	}

	public static void setVolume(float volume, Clip clip) {
		if (volume < 0f || volume > 1f) {
			throw new IllegalArgumentException("Volume not valid: " + volume);
		}
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(20f * (float) Math.log10(volume));

	}

}
