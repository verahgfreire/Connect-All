package tps.tp4.Elemento;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import tps.tp4.*;

public class ElementoVazio extends Elemento{

	public ElementoVazio(int x, int y){
		super(x,y);	
		pressed = false;
		Jogo.tabuleiro().quadricula(x,y).adicionar(this);
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g); 
	}

	public void desenharTrajecto(){	
		if(podeEntrar(Jogo.tabuleiro().trajecto().getValue())){
			
			super.corrigirCantos();

			if(Jogo.tabuleiro().trajecto().ultimo().getTabX() == x)
				new LigacaoRectaVertical(x,y);
			else if(Jogo.tabuleiro().trajecto().ultimo().getTabY() == y)
				new LigacaoRectaHorizontal(x,y);
		}
	}
}