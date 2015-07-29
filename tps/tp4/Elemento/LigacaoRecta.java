package tps.tp4.Elemento;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import tps.tp4.*;

public abstract class LigacaoRecta extends Ligacao{

	public LigacaoRecta(int x, int y){
		super(x,y);
		Jogo.tabuleiro().trajecto().inserir(this);
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
	}

	public void desenharTrajecto(){
		super.desenharTrajecto();
	}
}