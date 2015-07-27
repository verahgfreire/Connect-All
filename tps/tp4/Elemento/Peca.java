package tps.tp4.Elemento;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.border.LineBorder;

public class Peca extends Elemento{

	private int num;

	public Peca(int num){
		super();
		this.num = num;
		setText("" + num);
		setForeground(Color.WHITE);
		setFont(new Font("Courier New", Font.BOLD + Font.ITALIC, 40));

	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g); 
	}
}