package me.obyl.ss.entities;

import me.obyl.ss.Game;
import me.obyl.ss.entities.projectiles.Missile;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

public class Player extends Rectangle{
	public int sY = 0;
	public double xdir = 0;
	public boolean dead = false;
	public int enemiesShot = 0;
	
	public ArrayList<Missile> missiles = new ArrayList<Missile>();
	
	private Image player;
	
	public Player(int x, int y, int width, int height){
		setBounds(x, y, width, height);

		try {
			player = ImageIO.read(Player.class.getResourceAsStream("/player.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void tick(){
		x += xdir;
		if(x < 0) x = 0;
		if((x + 10) > Game.pixel.width) x = Game.pixel.width - 10;
		for(Missile m : missiles){
			m.tick();
		}
	}
	
	public void render(Graphics g){
		if(!dead){
			g.drawImage(player, x, y, null);
			for(Missile m : missiles){
				if(!m.hit){
					g.setColor(Color.ORANGE);
					g.fillRect(m.x, m.y, m.width, m.height);
				}
			}
		}
		if(dead){
			g.setFont(new Font("SansSerif", Font.PLAIN, 50));
			g.setColor(Color.RED);
			g.drawString("You died!", 0, 0);
		}
		
	} 
	
	public void setXDir(double dir){
		xdir = dir;
	}
	
	public void shoot(){
		missiles.add(new Missile(x + 4, y - 2, 1, 2));
	}
}
