package tps.tp4.Elemento;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import tps.tp4.Jogo;

public abstract class Elemento extends JLabel {

	private static final long serialVersionUID = 1L;
	protected int x;
	protected int y;
	protected static int pressed = 0;

	public Elemento(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		setLayout(new CardLayout());
		setBorder(new LineBorder(Color.GRAY, 1));
		setOpaque(true);
		setBackground(Color.BLACK);
	}

	public int pressed() {
		return pressed;
	}

	public void incPressed() {
		pressed++;
	}

	public void clearPressed() {
		pressed = 0;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public int getTabX() {
		return x;
	}

	public int getTabY() {
		return y;
	}

	public abstract void alterarTrajecto();

	public void corrigirCanto(int x, int y) {
	}

	public boolean podeEntrar(int currentValue) {

		if (Jogo.tabuleiro().trajecto().contem(this))
			return false;

		Elemento ultimo = Jogo.tabuleiro().trajecto().ultimo();

		if (Math.abs(ultimo.getTabX() - x) > 1
				|| Math.abs(ultimo.getTabY() - y) > 1)
			return false;

		if (Math.abs(ultimo.getTabX() - x) == 1
				&& Math.abs(ultimo.getTabY() - y) != 0)
			return false;

		if (Math.abs(ultimo.getTabY() - y) == 1
				&& Math.abs(ultimo.getTabX() - x) != 0)
			return false;

		return true;
	}
}