package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class Ping {
double xVel, yVel, x, y;

public Ping() {
	x = 350;
	y = 250;
	xVel = 2;
	yVel = -2;
}
public void draw(Graphics g) {
	g.setColor(Color.red);
	g.fillOval((int)x-5, (int)y-5, 25, 25);
	
}

public void hitMyPaddle(MyPaddle p1) {
	if(x <= 40)
		if(y >= p1.getY() && y <= p1.getY() + 60)
			xVel = -xVel;
}

public void move() {
	x += xVel;
	y += yVel;
	if(y < 20)
		yVel = -yVel;
	if(y > 480)
		yVel =-yVel; 
	if( x < 20)
		xVel = -xVel;
	if(x > 680)
		xVel = -xVel;
}
public int getx() {
	return (int)x;
	
}
public int gety() {
	return (int)y;
	
}
}
