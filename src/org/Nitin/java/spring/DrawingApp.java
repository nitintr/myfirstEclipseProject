 package org.Nitin.java.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

@SuppressWarnings("deprecation")
public class DrawingApp {

	public static void main(String[] args) {
		
		Triangle triangle = new Triangle("Equi");
		triangle.draw();
		
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		Triangle triangleBeanFactory = (Triangle) factory.getBean("triangleBean");
		
		triangleBeanFactory.draw();
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("springAppContext.xml");
		System.out.println("---------------------------------");		
		Triangle triangleBeanAppContext = (Triangle) context.getBean("triangleBean");
		triangleBeanAppContext.draw();
		System.out.println("---------------------------------");
		System.out.println("AutoWire!!!");
		triangleBeanAppContext = (Triangle) context.getBean("triangleBean-autowire");
		triangleBeanAppContext.draw();
		System.out.println("---------------------------------");
		System.out.println("Bean Inheritance!!!");
		triangleBeanAppContext = (Triangle) context.getBean("triangleBean1");
		triangleBeanAppContext.draw();
		System.out.println("---------------------------------");
		triangleBeanAppContext = (Triangle) context.getBean("triangleBean-autowire1");
		triangleBeanAppContext.draw();
		System.out.println("---------------------------------");
		triangleBeanAppContext = (Triangle) context.getBean("triangleBean-autowire2");
		triangleBeanAppContext.draw();	
		
		@SuppressWarnings("resource")
		AbstractApplicationContext contextAbstract = new ClassPathXmlApplicationContext("springAppContext.xml");
		System.out.println("---------------------------------");
		System.out.println("Abstract Application Context!!!");		
		contextAbstract.registerShutdownHook();
		Triangle triangleBeanAbsAppContext = (Triangle) contextAbstract.getBean("triangleBean");
		triangleBeanAbsAppContext.draw();

	}

}
