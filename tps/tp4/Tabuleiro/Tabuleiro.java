package tps.tp4.Tabuleiro;

import tps.tp4.*;
import tps.tp4.Elemento.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.File;
import java.util.Scanner;

public abstract class Tabuleiro extends JPanel {

	private static final long serialVersionUID = 1L;
	private int dim;
	private Trajecto trajecto;
	private String name;
	private int numPuzzle;
	private static JFrame frame;
	private int valor;

	public Tabuleiro(int _dim, String _name, int _numPuzzle) {

		dim = _dim;
		name = _name;
		numPuzzle = _numPuzzle;
		trajecto = new Trajecto();

		this.setLayout(new GridLayout(dim, dim));
		setPreferredSize(new Dimension(500, 500));

		Jogo.setTabuleiroAct(this);
		Jogo.tabuleiro().desenhar();
		frame.getContentPane().add(Jogo.tabuleiro());
	}
	
	public int getMaxValue(){
		return valor;
	}

	public void desenhar() {

		MenuNivel.frame().setVisible(false);
		MenuNivel.frame().dispose();

		frame = new JFrame();

		frame.setTitle("...:" + dim + "x" + dim + " " + name + ":...");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// frame.setLayout(new GridLayout(1, 2));
		setPreferredSize(new Dimension(150 * dim, 150 * dim));

		for (int y = 0; y < dim; y++) {
			for (int x = 0; x < dim; x++) {
				add(new Quadricula(new ElementoVazio(x, y)));
			}
		}
		desenharPecas(numPuzzle);
		frame.setVisible(true);
	}

	// retorna a quadricula x,y
	public Quadricula quadricula(int x, int y) {
		return (Quadricula) getComponents()[x + y * dim];
	}

	public Trajecto trajecto() {
		return trajecto;
	}

	public int dimensao() {
		return dim*dim;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public abstract Color getColor(int nColor);

	public void desenharPecas(int numPuzzle) {

		Scanner leitor = null;

		try {

			String folder = "" + dim + dim + name.replace(" ", "");
			String path = Jogo.ROOTPATH + "tps/tp4/levels/" + folder + "/"
					+ folder + "_";
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

			valor = 1;
			while (leitor.hasNext()) {
				leitor.next();
				int xPeca = leitor.nextInt();
				int yPeca = Integer.parseInt(leitor.next().substring(0, 1));

				new Peca(valor, getColor(valor), xPeca, yPeca);

				valor++;
			}
			valor--;

		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}

		leitor.close();
	}

	/**
	 * Class Quadricula
	 * 
	 * @author verafreire
	 *
	 */
	public class Quadricula extends JPanel {

		private static final long serialVersionUID = 1L;
		Elemento elem = null;

		public Elemento getElem() {
			return elem;
		}

		public Quadricula(Elemento e) {
			setLayout(new CardLayout());
			add(e);
			elem = e;
			// Implementação anónima da interface MouseListener()
			addMouseListener(new MouseListener() {

				// getSource() retorna Component onde MouseListener foi
				// adicionado
				public void mouseReleased(MouseEvent m) {
					((Elemento) ((Quadricula) m.getSource()).getElem())
							.clearPressed();
				}

				public void mousePressed(MouseEvent m) {
					((Elemento) ((Quadricula) m.getSource()).getElem())
							.incPressed();
					((Elemento) ((Quadricula) m.getSource()).getElem())
							.alterarTrajecto();
				}

				public void mouseClicked(MouseEvent m) {
				}

				public void mouseExited(MouseEvent m) {
				}

				public void mouseEntered(MouseEvent m) {

					if (((Elemento) ((Quadricula) m.getSource()).getElem())
							.pressed() > 0) {
						((Elemento) ((Quadricula) m.getSource()).getElem())
								.incPressed();
						((Elemento) ((Quadricula) m.getSource()).getElem())
								.alterarTrajecto();
					}
				}
			});
		}

		public void replace(Elemento e) {
			remove(elem);
			add(e);
			revalidate();
			repaint();
			elem = e;
		}
	}
}