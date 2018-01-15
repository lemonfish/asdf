package net.asdf.core.util;

public interface TimeLogger {

    void start(String key);

    void stop(String key);

    void print(String prefix);

}
