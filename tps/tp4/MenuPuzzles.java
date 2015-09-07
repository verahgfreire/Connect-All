package tps.tp4;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class MenuPuzzles {

	private static JFrame frame;
	private int dim = (Jogo.tabActual.dimensao());
	private String name;

	public MenuPuzzles() {
		menuPuzzles();
	}

	public static JFrame frame() {
		return frame;
	}

	public void menuPuzzles() {

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

		JLabel label = new JLabel("Menu Puzzles");
		label.setFont(new Font("Courier New", Font.BOLD + Font.ITALIC, 36));
		label.setForeground(new Color(110, 180, 50));
		label.setOpaque(true);
		label.setBackground(Color.black);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(label);
		
		JPanel botoes = new JPanel();
		
		int nPuzzles = new File(Jogo.ROOTPATH + "tps/tp4/levels/" + dim + dim + name).listFiles().length;
		
//		for()

		// for (int y = 0; y < dim; y++) {
		// for (int x = 0; x < dim; x++) {
		// add(new Quadricula(new ElementoVazio(x, y)));
		// }
		// }
	}
}
