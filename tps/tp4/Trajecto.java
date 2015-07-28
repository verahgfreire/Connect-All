package tps.tp4;

import java.util.ArrayList;
import java.util.Iterator;
import tps.tp4.Elemento.*;
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
		
		percurso.add(el);
		
		 /*System.out.print("{");
		 for (int i = 0; i < percurso.size(); i++) {
		 System.out.print("["+percurso.get(i).getTabX()+","+percurso.get(i).getTabY()+"], ");
		 }
		 System.out.println("}");*/
	}

	public Elemento obter(int x, int y){
		/*Iterator<Elemento> iterator = percurso.iterator();
		while (iterator.hasNext()) {
			Elemento e = iterator.next();
			if(e.getTabX()==x && e.getTabY()==y){
				return e;
			}
		}*/
		return null;
	}

	public Elemento ultimo(){
		if(percurso.size()==0){
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
