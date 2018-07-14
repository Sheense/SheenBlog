package priv.MyBlog.util;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import org.apache.log4j.SimpleLayout;
public class LogUtil {

	private static Logger logger=null;

	private static <T> Logger getLogger(Class<T> cl) {
		SimpleLayout layout = new SimpleLayout();
        FileAppender appender = null;
        try {
             appender = new FileAppender(layout, "myApacheLog.log", false);
        } catch (Exception e) {
        }
        logger= Logger.getLogger(cl);
        logger.addAppender(appender);
        // Set the logger level to Level.INFO
        logger.setLevel(Level.INFO);
		return logger;
	}
	public static <T> void debug(Class<T> cl,String message) {
		getLogger(cl).debug(message);
	}
	
	public static <T> void info(Class<T> cl,String message) {
		getLogger(cl).info(message);
	}
	
	public static <T> void warn(Class<T> cl,String message) {
		getLogger(cl).warn(message);
	}
	
	public static <T> void fatal(Class<T> cl,String message) {
		getLogger(cl).fatal(message);
	}
	
}
