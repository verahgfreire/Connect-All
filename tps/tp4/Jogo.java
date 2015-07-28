package tps.tp4;

import tps.tp4.Tabuleiro.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Jogo{

	private static Tabuleiro tabActual;
	public static final String ROOTPATH = "/Users/verafreire/Desktop/Projecto/Connect-All/";


	public Jogo(){

	}

	public static Tabuleiro tabuleiro(){
		return tabActual;
	}

	public static void main(String args[]){
		
		JFrame frame = new JFrame("..:Connect-All:..");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tabActual = new Tabuleiro();
        tabActual.criarTabuleiro();
        
        frame.getContentPane().add(tabActual);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
	}
}