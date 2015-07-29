package tps.tp4.Elemento.Ligacao.LigacaoCanto;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import tps.tp4.Jogo;
import tps.tp4.Elemento.Ligacao.Ligacao;

public class LigacaoCantoNO extends LigacaoCanto{

	public LigacaoCantoNO(int x, int y){
		super(x,y);
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        g.fillRect(getWidth()/3,getHeight()/3,getWidth()-getWidth()/3,getHeight()-getHeight()/3);
        g.setColor(Color.BLACK);
        g.fillRect(getWidth()-getWidth()/3,getHeight()-getHeight()/3,getWidth()/3,getHeight()/3);
	}
}