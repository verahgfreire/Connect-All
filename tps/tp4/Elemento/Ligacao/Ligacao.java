package tps.tp4.Elemento.Ligacao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import tps.tp4.Jogo;
import tps.tp4.Elemento.Elemento;

public class Ligacao extends Elemento{

	protected Color color;

	public Ligacao(int x, int y){
		super(x,y);
		Jogo.tabuleiro().quadricula(x,y).replace(this);
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        g.setColor(color);
	}

	public boolean podeEntrar(int currentValue){
		return false;
	}
	public Color getColor(){
		return color;
	}

	public void alterarTrajecto(){	
		//eliminarTrajecto
	}
}