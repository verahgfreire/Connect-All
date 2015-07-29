package tps.tp4.Elemento.Ligacao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import tps.tp4.*;
import tps.tp4.Elemento.*;
import tps.tp4.Elemento.Ligacao.LigacaoCanto.*;
import tps.tp4.Elemento.Ligacao.LigacaoRecta.*;

public class Ligacao extends Elemento{

	private Color color;

	public Ligacao(int x, int y){
		super(x,y);
		
		Jogo.tabuleiro().quadricula(x,y).replace(this);
		this.color = Jogo.tabuleiro().trajecto().getColor();
		Jogo.tabuleiro().quadricula(x,y).replace(this);
		
		Jogo.tabuleiro().trajecto().inserir(this);
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        g.setColor(color);
	}

	public boolean podeEntrar(int currentValue){
		return false;
	}

	public void alterarTrajecto(){	
		//eliminarTrajecto
	}
}