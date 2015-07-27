package tps.tp4.Tabuleiro;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import tps.tp4.Elemento.*;

public class Quadricula extends JPanel{

	private int x;
	private int y;
	private Elemento elemento;

	public Quadricula(int x, int y){
		this.x = x;
		this.y = y;

		setLayout(new CardLayout());

		Elemento e = new ElementoVazio();
		elemento = e;
		add(elemento);

		addMouseListener(new QuadriculaListener(this));
	}

	public void desenhar(Elemento e){
		remove(elemento);
		elemento = e;
		add(elemento);
		revalidate();
		repaint();
	}

	public int getTabX() {
		return x;
	}
	public int getTabY() {
		return y;
	}

    @Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g); 
	}
}