package me.obyl.ss.entities.projectiles;

import me.obyl.ss.Game;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

public class SpaceRock extends Rectangle{
	private static Image rock;

	static {
		try {
			rock = ImageIO.read(SpaceRock.class.getResourceAsStream("/rock.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public SpaceRock(int x, int y, int width, int height){
		setBounds(x, y, width, height);
	}
	
	public void tick(){
		for(Missile m : Game.player.missiles){
			if(!m.hit){
				if(contains(new Point(m.x, m.y))){
					m.hit = true;
				}
			}
		}
		if(contains(new Point(Game.player.x, Game.player.y))){
			Game.player.dead = true;
		}
		y++;
	}
	
	public void render(Graphics g){
		if((y + 10) < Game.pixel.height - Game.inventHeight){
			g.drawImage(rock, x, y, width, height, null);
		}
	}
}
