package tps.tp4.Tabuleiro;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import tps.tp4.Elemento.*;
import tps.tp4.Trajecto;

public class Quadricula extends JPanel{

	Elemento elem = null;

	public Quadricula(){

		setLayout(new CardLayout());
	}

	public void replace(Elemento e){
		remove(elem);
		add(e);
		elem=e;
	}
	public void adicionar(Elemento e){
		add(e);
		elem=e;
	}

    @Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g); 
	}
}