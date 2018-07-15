package me.obyl.ss;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listening implements KeyListener{

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_D){
			Game.player.setXDir(1);
		}
		if(keyCode == KeyEvent.VK_A){
			Game.player.setXDir(-0.5);
		}
		if(keyCode == KeyEvent.VK_SPACE){
			Game.player.shoot();
		}
		if(keyCode == KeyEvent.VK_LEFT){
			Game.player.setXDir(-0.5);
		}
		if(keyCode == KeyEvent.VK_RIGHT){
			Game.player.setXDir(1);
		}
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_D){
			Game.player.setXDir(0);
		}
		if(keyCode == KeyEvent.VK_A){
			Game.player.setXDir(0);
		}
		if(keyCode == KeyEvent.VK_LEFT){
			Game.player.setXDir(0);
		}
		if(keyCode == KeyEvent.VK_RIGHT){
			Game.player.setXDir(0);
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
