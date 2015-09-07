package tps.tp4.Tabuleiro;

import tps.tp4.Jogo;
import tps.tp4.Elemento.*;

import java.util.ArrayList;
import java.util.ListIterator;
import java.awt.*;

public class Trajecto {

	private ArrayList<Elemento> percurso;
	private Color corActual;
	private int valorActual;

	public Trajecto() {
		percurso = new ArrayList<Elemento>();
		corActual = null;
		valorActual = 0;
	}

	public Color getColor() {
		return corActual;
	}

	public void setColor(Color c) {
		corActual = c;
	}

	public int getValue() {
		return valorActual;
	}

	public void setValue(int v) {
		valorActual = v;
	}
	
	public int percursoSize(){
		return percurso.size();
	}

	public void inserir(Elemento el) {
		if (el instanceof Peca) {
			valorActual = ((Peca) el).valor();
			corActual = ((Peca) el).color();
		}
		if (ultimo() != null)
			ultimo().corrigirCanto(el.getTabX(), el.getTabY());

		// ja existe no trajecto, faz-se replace
		if (obter(el.getTabX(), el.getTabY()) > -1) {
			percurso.set(obter(el.getTabX(), el.getTabY()), el);
		} else {
			percurso.add(el);
		}
		//TODO
		if(Jogo.tabuleiro().trajecto().percursoSize() == Jogo
				.tabuleiro().dimensao())
			System.out.println("Parabens!");

	}

	public int obter(int x, int y) {
		for (int i = 0; i < percurso.size(); i++)
			if (percurso.get(i).getTabX() == x
					&& percurso.get(i).getTabY() == y)
				return i;
		return -1;
	}

	public Elemento ultimo() {
		if (percurso.size() < 1) {
			return null;
		}
		return percurso.get(percurso.size() - 1);
	}

	public boolean contem(Elemento e) {
		return percurso.contains(e);
	}

	public void eliminar(Elemento el) {
		int ind = percurso.indexOf(el);
		if (ind == 0)
			ind = 1;

		ListIterator<Elemento> it = percurso.listIterator(ind);
		while (it.hasNext()) {

			Elemento elAct = it.next();
			if (!(elAct instanceof Peca)) {
				Elemento vazio = new ElementoVazio(elAct.getTabX(),
						elAct.getTabY());
				Jogo.tabuleiro().quadricula(elAct.getTabX(), elAct.getTabY())
						.replace(vazio);
			} else {
				valorActual--;
				corActual = Jogo.tabuleiro().getColor(valorActual);
			}
			System.out.println(elAct.getClass().getName());
			it.remove();
		}
	}

	public void saveToFile() {

	}
}
