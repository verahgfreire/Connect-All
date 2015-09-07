package tps.tp4.Tabuleiro;

import java.awt.Color;

public class TabuleiroDim9 extends Tabuleiro {

	private static final long serialVersionUID = 1L;
	static int dim = 9;
	static String name = "Very Hard";

	public TabuleiroDim9(int numPuzzle) {
		super(dim, name, numPuzzle);
	}

	public enum CorDasPecas {

		one(197, 40, 4), two(197, 87, 40), three(197, 127, 40), four(197, 170,
				40), five(174, 197, 40), six(131, 197, 40), seven(90, 197, 40), eight(
				44, 197, 40), nine(40, 197, 80), ten(40, 197, 121), eleven(40,
				197, 163), twelve(40, 178, 197), thirteen(40, 131, 197), fourteen(
				40, 90, 197), fifteen(40, 44, 197), sixteen(80, 40, 197), seventeen(
				121, 40, 197), eighteen(163, 40, 197), nineteen(197, 40, 182), twenty(
				197, 40, 138);

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
