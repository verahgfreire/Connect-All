package tps.tp4.Tabuleiro;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import tps.tp4.Elemento.*;
import tps.tp4.Trajecto;

public class Quadricula extends JPanel{

	private int x;
	private int y;
	private Elemento elem;

	public Quadricula(Trajecto trajecto,int x, int y){
		this.x = x;
		this.y = y;

		setLayout(new CardLayout());

		Elemento e = new ElementoVazio(x,y);
		elem = e;
		add(elem);

		addMouseListener(new QuadriculaListener(this,trajecto));
	}

	public void desenhar(Elemento e){
		
		if(e instanceof Ligacao && elem instanceof Peca)
			return;

		remove(elem);
		elem = e;
		add(elem);
		revalidate();
		repaint();
	}

	public int getTabX() {
		return x;
	}
	public int getTabY() {
		return y;
	}

	public Elemento elemento(){
		return elem;
	}

    @Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g); 
	}
}