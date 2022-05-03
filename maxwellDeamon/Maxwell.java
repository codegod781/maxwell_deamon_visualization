package maxwellDeamon;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Maxwell {
	
	// Bounce owns the MODEL -- state of the balls
			Particle[] particles;
			int particleCount;
			int gateCount = 0;
			

			// Bounce also owns the VIEW objects -- displaying the balls
			JFrame f;
			Game gamePanel;
//			boolean gateOpen;

			JPanel buttonPanel, tempPanel;
			JButton addParticle,reset;
			JButton tempLeft, tempRight;
			
			double tempL, tempR;



			
			
			
			public static void main(String[] args) {
				new Maxwell();
			}
			
			public Maxwell() {
				f = new JFrame();
				

				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setTitle("Maxwell's Demon");
				f.setSize(600, 600);

				int width = f.getWidth();
				int height = f.getHeight();

		
				
				// Initialize the model
				particleCount = 4;
				particles = new Particle[100];
				particles[0] = new Particle("cold", "left");
				particles[1] = new Particle("hot", "left");
				particles[2] = new Particle("cold", "right");
				particles[3] = new Particle("hot", "right");
				
				
				
				
				
				
				buttonPanel = new JPanel();
				tempPanel = new JPanel();
				
				addParticle = new JButton("Add Particles");
				reset = new JButton("Reset");
				
				tempLeft = new JButton("Temp Left: " + tempL);
				tempRight = new JButton("Temp Right");
				
				buttonPanel.setBackground(Color.gray);
				tempPanel.setBackground(Color.pink);
				f.add(buttonPanel, BorderLayout.SOUTH);
				f.add(tempPanel, BorderLayout.NORTH);

				
				buttonPanel.setLayout(new GridLayout(1,2));
				tempPanel.setLayout(new GridLayout(1,2));
				
				tempPanel.add(tempLeft);
				tempPanel.add(tempRight);

				buttonPanel.add(reset);
				buttonPanel.add(addParticle);
				ButtonListener b = new ButtonListener();
				reset.addActionListener(b);
				addParticle.addActionListener(b);
				reset.setActionCommand("reset");
				addParticle.setActionCommand("addParticle");
				addParticle.setVisible(true);
				reset.setVisible(true);


//				for (int i = 0; i < particleCount; i++) 
//				{
//					particles[i] = new Particle();
//				}
				
				// Create the play area
				gamePanel = new Game(width, height);
				f.add(gamePanel);
				
//				An anonymous MouseAdapter to add new balls
				gamePanel.addMouseListener( new MouseAdapter() 
				{
					public void mouseClicked(MouseEvent e) 
					{
//						int x = e.getX();
//						int y = e.getY();
//						System.out.println("count: " + gateCount);
//						if (particleCount < 100 && 150<x && x<450 && 150<y&& y<450) 
//						{
							if(gateCount%2 == 0)
							{
								System.out.println("set true ");
								gamePanel.gateOpen=true;
								gateCount++;
							}
							else if(gateCount%2!=0)
							{
								System.out.println("set false");
								gamePanel.gateOpen=false;
								gateCount++;
							}
//							particles[particleCount++] = new Particle(e.getX(), e.getY());
//						}
					}
				}
				);
				
				// Create a timer
				Timer tick = new Timer(10, new Animator());
				tick.start();
				f.setVisible(true);
			}
			
			
			
			// Game is part of the VIEW -- it displays the current ball positions
			public class Game extends JPanel 
			{
				int width, height;
				boolean gateOpen;
				public Game(int w, int h)
				{
					width = w;
					height = h;
				}
				@Override
				public void paintComponent(Graphics g) 
				{
					// Jpanel.paintComponent is too slow, so we just draw a white rectangle over everything
				    // super.paintComponent(g);
				    g.setColor(Color.white);
				    g.fillRect(width/4,height/4,width/2,height/2);
				    g.setColor(Color.black);
				    g.drawRect(width/4-1,height/4-1,width/2+1,height/2+1);
				    g.drawLine(width/2, height/4, width/2, height*3/8);
				    g.drawLine(width/2, height*5/8, width/2, height*3/4);
//					System.out.println("count: " + gateOpen);
				    if(gateOpen == true)
					{
						g.setColor(Color.white);
					    g.drawLine(width/2, height*3/8, width/2, height*5/8);
					}
					else
					{
						g.setColor(Color.green);
					    g.drawLine(width/2, height*3/8, width/2, height*5/8);
					}
//				    g.setColor(Color.green);
//				    g.drawLine(width/2, height*3/8, width/2, height*5/8);
					for (int i = 0; i < particleCount; i++) 
					{
						particles[i].draw(g);
					}
				} 
//				public void gateDo()
//				{
//					this.gate(Graphics g);
//				}
				public void gate(Graphics g)
				{
					if(gateOpen == false)
					{
						g.setColor(Color.white);
					    g.drawLine(width/2, height*3/8, width/2, height*5/8);
					    gateOpen = true;
					}
					else
					{
						g.setColor(Color.green);
					    g.drawLine(width/2, height*3/8, width/2, height*5/8);
					    gateOpen = false;
					}
				}
			}
			
			
			
			class ButtonListener implements ActionListener 
	    	{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					if ( e.getActionCommand().equals("addParticle")) 
					{
						System.out.println("boobs");

//						addParticle.setVisible(false);
						particles[particleCount++] = new Particle("cold", "left");
						particles[particleCount++] = new Particle("hot", "left");
						particles[particleCount++] = new Particle("cold", "right");
						particles[particleCount++] = new Particle("hot", "right");
						for(int i=0; i<particleCount; i++)
						{
							 tempL=tempL+particles[i].vtot;
						}					
						
					}
					else if ( e.getActionCommand().equals("reset")) 
					{		
						for(int i=0; i<particleCount; i++)
						{
							 particles[i]=null;
						}
						

						
						particles[0] = new  Particle("cold", "left");
						particles[1] = new Particle("hot", "left");
						particles[2] = new Particle("cold", "right");
						particles[3] = new Particle("hot", "right");
						
						particleCount = 4;
					}
//					else 
//					{
//						blueButton.setVisible(false);
//						colorPanel.setBackground(Color.blue);
//						redButton.setVisible(true);
//					}
		
		
				}
	    	}
			
			
			// Animator is the CONTROLLER -- it responds to events
			public class Animator implements ActionListener 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					int numL = 0;
					int numR = 0;

					tempL=0;
					tempR=0;
					
					for (int i = 0; i < particleCount; i++) 
					{
						particles[i].move(0.1);
						particles[i].gateOpen = gamePanel.gateOpen;
//						System.out.println("boobs: "+particles[i].vtot);
						
						if(particles[i].x<298)
						{
							tempL=particles[i].vtot+tempL;
							numL++;
						}
						if(particles[i].x>302)
						{
							tempR=particles[i].vtot+tempR;
							numR++;
						}
						
					}
					
					tempLeft.setText("Temp Left: "+ tempL/(numL));
					tempRight.setText("Temp Right: "+ tempR/(numR));
					gamePanel.repaint();
				}
			}

}
