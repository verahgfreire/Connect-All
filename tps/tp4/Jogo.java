package tps.tp4;

import tps.tp4.Tabuleiro.*;

import javax.swing.*;

public class Jogo {

	protected static Tabuleiro tabActual;
	public static final String ROOTPATH = "/Users/verafreire/Documents/4º SEMESTRE/MoP/Code/MOP/src/";
	
	private static JFrame frame;

	public Jogo() {
		new PainelInicial();
	}

	public static Tabuleiro tabuleiro() {
		return tabActual;
	}
	
	public static void setTabuleiroAct(Tabuleiro t){
		tabActual = t;
	}
	
	public static JFrame frame(){
		return frame;
	}
	
	public static void main(String[] args) {
		new Jogo();
	}
}