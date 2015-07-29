package tps.tp4.Elemento;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import tps.tp4.*;
import tps.tp4.Elemento.Ligacao.*;
import tps.tp4.Elemento.Ligacao.LigacaoRecta.*;

public class ElementoVazio extends Elemento{

	public ElementoVazio(int x, int y){
		super(x,y);	
		pressed = false;
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g); 
	}

	public void alterarTrajecto(){	
		if(podeEntrar(Jogo.tabuleiro().trajecto().getValue())){

			Elemento ultimo = Jogo.tabuleiro().trajecto().ultimo();

			if(ultimo.getTabX() == x)
				new LigacaoRectaVertical(x,y, ultimo.getTabY()-y);
			else if(ultimo.getTabY() == y)
				new LigacaoRectaHorizontal(x,y,ultimo.getTabX()-x);
		}
	}

	public boolean podeEntrar(int currentValue){
		if(currentValue==0){ // obrigatório comecar numa peça
			return false;
		}
		return super.podeEntrar(currentValue);
	}
}