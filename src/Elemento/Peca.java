package tps.tp4.Elemento;

import java.awt.*;

import tps.tp4.Jogo;
import tps.tp4.Elemento.Ligacao.LigacaoRecta.LigacaoRectaHorizontal;
import tps.tp4.Elemento.Ligacao.LigacaoRecta.LigacaoRectaVertical;

public class Peca extends Elemento {

	private static final long serialVersionUID = 1L;
	private int num;
	private Color cor;

	/*
	 * Construtor da classe peca, substitui o elemento da quadricula por um do
	 * tipo peca
	 */
	public Peca(int num, Color cor, int x, int y) {
		super(x, y);

		this.num = num;
		this.cor = cor;
		Jogo.tabuleiro().quadricula(x, y).replace(this);
	}

	/*
	 * Retorna a cor da peca
	 */
	public Color color() {
		return cor;
	}

	/*
	 * Retorna o valor da peca
	 */
	public int valor() {
		return num;
	}

	public int getMoves() {
		return nMovimentos;
	}

	/*
	 * Este método permite criar as rectas horizontais ou verticais consoante a
	 * posição e a acção do rato. É possivel fazer click na posição seguinte em
	 * linha reta para com a posição corrente (mas não adjacente).
	 */
	public void alterarTrajecto() {
		Elemento ultimo = Jogo.tabuleiro().trajecto().ultimo();

		if (podeEntrar(Jogo.tabuleiro().trajecto().getValue())) {
			Jogo.tabuleiro().trajecto().inserir(this);
			Jogo.tabuleiro().setMoves(1);
		} else if (pressed <= 1) {
			Jogo.tabuleiro().trajecto().eliminar(this);
		}
		if (podeEntrarSequencia(Jogo.tabuleiro().trajecto().getValue())) {
			boolean flag = true;
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
							new LigacaoRectaHorizontal(x - i, y,
									(ultimo.getTabX() - i) - (x - i));
							Jogo.tabuleiro().setMoves(1);
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
							new LigacaoRectaHorizontal(x + i, y,
									(ultimo.getTabX() + i) - (x + i));
							Jogo.tabuleiro().setMoves(1);
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
							new LigacaoRectaVertical(x, y - i,
									(ultimo.getTabY() - i) - (y - i));
							Jogo.tabuleiro().setMoves(1);
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
							new LigacaoRectaVertical(x, y + i,
									(ultimo.getTabY() + i) - (y + i));
							Jogo.tabuleiro().setMoves(1);
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

		if (currentValue == 0 && num == 1) { // obrigatório comecar na peca 1
			return true;
		}
		if (currentValue != num - 1) {
			return false;
		}

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
	 * Testa se podemos entrar na peca, ou seja, verifica que a ultima peca onde
	 * entramos é exatamente a anterior (se queremos entrar na 3 a ultima onde
	 * entramos tem de ser a 2), e se tentarmos entrar na ultima peca do
	 * tabuleiro mas nem todas as quadriculas estiverem preenchidas impede
	 */
	@Override
	public boolean podeEntrar(int currentValue) {
		// System.out.println("currentValue: "+currentValue + ", num: " + num);
		if (currentValue == 0 && num == 1) { // obrigatório comecar na peca 1
			return true;
		}
		if (currentValue != num - 1) {
			return false;
		}

		if (currentValue == Jogo.tabuleiro().getMaxValue() - 1
				&& Jogo.tabuleiro().trajecto().percursoSize() != Jogo
						.tabuleiro().dimensao() - 1) {
			System.out.println("Nem todas as quadriculas estão preenchidas!!");
			return false;
		}
		return super.podeEntrar(currentValue);
	}

	/*
	 * Desenha a peca no tabuleiro
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(cor);
		g.fillOval(getWidth() / 2 - 40, getHeight() / 2 - 40, 80, 80);
		g.setColor(Color.BLACK);
		g.fillOval(getWidth() / 2 - 25, getHeight() / 2 - 25, 50, 50);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Courier New", Font.BOLD + Font.ITALIC, 35));
		g.drawString("" + num, getWidth() / 2 - 9 - num, getHeight() / 2 + 12);
	}
}