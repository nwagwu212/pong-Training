package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class MyPaddle implements Paddle {
double y, yVel;
boolean upAcl, downAcl;
int player, x;

	public MyPaddle(int player) {
		upAcl = false;
		downAcl = false;
		y = 210;
		yVel = 0;
		if( player == 1) 
	x = 20;
	else
		x = 660;
	}
	public void draw(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(x, (int)y, 15, 60);
		
	}

	
	public void move() {
		if(upAcl) {
		yVel -= 1;	
		}
		else if(downAcl) {
			yVel += 1;
		}
		else if(!upAcl && !downAcl) {
			
		}
		if( yVel >= 3)
			yVel = 3;
		else if( yVel <= -3) 
			yVel = -3;
		y += yVel;
		
		if(y < 0)
		y = 0;
		if(y > 440)
			y = 440;
	
	}

	public void setupAcl( boolean input) {
		upAcl = input;
	}
	public void setdownAcl(boolean input) {
		downAcl = input;
	}
	
	public int getY() {
		return (int)y;
		
	}

}
