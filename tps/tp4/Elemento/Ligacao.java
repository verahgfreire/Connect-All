package tps.tp4.Elemento;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.border.LineBorder;

public class Ligacao extends Elemento{

	private Color color;

	public Ligacao(Color color){
		super();
		this.color = color;
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0,getHeight()/3,getWidth(),getHeight()/3);
	}
}