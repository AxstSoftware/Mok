package io.github.axst.client.minecraft.screen;

import io.github.axst.api.render.UIBackground;
import io.github.axst.api.render.UIButton;
import io.github.axst.api.render.UILogo;
import io.github.axst.api.screen.UIScreen;
import net.minecraft.client.gui.GuiButton;

import java.util.Collections;

public class UIMainMenu extends UIScreen {

    @Override
    public void initComponent(int mouseX, int mouseY, boolean shouldRender) {
        this.draw(
                new UIBackground(mouseX, mouseY, mc.displayWidth, mc.displayHeight, "bg.png"),
                new UILogo(this.width / 2 - 30, this.height / 2 - 65, 64, 64, "logo.png"));
        this.addButton(
                new UIButton(1, sr.getScaledWidth() / 2 - 80, sr.getScaledHeight() / 2, 170, 20, "SINGLEPLAYER"),
                new UIButton(2, sr.getScaledWidth() / 2 - 80, sr.getScaledHeight() / 2 + 25, 170, 20, "MULTIPLAYER"),
                new UIButton(3, sr.getScaledWidth() / 2 - 30, sr.getScaledHeight() / 2 + 50, 70, 20, "QUIT")
        );
    }

    @Override
    public void renderScreen(int mouseX, int mouseY, boolean shouldRender) {

    }

    private void addButton(GuiButton... button) {
        Collections.addAll(this.buttonList, button);
    }

}
