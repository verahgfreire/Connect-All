package tps.tp4.Elemento;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class Peca extends Elemento{

	private int num;

	public Peca(int num){
		super();
		this.num = num;
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        //g.drawOval(getWidth()/2 - 40, getHeight()/2 -40, 80, 80);
        g.fillOval(getWidth()/2 - 40, getHeight()/2 -40, 80, 80);
        g.setColor(Color.BLACK);
        g.fillOval(getWidth()/2 - 25, getHeight()/2 -25, 50, 50);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", Font.BOLD + Font.ITALIC, 40));
        g.drawString("" + num, getWidth()/2-13, getHeight()/2+12);
	}
}