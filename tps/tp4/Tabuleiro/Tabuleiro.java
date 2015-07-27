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

		dim = 4;
		name = "Easy";
		this.setLayout(new GridLayout(4,4));
		setPreferredSize(new Dimension(500, 500));

		for(int y=0; y<4; y++){
			for(int x=0; x<4; x++){
				add(new Quadricula(x,y));
			}
		}
		desenharPecas(6);
	}

	public Quadricula quadricula(int x, int y){
		return (Quadricula) getComponents()[x+y*dim];
	}

	public Trajecto trajecto(){
		return trajecto;
	}

	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public enum CorDasPecas {
		one(197, 40, 4), two(174, 197, 40), three(40, 197, 80), four(40, 131, 197);

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
			String path = "/Users/verafreire/Desktop/Projecto/Connect-All/tps/tp4/levels/" + folder + "/" + folder + "_";
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

				//criar peca
				quadricula(xPeca,yPeca).desenhar(new Peca(valor));

				valor++;
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}

		leitor.close();
	}

	public static void main(String args[]){
		
		JFrame frame = new JFrame("Tabuleiro");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Tabuleiro t = new Tabuleiro();
        
        frame.getContentPane().add(t);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
	}
}