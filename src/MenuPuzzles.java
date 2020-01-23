package tps.tp4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import tps.tp4.tabuleiros.*;

public class MenuPuzzles {

	private static JFrame frame;
	int nPuzzles = 6;
	private static Scanner inputStream;

	public MenuPuzzles(int nivel) {
		menuPuzzles(nivel);
	}

	/*
	 * Devolve a frame actual
	 */
	public static JFrame frame() {
		return frame;
	}

	/*
	 * Método que retorna o melhor tempo de realização do nível completo. Este
	 * método tem como parâmetro o número de nível, que permite adquirir o
	 * melhor tempo guardado no fichero de texto. Caso o nível não esteja
	 * completo, o método retorna null;
	 */
	public static String recordTempo(int nivel) {

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
//					System.out.println(inputNivel);
					String aux = inputStream.next();
					float inputDuracao = Float.parseFloat(aux);
//					System.out.println(inputDuracao);
					int inputMoves = inputStream.nextInt();
//					System.out.println(inputMoves);
					if (inputNivel == nivel)
						return "Melhor Tempo: "
								+ String.format("%.2f", inputDuracao);
					memoria.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	/*
	 * Método que retorna o número mínimo de movimentos realizados do nível
	 * completo. Este método tem como parâmetro o número de nível, que permite
	 * adquir o melhor número de movimentos guardado no fichero de texto. Caso o
	 * nível não esteja completo, o método retorna null;
	 */
	public static String recordMovimento(int nivel) {

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
//					System.out.println(inputNivel);
					String aux = inputStream.next();
					float inputDuracao = Float.parseFloat(aux);
//					System.out.println(inputDuracao);
					int inputMoves = inputStream.nextInt();
//					System.out.println(inputMoves);
					if (inputNivel == nivel)
						return "Melhor Movimento: " + inputMoves;
					memoria.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	/*
	 * Método que cria o menu dos puzzles. É criado uma grelha 3*2 onde são
	 * adicionados os botões que permite ao utilizador escolher o nível do
	 * puzzle. Cada botão tem um índice que permite indicar o número do puzzle
	 * seleccionado. Os botões têm informação dos puzzles completos, como também
	 * da sua melhor pontuação. É criado um botão que permite o utilizador
	 * voltar ao menu dos níveis.
	 */
	public void menuPuzzles(int nivel) {

		// create a JFrame
		frame = new JFrame();
		// set title
		frame.setTitle("...:Connect-All:...");
		// set size and location
		frame.setSize(350, 400);
		// to center a frame
		frame.setLocationRelativeTo(null);
		// set default close operation
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		frame.setLayout(bl);

		// set content pane background color
		frame.getContentPane().setBackground(Color.black);

		JLabel title = new JLabel("Menu Puzzles");
		title.setFont(new Font("Courier New", Font.BOLD + Font.ITALIC, 30));
		title.setForeground(Color.WHITE);
		title.setOpaque(true);
		title.setBackground(Color.black);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(title);

		GridLayout gl = new GridLayout(3, 3);

		JPanel panel = new JPanel();
		panel.setLayout(gl);
		panel.setBackground(Color.BLACK);

		JButton[] botoes = new JButton[nPuzzles];

		for (int i = 0; i < nPuzzles; i++) {
			if (recordTempo((nivel * 100) + i + 1).equals(""))
				botoes[i] = new JButton(i + 1 + "");
			else {
				botoes[i] = new JButton(i + 1 + " " + "Nivel Completo");
				botoes[i].setLayout(new BorderLayout());
				JLabel label1 = new JLabel(recordTempo((nivel * 100) + i + 1));
				botoes[i].add(BorderLayout.NORTH, label1);
				JLabel label2 = new JLabel(recordMovimento((nivel * 100) + i
						+ 1));
				botoes[i].add(BorderLayout.SOUTH, label2);
			}
			botoes[i].setPreferredSize(new Dimension(160, 90));
			panel.add(botoes[i]);
			botoes[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					frame.dispose();
					String num = e.getActionCommand();
					int index = Integer.parseInt(num.substring(0, 1));
					if (nivel == 4)
						new TabuleiroDim4(index);
					if (nivel == 5)
						new TabuleiroDim5(index);
					if (nivel == 6)
						new TabuleiroDim6(index);
					if (nivel == 7)
						new TabuleiroDim7(index);
					if (nivel == 8)
						new TabuleiroDim8(index);
					if (nivel == 9)
						new TabuleiroDim9(index);
				}
			});
		}
		frame.add(panel);

		JButton buttonBack = new JButton("Voltar");
//		buttonBack.setLayout(gl);
		buttonBack.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.add(buttonBack);

		// set dynamic part =======================================
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); // you can't see me!
				frame.dispose();

				new MenuNivel();
			}
		});
		frame.add(buttonBack);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
