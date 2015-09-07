package tps.tp4.Elemento.Ligacao.LigacaoRecta;

import java.awt.*;

import tps.tp4.Elemento.Ligacao.LigacaoCanto.*;

public class LigacaoRectaVertical extends LigacaoRecta {

	private static final long serialVersionUID = 1L;

	public LigacaoRectaVertical(int x, int y, int origem) {
		super(x, y, origem);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(getWidth() / 3, 0, getWidth() / 3, getHeight());
	}

	@Override
	public void corrigirCanto(int newX, int newY) {
		if (origem < 0) {
			if (x < newX)
				new LigacaoCantoSO(x, y,-1);
			if (x > newX)
				new LigacaoCantoSE(x, y,-1);
		}
		if (origem > 0) {
			if (x < newX)
				new LigacaoCantoNO(x, y,1);
			if (x > newX)
				new LigacaoCantoNE(x, y,1);
		}
	}
}