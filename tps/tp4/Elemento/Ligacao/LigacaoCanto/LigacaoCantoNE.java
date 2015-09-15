package tps.tp4.Elemento.Ligacao.LigacaoCanto;

import java.awt.*;

import tps.tp4.Elemento.Ligacao.LigacaoRecta.*;

public class LigacaoCantoNE extends LigacaoCanto {

	private static final long serialVersionUID = 1L;

	public LigacaoCantoNE(int x, int y, int origem) {
		super(x, y, origem);
	}

	/*
	 * Desenha uma ligacao em forma de canto superior direito
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(0, getHeight() / 3, getWidth() - getWidth() / 3, getHeight()
				- getHeight() / 3);
		g.setColor(Color.BLACK);
		g.fillRect(0, getHeight() - getHeight() / 3, getWidth() / 3,
				getHeight() / 3);
	}

	/*
	 * Corrige os cantos com base na origem, ou seja, ve de onde vem o trajecto,
	 * e para onde vai e decide que tipo de canto aplicar
	 */
	@Override
	public void corrigirCanto(int newX, int newY) {
		if (origem > 0 && newY < y)
			new LigacaoRectaVertical(x, y, origem);
		if (origem > 0 && newX > x)
			new LigacaoCantoNO(x, y, origem);

		if (origem < 0 && newY < y)
			new LigacaoCantoSE(x, y, origem);

		if (origem < 0 && newX > x)
			new LigacaoRectaHorizontal(x, y, origem);
	}
}