package tps.tp4.Elemento;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import tps.tp4.*;

public class Ligacao extends Elemento{

	private Color color;

	public Ligacao(int x, int y){
		super(x,y);
		this.color = Jogo.tabuleiro().trajecto().getColor();
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0,getHeight()/3,getWidth(),getHeight()/3);
	}
}