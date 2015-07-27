package tps.tp4.Elemento;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ElementoVazio extends Elemento{

	public ElementoVazio(){
		super();	
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g); 
	}
}