package tps.tp4.Elemento.Ligacao.LigacaoCanto;

import java.awt.*;

import tps.tp4.Elemento.Ligacao.LigacaoRecta.LigacaoRectaHorizontal;
import tps.tp4.Elemento.Ligacao.LigacaoRecta.LigacaoRectaVertical;

public class LigacaoCantoSO extends LigacaoCanto {

	private static final long serialVersionUID = 1L;

	public LigacaoCantoSO(int x, int y, int origem) {
		super(x, y, origem);
	}

	/*
	 * Identico a LigacaoCantoSE mas desenha um canto inferior esquerdo
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(getWidth() / 3, 0, getWidth() - getWidth() / 3, getHeight()
				- getHeight() / 3);
		g.setColor(Color.BLACK);
		g.fillRect(getWidth() - getWidth() / 3, 0, getWidth() / 3,
				getHeight() / 3);
	}

	@Override
	public void corrigirCanto(int newX, int newY) {
		if (origem > 0 && newY > y)
			new LigacaoCantoNO(x, y, origem);
		if (origem > 0 && newX < x)
			new LigacaoRectaHorizontal(x, y, origem);

		if (origem < 0 && newY > y)
			new LigacaoRectaVertical(x, y, origem);

		if (origem < 0 && newX < x)
			new LigacaoCantoSE(x, y, origem);
	}
}