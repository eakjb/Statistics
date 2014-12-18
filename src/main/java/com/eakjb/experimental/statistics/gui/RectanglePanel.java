package com.eakjb.experimental.statistics.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JComponent;

public class RectanglePanel extends JComponent {
	private static final long serialVersionUID = 774398589835078735L;
	
	private Rectangle rect;
	
	public RectanglePanel() {
		rect=new Rectangle(0,0,150,150);
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics;
		
		g.draw(rect);
	}
	
	public void randomize() {
		Random r = new Random();
		rect=new Rectangle(r.nextInt(100),r.nextInt(100),r.nextInt(200),r.nextInt(200));
	}
	
	public Rectangle getRect() {
		return rect;
	}
}
