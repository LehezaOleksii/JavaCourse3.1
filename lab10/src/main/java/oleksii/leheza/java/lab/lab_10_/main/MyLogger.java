package oleksii.leheza.java.lab.lab_10_.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLogger {

	private static final Logger logger = LogManager.getLogger(MyLogger.class);

	public static void logInfo(String message) {
		logger.info(message);
	}

	public static void logError(String message, Throwable throwable) {
		logger.error(message, throwable);
	}

	public static void logDebug(String message) {
		logger.debug(message);
	}
}