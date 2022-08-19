package io.github.axst.client.module.misc;

import io.github.axst.client.module.ModuleRenderer;
import net.minecraft.client.Minecraft;

public class FPS2 extends ModuleRenderer {

    protected String fpsPrefix = "FPS: ";

    public FPS2() {
        super("FPS");
        initComponent(100, 100);
    }

    @Override
    public void drawInGame() {
        getMc().fontRendererObj.drawString(fpsPrefix + Minecraft.getDebugFPS(), getX(), getY(), -1);
    }

    @Override
    public void drawOnScreen(int mouseX, int mouseY) {
        getMc().fontRendererObj.drawString(fpsPrefix + "999", getX(), getY(), -1);
    }

    @Override
    public int getWidth() {
        return getMc().fontRendererObj.getStringWidth(fpsPrefix + Minecraft.getDebugFPS());
    }

    @Override
    public int getHeight() {
        return getMc().fontRendererObj.FONT_HEIGHT;
    }

}
