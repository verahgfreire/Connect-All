package tps.tp4.Elemento.Ligacao.LigacaoRecta;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import tps.tp4.*;
import tps.tp4.Elemento.Ligacao.LigacaoCanto.*;

public class LigacaoRectaVertical extends LigacaoRecta{

	public LigacaoRectaVertical(int x, int y, int origem){
		super(x,y,origem);
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        g.fillRect(getWidth()/3,0,getWidth()/3,getHeight());
	}

	@Override
	public void corrigirCanto(int newX, int newY){
		if(origem<0){
			if(x<newX)
				new LigacaoCantoSO(x,y);
			if(x>newX)
				new LigacaoCantoSE(x,y);	
		}
		if(origem>0){
			if(x<newX)
				new LigacaoCantoNO(x,y);
			if(x>newX)
				new LigacaoCantoNE(x,y);	
		}
	}
}