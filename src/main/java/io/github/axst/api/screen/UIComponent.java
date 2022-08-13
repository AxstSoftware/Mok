package io.github.axst.api.screen;

import lombok.Getter;
import net.minecraft.client.Minecraft;

@Getter
public abstract class UIComponent {

    public int x;
    public int y;
    public int width;
    public int height;

    public boolean visible = true;

    public Minecraft mc;

    public UIComponent(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        mc = Minecraft.getMinecraft();
    }

    public abstract void drawComponent(int mouseX, int mouseY, boolean shouldRender);
}
