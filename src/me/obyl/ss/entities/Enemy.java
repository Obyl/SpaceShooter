package me.obyl.ss.entities;

import me.obyl.ss.Game;
import me.obyl.ss.entities.projectiles.Missile;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

public class Enemy extends Rectangle{
	private static Image enemy;

	static {
		try {
			enemy = ImageIO.read(Enemy.class.getResourceAsStream("/enemy.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean dead = false;
	
	public Enemy(int x, int y, int width, int height){
		setBounds(x, y, width, height);
	}
	
	public void tick(){
		y++;
		for(Missile m : Game.player.missiles){
			if(!m.hit){
				if(contains(new Point(m.x, m.y))){
					dead = true;
					m.hit = true;
					Game.player.enemiesShot++;
				}
			}
		}
	}
	
	public void render(Graphics g){
		if(!dead){
			if((y + 10) < Game.pixel.height - Game.inventHeight){
				g.drawImage(enemy, x, y, width, height, null);
			}
		}
	}
}
