package tps.tp4.Elemento.Ligacao.LigacaoRecta;

import java.awt.*;

import tps.tp4.Jogo;
import tps.tp4.Elemento.Ligacao.Ligacao;

public abstract class LigacaoRecta extends Ligacao {

	private static final long serialVersionUID = 1L;
	protected int origem;

	/*
	 * Construtor da classe LigacaoRecta que vai ser definida ao pormenor pelas
	 * suas classes descendentes (Horizontal e Vertical) e, identica a
	 * LigacaoCanto. Substitui-se no trajecto e altera o tabuleiro onde estava a
	 * peça ElementoVazio (por exemplo) por uma ligacao recta
	 */
	public LigacaoRecta(int x, int y, int origem) {
		super(x, y);
		this.color = Jogo.tabuleiro().trajecto().getColor();
		this.origem = origem;
		Jogo.tabuleiro().quadricula(x, y).replace(this);
		Jogo.tabuleiro().trajecto().inserir(this);
		// System.out.println("origem:"+origem);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}