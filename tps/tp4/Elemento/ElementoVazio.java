package tps.tp4.Elemento;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import tps.tp4.*;

public class ElementoVazio extends Elemento{

	public ElementoVazio(int x, int y){
		super(x,y);	
		Jogo.tabuleiro().quadricula(x,y).adicionar(this);
		
	}

	//public void desenhar(){
		
	//}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g); 
	}
}