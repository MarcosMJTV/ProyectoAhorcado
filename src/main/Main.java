package main;

import dominio.Proceso;
import frames.VentanaJuego;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Main {
	public static String [] palabras = {"cosa","asereje","skyrim","muleta","accidente", "ushuaia"};
	//public static int intentos = 9;
	public static int intentos = 3;
	public static Proceso p = new Proceso();
	public static VentanaJuego ventana;
	public static ArrayList<ImageIcon> dibujos = new ArrayList<>();
	public static String direc = "C:\\Users\\marco\\Documents\\WorkSpace\\ProyectoGochAhorcado\\src\\recursos\\imaAho\\";
	
	
	
	public static void main(String[]args) {
		for(int i = 9; i > 0; i--) {
			
			dibujos.add(new ImageIcon(direc + "imaAho_"+i+".png"));
		}
		
		ventana = new VentanaJuego();
		ventana.getLabelDibujo().setIcon(dibujos.get(0));
		ventana.getLblNewLabel().setText(new String(p.guiones));
		ventana.getLabelMensaje().setText("");
		
	}
}
