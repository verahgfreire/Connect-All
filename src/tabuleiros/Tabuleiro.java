package tps.tp4.tabuleiros;

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
	private int[] xPecas;
	private int[] yPecas;
	private int[] valores;
	private Color[] cores;
	private long startTime;
	private int nMoves;
	private int nivel;
	private JLabel label = new JLabel("teste");

	/*
	 * Construtor da classe tabuleiro, cria o layout e desenha o tabuleiro
	 */
	public Tabuleiro(int dim, String name, int numPuzzle) {

		this.dim = dim;
		this.name = name;
		this.numPuzzle = numPuzzle;
		trajecto = new Trajecto();
		this.xPecas = new int[20];
		this.yPecas = new int[20];
		this.valores = new int[20];
		this.cores = new Color[20];
		this.nMoves = 0;

		this.setLayout(new GridLayout(dim, dim));
		setPreferredSize(new Dimension(500, 500));

		Jogo.setTabuleiroAct(this);
		Jogo.tabuleiro().desenhar();
		frame.getContentPane().add(Jogo.tabuleiro());
		this.startTime = System.nanoTime();
	}

	/*
	 * Retorna o tempo em que inicio o puzzle.
	 */
	public long getStartTime() {
		return this.startTime;
	}

	/*
	 * Retorna o número de puzzles.
	 */
	public int getNumPuzzles() {
		return numPuzzle;
	}

	/*
	 * Retorna o número de movimentos feitos pelo jogador
	 */
	public int getMoves() {
		return nMoves;
	}

	/*
	 * Método que permite contar e avisar o jogador dos movimentos efectuados.
	 */
	public void setMoves(int set) {
		String num = Integer.toString(nMoves);
		// System.out.println(num);
		label.setText("Moves: " + num + " "
				+ MenuPuzzles.recordMovimento((dim * 100) + numPuzzle) + " "
				+ MenuPuzzles.recordTempo((dim * 100) + numPuzzle));
		nMoves = nMoves + set;

	}

	/*
	 * Método que retorna o valor da ultima peca do tabuleiro
	 */
	public int getMaxValue() {
		return valor;
	}

	/*
	 * Retorna a dimensão do tabuleiro.
	 */
	public int getDim() {
		return dim;
	}

	/*
	 * Método que desenha o tabuleiro com os Elementos Vazios e as Peças do
	 * nível seleccionado. É criado também um painel com informação da melhor
	 * pontuação, só se o puzzle tivesse sido completo anteriormente. É criado
	 * também um botão que permite o jogador retornar ao menu dos puzzles.
	 */
	public void desenhar() {

		MenuNivel.frame().setVisible(false);
		MenuNivel.frame().dispose();

		frame = new JFrame();

		frame.setTitle("...:" + dim + "x" + dim + " " + name + ":...");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(150 * dim, 150 * dim));

		BoxLayout boxLayout = new BoxLayout(frame.getContentPane(),
				BoxLayout.Y_AXIS); // top to bottom
		frame.setLayout(boxLayout);
		frame.setMinimumSize(new Dimension(0, 10));

		JPanel info = new JPanel();
		label.setText("Moves: " + 0 + " "
				+ MenuPuzzles.recordMovimento((dim * 100) + numPuzzle) + " "
				+ MenuPuzzles.recordTempo((dim * 100) + numPuzzle));
		label.setFont(new Font("Courier New", Font.BOLD + Font.ITALIC, 14));
		label.setForeground(Color.WHITE);
		info.add(label);
		info.setBackground(Color.black);

		JButton buttonBack = new JButton("Voltar");
		info.add(buttonBack);
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); // you can't see me!
				frame.dispose();

				new MenuNivel();
			}
		});
		frame.getContentPane().add(info);

		for (int y = 0; y < dim; y++) {
			for (int x = 0; x < dim; x++) {
				add(new Quadricula(new ElementoVazio(x, y)));
			}
		}
		desenharPecas(numPuzzle);
		frame.setVisible(true);
	}

	/*
	 * oculta e destroi a frame
	 */
	public void close() {
		frame.setVisible(false); // you can't see me!
		frame.dispose();
	}

	// retorna a quadricula x,y
	public Quadricula quadricula(int x, int y) {
		return (Quadricula) getComponents()[x + y * dim];
	}

	public Trajecto trajecto() {
		return trajecto;
	}

	/*
	 * retorna o numero de quadriculas existentes no tabuleiro
	 */
	public int dimensao() {
		return dim * dim;
	}

	/*
	 * Retorna as coordenas X das peças existentes no tabuleiro
	 */
	public int[] getPecaX() {
		return this.xPecas;
	}

	/*
	 * Retorna as coordenas Y das peças existentes no tabuleiro
	 */
	public int[] getPecaY() {
		return this.yPecas;
	}

	/*
	 * Retorna o valor das peças existentes no tabuleiro
	 */
	public int[] getPecaValores() {
		return this.valores;
	}

	/*
	 * Retorna as cores das peças existentes no tabuleiro
	 */
	public Color[] getPecaCores() {
		return this.cores;
	}

	/*
	 * Retorna o nível do tabuleiro criado.
	 */
	public int getNivel() {
		return nivel;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public abstract Color getColor(int nColor);

	/*
	 * Este metodo vai ler dos ficheiros de texto os valores das pecas e o seu x
	 * e y correspondente. Depois vai criar essas mesmas pecas na posicao dada.
	 */
	public void desenharPecas(int numPuzzle) {

		Scanner leitor = null;

		try {

			String folder = "" + dim + dim + name.replace(" ", "");
			String path = Jogo.ROOTPATH + "tps/tp4/levels/" + folder + "/"
					+ folder + "_";
			if (numPuzzle < 10)
				path += "0";
			nivel = 100 * dim;
			nivel = nivel + numPuzzle;
			System.out.println("nivel: " + nivel);
			leitor = new Scanner(new File(path + numPuzzle + ".txt"));
			leitor.next();
			// para separar os numeros dos ;
			int dimension = Integer.parseInt(leitor.next().substring(0, 1));
			if (dimension != dim) {
				System.out.println("Dimension != dim");
			}

			valor = 1;
			while (leitor.hasNext()) {
				leitor.next();
				int xPeca = leitor.nextInt();
				int yPeca = Integer.parseInt(leitor.next().substring(0, 1));

				new Peca(valor, getColor(valor), xPeca, yPeca);
				xPecas[valor - 1] = xPeca;
				yPecas[valor - 1] = yPeca;
				valores[valor - 1] = valor;
				cores[valor - 1] = getColor(valor);

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

		/*
		 * retorna o elemento da quadricula corrente
		 */
		public Elemento getElem() {
			return elem;
		}

		/*
		 * Mouse listener da quadricula, que define um conjunto de tarefas para
		 * cada um dos seus estados. Quando a pressionamos, altera o trajecto;
		 * quando largamos informa actualiza a informacao de que ja nao esta ser
		 * pressionado; e quando e detectado que entramos no espaco da
		 * quadricula corrente e estiver a ser pressionado, incrementa o
		 * contador pressed e altera trajecto
		 */
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

		/*
		 * substitui o elemento da quadricula sem remover o mouse listener
		 */
		public void replace(Elemento e) {
			remove(elem);
			add(e);
			revalidate();
			repaint();
			elem = e;
		}
	}
}