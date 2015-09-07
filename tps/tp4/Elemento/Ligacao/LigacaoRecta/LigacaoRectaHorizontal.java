package tps.tp4.Elemento.Ligacao.LigacaoRecta;

import java.awt.*;
import tps.tp4.Elemento.Ligacao.LigacaoCanto.*;

public class LigacaoRectaHorizontal extends LigacaoRecta {

	private static final long serialVersionUID = 1L;

	public LigacaoRectaHorizontal(int x, int y, int origem) {
		super(x, y, origem);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(0, getHeight() / 3, getWidth(), getHeight() / 3);
	}

	@Override
	public void corrigirCanto(int newX, int newY) {
		if (origem < 0) {
			if (y < newY)
				new LigacaoCantoNE(x, y,-1);
			if (y > newY)
				new LigacaoCantoSE(x, y,1);
		}
		if (origem > 0) {
			if (y < newY)
				new LigacaoCantoNO(x, y,-1);
			if (y > newY)
				new LigacaoCantoSO(x, y,1);
		}
	}
}