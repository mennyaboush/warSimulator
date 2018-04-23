import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import model.*;
import java.lang.reflect.*;
import com.sun.org.apache.bcel.internal.generic.LUSHR;

import model.AbstractLauncher;

public class myLogger {
	private static Logger logger = Logger.getLogger("myLogger");
	
	static{

	}
	
	public Logger getInstance() {
		return logger;
	}

}
