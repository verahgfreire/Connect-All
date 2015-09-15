package tps.tp4.tabuleiros;

import java.awt.Color;

public class TabuleiroDim4 extends Tabuleiro {

	private static final long serialVersionUID = 1L;
	static int dim = 4;
	static String name = "Easy";

	public TabuleiroDim4(int numPuzzle) {
		super(dim, name, numPuzzle);
	}

	/*
	 * Enumerado com as cores das peças
	 */
	public enum CorDasPecas {
		one(197, 40, 4), two(174, 197, 40), three(40, 197, 80), four(40, 131,
				197);

		private int r;
		private int g;
		private int b;

		private CorDasPecas(int r, int g, int b) {
			this.r = r;
			this.g = g;
			this.b = b;
		}
	}

	/*
	 * Devolve a cor da peca de valor correspondente
	 */
	public Color getColor(int nColor) {
		CorDasPecas[] coresPecas = CorDasPecas.values();
		return new Color(coresPecas[nColor - 1].r, coresPecas[nColor - 1].g,
				coresPecas[nColor - 1].b);
	}
}