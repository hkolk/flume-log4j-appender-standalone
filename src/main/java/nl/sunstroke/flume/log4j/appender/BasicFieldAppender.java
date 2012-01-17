package nl.sunstroke.flume.log4j.appender;

import org.apache.log4j.spi.LoggingEvent;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: hkolk
 * Date: 1/17/12
 * Time: 7:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class BasicFieldAppender implements FieldAppender {
    @Override
    public Map<CharSequence, ByteBuffer> getFields(LoggingEvent event) {
        Map<CharSequence, ByteBuffer> map = new HashMap<CharSequence, ByteBuffer>();
        map.put("loggerName", wrap(event.getLoggerName()));
        map.put("threadName", wrap(event.getThreadName()));

        return map;
    }

    private ByteBuffer wrap(String value) {
        return ByteBuffer.wrap(value.getBytes());
    }
}
