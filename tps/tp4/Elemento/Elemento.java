package tps.tp4.Elemento;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public abstract class Elemento extends JLabel{

	public Elemento(){
		super();
		setBorder(new LineBorder(Color.GRAY, 1));
		setOpaque(true);
		setBackground(Color.BLACK);
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g); 
	}
}