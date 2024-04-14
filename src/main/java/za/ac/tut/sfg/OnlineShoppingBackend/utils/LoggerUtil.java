package za.ac.tut.sfg.OnlineShoppingBackend.utils;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
    public void LOG_INFO(String message,Class c){
         final Logger LOGGER = LoggerFactory.getLogger(c.getName());
         LOGGER.info(message);
    }
}
