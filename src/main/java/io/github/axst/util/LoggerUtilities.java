package io.github.axst.util;

import lombok.Getter;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerUtilities {

    @Getter
    private final Date data = new Date();
    @Getter
    private final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    @Getter
    private String loggerName;

    public void register(String name) {
        loggerName = name;
    }

    public void sendLog(String message, LogLevel logLevel) {
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
            System.out.println("[" + getFormat().format(getData()) + "] " + "[Null] [" + Thread.currentThread().getName() + "/FATAL]: There are no name for the logger.");
        }
    }

    public void sendLogMinecraft(String message, LogLevel logLevel) {
        Minecraft mc = Minecraft.getMinecraft();
        if (mc.theWorld != null && mc.thePlayer != null && getLoggerName() != null) {
            switch (logLevel) {
                case INFO:
                    mc.thePlayer.addChatMessage(new ChatComponentText("[" + getFormat().format(getData()) + "] " + "[" + loggerName + "] [" + Thread.currentThread().getName() + "/INFO]: " + message));
                    break;
                case WARN:
                    mc.thePlayer.addChatMessage(new ChatComponentText("[" + getFormat().format(getData()) + "] " + "[" + loggerName + "] [" + Thread.currentThread().getName() + "/WARN]: " + message));
                    break;
                case ERROR:
                    mc.thePlayer.addChatMessage(new ChatComponentText("[" + getFormat().format(getData()) + "] " + "[" + loggerName + "] [" + Thread.currentThread().getName() + "/ERROR]: " + message));
                    break;
            }
        } else {
            System.out.println("[" + getFormat().format(getData()) + "] " + "[Null] [" + Thread.currentThread().getName() + "/FATAL]: There are no name for the logger.");
        }
    }

    public enum LogLevel {
        INFO, ERROR, WARN
    }
}

