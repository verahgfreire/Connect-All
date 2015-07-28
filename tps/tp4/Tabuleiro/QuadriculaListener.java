package tps.tp4.Tabuleiro;

import tps.tp4.Elemento.*;
import tps.tp4.Trajecto;
import tps.tp4.*;

import java.awt.*;
import java.awt.event.*;

public class QuadriculaListener implements MouseListener{

	protected Elemento elem;

	public QuadriculaListener(Elemento e){
    	super();
    	this.elem = e;	
    }

	public void mouseReleased(MouseEvent m) {

	}

	public void mousePressed(MouseEvent m) {

	}

	public void mouseClicked(MouseEvent m) {	
		
		if(elem.podeEntrar(Jogo.tabuleiro().trajecto().getValue())){
			if(!(elem instanceof Peca)){
				elem = new Ligacao(elem.getTabX(),elem.getTabY());
			}
			Jogo.tabuleiro().trajecto().inserir(elem);
		}
	}

	public void mouseExited(MouseEvent m) {

	}

	public void mouseEntered(MouseEvent m) {
	
	}
}