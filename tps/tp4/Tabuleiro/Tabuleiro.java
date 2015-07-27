package tps.tp4.Tabuleiro;

import tps.tp4.*;
import tps.tp4.Elemento.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tabuleiro extends JPanel{

	private int dimensao;
	private Trajecto trajecto;

	public Tabuleiro(){

		dimensao = 4;
		this.setLayout(new GridLayout(4,4));
		setPreferredSize(new Dimension(500, 500));

		for(int y=0; y<4; y++){
			for(int x=0; x<4; x++){
				add(new Quadricula(x,y));
			}
		}
	}

	public Quadricula quadricula(int x, int y){
		return (Quadricula) getComponents()[x+y*dimensao];
	}

	public Trajecto trajecto(){
		return trajecto;
	}

	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

	public static void main(String args[]){
		
		JFrame frame = new JFrame("Tabuleiro");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Tabuleiro t = new Tabuleiro();
        
        frame.getContentPane().add(t);
        frame.pack();
        frame.setVisible(true);

        t.quadricula(2,1).desenhar(new Peca(1));

	}
}