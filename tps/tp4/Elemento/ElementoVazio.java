package tps.tp4.Elemento;

import java.awt.*;

import tps.tp4.Jogo;
import tps.tp4.Elemento.Ligacao.LigacaoRecta.*;

public class ElementoVazio extends Elemento {

	private static final long serialVersionUID = 1L;

	public ElementoVazio(int x, int y) {
		super(x, y);
		pressed = 0;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	/*
	 * Este método permite criar as rectas horizontais ou verticais consoante a
	 * posição e a acção do rato. É possivel fazer click na posição seguinte em
	 * linha reta para com a posição corrente (mas não adjacente).
	 */
	public void alterarTrajecto() {

		if (podeEntrar(Jogo.tabuleiro().trajecto().getValue())) {

			Elemento ultimo = Jogo.tabuleiro().trajecto().ultimo();

			if (ultimo.getTabX() == x) {
				Jogo.tabuleiro().setMoves(1);
				new LigacaoRectaVertical(x, y, ultimo.getTabY() - y);
			} else if (ultimo.getTabY() == y) {
				Jogo.tabuleiro().setMoves(1);
				new LigacaoRectaHorizontal(x, y, ultimo.getTabX() - x);
			}
		}

		else if (podeEntrarSequencia(Jogo.tabuleiro().trajecto().getValue())) {

			boolean flag = true;
			Elemento ultimo = Jogo.tabuleiro().trajecto().ultimo();

			if (ultimo.getTabY() == y) {

				int seq = Math.abs(Jogo.tabuleiro().trajecto().ultimo()
						.getTabX()
						- x);

				if (Jogo.tabuleiro().trajecto().ultimo().getTabX() - x < 0)
					for (int i = seq - 1; i >= 0; i--) {
						for (int j = 0; j < Jogo.tabuleiro().getPecaX().length; j++) {
							if ((x - i) == Jogo.tabuleiro().getPecaX()[j]
									&& y == Jogo.tabuleiro().getPecaY()[j]) {
								flag = false;
								if (j == Jogo.tabuleiro().trajecto().getValue()) {
									Jogo.tabuleiro().setMoves(1);
									Jogo.tabuleiro()
											.trajecto()
											.inserir(
													new Peca(
															Jogo.tabuleiro()
																	.getPecaValores()[j],
															Jogo.tabuleiro()
																	.getPecaCores()[j],
															Jogo.tabuleiro()
																	.getPecaX()[j],
															Jogo.tabuleiro()
																	.getPecaY()[j]));
								}
							}
						}
						if (Jogo.tabuleiro().trajecto().obter(x - i, y) != -1)
							return;
						if (flag == true) {
							Jogo.tabuleiro().setMoves(1);
							new LigacaoRectaHorizontal(x - i, y,
									(ultimo.getTabX() - i) - (x - i));
						}
					}

				if (Jogo.tabuleiro().trajecto().ultimo().getTabX() - x > 0)
					for (int i = seq - 1; i >= 0; i--) {
						for (int j = 0; j < Jogo.tabuleiro().getPecaX().length; j++) {
							if ((x + i) == Jogo.tabuleiro().getPecaX()[j]
									&& y == Jogo.tabuleiro().getPecaY()[j]) {
								flag = false;
								if (j == Jogo.tabuleiro().trajecto().getValue()) {
									Jogo.tabuleiro().setMoves(1);
									Jogo.tabuleiro()
											.trajecto()
											.inserir(
													new Peca(
															Jogo.tabuleiro()
																	.getPecaValores()[j],
															Jogo.tabuleiro()
																	.getPecaCores()[j],
															Jogo.tabuleiro()
																	.getPecaX()[j],
															Jogo.tabuleiro()
																	.getPecaY()[j]));
								}
							}
						}
						if (Jogo.tabuleiro().trajecto().obter(x + i, y) != -1)
							return;
						if (flag == true) {
							Jogo.tabuleiro().setMoves(1);
							new LigacaoRectaHorizontal(x + i, y,
									(ultimo.getTabX() + i) - (x + i));
						}
					}
			}

			if (ultimo.getTabX() == x) {

				int seq = Math.abs(Jogo.tabuleiro().trajecto().ultimo()
						.getTabY()
						- y);

				if (Jogo.tabuleiro().trajecto().ultimo().getTabY() - y < 0)
					for (int i = seq - 1; i >= 0; i--) {
						for (int j = 0; j < Jogo.tabuleiro().getPecaX().length; j++) {
							if (x == Jogo.tabuleiro().getPecaX()[j]
									&& (y - i) == Jogo.tabuleiro().getPecaY()[j]) {
								flag = false;
								if (j == Jogo.tabuleiro().trajecto().getValue()) {
									Jogo.tabuleiro().setMoves(1);
									Jogo.tabuleiro()
											.trajecto()
											.inserir(
													new Peca(
															Jogo.tabuleiro()
																	.getPecaValores()[j],
															Jogo.tabuleiro()
																	.getPecaCores()[j],
															Jogo.tabuleiro()
																	.getPecaX()[j],
															Jogo.tabuleiro()
																	.getPecaY()[j]));
								}
							}
						}
						if (Jogo.tabuleiro().trajecto().obter(x, (y - i)) != -1)
							return;
						if (flag == true) {
							Jogo.tabuleiro().setMoves(1);
							new LigacaoRectaVertical(x, y - i,
									(ultimo.getTabY() - i) - (y - i));
						}
					}

				if (Jogo.tabuleiro().trajecto().ultimo().getTabY() - y > 0)
					for (int i = seq - 1; i >= 0; i--) {
						for (int j = 0; j < Jogo.tabuleiro().getPecaX().length; j++) {
							if (x == Jogo.tabuleiro().getPecaX()[j]
									&& (y + i) == Jogo.tabuleiro().getPecaY()[j]) {
								flag = false;
								if (j == Jogo.tabuleiro().trajecto().getValue()) {
									Jogo.tabuleiro().setMoves(1);
									Jogo.tabuleiro()
											.trajecto()
											.inserir(
													new Peca(
															Jogo.tabuleiro()
																	.getPecaValores()[j],
															Jogo.tabuleiro()
																	.getPecaCores()[j],
															Jogo.tabuleiro()
																	.getPecaX()[j],
															Jogo.tabuleiro()
																	.getPecaY()[j]));
								}
							}
						}
						if (Jogo.tabuleiro().trajecto().obter(x, (y + i)) != -1)
							return;
						if (flag == true) {
							Jogo.tabuleiro().setMoves(1);
							new LigacaoRectaVertical(x, y + i,
									(ultimo.getTabY() + i) - (y + i));
						}
					}

			}
		}

	}

	/*
	 * Este metodo permite fazer restriçoes ao fazer click na posição seguinte
	 * em linha reta para com a posição corrente (mas não adjacente).
	 */
	public boolean podeEntrarSequencia(int currentValue) {
		if (currentValue == 0) // obrigatório comecar numa peça
			return false;

		if (Math.abs(Jogo.tabuleiro().trajecto().ultimo().getTabX() - x) != 0
				&& Math.abs(Jogo.tabuleiro().trajecto().ultimo().getTabY() - y) != 0)
			return false;

		if (currentValue == Jogo.tabuleiro().getMaxValue() - 1
				&& Jogo.tabuleiro().trajecto().percursoSize() != Jogo
						.tabuleiro().dimensao() - 1) {
			System.out.println("Nem todas as quadriculas estão preenchidas!!");
			return false;
		}

		return true;
	}

	/*
	 * Verifica se estamos a comecar numa peca
	 */
	public boolean podeEntrar(int currentValue) {
		if (currentValue == 0) {
			return false;
		}
		return super.podeEntrar(currentValue);
	}
}