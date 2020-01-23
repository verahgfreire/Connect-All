package tps.tp4.tabuleiros;

import java.awt.Color;

public class TabuleiroDim7 extends Tabuleiro {

	private static final long serialVersionUID = 1L;
	static int dim = 7;
	static String name = "Not so medium";

	public TabuleiroDim7(int numPuzzle) {
		super(dim, name, numPuzzle);
	}

	public enum CorDasPecas {
		one(197, 40, 4), two(197, 127, 40), three(174, 197, 40), four(90, 197,
				40), five(40, 197, 80), six(40, 197, 163), seven(40, 131, 197), eight(
				40, 44, 197), nine(121, 40, 197), ten(197, 40, 182), eleven(
				197, 40, 97), twelve(197, 87, 40), thirteen(197, 170, 40);

		private int r;
		private int g;
		private int b;

		private CorDasPecas(int r, int g, int b) {
			this.r = r;
			this.g = g;
			this.b = b;
		}
	}

	public Color getColor(int nColor){
		CorDasPecas[] coresPecas = CorDasPecas.values();
		return new Color (coresPecas[nColor-1].r,coresPecas[nColor-1].g,coresPecas[nColor-1].b);
	}
}
