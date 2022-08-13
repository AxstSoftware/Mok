package io.github.axst.api.render;

import io.github.axst.api.screen.UIComponent;
import lombok.Getter;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@Getter
public class UILogo extends UIComponent {

    public ResourceLocation logoLocation;

    public UILogo(int x, int y, int width, int height, String logoLocation) {
        super(x, y, width, height);
        this.logoLocation = new ResourceLocation("mok/logo/" + logoLocation);
    }

    @Override
    public void drawComponent(int mouseX, int mouseY, boolean shouldRender) {
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
