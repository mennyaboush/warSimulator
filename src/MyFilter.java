import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

import model.AbstractLauncher;

public class MyFilter implements Filter{

	@Override
	public boolean isLoggable(LogRecord record) {
		Object o = new Object();
		Method func;
		try {
			func = o.getClass().getMethod(((AbstractLauncher)o).getFileName(), new Class[]{});
				String fileName = (String) func.invoke(o);
			
		} catch (NoSuchMethodException|SecurityException |
				IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		//record.gets
		
		return false;
	}
	
}