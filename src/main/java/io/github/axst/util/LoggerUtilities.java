package io.github.axst.util;

import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerUtilities {

    @Getter
    private static final Date data = new Date();
    @Getter
    private static SimpleDateFormat format;
    @Getter
    private static String loggerName;

    public static void register(String name) {
        loggerName = name;
        format = new SimpleDateFormat("HH:mm:ss");
    }

    public static void sendLog(String message, LogLevel logLevel) {
        if (getLoggerName() != null) {
            switch (logLevel) {
                case INFO:
                    System.out.println("[" + getFormat().format(getData()) + "] " + "[" + loggerName + "] [" + Thread.currentThread().getName() + "/INFO]: " + message);
                    break;
                case WARN:
                    System.out.println("[" + getFormat().format(getData()) + "] " + "[" + loggerName + "] [" + Thread.currentThread().getName() + "/WARN]: " + message);
                    break;
                case ERROR:
                    System.out.println("[" + getFormat().format(getData()) + "] " + "[" + loggerName + "] [" + Thread.currentThread().getName() + "/ERROR]: " + message);
                    break;
            }
        } else {
            System.out.println("[" + getFormat().format(getData()) + "] " + "[LimeeNull] [" + Thread.currentThread().getName() + "/FATAL]: There are no name for the logger.");
        }
    }

    public enum LogLevel {
        INFO, ERROR, WARN
    }
}

