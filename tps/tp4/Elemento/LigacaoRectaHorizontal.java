package tps.tp4.Elemento;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import tps.tp4.*;

public class LigacaoRectaHorizontal extends LigacaoRecta{

	public LigacaoRectaHorizontal(int x, int y){
		super(x,y);
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        g.fillRect(0,getHeight()/3,getWidth(),getHeight()/3);
	}

	public void desenharTrajecto(){
		super.desenharTrajecto();
	}
}