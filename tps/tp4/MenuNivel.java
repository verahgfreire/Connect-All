package tps.tp4;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class MenuNivel {

	private static JFrame frame;

	public MenuNivel() {
		menu();
	}

	/*
	 * Devolve a frame actual
	 */
	public static JFrame frame() {
		return frame;
	}

	/*
	 * Cria o menu de niveis e chama o menu de puzzles do nivel escolhido
	 */
	public void menu() {
		// create a JFrame
		frame = new JFrame();
		// set title
		frame.setTitle("...:Connect-All:...");
		// set size and location
		frame.setSize(500, 700);
		// to center a frame
		frame.setLocationRelativeTo(null);
		// set default close operation
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// build the gridLayout
		GridLayout gl = new GridLayout(8, 1);// _dim, 2);
		frame.setLayout(gl);

		// set content pane background color
		frame.getContentPane().setBackground(Color.black);

		JLabel label = new JLabel("Menu");
		label.setFont(new Font("Courier New", Font.BOLD + Font.ITALIC, 36));
		label.setForeground(Color.WHITE);
		label.setOpaque(true);
		label.setBackground(Color.black);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(label);

		JButton button44 = new JButton("4x4 Easy");
		button44.setForeground(new Color(170, 44, 44));
		frame.add(button44);

		// set dynamic part =======================================
		button44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); // you can't see me!
				frame.dispose();

				new MenuPuzzles(4);
			}
		});

		JButton button55 = new JButton("5x5 Not so Easy");
		button55.setForeground(new Color(190, 169, 56));
		frame.add(button55);

		// set dynamic part =======================================
		button55.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); // you can't see me!
				frame.dispose();

				new MenuPuzzles(5);
			}
		});

		JButton button66 = new JButton("6x6 Medium");
		button66.setForeground(new Color(132, 197, 61));
		frame.add(button66);

		// set dynamic part =======================================
		button66.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); // you can't see me!
				frame.dispose();

				new MenuPuzzles(6);
			}
		});

		JButton button77 = new JButton("7x7 Not so medium");
		button77.setForeground(new Color(82, 131, 195));
		frame.add(button77);

		// set dynamic part =======================================
		button77.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); // you can't see me!
				frame.dispose();

				new MenuPuzzles(7);
			}
		});

		JButton button88 = new JButton("8x8 Hard");
		button88.setForeground(new Color(190, 73, 161));
		frame.add(button88);

		// set dynamic part =======================================
		button88.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); // you can't see me!
				frame.dispose();

				new MenuPuzzles(8);
			}
		});

		JButton button99 = new JButton("9x9 Very Hard");
		button99.setForeground(new Color(142, 44, 194));
		frame.add(button99);

		// set dynamic part =======================================
		button99.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); // you can't see me!
				frame.dispose();

				new MenuPuzzles(9);
			}
		});

		JButton buttonBack = new JButton("Voltar");
		buttonBack.setLayout(gl);
		frame.add(buttonBack);

		// set dynamic part =======================================
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); // you can't see me!
				frame.dispose();

				new PainelInicial();
			}
		});

		// set content pane background color
		frame.getContentPane().setBackground(Color.black);
		// puts the frame visible (is not visible at start)
		frame.setVisible(true);
		// life goes on
		System.out.println("Menu created...");
	}
}
