package io.github.axst;

import io.github.axst.api.fonts.CustomFontRenderer;
import io.github.axst.util.KeybindingsUtilities;
import io.github.axst.util.LoggerUtilities;
import lombok.Getter;

public class Mok {

    @Getter
    private static final Mok instance = new Mok();

    public CustomFontRenderer font;

    public void startClient() {
        LoggerUtilities.register("Mok");
        initFont();
        new KeybindingsUtilities();
        LoggerUtilities.sendLog("Client Started", LoggerUtilities.LogLevel.INFO);
    }

    public void initFont() {
        font = new CustomFontRenderer("font", 15.0F);
    }

    public void stopClient() {

    }
}
