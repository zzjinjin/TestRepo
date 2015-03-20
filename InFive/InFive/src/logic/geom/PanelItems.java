package logic.geom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PanelItems {

	long seed=100;
	int circleNumber=15;
	double xRange=600;
	double yRange=600;
	double radiusMax=100;
	
	private Circle[] circles=new Circle[circleNumber];
	private Point[] crossPoints=new Point[2];
	
	public PanelItems(){
		this.generteRandomCircles();
		this.generateCrossPoints();
	}
	
	private void generteRandomCircles(){
		Random rand=new Random();
		for(int i=0;i<circleNumber;i++){
			circles[i]=new Circle();
			circles[i].setId(i);
			circles[i].setCenterX(rand.nextDouble()*xRange);
			circles[i].setCenterY(rand.nextDouble()*yRange);
			double r=0;
			while(r<10){
				r=(rand.nextGaussian()+0.9)*(radiusMax);
//				System.out.println(r);
			}
			circles[i].setRadius(r);
		}
	}
	
	private void generateCrossPoints(){
		List<Point> points=new ArrayList<Point>();
		for(int i=1;i<circleNumber;i++){
			for(int j=0;j<i;j++){
				if(CircleIntersection.isMeet(circles[i],circles[j])){
					Point[] inter=CircleIntersection.getIntersection(circles[i],circles[j]);
					if(inter.length==2){
						points.add(inter[0]);
						points.add(inter[1]);
					}
				}
			}
		}
		crossPoints=points.toArray(crossPoints);
	}
	
	public Circle[] getCircles(){
		return this.circles;
	}
	
	public Point[] getCrossPoints(){
		return this.crossPoints;
	}
}
