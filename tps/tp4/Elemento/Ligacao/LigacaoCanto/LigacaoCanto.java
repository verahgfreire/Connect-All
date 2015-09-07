package tps.tp4.Elemento.Ligacao.LigacaoCanto;

import java.awt.*;

import tps.tp4.Jogo;
import tps.tp4.Elemento.Ligacao.Ligacao;

public abstract class LigacaoCanto extends Ligacao{

	private static final long serialVersionUID = 1L;
	protected int origem;

	public LigacaoCanto(int x, int y, int origem){
		super(x,y);
		this.origem = origem;
		this.color = ((Ligacao) Jogo.tabuleiro().trajecto().ultimo()).getColor();
		Jogo.tabuleiro().quadricula(x,y).replace(this);
		Jogo.tabuleiro().trajecto().inserir(this);
//		System.out.println("origem:"+origem);
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
	}
}