package beta;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo2 {



    private static Logger log = LogManager.getLogger(Demo2.class.getName());
    public static void main(String[] args) {

        log.debug("I'm debuging");

        if(2<0) {
            log.debug("object is present");
        }
        else{
            log.error("object is not present");
        }

        log.fatal("THIS is Fu... FATAL");
        log.info("Info demo");
    }
}
