package io.github.axst.api.render;

import io.github.axst.Mok;
import io.github.axst.util.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class UIButton extends GuiButton {

    public UIButton(int buttonId, int x, int y, int width, int height, String text) {
        super(buttonId, x, y, width, height, text);
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        this.hovered = mouseX >= this.xPosition &&
                mouseY >= this.xPosition &&
                mouseX < this.xPosition + this.width &&
                mouseY < this.yPosition + this.height;
        RenderUtils.drawRoundedRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, 5, new Color(164, 172, 180, 64).getRGB());
        RenderUtils.drawRoundedOutline(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, 5, 2, new Color(164, 172, 180, 255).getRGB());
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_BLEND);
        Mok.getInstance().font.drawString(this.displayString, this.xPosition + ((this.width - mc.fontRendererObj.getStringWidth(this.displayString)) >> 1), this.yPosition + ((this.height - 8) >> 1), new Color(255, 255, 255).getRGB());
    }
}
