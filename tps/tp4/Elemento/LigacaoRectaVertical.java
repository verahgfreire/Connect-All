package tps.tp4.Elemento;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import tps.tp4.*;

public class LigacaoRectaVertical extends LigacaoRecta{

	public LigacaoRectaVertical(int x, int y){
		super(x,y);
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        g.fillRect(getWidth()/3,0,getWidth()/3,getHeight());
	}

	public void desenharTrajecto(){
		super.desenharTrajecto();
	}
}