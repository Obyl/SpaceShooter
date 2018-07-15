package me.obyl.ss;

import me.obyl.ss.entities.Player;
import me.obyl.ss.gfx.Level;
import me.obyl.ss.gfx.Screen;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class Game extends Canvas implements Runnable{
	public static boolean running = false;

	public static int pixelSize = 4;
	public static int inventHeight = 20;
	public static int tileSize = 10;
	
	public static Dimension size = new Dimension(600, 500);
	public static Dimension pixel = new Dimension(size.width / pixelSize, (size.height / pixelSize));
	
	public static String title = "SpaceShooter";
	
	private Image img;
	
	public static Screen screen;
	public static Player player;
	public static Level level;
	
	public Game(){
		setMinimumSize(size);
		setMaximumSize(size);
		setPreferredSize(size);

		addKeyListener(new Listening());
	}
	
	public void init(){
		img = createVolatileImage(pixel.width, pixel.height);
			
		screen = new Screen(pixel.width, pixel.height);
		player = new Player((pixel.width / 2) - 5, pixel.height - 40, 15, 15);
		level = new Level();
	}
	
	public void start(){
		 running = true;
		 new Thread(this).start();
	}
	
	public void stop(){
		running = false;
	}
	
	public void run(){
		init();
		while(running){
			tick();
			render();
			
			try{
				Thread.sleep(10);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void tick(){
		player.tick();
		level.tick();
	}
	
	public void render(){
		Graphics g = img.getGraphics();
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, pixel.width, pixel.height);
		g.fillRect(0, pixel.height - inventHeight, pixel.width, inventHeight);
		screen.render(g, 0, player.sY, (pixel.width / tileSize) + 2, (pixel.height / tileSize) + 2);
		level.render(g);
		player.render(g);
		g.setFont(new Font("SansSerif", Font.PLAIN, 10));
		g.setColor(Color.BLACK);
		g.drawString("Score:" + player.enemiesShot, 0, pixel.height - 7);
		g.drawString("| SpaceShooter", (pixel.width / 2) - 10, pixel.height - 7);
		
		if(player.dead){
			g.setColor(Color.RED);
			g.drawString("You died!", (pixel.width / 2) - 20, pixel.height / 2);
		}
		
		g = getGraphics();
		
		g.drawImage(img, 0, 0, size.width, size.height, null);
		g.dispose();
	}
	
	public static void main(String args[]){
		JFrame frame = new JFrame(title);
		Game game = new Game();
		
		frame.setResizable(false);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		game.start();
		frame.setVisible(true);
	}
}
