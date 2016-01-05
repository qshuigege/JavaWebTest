package cn.itcast.oa.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	
	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	//测试spring
	@Test
	public void testBean(){
		TestAction action = (TestAction)ac.getBean("testAction");
		System.out.println(action);
	}
	
	
	//测试sessionFactory
	@Test
	public void testSessionFactory(){
		System.out.println(ac.getBean("sessionFactory"));
	}
	
	//测试事务管理
	@Test
	public void testTX(){
		TestService service = (TestService)ac.getBean("testService");
		service.saveTwoUsers();
	}
}
