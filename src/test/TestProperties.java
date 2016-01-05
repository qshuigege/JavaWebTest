package test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestProperties {
	public static void main(String[] args) {
		try{
		PropertyConfigurator.configure(TestProperties.class.getClassLoader().getResourceAsStream("log4j.properties"));
		}catch(Exception e){
			System.out.println(e);
		}
		Logger log = Logger.getLogger("log4j.subpkg");
		log.debug("debug..........");
		log.info("info..........");
		log.warn("warn..........");
	}
}
