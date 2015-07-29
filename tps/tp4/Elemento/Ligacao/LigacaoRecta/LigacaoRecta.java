package tps.tp4.Elemento.Ligacao.LigacaoRecta;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import tps.tp4.Jogo;
import tps.tp4.Elemento.Ligacao.Ligacao;

public abstract class LigacaoRecta extends Ligacao{

	protected int origem;

	public LigacaoRecta(int x, int y, int origem){
		super(x,y);
		this.origem = origem;
		Jogo.tabuleiro().trajecto().inserir(this);
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
	}
}