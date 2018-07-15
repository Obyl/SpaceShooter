package me.obyl.ss.gfx;

import me.obyl.ss.Game;
import me.obyl.ss.entities.Enemy;
import me.obyl.ss.entities.SuperEnemy;
import me.obyl.ss.entities.projectiles.SpaceRock;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Level {
	private int renderId = 0;
	private ArrayList<Enemy> enemies = new ArrayList<>();
	private ArrayList<SpaceRock> rocks = new ArrayList<>();
	private ArrayList<SuperEnemy> sEnemies = new ArrayList<>();
	
	public void tick(){
		renderId = new Random().nextInt(100);
		
		if(renderId == 1){
			enemies.add(new Enemy((new Random().nextInt(10) + 1) * Game.tileSize, 0, 10, 10));
		}
		for(Enemy e : enemies){
				e.tick();
		}

		if(renderId == 3 && Game.player.enemiesShot >= 50){
			sEnemies.add(new SuperEnemy((new Random().nextInt(10) + 1) * Game.tileSize, 0, 20, 20));
		}
		for(SuperEnemy se : sEnemies){
				se.tick();
		}
		if(renderId == 2){
			rocks.add(new SpaceRock((new Random().nextInt(10) + 1) * Game.tileSize, 0, 10, 10));
		}
		for(SpaceRock r : rocks){
				r.tick();
		}
	}
	
	public void render(Graphics g){
		for(Enemy e : enemies){
			e.render(g);
		}
		for(SpaceRock r : rocks){
			r.render(g);
		}
		for(SuperEnemy se : sEnemies){
			se.render(g);
		}
	}
}
