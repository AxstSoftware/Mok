package io.github.axst.api.render;

import io.github.axst.api.screen.UIComponent;
import io.github.axst.util.BlurUtilities;
import lombok.Getter;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;

@Getter
public class UIBackground extends UIComponent {

    public ResourceLocation resolveLocation;

    public UIBackground(int x, int y, int width, int height, String source) {
        super(x, y, width, height);
        resolveLocation = new ResourceLocation("mok/background/" + source);
    }

    @Override
    public void drawComponent(int mouseX, int mouseY, boolean shouldRender) {
        GlStateManager.pushMatrix();
        mc.getTextureManager().bindTexture(resolveLocation);
        Gui.drawModalRectWithCustomSizedTexture(-22 + (Mouse.getX() / 90), (Mouse.getY() * -1 / 90), 0, 0, width + 20, height + 18, width + 21f, height + 20f);
        BlurUtilities.blur(0, 0, width, height);
        GlStateManager.popMatrix();
    }
}
