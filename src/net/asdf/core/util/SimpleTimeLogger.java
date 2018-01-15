package net.asdf.core.util;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;


public class SimpleTimeLogger implements TimeLogger {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static SimpleTimeLogger instance;

    private ThreadLocal<Map<String, StopWatch>> m = new ThreadLocal<Map<String, StopWatch>>() {

        @Override
        protected Map<String, StopWatch> initialValue() {
            return new LinkedHashMap<String, StopWatch>();
        }
    };

    public SimpleTimeLogger() {
        instance = this;
    }

    public static void startLog(String key) {
        instance.start(key);
    }

    public static void stopLog(String key) {
        instance.stop(key);
    }

    @Override
    public void start(String key) {
        if (!logger.isDebugEnabled()) {
            return;
        }
        Map<String, StopWatch> msw = m.get();
        StopWatch sw = null;
        if (msw.containsKey(key)) {
            sw = msw.get(key);
        } else {
            sw = new StopWatch(key);
            msw.put(key, sw);
        }

        if (sw.isRunning()) {
            sw.stop();
        }
        sw.start();
    }

    @Override
    public void stop(String key) {
        if (!logger.isDebugEnabled()) {
            return;
        }
        Map<String, StopWatch> msw = m.get();
        StopWatch sw = null;
        if (msw.containsKey(key)) {
            sw = msw.get(key);
            sw.stop();
        } else {
            logger.error("can't find stopwatch {}", key);
        }
    }

    @Override
    public void print(String prefix) {
        if (!logger.isDebugEnabled()) {
            return;
        }
        StringBuilder sb = new StringBuilder();

        Map<String, StopWatch> msw = m.get();
        for (String key : msw.keySet()) {
            StopWatch sw = msw.get(key);
            if (sw != null) {
                if (sw.isRunning()) {
                    logger.error("what the hell. stopwatch still running! {}", key);
                    sw.stop();
                }

                sb.append(String.format("%40s : %7.2fs ( %7dms )\n", key, sw.getTotalTimeSeconds(),
                        sw.getTotalTimeMillis()));

            } else {
                logger.error("stopwatch is null {}", key);
                continue;
            }
        }

        msw.clear();
        logger.debug("{}\n{}", prefix, sb.toString());

    }
}
