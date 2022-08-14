package io.github.axst.client.module.misc;

import io.github.axst.client.module.ModuleRenderer;
import io.github.axst.client.module.settings.impl.BooleanSettings;
import net.minecraft.client.Minecraft;

public class FPS extends ModuleRenderer {

    BooleanSettings test = new BooleanSettings("test", true);

    public FPS() {
        super("FPS");
        addSettings(test);
        initComponent(100, 100);
    }

    @Override
    public void drawOnScreen() {
        if (test.isEnabled()) {
            getMc().fontRendererObj.drawString("Test1", getX(), getY(), -1);
        } else getMc().fontRendererObj.drawString("Test2", getX(), getY(), -1);
    }

    @Override
    public void drawInGame(int mouseX, int mouseY) {
        if (test.isEnabled()) {
            getMc().fontRendererObj.drawString("Test1", getX(), getY(), -1);
        } else getMc().fontRendererObj.drawString("Test2", getX(), getY(), -1);
    }

    @Override
    public int getWidth() {
        if (test.isEnabled()) return getMc().fontRendererObj.getStringWidth("[ENABLED] FPS : " + Minecraft.getDebugFPS());
        return 0;
    }

    @Override
    public int getHeight() {
        if (test.isEnabled()) return getMc().fontRendererObj.FONT_HEIGHT;
        return 0;
    }

}
