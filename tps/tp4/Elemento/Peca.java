package tps.tp4.Elemento;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class Peca extends Elemento{

	private int num;

	public Peca(int num){
		super();
		this.num = num;
		setText("" + num);
		setForeground(Color.WHITE);
		setFont(new Font("Courier New", Font.BOLD + Font.ITALIC, 40));
		setHorizontalAlignment(SwingConstants.CENTER);
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.drawOval(getWidth()/2 - 40, getHeight()/2 -40, 80, 80);
        //g.setStroke(10);
	}
}