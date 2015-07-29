package tps.tp4.Elemento;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import tps.tp4.*;
import tps.tp4.Tabuleiro.*;

public abstract class Elemento extends JLabel{
	
	protected int x;
	protected int y;
	protected static boolean pressed;
	
	public Elemento(int x,int y){
		super();
		this.x=x;
		this.y=y;
		setLayout(new CardLayout());
		setBorder(new LineBorder(Color.GRAY, 1));
		setOpaque(true);
		setBackground(Color.BLACK);

		// Implementação anónima da interface MouseListener()
		addMouseListener(new MouseListener(){

			// getSource() retorna Component onde MouseListener foi adicionado
			public void mouseReleased(MouseEvent m) { 
				((Elemento) m.getSource()).pressed(false);
			}

			public void mousePressed(MouseEvent m) {
				((Elemento) m.getSource()).pressed(true);
				((Elemento) m.getSource()).desenharTrajecto();
			}

			public void mouseClicked(MouseEvent m) {	
				((Elemento) m.getSource()).desenharTrajecto();
			}

			public void mouseExited(MouseEvent m) {}

			public void mouseEntered(MouseEvent m) {
				if( ((Elemento) m.getSource()).pressed() )
						((Elemento) m.getSource()).desenharTrajecto();
			}
		});
	}

	public boolean pressed(){
		return pressed;
	}
	public void pressed(boolean p){
		pressed = p;
	}

	public abstract void desenharTrajecto();

	public void corrigirCantos(){
			
		Elemento ultimo = Jogo.tabuleiro().trajecto().ultimo();
		Elemento penultimo = Jogo.tabuleiro().trajecto().penultimo();

		if(ultimo==null || penultimo==null){
			return;
		}

		if(!(ultimo instanceof Peca)){
			
			if(penultimo.getTabX()>ultimo.getTabX() && ultimo.getTabX()==x){
				if(penultimo.getTabY()==ultimo.getTabY() && ultimo.getTabY()<y)
					new LigacaoCantoNO(ultimo.getTabX(),ultimo.getTabY());
				if(penultimo.getTabY()==ultimo.getTabY() && ultimo.getTabY()>y)
					new LigacaoCantoSO(ultimo.getTabX(),ultimo.getTabY());
			}

			if(penultimo.getTabX()==ultimo.getTabX() && ultimo.getTabX()>x){
				if(penultimo.getTabY()>ultimo.getTabY() && ultimo.getTabY()==y)
					new LigacaoCantoNE(ultimo.getTabX(),ultimo.getTabY());
				if(penultimo.getTabY()<ultimo.getTabY() && ultimo.getTabY()==y)
					new LigacaoCantoSE(ultimo.getTabX(),ultimo.getTabY());
			}

			if(penultimo.getTabX()==ultimo.getTabX() && ultimo.getTabX()<x){
				if(penultimo.getTabY()<ultimo.getTabY() && ultimo.getTabY()==y)
					new LigacaoCantoSO(ultimo.getTabX(),ultimo.getTabY());
				if(penultimo.getTabY()>ultimo.getTabY() && ultimo.getTabY()==y)
					new LigacaoCantoNO(ultimo.getTabX(),ultimo.getTabY());
			}
			if(penultimo.getTabX()<ultimo.getTabX() && ultimo.getTabX()==x){
				if(penultimo.getTabY()==ultimo.getTabY() && ultimo.getTabY()>y)
					new LigacaoCantoSE(ultimo.getTabX(),ultimo.getTabY());
				if(penultimo.getTabY()==ultimo.getTabY() && ultimo.getTabY()<y)
					new LigacaoCantoNE(ultimo.getTabX(),ultimo.getTabY());
			}
		}
	}

	@Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g); 
	}

	public int getTabX() {
		return x;
	}
	public int getTabY() {
		return y;
	}

	public boolean podeEntrar(int currentValue){
		if(currentValue==0){ // obrigatório comecar numa peça
			return false;
		}
		if(Jogo.tabuleiro().trajecto().contem(this)){
			return false;
		}
		if(Math.abs(Jogo.tabuleiro().trajecto().ultimo().getTabX()-x)>1){
			return false;
		}
		if(Math.abs(Jogo.tabuleiro().trajecto().ultimo().getTabY()-y)>1){
			return false;
		}
		if(Math.abs(Jogo.tabuleiro().trajecto().ultimo().getTabX()-x)==1){
			if(Math.abs(Jogo.tabuleiro().trajecto().ultimo().getTabY()-y)!=0){
				return false;
			}
		}
		if(Math.abs(Jogo.tabuleiro().trajecto().ultimo().getTabY()-y)==1){
			if(Math.abs(Jogo.tabuleiro().trajecto().ultimo().getTabX()-x)!=0){
				return false;
			}
		}
		return true;
	}
}