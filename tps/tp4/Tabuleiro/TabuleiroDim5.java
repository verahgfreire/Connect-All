package tps.tp4.Tabuleiro;

import java.awt.Color;

public class TabuleiroDim5 extends Tabuleiro {

	private static final long serialVersionUID = 1L;
	static int dim = 5;
	static String name = "Not So Easy";

	public TabuleiroDim5(int numPuzzle) {
		super(dim, name, numPuzzle);
	}

	public enum CorDasPecas {
		one(197, 40, 4), two(174, 197, 40), three(40, 197, 80), four(40, 131,
				197), five(121, 40, 197), six(197, 40, 97);

		private int r;
		private int g;
		private int b;

		private CorDasPecas(int r, int g, int b) {
			this.r = r;
			this.g = g;
			this.b = b;
		}
	}

	public Color getColor(int nColor) {
		CorDasPecas[] coresPecas = CorDasPecas.values();
		return new Color(coresPecas[nColor - 1].r, coresPecas[nColor - 1].g,
				coresPecas[nColor - 1].b);
	}
}
