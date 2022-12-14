package io.github.axst.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import org.apache.commons.lang3.ArrayUtils;
import org.lwjgl.input.Keyboard;

public class KeybindingsUtilities {

    public static final KeyBinding TEST = new KeyBinding("test", Keyboard.KEY_C, "Mok");
    public static final KeyBinding TEST2 = new KeyBinding("test", Keyboard.KEY_R, "Mok");

    public KeybindingsUtilities() {
        addKeybindings(TEST);
        addKeybindings(TEST2);
    }

    public void addKeybindings(KeyBinding... k) {
        Minecraft.getMinecraft().gameSettings.keyBindings = ArrayUtils.addAll(Minecraft.getMinecraft().gameSettings.keyBindings, k);
    }

}
