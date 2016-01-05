package test;

import log4j.subpkg.SubClass;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class TestPatternLayout {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("log4j");
		String pattern = "%r [%t] %-5p %c - %m%n";
		pattern = "%d{ABSOLUTE} %5p %c{1}:%L - %m%n";
		logger.addAppender(new ConsoleAppender(new PatternLayout(pattern)));
		Logger l = Logger.getLogger(SubClass.class);
		l.info("info........");
		l.error("error.......");
	}
}
