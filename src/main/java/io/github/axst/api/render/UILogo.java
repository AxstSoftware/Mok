package io.github.axst.api.render;

import lombok.Getter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@Getter
public class UILogo {

    public static final Minecraft mc = Minecraft.getMinecraft();

    public ResourceLocation logoLocation;

    public int x;
    public int y;
    public int width;
    public int height;

    public UILogo(int x, int y, int width, int height, String logoLocation) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.logoLocation = new ResourceLocation("mok/logo/" + logoLocation);
    }

    public void drawPicture() {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDepthMask(false);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        mc.getTextureManager().bindTexture(getLogoLocation());
        Gui.drawModalRectWithCustomSizedTexture(getX(), getY(), 0.0f, 0.0f, getWidth(), getHeight(), getWidth(), getHeight());
        GL11.glDepthMask(true);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glPopMatrix();
    }
}
