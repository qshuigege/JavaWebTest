package test;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class TestRoot {
	public static void main(String[] args) {
		Logger rootLogger = Logger.getRootLogger();
		Logger logger = Logger.getLogger("root");
		System.out.println(rootLogger == logger);
		System.out.println(rootLogger.getName());
		System.out.println(logger.getName());
		String pattern = "%r [%t] %-5p %c - %m%n";
		pattern = "%d{ABSOLUTE} %5p %c{1}:%L - %m%n";
		logger.addAppender(new ConsoleAppender(new PatternLayout(pattern)));
		logger.info("info....");
	}
}
