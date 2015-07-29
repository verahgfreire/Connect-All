package tps.tp4.Elemento;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import tps.tp4.*;

public class LigacaoCantoSO extends LigacaoCanto{

	public LigacaoCantoSO(int x, int y){
		super(x,y);
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        g.fillRect(getWidth()/3,0,getWidth()-getWidth()/3,getHeight()-getHeight()/3);
        g.setColor(Color.BLACK);
        g.fillRect(getWidth()-getWidth()/3,0,getWidth()/3,getHeight()/3);
	}

	public void desenharTrajecto(){
		super.desenharTrajecto();
	}
}