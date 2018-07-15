package me.obyl.ss.entities;

import me.obyl.ss.Game;
import me.obyl.ss.entities.projectiles.Missile;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

public class SuperEnemy extends Rectangle{
	private static Image superEnemy;

	static {
		try {
			superEnemy = ImageIO.read(SuperEnemy.class.getResourceAsStream("/superEnemy.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean dead = false;
	public int health = 2;
	
	public SuperEnemy(int x, int y, int width, int height){
		setBounds(x, y, width, height);
	}
	
	public void tick(){
		if(!dead){
			y += 1;
			for(Missile m : Game.player.missiles){
				if(!m.hit){
					if(contains(new Point(m.x, m.y))){
						m.hit = true;
						health--;
					}
				}
			}
			if(health == 0){
				dead = true;
				Game.player.enemiesShot += 2;
			}
		}
	}
	
	public void render(Graphics g){
		if(!dead){
			if((y + 20) < Game.pixel.height - Game.inventHeight){
				g.drawImage(superEnemy, x, y, width, height, null);
			}
		}
	}
}
