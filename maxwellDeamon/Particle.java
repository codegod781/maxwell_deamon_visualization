package maxwellDeamon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;


public class Particle {
	
	//particle data members
	String type;
	double x, y;
	double vx, vy, vtot;
	double oldx, oldy;
	boolean gateOpen;
	int resolution = Toolkit.getDefaultToolkit().getScreenResolution(); 

	
	public Particle(String typeGiven, String side)
	{
		type = typeGiven;
		if(typeGiven.equals("hot"))
		{

			boolean notYet = true;
			//create while loop to produce a speed between the given ranges
			while(notYet)
			{
				vx = (int) (Math.random()*80-40); // [-50, 50)
				vy = (int) (Math.random()*80-40);
				vtot= Math.sqrt(Math.pow(vx, 2)+Math.pow(vy, 2));
				System.out.println("speed:" + vtot);
				if(vtot>40 && vtot<60)
				{
					notYet = false;
				}
			}
		}
		
		if(typeGiven.equals("cold"))
		{
			vx = (int) (Math.random()*80-40); // [-50, 50)
			vy = (int) (Math.random()*80-40);
			
			boolean notYet = true;
			while(notYet)
			{
				vx = (int) (Math.random()*80 - 40); // [-50, 50)
				vy = (int) (Math.random()*80 - 40);
				vtot= Math.sqrt(Math.pow(vx, 2)+Math.pow(vy, 2));
				System.out.println("speed:" + vtot);
				if(vtot>20 && vtot<40)
				{
					notYet = false;
				}
			}
		}

			
			
		if(side.equals("left"))
		{
			x = (int) (Math.random() * 148 + 150); // [100, 500)
			y = (int) (Math.random() * 300 + 150);
		}
		if(side.equals("right"))
		{
			x = (int) (Math.random() * 152 + 298); // [100, 500)
			y = (int) (Math.random() * 300 + 150);
		}
	}


	
	//create particle at given location (NOT USED)
	public Particle(int xClick, int yClick) 
	{
		System.out.println("resolution:" + resolution);
		type = "hot";
		x = xClick;
		y = yClick;
		boolean i = true;
		while(i)
		{
			vx = (int) (Math.random()*2.3622*resolution*2 - 2.3622*resolution*2); // [-50, 50)
			vy = (int) (Math.random()*2.3622*resolution*2 - 2.3622*resolution*2);
			double vtot= Math.sqrt(Math.pow(vx, 2)+Math.pow(vy, 2));
			System.out.println("speed:" + vtot);
			if(vtot>1.5748*resolution && vtot<2.3662*resolution)
			{
				i = false;
			}
		}
	}
	
	public void move(double delta) 
	{
		oldx = x;
		oldy = y;
		x += vx * delta;
		y += vy * delta;
		//distinguish between open and closed gate
		if(gateOpen==true) 
		{
			stayOnScreenOpen();
		}
		else if(gateOpen==false)
		{
			stayOnScreenClosed();
		}
	}
	
	
	public void stayOnScreenClosed() 
	{
		// Check bounces off each edge of screen
		if (x < 150)
			vx *= -1;
		if(x>297&&x<303)
			vx *= -1;
		if (x > 450)
			vx *= -1;
		if (y < 150)
			vy *= -1;
		if (y > 450)
			vy *= -1;
	}	
	
	public void stayOnScreenOpen() 
	{
		// Check bounces off each edge of screen
		if (x < 150)
			vx *= -1;
		//go through gate opening
		if (x>297&&x<303&&y>150&&y<225)
			vx *= -1;
		if (x>297&&x<303&&y>375&&y<450)
			vx *= -1;
		if (x > 450)
			vx *= -1;
		if (y < 150)
			vy *= -1;
		if (y > 450)
			vy *= -1;
	}	
	
	// Balls draw themselves at current position
	public void draw(Graphics g) 
	{
		if(type.equals("cold"))
		{
			g.setColor(Color.blue);
			g.fillOval((int) (x - 2), (int) (y - 2), 5, 5);
		}
		else 
		{
			g.setColor(Color.red);
			g.fillOval((int) (x - 2), (int) (y - 2), 5, 5);
		}

	}
	
	
	
}
