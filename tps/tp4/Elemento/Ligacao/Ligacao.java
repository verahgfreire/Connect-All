package tps.tp4.Elemento.Ligacao;

import java.awt.*;

import tps.tp4.Jogo;
import tps.tp4.Elemento.Elemento;

public class Ligacao extends Elemento {

	private static final long serialVersionUID = 1L;
	protected Color color;

	public Ligacao(int x, int y) {
		super(x, y);

		Jogo.tabuleiro().quadricula(x, y).replace(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
	}

	public boolean podeEntrar(int currentValue) {
		return false;
	}

	public Color getColor() {
		return color;
	}

	/**
	 * A unica altura em que vamos querer alterar o trajecto quando la estiver
	 * uma ligacao sera para eliminar o trajecto até esse ponto
	 */
	public void alterarTrajecto() {
		if (pressed <= 1)
			Jogo.tabuleiro().trajecto().eliminar(this);
	}
}