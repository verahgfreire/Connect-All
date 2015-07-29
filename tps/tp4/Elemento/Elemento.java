package tps.tp4.Elemento;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import tps.tp4.Jogo;
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
				((Elemento) m.getSource()).alterarTrajecto();
			}

			public void mouseClicked(MouseEvent m) {	
				((Elemento) m.getSource()).alterarTrajecto();
			}

			public void mouseExited(MouseEvent m) {}

			public void mouseEntered(MouseEvent m) {
				if( ((Elemento) m.getSource()).pressed() )
						((Elemento) m.getSource()).alterarTrajecto();
			}
		});
	}

	public boolean pressed(){
		return pressed;
	}
	public void pressed(boolean p){
		pressed = p;
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

	public abstract void alterarTrajecto();
	public void corrigirCanto(int x, int y){}


	public boolean podeEntrar(int currentValue){

		if(Jogo.tabuleiro().trajecto().contem(this))
			return false;

		Elemento ultimo = Jogo.tabuleiro().trajecto().ultimo();

		if(Math.abs(ultimo.getTabX()-x)>1 || Math.abs(ultimo.getTabY()-y)>1)
			return false;

		if(Math.abs(ultimo.getTabX()-x)==1 && Math.abs(ultimo.getTabY()-y)!=0)
			return false;

		if(Math.abs(ultimo.getTabY()-y)==1 && Math.abs(ultimo.getTabX()-x)!=0)
			return false;

		return true;
	}
}