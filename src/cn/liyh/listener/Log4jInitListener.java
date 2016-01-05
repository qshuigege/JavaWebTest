package cn.liyh.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log4jInitListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//PropertyConfigurator.configure(this.getClass().getClassLoader().getResourceAsStream("log4j.properties"));
		String realPath = arg0.getServletContext().getRealPath("/");//+"/log4j.xml");
		DOMConfigurator.configure(realPath + "WEB-INF\\classes\\log4j.xml");
		if(Logger.getLogger(this.getClass())!=null){
			Logger.getLogger(this.getClass()).debug("log4j初始化成功");
		}
	}

}
