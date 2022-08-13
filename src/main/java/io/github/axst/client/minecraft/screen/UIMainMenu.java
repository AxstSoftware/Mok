package io.github.axst.client.minecraft.screen;

import io.github.axst.api.render.UIButton;
import io.github.axst.api.render.UILogo;
import io.github.axst.api.screen.UIScreen;
import io.github.axst.util.BlurUtilities;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;

import java.util.Collections;

import static org.lwjgl.opengl.GL11.GL_SMOOTH;
import static org.lwjgl.opengl.GL11.glShadeModel;

public class UIMainMenu extends UIScreen {

    @Override
    public void initComponent(int mouseX, int mouseY, boolean shouldRender) {

        this.addButton(
                new UIButton(1, sr.getScaledWidth() / 2 - 80, sr.getScaledHeight() / 2, 170, 20, "SINGLEPLAYER"),
                new UIButton(2, sr.getScaledWidth() / 2 - 80, sr.getScaledHeight() / 2 + 25, 170, 20, "MULTIPLAYER"),
                new UIButton(3, sr.getScaledWidth() / 2 - 30, sr.getScaledHeight() / 2 + 50, 70, 20, "QUIT")
        );
    }

    @Override
    public void renderScreen(int mouseX, int mouseY, boolean shouldRender) {
        mc.getTextureManager().bindTexture(new ResourceLocation("mok/background/bg.png"));
        glShadeModel(GL_SMOOTH);
        Gui.drawModalRectWithCustomSizedTexture(-22 + (Mouse.getX() / 90), (Mouse.getY() * -1 / 90), 0, 0, width + 20, height + 18, width + 21f, height + 20f);
        BlurUtilities.blur(0, 0, mc.displayWidth, mc.displayHeight);
        new UILogo(this.width / 2 - 30, this.height / 2 - 65, 64, 64, "logo.png").drawPicture();
    }

    private void addButton(GuiButton... button) {
        Collections.addAll(this.buttonList, button);
    }

}
