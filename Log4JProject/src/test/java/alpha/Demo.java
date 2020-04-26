package alpha;

import org.apache.logging.log4j.*;

public class Demo {



    private static Logger log = LogManager.getLogger(Demo.class.getName());
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
