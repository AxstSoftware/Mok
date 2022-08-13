package io.github.axst.api.render;

import io.github.axst.util.RenderUtilities;
import lombok.Getter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

import java.awt.*;

@Getter
public class UIIConButton extends GuiButton {

    public ResourceLocation location;

    public UIIConButton(int buttonId, int x, int y, int widthIn, int heightIn, String iconName) {
        super(buttonId, x, y, widthIn, heightIn, "");
        this.location = new ResourceLocation("mok/icons/" + iconName);
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
        RenderUtilities.drawRoundedRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, 5, new Color(164, 172, 180, 64).getRGB());
        RenderUtilities.drawRoundedOutline(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, 5, 2, new Color(164, 172, 180, 255).getRGB());
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL13.GL_MULTISAMPLE);
        GL11.glDepthMask(false);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        mc.getTextureManager().bindTexture(getLocation());
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1F);
        Gui.drawModalRectWithCustomSizedTexture(this.xPosition + (this.width - 12) / 2, this.yPosition + (this.height - 12) / 2, 0, 0, 12, 12, (float) 12, (float) 12);
        GL11.glDepthMask(true);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glPopMatrix();
    }
}
