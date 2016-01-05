package log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class Main {
	public static Logger log4j_Main = Logger.getLogger(Main.class);
	public static void main(String[] args) {
		BasicConfigurator.configure();
		Logger log4j = Logger.getLogger("log4j");
		log4j.addAppender(new ConsoleAppender(new SimpleLayout()));
		log4j.setAdditivity(true);
		Logger log4j_subpkg = Logger.getLogger("log4j.subpkg");
		log4j_subpkg.addAppender(new ConsoleAppender(new SimpleLayout()));
		log4j_subpkg.setAdditivity(true);
		Logger log4j_subpkg_SubClass = Logger.getLogger("log4j.subpkg.SubClass");
		log4j_subpkg_SubClass.debug("log4j.subpkg.SubClass:......");
		Logger aaa = Logger.getLogger("aaa");
		aaa.debug("aaa:......");
		
	}
}
