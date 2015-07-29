package tps.tp4.Elemento.Ligacao.LigacaoCanto;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import tps.tp4.*;
import tps.tp4.Elemento.Ligacao.*;

public abstract class LigacaoCanto extends Ligacao{

	public LigacaoCanto(int x, int y){
		super(x,y);
		Jogo.tabuleiro().trajecto().replace(this,x,y);
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
	}
}