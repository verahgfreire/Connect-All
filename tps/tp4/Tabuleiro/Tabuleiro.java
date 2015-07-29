package tps.tp4.Tabuleiro;

import tps.tp4.*;
import tps.tp4.Elemento.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class Tabuleiro extends JPanel{

	private int dim;
	private Trajecto trajecto;
	private String name;

	public Tabuleiro(){    

		dim = 9;
		name = "Very Hard";
		trajecto = new Trajecto();

		this.setLayout(new GridLayout(dim,dim));
		setPreferredSize(new Dimension(500, 500));

	}
	public void desenhar(){
		for(int y=0; y<dim; y++){
			for(int x=0; x<dim; x++){
				add(new Quadricula(new ElementoVazio(x,y)));
			}
		}
		desenharPecas(6);
	}

	public Quadricula quadricula(int x, int y){
		return (Quadricula)getComponents()[x+y*dim];
	}

	public Trajecto trajecto(){
		return trajecto;
	}
	public int dimensao(){
		return dim;
	}

	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    /*public enum CorDasPecas {
		one(197, 40, 4), two(174, 197, 40), three(40, 197, 80), four(40, 131, 197);

		private int r;
		private int g;
		private int b;

		private CorDasPecas(int r, int g, int b) {
			this.r = r;
			this.g = g;
			this.b = b;
		}
	}*/
	public enum CorDasPecas {

		one(197, 40, 4), two(197, 87, 40), three(197, 127, 40), four(197, 170,
				40), five(174, 197, 40), six(131, 197, 40), seven(90, 197, 40), eight(
				44, 197, 40), nine(40, 197, 80), ten(40, 197, 121), eleven(40,
				197, 163), twelve(40, 178, 197), thirteen(40, 131, 197), fourteen(
				40, 90, 197), fifteen(40, 44, 197), sixteen(80, 40, 197), seventeen(
				121, 40, 197), eighteen(163, 40, 197), nineteen(197, 40, 182), twenty(
				197, 40, 138);

		private int r;
		private int g;
		private int b;

		private CorDasPecas(int r, int g, int b) {
			this.r = r;
			this.g = g;
			this.b = b;
		}
	}

	public Color getColor(int nColor){
		CorDasPecas[] coresPecas = CorDasPecas.values();
		return new Color(coresPecas[nColor - 1].r, coresPecas[nColor - 1].g,coresPecas[nColor - 1].b);
	}

	public void desenharPecas(int numPuzzle) {

		Scanner leitor = null;

		try {

			String folder = "" + dim + dim + name.replace(" ", "");
			String path = Jogo.ROOTPATH+"tps/tp4/levels/" + folder + "/" + folder + "_";
			if (numPuzzle < 10)
				path += "0";
			leitor = new Scanner(new File(path + numPuzzle + ".txt"));
			leitor.next();
			// para separar os numeros dos ;
			int dimension = Integer.parseInt(leitor.next().substring(0, 1));
			if (dimension != dim) {
				// throw new Exception("Ficheiro mal formado!");
				System.out.println("Dimension != dim");
			}

			int valor = 1;
			while (leitor.hasNext()) {
				leitor.next();
				int xPeca = leitor.nextInt();
				int yPeca = Integer.parseInt(leitor.next().substring(0, 1));

				new Peca(valor,getColor(valor),xPeca,yPeca);

				valor++;
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}

		leitor.close();
	}

	public class Quadricula extends JPanel{

		Elemento elem = null;

		public Quadricula(Elemento e){
			setLayout(new CardLayout());
			add(e);
			elem=e;
		}
		public void replace(Elemento e){
			remove(elem);
			add(e);
			elem=e;
		}
	}
}