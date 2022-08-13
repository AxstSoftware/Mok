package io.github.axst;

import io.github.axst.util.KeybindingsUtilities;
import io.github.axst.util.LoggerUtilities;
import lombok.Getter;

public class Mok {

    @Getter
    private static final Mok instance = new Mok();

    public void startClient() {
        LoggerUtilities.register("Mok");
        new KeybindingsUtilities();
        LoggerUtilities.sendLog("Client Started", LoggerUtilities.LogLevel.INFO);
    }

    public void stopClient() {

    }
}
