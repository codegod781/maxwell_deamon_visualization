package maxwellDeamon;

import java.awt.Color;
import java.awt.Graphics;

public class Particle {
	
	double x, y;
	double vx, vy;
	double oldx, oldy;
	public Particle() 
	{
		x = (int) (Math.random() * 400 + 100); // [100, 500)
		y = (int) (Math.random() * 400 + 100);
		vx = (int) (Math.random() * 100 - 50); // [-50, 50)
		vy = (int) (Math.random() * 100 - 50);
	}
	public Particle(int xClick, int yClick) 
	{
		x = xClick;
		y = yClick;
		vx = (int) (Math.random() * 100 - 50); // [-50, 50)
		vy = (int) (Math.random() * 100 - 50);
	}
	public void move(double delta) 
	{
		oldx = x;
		oldy = y;
		x += vx * delta;
		y += vy * delta;
		stayOnScreen();
	}
	public void stayOnScreen() 
	{
		// Check bounces off each edge of screen
		if (x < 0)
		vx *= -1;
		if (x > 550)
		vx *= -1;
		if (y < 0)
		vy *= -1;
		if (y > 550)
		vy *= -1;
	}
	// Balls draw themselves at current position
	public void draw(Graphics g) 
	{
		g.setColor(Color.black);
		g.fillOval((int) (x - 2), (int) (y - 2), 5, 5);
		// g.drawString("("+vx+";"+vy+")", (int) x, (int) (y+12));
	}
	
	
	
}
