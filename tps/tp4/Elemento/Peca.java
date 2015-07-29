package tps.tp4.Elemento;

import tps.tp4.Tabuleiro.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

import tps.tp4.Jogo;

public class Peca extends Elemento{

	private int num;
	private Color cor;

	public Peca(int num, Color cor, int x, int y){
		super(x,y);

		this.num = num;
		this.cor = cor;
		Jogo.tabuleiro().quadricula(x,y).replace(this);
	}

	public Color color(){
		return cor;
	}
	public int valor(){
		return num;
	}

	public void desenharTrajecto(){
		if(podeEntrar(Jogo.tabuleiro().trajecto().getValue())){
			super.corrigirCantos();
			Jogo.tabuleiro().trajecto().inserir(this);
		}
	}

	@Override
	public boolean podeEntrar(int currentValue){
		if(currentValue==0 && num==1){ // obrigatório comecar na peca 1
			return true;
		}
		if(currentValue != num - 1){
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

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        g.setColor(cor);
        g.fillOval(getWidth()/2 - 40, getHeight()/2 -40, 80, 80);
        g.setColor(Color.BLACK);
        g.fillOval(getWidth()/2 - 25, getHeight()/2 -25, 50, 50);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", Font.BOLD + Font.ITALIC, 40));
        g.drawString("" + num, getWidth()/2-13, getHeight()/2+12);
	}
}