package tps.tp4.Tabuleiro;

import tps.tp4.Elemento.*;
import tps.tp4.Trajecto;

import java.awt.*;
import java.awt.event.*;

public class QuadriculaListener implements MouseListener{

	protected Quadricula quadricula;
	private Trajecto trajecto;

	public QuadriculaListener(Quadricula quadricula, Trajecto trajecto){
    	super();
    	this.quadricula = quadricula;
    	this.trajecto = trajecto;	
    }

	public void mouseReleased(MouseEvent m) {

	}

	public void mousePressed(MouseEvent m) {

	}

	public void mouseClicked(MouseEvent m) {	
		
		if(quadricula.elemento().podeEntrar(trajecto.getValue())){
			int x = quadricula.elemento().getTabX();
			int y = quadricula.elemento().getTabY();
			quadricula.desenhar(new Ligacao(trajecto.getColor(),x,y));
			trajecto.inserir(quadricula.elemento());
		}
	}

	public void mouseExited(MouseEvent m) {

	}

	public void mouseEntered(MouseEvent m) {
	
	}
}