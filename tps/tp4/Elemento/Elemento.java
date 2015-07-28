package tps.tp4.Elemento;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import tps.tp4.Jogo;

public abstract class Elemento extends JLabel{
	
	protected int x;
	protected int y;
	
	public Elemento(int x,int y){
		super();
		this.x=x;
		this.y=y;
		setBorder(new LineBorder(Color.GRAY, 1));
		setOpaque(true);
		setBackground(Color.BLACK);
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g); 
	}

	public int getTabX() {
		return x;
	}
	public int getTabY() {
		return y;
	}

	public boolean podeEntrar(int currentValue){
		if(currentValue==0){ // obrigatório comecar numa peça
			return false;
		}
		if(Jogo.tabuleiro().trajecto().contem(this)){
			return false;
		}
		if(Math.abs(Jogo.tabuleiro().trajecto().ultimo().getTabX()-x)>1){
			return false;
		}
		if(Math.abs(Jogo.tabuleiro().trajecto().ultimo().getTabY()-y)>1){
			return false;
		}
		if(Math.abs(Jogo.tabuleiro().trajecto().ultimo().getTabX()-x)==1){
			if(Math.abs(Jogo.tabuleiro().trajecto().ultimo().getTabY()-y)!=0){
				return false;
			}
		}
		if(Math.abs(Jogo.tabuleiro().trajecto().ultimo().getTabY()-y)==1){
			if(Math.abs(Jogo.tabuleiro().trajecto().ultimo().getTabX()-x)!=0){
				return false;
			}
		}
		return true;
	}
}