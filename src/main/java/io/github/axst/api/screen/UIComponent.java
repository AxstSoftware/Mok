package io.github.axst.api.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public abstract class UIComponent {

    public int x;
    public int y;
    public int width;
    public int height;

    public Minecraft mc;

    public ScaledResolution sr;

    public UIComponent(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        mc = Minecraft.getMinecraft();
        sr = new ScaledResolution(mc);
    }

    public abstract void drawComponent(int mouseX, int mouseY, boolean shouldRender);
}
