package tps.tp4.Elemento;

import java.awt.*;

import tps.tp4.Jogo;

public class Peca extends Elemento {

	private static final long serialVersionUID = 1L;
	private int num;
	private Color cor;

	public Peca(int num, Color cor, int x, int y) {
		super(x, y);

		this.num = num;
		this.cor = cor;
		Jogo.tabuleiro().quadricula(x, y).replace(this);
	}

	public Color color() {
		return cor;
	}

	public int valor() {
		return num;
	}

	public void alterarTrajecto() {

		if (podeEntrar(Jogo.tabuleiro().trajecto().getValue())) {
			Jogo.tabuleiro().trajecto().inserir(this);
		} else if (pressed <= 1) {
			Jogo.tabuleiro().trajecto().eliminar(this);
		}
	}

	@Override
	public boolean podeEntrar(int currentValue) {
		if (currentValue == 0 && num == 1) { // obrigatório comecar na peca 1
			return true;
		}
		if (currentValue != num - 1) {
			return false;
		}
		
		if (currentValue == Jogo.tabuleiro().getMaxValue()-1
				&& Jogo.tabuleiro().trajecto().percursoSize() != Jogo
						.tabuleiro().dimensao()-1) {
			System.out.println("Nem todas as quadriculas estão preenchidas!!");
			return false;
		}
		return super.podeEntrar(currentValue);
	}

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