package nl.sunstroke.flume.log4j.appender;

import org.apache.log4j.spi.LoggingEvent;

import java.nio.ByteBuffer;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: hkolk
 * Date: 1/17/12
 * Time: 7:01 PM
 * To change this template use File | Settings | File Templates.
 */
public interface FieldAppender {
    
    public Map<CharSequence, ByteBuffer> getFields(LoggingEvent event);
}
