package Pong;

import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Applet implements Runnable, KeyListener {
	final int WIDTH = 700, HEIGHT = 500;
	Thread thread;
	MyPaddle p1;
	Ping b1;
	public void init() {
		this.resize(WIDTH, HEIGHT);
		
		this.addKeyListener(this);
		p1 = new MyPaddle(1);
		b1 = new Ping();
		thread = new Thread(this);
		thread.start();
	}
	public void paint(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		if(b1.getx() <= 30) {
			g.setColor(Color.white);
		g.drawString("Oof!", 350,250);
		}
		else
		p1.draw(g);
		b1.draw(g);

	}
	public void update(Graphics g) {
		paint(g);
	}
	public void run() {
		for(;;) {
			p1.move();
			b1.move();
			b1.hitMyPaddle(p1);
			
		repaint();
	try {
		Thread.sleep(10);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
		}
	}
	public void keyTyped(KeyEvent e) {
		
		
	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setupAcl(true);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setdownAcl(true);
		}
		
	}
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setupAcl(false);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setdownAcl(false);
		}
		
	}
}
