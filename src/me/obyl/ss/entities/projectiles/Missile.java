package me.obyl.ss.entities.projectiles;

import java.awt.Rectangle;

public class Missile extends Rectangle{
	public boolean hit = false;
	
	public Missile(int x, int y , int width, int height){
		setBounds(x, y, width, height);
	}
	
	public void tick(){
		y--;
	}
}
