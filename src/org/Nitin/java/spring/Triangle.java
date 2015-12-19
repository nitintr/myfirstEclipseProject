package org.Nitin.java.spring;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/*First Changes */
/*Second Changes */
/*Third Change - Started */

/*Third Change - Ended */

public class Triangle implements ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean{
	private String beanName;
	
	private String type;
	private int height;
	
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	private List<Point> points;
	
	private ApplicationContext context=null;
	
	public List<Point> getPoints() {
		return points;
	}

	@Autowired
	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public String getBeanName() {
		return beanName;
	}

	
	public Triangle()
	{
		  
	}
	
	public Triangle(String type)
	{
		this.type = type;  
	}
	
	public Triangle(String type,int height)
	{
		this.type = type;  
		this.height = height;
	}
	
	public Triangle(int height)
	{
		this.height = height;  
	}
	
	public void draw()
	{
		System.out.println(getType() + " Trangle Drawn " + "of height " + getHeight() );
		if(getPointA() == null) System.out.println("Point A is null"); else System.out.println("Point A:(" + getPointA().getX() + ", "+ getPointA().getY() + ")");
		if(getPointB() == null) System.out.println("Point B is null"); else System.out.println("Point B:(" + getPointB().getX() + ", "+ getPointB().getY() + ")");
		if(getPointC() == null) System.out.println("Point C is null"); else System.out.println("Point C:(" + getPointC().getX() + ", "+ getPointC().getY() + ")");
		if(getPoints() != null) 
		{
			for (Point point: points)
			{
				System.out.println("Point:(" + point.getX() + ", "+ point.getY() + ")");
			}
		}
		else
		{
			System.out.println("Points is Null");
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
		
	}

	@Override
	public void setBeanName(String beanName) {
		System.out.println("Bean Name is :" + beanName);
		this.beanName = beanName;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Bean has been Initialized!!" + getBeanName());
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Bean has been destroyed via disposableBeans!! " + getBeanName());
		
	}
}
