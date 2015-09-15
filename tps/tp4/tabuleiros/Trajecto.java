package tps.tp4.tabuleiros;

import tps.tp4.Jogo;
import tps.tp4.Elemento.*;
import tps.tp4.MenuPuzzles;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Trajecto {

	private static JFrame frame;
	private ArrayList<Elemento> percurso;
	private Color corActual;
	private int valorActual;
	private Scanner inputStream;

	/*
	 * Construtor da classe trajecto, inicializa o arraylist
	 */
	public Trajecto() {
		percurso = new ArrayList<Elemento>();
		corActual = null;
		valorActual = 0;
	}

	/*
	 * Retorna a cor actual, ou seja, do elemento do trajecto
	 */
	public Color getColor() {
		return corActual;
	}

	/*
	 * Actualiza a cor actual do trajecto
	 */
	public void setColor(Color c) {
		corActual = c;
	}

	/*
	 * Retorna o valor actual ou seja, o valor da ultima peca por onde passamos
	 */
	public int getValue() {
		return valorActual;
	}

	/*
	 * Actualiza o valor actual
	 */
	public void setValue(int v) {
		valorActual = v;
	}

	public int percursoSize() {
		return percurso.size();
	}

	/*
	 * Este metodo insere um elemento no arraylist, ou seja, se ele ja la
	 * estiver, faz replace, actualizando, caso contrario, insere-o. Alem disso,
	 * tambem trata do fim do puzzle
	 */
	public void inserir(Elemento el) {
		if (el instanceof Peca) {
			valorActual = ((Peca) el).valor();
			corActual = ((Peca) el).color();
		}
		if (ultimo() != null)
			ultimo().corrigirCanto(el.getTabX(), el.getTabY());

		// ja existe no trajecto, faz-se replace
		if (obter(el.getTabX(), el.getTabY()) > -1) {
			percurso.set(obter(el.getTabX(), el.getTabY()), el);
		} else {
			percurso.add(el);
		}

		/*
		 * Fim do puzzle. É contado o tempo de duração do nível. Fica registado
		 * no fichero de texto, caso haja uma pontuação melhor ou se o nível é
		 * completo pela primeira vez. É apresentado um menu que permite
		 * escolher repetir o nivel ou avançar.
		 */
		if (Jogo.tabuleiro().trajecto().percursoSize() == Jogo.tabuleiro()
				.dimensao()) {
			long endTime = System.nanoTime();
			float duration = (float) ((endTime - Jogo.tabuleiro()
					.getStartTime()) / 1000000000.0);
			saveToFile(Jogo.tabuleiro().getNivel(), duration, Jogo.tabuleiro()
					.getMoves());
			System.out.println("Parabens!");
			menu(Jogo.tabuleiro().getNivel(), Jogo.tabuleiro().getNumPuzzles(),
					Jogo.tabuleiro().getMoves(), duration);
		}
	}

	/*
	 * Menu criado para permitir ao jogador escolher repetir o puzzle, avançar
	 * para o seguinte, repetir o anterior ou ir para o menu dos puzzles. É
	 * criado um painel com as informações da pontuação do puzzle realizado e da
	 * sua melhor pontuação.
	 */
	public void menu(int nivel, int index, int moves, float time) {
		int MenuNivel = nivel / 100;
		// create a JFrame
		frame = new JFrame();
		// set title
		frame.setTitle("...:Connect-All:...");
		// set size and location
		frame.setSize(500, 300);
		// to center a frame
		frame.setLocationRelativeTo(null);
		// set default close operation
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		frame.setLayout(bl);

		// set content pane background color
		frame.getContentPane().setBackground(Color.black);

		JLabel label = new JLabel("Menu Puzzles");
		label.setOpaque(true);
		label.setBackground(Color.black);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(label);

		GridLayout gl = new GridLayout(4, 1);

		JPanel panel = new JPanel();
		panel.setLayout(gl);
		panel.setBackground(Color.BLACK);

		JButton[] botoes = new JButton[4];

		botoes[0] = new JButton("Repetir nivel?");
		panel.add(botoes[0]);
		botoes[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jogo.tabuleiro().close();
				frame.setVisible(false);
				frame.dispose();
				if (MenuNivel == 4)
					new TabuleiroDim4(index);
				if (MenuNivel == 5)
					new TabuleiroDim5(index);
				if (MenuNivel == 6)
					new TabuleiroDim6(index);
				if (MenuNivel == 7)
					new TabuleiroDim7(index);
				if (MenuNivel == 8)
					new TabuleiroDim8(index);
				if (MenuNivel == 9)
					new TabuleiroDim9(index);
			}
		});

		if (index != 6) {
			botoes[1] = new JButton("Nivel seguinte");
			panel.add(botoes[1]);
			botoes[1].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Jogo.tabuleiro().close();
					frame.setVisible(false);
					frame.dispose();
					if (MenuNivel == 4)
						new TabuleiroDim4(index + 1);
					if (MenuNivel == 5)
						new TabuleiroDim5(index + 1);
					if (MenuNivel == 6)
						new TabuleiroDim6(index + 1);
					if (MenuNivel == 7)
						new TabuleiroDim7(index + 1);
					if (MenuNivel == 8)
						new TabuleiroDim8(index + 1);
					if (MenuNivel == 9)
						new TabuleiroDim9(index + 1);
				}
			});
		}
		if (index != 1) {
			botoes[2] = new JButton("Nivel anterior");
			panel.add(botoes[2]);
			botoes[2].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Jogo.tabuleiro().close();
					frame.setVisible(false);
					frame.dispose();
					if (MenuNivel == 4)
						new TabuleiroDim4(index - 1);
					if (MenuNivel == 5)
						new TabuleiroDim5(index - 1);
					if (MenuNivel == 6)
						new TabuleiroDim6(index - 1);
					if (MenuNivel == 7)
						new TabuleiroDim7(index - 1);
					if (MenuNivel == 8)
						new TabuleiroDim8(index - 1);
					if (MenuNivel == 9)
						new TabuleiroDim9(index - 1);
				}
			});
		}
		botoes[3] = new JButton("Menu niveis");
		panel.add(botoes[3]);
		botoes[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jogo.tabuleiro().close();
				frame.setVisible(false);
				frame.dispose();
				new MenuPuzzles(MenuNivel);
			}
		});

		BoxLayout boxLayout = new BoxLayout(frame.getContentPane(),
				BoxLayout.Y_AXIS); // top to bottom
		frame.setLayout(boxLayout);
		frame.setMinimumSize(new Dimension(0, 5));

		JPanel info = new JPanel();
		label.setText("<html><br>" + "Parabens!<br>" + "Movimento: " + moves
				+ "<br>Tempo: " + String.format("%.2f", time) + "<br>"
				+ MenuPuzzles.recordMovimento((MenuNivel * 100) + index)
				+ "<br>" + MenuPuzzles.recordTempo((MenuNivel * 100) + index));
		label.setFont(new Font("Courier New", Font.BOLD + Font.ITALIC, 16));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		info.add(label);
		info.setBackground(Color.black);
		frame.getContentPane().add(info);

		frame.add(panel);
		frame.setVisible(true);

	}

	/*
	 * Retorna o elemento correspondente ao x e y dado como argumento
	 */
	public int obter(int x, int y) {
		for (int i = 0; i < percurso.size(); i++)
			if (percurso.get(i).getTabX() == x
					&& percurso.get(i).getTabY() == y)
				return i;
		return -1;
	}

	/*
	 * Retorna o ultimo elemento do arraylist
	 */
	public Elemento ultimo() {
		if (percurso.size() < 1) {
			return null;
		}
		return percurso.get(percurso.size() - 1);
	}

	/*
	 * Verifica se contem ou nao determinado argumento
	 */
	public boolean contem(Elemento e) {
		return percurso.contains(e);
	}

	/*
	 * Elimina elementos do arraylist e do tabuleiro
	 */
	public void eliminar(Elemento el) {
		int ind = percurso.indexOf(el);
		if (ind == 0)
			ind = 1;
		if (ind == -1) // não deixar eliminar elementos que não estão no
						// trajecto
			return;

		ListIterator<Elemento> it = percurso.listIterator(ind);
		while (it.hasNext()) {

			Elemento elAct = it.next();
			if (!(elAct instanceof Peca)) {
				Elemento vazio = new ElementoVazio(elAct.getTabX(),
						elAct.getTabY());
				Jogo.tabuleiro().quadricula(elAct.getTabX(), elAct.getTabY())
						.replace(vazio);
			} else {
				valorActual--;
				corActual = Jogo.tabuleiro().getColor(valorActual);
			}
			it.remove();
		}
	}

	/*
	 * Metodo que permite salvar o jogo. É criado um ficheiro de texto que
	 * permite guardar o puzzle realizado, a sua pontuação em termos de tempo e
	 * movimentos. Caso o ficheiro já exista, é guardado noutra linha de texto o
	 * nivel completo e as suas pontuações. Se o nível já tiver completo mas a
	 * sua respetiva pontuação for melhor, a pontuação registada é substituida.
	 * Caso contrário, nada é registado.
	 */
	public void saveToFile(int nivel, float duracao, int nMoves) {

		String memoria_str = Jogo.ROOTPATH + "tps/tp4/memoria.txt";
		PrintWriter memoria = null;
		File f = new File(memoria_str);

		if (f.exists()) {
			try {
				memoria = new PrintWriter(new BufferedWriter(new FileWriter(
						memoria_str, true)));
				inputStream = new Scanner(new File(memoria_str));
				while (inputStream.hasNext()) {
					int inputNivel = inputStream.nextInt();
					// System.out.println(inputNivel);
					String aux = inputStream.next();
					float inputDuracao = Float.parseFloat(aux);
					// System.out.println(inputDuracao);
					int inputMoves = inputStream.nextInt();
					// System.out.println(inputMoves);
					if (inputNivel == nivel && nMoves < inputMoves) {
						Path path = Paths.get(Jogo.ROOTPATH
								+ "tps/tp4/memoria.txt");
						Charset charset = StandardCharsets.UTF_8;
						String content = new String(Files.readAllBytes(path),
								charset);
						content = content.replaceAll(inputNivel + " "
								+ inputDuracao + " " + inputMoves, inputNivel
								+ " " + inputDuracao + " " + nMoves);
						Files.write(path, content.getBytes(charset));
						if (inputNivel == nivel && duracao > inputDuracao)
							return;
					}
					if (inputNivel == nivel && duracao < inputDuracao) {
						Path path = Paths.get(Jogo.ROOTPATH
								+ "tps/tp4/memoria.txt");
						Charset charset = StandardCharsets.UTF_8;
						String content = new String(Files.readAllBytes(path),
								charset);
						content = content.replaceAll(inputNivel + " "
								+ inputDuracao, nivel + " " + duracao);
						Files.write(path, content.getBytes(charset));
						return;
					} else if (inputNivel == nivel
							&& (duracao > inputDuracao || nMoves > inputMoves))
						return;
				}
				memoria.println(nivel + " " + duracao + " " + nMoves);
				memoria.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				memoria = new PrintWriter(memoria_str);
			} catch (FileNotFoundException e) {
				System.out.println("Error opening the file" + memoria_str);
			}
			memoria.println(nivel + " " + duracao + " " + nMoves);
			memoria.close();
		}
	}
}
