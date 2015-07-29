package tps.tp4.Tabuleiro;

import tps.tp4.Elemento.*;

import java.util.ArrayList;
import java.util.Iterator;
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

	public Color getColor(){
		return corActual;
	}
	public int getValue(){
		return valorActual;
	}


	public void inserir(Elemento el){

		if(el instanceof Peca){
			valorActual = ((Peca)el).valor();
			corActual = ((Peca)el).color();
		}
		if(ultimo()!=null)
			ultimo().corrigirCanto(el.getTabX(),el.getTabY());
		percurso.add(el);
	}

	public int obter(int x, int y){
		for (int i = 0; i < percurso.size(); i++) 
			if(percurso.get(i).getTabX()==x && percurso.get(i).getTabY()==y)
				return i;
		return -1;
		
	}

	public void replace(Elemento e, int x, int y){
		percurso.set(obter(x,y), e);
	}

	public Elemento ultimo(){
		if(percurso.size()<1){
			return null;
		}
		return percurso.get(percurso.size() - 1);
	}

	public boolean contem(Elemento e){
		return percurso.contains(e);
	}

	public void eliminar(int x, int y){
		/*Elemento e;
		boolean encontrado=false;
		for (int i = 0; i < percurso.size(); i++) {
			e = percurso.get(i);
			if(e.getTabX()==x && e.getTabY()==y){
				encontrado=true;
			}
			if(encontrado){
				percurso.remove(i);
			}
		}*/
	}
}
