package tps.tp4.Tabuleiro;

import tps.tp4.Elemento.*;

import java.awt.*;
import java.awt.event.*;

public class QuadriculaListener implements MouseListener{

	protected Quadricula quadricula;

	public void mouseReleased(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseClicked(MouseEvent e) {
		quadricula.desenhar(new Ligacao(Color.BLUE));
	}

	public void mouseExited(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {
	
	}


    public QuadriculaListener(Quadricula quadricula){
    	super();
    	this.quadricula = quadricula;	
    }

}