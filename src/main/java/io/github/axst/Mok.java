package io.github.axst;

import io.github.axst.api.events.Event;
import io.github.axst.api.events.EventTick;
import io.github.axst.api.fonts.CustomFontRenderer;
import io.github.axst.api.screen.UIHudScreen;
import io.github.axst.api.screen.UINotification;
import io.github.axst.client.minecraft.screen.SplashProgress;
import io.github.axst.client.module.ModuleManager;
import io.github.axst.util.KeybindingsUtilities;
import io.github.axst.util.LoggerUtilities;
import io.github.nevalackin.homoBus.Listener;
import io.github.nevalackin.homoBus.annotations.EventLink;
import io.github.nevalackin.homoBus.bus.Bus;
import io.github.nevalackin.homoBus.bus.impl.EventBus;
import lombok.Getter;
import lombok.SneakyThrows;
import net.minecraft.client.Minecraft;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Getter
public class Mok {

    @Getter
    public static final Mok instance = new Mok();
    private final Bus<Event> bus = new EventBus<>();
    private final LoggerUtilities logger = new LoggerUtilities();
    @EventLink
    public Listener<EventTick> someTest = event -> {
        if (KeybindingsUtilities.TEST.isPressed()) {
            Minecraft.getMinecraft().displayGuiScreen(new UIHudScreen());
            getLogger().sendLogMinecraft("test", LoggerUtilities.LogLevel.INFO);
            new UINotification.Builder()
                    .setName("Test")
                    .setDescription("Some Test")
                    .setNotifications(UINotification.NotificationType.INFO)
                    .setTime(40)
                    .build();
        } else if (KeybindingsUtilities.TEST2.isPressed()) {
            new UINotification.Builder()
                    .setName("Test2")
                    .setDescription("Some Test2")
                    .setNotifications(UINotification.NotificationType.INFO)
                    .setTime(40)
                    .build();
        }
    };
    protected String name = "Mok";
    protected String version = "1.8.9";
    private CustomFontRenderer font;
    private ModuleManager moduleManager;

    public void startClient() {
        bus.subscribe(instance);
        initFont();
        logger.register("Mok");
        moduleManager = new ModuleManager();
        SplashProgress.newMessage("test");
        SplashProgress.newMessage("test2");
        SplashProgress.newMessage("test3");
        SplashProgress.newMessage("test4");
        SplashProgress.newMessage("test5");
        SplashProgress.newMessage("test6");
        SplashProgress.newMessage("test7");
        new KeybindingsUtilities();
        getLogger().sendLog("Client Started", LoggerUtilities.LogLevel.INFO);
    }

    public void initFont() {
        font = new CustomFontRenderer("font", 15.0F);
    }

    @SneakyThrows
    public String readCommit() {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("git rev-parse --verify --short HEAD");
        final BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        return reader.readLine();
    }

    public void stopClient() {
        bus.unsubscribe(instance);
        getLogger().sendLog("Client Stopped", LoggerUtilities.LogLevel.INFO);
    }

}
