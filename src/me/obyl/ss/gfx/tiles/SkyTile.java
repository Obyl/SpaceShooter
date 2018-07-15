package me.obyl.ss.gfx.tiles;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

public class SkyTile extends Rectangle{
	private static Image skyImg;

	static {
		try {
			skyImg = ImageIO.read(SkyTile.class.getResourceAsStream("/sky.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public SkyTile(int x, int y, int width, int height){
		setBounds(x, y, width, height);
	}

	public void render(Graphics g){
		g.drawImage(skyImg, x, y, width, height, null);
	}
}
