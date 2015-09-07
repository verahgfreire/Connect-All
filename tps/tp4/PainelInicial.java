package tps.tp4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class PainelInicial {

	private static JFrame frame;

	public PainelInicial() {
		painelInicial();
	}

	public void painelInicial(){
		// create a JFrame
		frame = new JFrame();
		// set title
		frame.setTitle("...:Connect-All:...");
		// set size and location
		frame.setSize(500, 500);
		// to center a frame
		frame.setLocationRelativeTo(null);
		// set default close operation
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// build the gridLayout
		GridLayout gl = new GridLayout(2, 1);
		frame.setLayout(gl);

		// set content pane background color
		frame.getContentPane().setBackground(Color.black);
		
		BufferedImage img;
		try {
			img = ImageIO.read(new File(Jogo.ROOTPATH
					+ "tps/tp4/logo.png"));

			ImageIcon icon = new ImageIcon(img);
			JLabel label = new JLabel(icon);
			frame.add(label);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.black);

		JButton button1 = new JButton("Play Game");
		button1.setPreferredSize(new Dimension(260,50));
		panel.add(button1);

		// set dynamic part =======================================
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); // you can't see me!
				frame.dispose(); // Destroy the JFrame object

				new MenuNivel();

			}
		});

		JButton button2 = new JButton("Additional Info");
		button2.setPreferredSize(new Dimension(260,50));
		panel.add(button2);

		// set dynamic part =======================================
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); // you can't see me!
				frame.dispose(); // Destroy the JFrame object

				// new Help();
			}
		});
		
		frame.add(panel);

		// puts the frame visible (is not visible at start)
		frame.setVisible(true);
		// life goes on
		System.out.println("Painel inicial do jogo criado");
	}
}
