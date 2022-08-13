package io.github.axst.client.minecraft.screen;

import io.github.axst.api.render.UIButton;
import io.github.axst.api.render.UILogo;
import io.github.axst.api.screen.UIScreen;
import io.github.axst.util.BlurUtilities;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;

public class UIMainMenu extends UIScreen {

    @Override
    public void initComponent(int mouseX, int mouseY, boolean shouldRender) {
        this.draw(
                new UILogo(this.width / 2 - 30, this.height / 2 - 65, 64, 64, "logo.png"),
                new UIButton(1, 100, 100, 80, 30, "test")
        );
    }

    @Override
    public void renderScreen(int mouseX, int mouseY, boolean shouldRender) {
        mc.getTextureManager().bindTexture(new ResourceLocation("mok/background/bg.png"));
        Gui.drawModalRectWithCustomSizedTexture(-22 + (Mouse.getX() / 90), (Mouse.getY() * -1 / 90), 0, 0, width + 20, height + 18, width + 21f, height + 20f);
        BlurUtilities.blur(0, 0, mc.displayWidth, mc.displayHeight);
    }

}
