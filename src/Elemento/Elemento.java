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
	protected int nMovimentos;

	/*
	 * Construtor da classe Elemento, define o tipo de layout da frame e desenha
	 * a sua borda
	 */
	public Elemento(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		setLayout(new CardLayout());
		setBorder(new LineBorder(Color.GRAY, 1));
		setOpaque(true);
		setBackground(Color.BLACK);
	}

	/*
	 * Devolve true se o rato estiver pressionado neste elemento
	 */
	public int pressed() {
		return pressed;
	}

	/*
	 * Incrementa o valor da variavel pressed. Diferentes valores tem diferentes
	 * significados a nivel de click ou click-hold.
	 */
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

	/*
	 * Retorna o valor de x deste elemento no tabuleiro
	 */
	public int getTabX() {
		return x;
	}

	/*
	 * Retorna o valor de y deste elemento no tabuleiro
	 */
	public int getTabY() {
		return y;
	}

	/*
	 * Classes a serem definidas nos descendentes de elemento
	 */
	public abstract void alterarTrajecto();

	public void corrigirCanto(int x, int y) {
	}

	/*
	 * Este metodo vai testar as condicoes em que se pode ou nao entrar num
	 * elemento, ou seja, se o ultimo elemento inserido no trajecto é um
	 * elemento vizinho do actual
	 */
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