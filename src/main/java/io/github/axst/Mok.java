package io.github.axst;

import io.github.axst.api.events.Event;
import io.github.axst.api.events.EventTick;
import io.github.axst.api.fonts.CustomFontRenderer;
import io.github.axst.api.screen.UIHudScreen;
import io.github.axst.client.minecraft.screen.SplashProgress;
import io.github.axst.client.module.ModuleManager;
import io.github.axst.util.KeybindingsUtilities;
import io.github.axst.util.LoggerUtilities;
import io.github.nevalackin.homoBus.Listener;
import io.github.nevalackin.homoBus.annotations.EventLink;
import io.github.nevalackin.homoBus.bus.Bus;
import io.github.nevalackin.homoBus.bus.impl.EventBus;
import lombok.Getter;
import net.minecraft.client.Minecraft;

public class Mok {

    @Getter
    private static final Mok instance = new Mok();
    @Getter
    private final LoggerUtilities logger = new LoggerUtilities();
    @Getter
    private final Bus<Event> bus = new EventBus<>();
    @Getter
    private CustomFontRenderer font;
    @Getter
    private ModuleManager moduleManager;

    @EventLink
    public Listener<EventTick> someTest = event -> {
        if (KeybindingsUtilities.TEST.isKeyDown()) {
           Minecraft.getMinecraft().displayGuiScreen(new UIHudScreen());
        }
    };

    public void startClient() {
        logger.register("Mok");
        moduleManager = new ModuleManager();
        initFont();
        SplashProgress.newMessage("test");
        SplashProgress.newMessage("test2");
        SplashProgress.newMessage("test3");
        SplashProgress.newMessage("test4");
        SplashProgress.newMessage("test5");
        SplashProgress.newMessage("test6");
        SplashProgress.newMessage("test7");
        new KeybindingsUtilities();
        bus.subscribe(instance);
        getLogger().sendLog("Client Started", LoggerUtilities.LogLevel.INFO);
    }

    public void initFont() {
        font = new CustomFontRenderer("font", 15.0F);
    }

    public void stopClient() {
        bus.unsubscribe(instance);
        getLogger().sendLog("Client Stopped", LoggerUtilities.LogLevel.INFO);
    }
}
