package tps.tp4;

import java.util.ArrayList;
import java.util.Iterator;
import tps.tp4.Elemento.Elemento;

public class Trajecto {
	
	ArrayList<Elemento> percurso;

	public Trajecto() {
		percurso = new ArrayList<Elemento>();
	}

	public void inserir(Elemento e){
		//percurso.add(e);
		
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
