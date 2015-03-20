package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import logic.geom.Circle;
import logic.geom.PanelItems;
import logic.geom.Point;

public class ContentPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7140613491108716496L;
	
	PanelItems items=new PanelItems();

	public ContentPanel(){
		super();
		this.setBackground(Color.white);
	}
	
	public void paintComponent(Graphics  g){
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
//		Ellipse2D circle=new Ellipse2D.Double(10, 10, 200, 200);
//		g2.draw(circle);
		Circle[] circles=items.getCircles();
		for(int i=0;i<circles.length;i++)
			this.drawCircle(g2, circles[i]);
		Point[] points=items.getCrossPoints();
		for(int i=0;i<points.length;i++)
			this.drawPoint(g2, points[i]);
	}
	
	private void drawCircle(Graphics2D g,Circle c){
		Ellipse2D circle=new Ellipse2D.Double(c.getCenterX()-c.getRadius(),c.getCenterY()-c.getRadius(),2*c.getRadius(),2*c.getRadius());
		g.draw(circle);
	}
	
	private void drawPoint(Graphics2D g,Point c){
		Ellipse2D point=new Ellipse2D.Double(c.getX()-2,c.getY()-2,4,4);
		g.setColor(Color.red);
		g.fill(point);
	}
}
