package dominio;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.Main;

public class Comandos implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		
		if (Main.ventana.getTextField().getText().length() >= 1 ) 
            e.consume();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		 if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			 Main.p.Juego();
		 }
		 
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
