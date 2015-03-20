package logic.geom;

public class CircleIntersection {

	public static Point[] getIntersection(Circle C1,Circle C2){
		double x=C1.getCenterX();
		double y=C1.getCenterY();
		double R=C1.getRadius();
		double a=C2.getCenterX();
		double b=C2.getCenterY();
		double S=C2.getRadius();
		Point c=new Point();
		Point d=new Point();
		double[] inter=CircleIntersection.getIntersection(x, y, R, a, b, S);
		c.setIdA(C1.getId());
		c.setIdB(C2.getId());
		c.setX(inter[0]);
		c.setY(inter[1]);
		d.setIdA(C1.getId());
		d.setIdB(C2.getId());
		d.setX(inter[2]);
		d.setY(inter[3]);
		return new Point[]{c,d};
	}
	
	public static Point2[] getIntersection(Circle2 c1,Circle2 c2){
		double[] inter=CircleIntersection.getIntersection(c1.x, c1.y, c1.r, c1.x, c2.y, c2.r);
		Point2 c=new Point2();
		Point2 d=new Point2();
		c.id_no.put(c1.id, null);
		c.id_no.put(c2.id, null);
		d.id_no.put(c1.id, null);
		d.id_no.put(c2.id, null);
		c.x=(int) inter[0];
		c.y=(int) inter[1];
		d.x=(int) inter[2];
		d.y=(int) inter[3];
		return new Point2[]{c,d};
	}
	
	private static double[] getIntersection(double x,double y,double R,double a,double b,double S){
		double Xc,Xd,Yc,Yd;
		double L=Math.sqrt((x-a)*(x-a)+(y-b)*(y-b));
		double X0=x+(a-x)*(R*R-S*S+L*L)/(2*L*L);
		double Y0=y+(b-y)*(R*R-S*S+L*L)/(2*L*L);
		double R2=Math.sqrt(R*R-(X0-x)*(X0-x)-(Y0-y)*(Y0-y));
		if(a==x){
			Xc=X0+R2;
			Yc=Y0;
			Xd=X0-R2;
			Yd=Y0;
		}else if(b==y){
			Xc=X0;
			Yc=Y0+R2;
			Xd=X0;
			Yd=Y0-R2;
		}else{
			double k1=(b-y)/(a-x);
			double K2=-1/k1;
			Xc=X0-R2*Math.sqrt(1/(1+K2*K2)); 
			Yc=Y0+K2*(Xc-X0); 
			Xd=X0+R2*Math.sqrt(1/(1+K2*K2)); 
			Yd=Y0+K2*(Xd-X0);
		}
		return new double[]{Xc,Yc,Xd,Yd};
	}
	
	public static boolean isMeet(Circle a,Circle b){
		double x=a.getCenterX()-b.getCenterX();
		double y=a.getCenterY()-b.getCenterY();
		double d=x*x+y*y;
		double rAdd=a.getRadius()+b.getRadius();
		double rMinus=a.getRadius()-b.getRadius();
		if(d>rAdd*rAdd)
			return false;
		else if(d<rMinus*rMinus)
			return false;
		else
			return true;
	}
	
}
