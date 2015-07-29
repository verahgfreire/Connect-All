package tps.tp4.Elemento.Ligacao.LigacaoRecta;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import tps.tp4.Jogo;
import tps.tp4.Elemento.Ligacao.Ligacao;
import tps.tp4.Elemento.Ligacao.LigacaoCanto.*;

public class LigacaoRectaHorizontal extends LigacaoRecta{

	public LigacaoRectaHorizontal(int x, int y, int origem){
		super(x,y, origem);
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        g.fillRect(0,getHeight()/3,getWidth(),getHeight()/3);
	}

	@Override
	public void corrigirCanto(int newX, int newY){
		if(origem<0){
			if(y<newY)
				new LigacaoCantoNE(x,y);
			if(y>newY)
				new LigacaoCantoSE(x,y);	
		}
		if(origem>0){
			if(y<newY)
				new LigacaoCantoNO(x,y);
			if(y>newY)
				new LigacaoCantoSO(x,y);	
		}
	}
}