package tps.tp4.Elemento.Ligacao;

import java.awt.*;

import tps.tp4.Jogo;
import tps.tp4.Elemento.Elemento;

public class Ligacao extends Elemento {

	private static final long serialVersionUID = 1L;
	protected Color color;

	/*
	 * Construtor da classe Ligacao, substitui o tipo de quadricula (exemplo
	 * elemento vazio) por uma ligacao
	 */
	public Ligacao(int x, int y) {
		super(x, y);

		Jogo.tabuleiro().quadricula(x, y).replace(this);
	}

	/*
	 * Define apenas a cor da ligacao, o resto sera desenhado nas implementacoes
	 * deste metodo nas classes descendentes de ligacao
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
	}

	/*
	 * Metodo apenas aplicavel se o elemento for do tipo peca
	 */
	public boolean podeEntrar(int currentValue) {
		return false;
	}

	/*
	 * Retorna cor da ligacao
	 */
	public Color getColor() {
		return color;
	}

	/*
	 * A unica altura em que vamos querer alterar o trajecto quando la estiver
	 * uma ligacao sera para eliminar o trajecto até esse ponto
	 */
	public void alterarTrajecto() {
		if (pressed <= 1)
			System.out.println("pressed");
		Jogo.tabuleiro().trajecto().eliminar(this);
	}
}