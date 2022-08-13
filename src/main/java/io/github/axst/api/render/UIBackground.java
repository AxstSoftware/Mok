package io.github.axst.api.render;

import io.github.axst.api.screen.UIComponent;
import io.github.axst.util.BlurUtilities;
import lombok.Getter;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;

@Getter
public class UIBackground extends UIComponent {

    public final ResourceLocation location;

    public UIBackground(int x, int y, int width, int height, String location) {
        super(x, y, width, height);
        this.location = new ResourceLocation("mok/background/" + location);
    }

    @Override
    public void drawComponent(int mouseX, int mouseY, boolean shouldRender) {
        mc.getTextureManager().bindTexture(getLocation());
        Gui.drawModalRectWithCustomSizedTexture(-22 + (Mouse.getX() / 90), (Mouse.getY() * -1 / 90), 0, 0, width + 20, height + 18, width + 21f, height + 20f);
        BlurUtilities.blur(0, 0, mc.displayWidth, mc.displayHeight);
    }
}
