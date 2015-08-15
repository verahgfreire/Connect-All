package tps.tp4.Elemento.Ligacao.LigacaoCanto;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import tps.tp4.Jogo;
import tps.tp4.Elemento.Ligacao.Ligacao;

public abstract class LigacaoCanto extends Ligacao{

	public LigacaoCanto(int x, int y){
		super(x,y);

		this.color = ((Ligacao) Jogo.tabuleiro().trajecto().ultimo()).getColor();
		
		Jogo.tabuleiro().quadricula(x,y).replace(this);
		Jogo.tabuleiro().trajecto().replace(this,x,y);
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
	}
}