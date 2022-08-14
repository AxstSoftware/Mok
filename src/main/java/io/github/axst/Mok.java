package io.github.axst;

import io.github.axst.api.fonts.CustomFontRenderer;
import io.github.axst.client.minecraft.screen.SplashProgress;
import io.github.axst.util.KeybindingsUtilities;
import io.github.axst.util.LoggerUtilities;
import lombok.Getter;

public class Mok {

    @Getter
    private static final Mok instance = new Mok();
    @Getter
    private final LoggerUtilities logger = new LoggerUtilities();
    @Getter
    private CustomFontRenderer font;

    public void startClient() {
        logger.register("Mok");
        initFont();
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

    public void stopClient() {
        getLogger().sendLog("Client Stopped", LoggerUtilities.LogLevel.INFO);
    }
}
