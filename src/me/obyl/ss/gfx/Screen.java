package me.obyl.ss.gfx;

import me.obyl.ss.Game;
import me.obyl.ss.gfx.tiles.SkyTile;

import java.awt.Graphics;

public class Screen {
	public int width;
	public int height;
	public int worldW = 15;
	public int worldH = 11;
	
	public SkyTile[][] tile = new SkyTile[worldW][worldH];

	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		for(int x = 0; x < tile.length; x++){
			for(int y = 0; y < tile[0].length; y++){
				tile[x][y] = new SkyTile(x * Game.tileSize, y * Game.tileSize, Game.tileSize, Game.tileSize);
			}
		}
	}
	
	public void render(Graphics g, int camX, int camY, int renW, int renH){
		for(int x = (camX / Game.tileSize); x < (camX / Game.tileSize) + renW; x++){
			for(int y = (camY / Game.tileSize); y < (camY / Game.tileSize) + renH; y++){
				
				if(x >= 0 && y >= 0 && x < worldW && y < worldH){
					tile[x][y].render(g);
				}
			}
		}
	}
}
