package io.github.axst.client.minecraft.screen;

import io.github.axst.api.render.UIBackground;
import io.github.axst.api.render.UILogo;
import io.github.axst.api.screen.UIScreen;

public class UIMainMenu extends UIScreen {

    @Override
    public void initComponent(int mouseX, int mouseY, boolean shouldRender) {
        this.draw(
                new UIBackground(mouseX, mouseY, mc.displayWidth, mc.displayHeight, "bg.png"),
                new UILogo(this.width / 2 - 30, this.height / 2 - 65, 64, 64, "logo.png")
        );
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
