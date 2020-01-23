package tps.tp4;

import tps.tp4.tabuleiros.*;

import javax.swing.*;

public class Jogo {

	protected static Tabuleiro tabActual;
	public static final String ROOTPATH = "/Users/verafreire/Documents/4º SEMESTRE/MoP/Code/MOP/src/";
	
	private static JFrame frame;

	public Jogo() {
		new PainelInicial();
	}

	/*
	 * Devolve o tabuleiro actual
	 */
	public static Tabuleiro tabuleiro() {
		return tabActual;
	}
	
	/*
	 * Guarda o tabuleiro actual
	 */
	public static void setTabuleiroAct(Tabuleiro t){
		tabActual = t;
	}
	
	/*
	 * Devolve a frame actual
	 */
	public static JFrame frame(){
		return frame;
	}
	
	public static void main(String[] args) {
		new Jogo();
	}
}