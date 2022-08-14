package io.github.axst.api.screen;

import io.github.axst.Mok;
import io.github.axst.client.module.Module;
import io.github.axst.client.module.ModuleRenderer;
import net.minecraft.client.gui.GuiScreen;

import java.awt.*;

public class UIHudScreen extends GuiScreen {
    private int lastDraggedMod = 0;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawBackground();

        boolean doDrag = true;

        for (Module module : Mok.getInstance().getModuleManager().getModules()) {
            if (module.isEnabled() && module instanceof ModuleRenderer) {
                ((ModuleRenderer) module).drawInGame(mouseX, mouseY);
                if (module.hashCode() == this.lastDraggedMod && ((ModuleRenderer) module).getComponent().isDraggingModule(mouseX, mouseY))
                    doDrag = false;
            }
        }

        for (Module module : Mok.getInstance().getModuleManager().getModules()) {
            if (doDrag && module.isEnabled() && module instanceof ModuleRenderer && ((ModuleRenderer) module).getComponent().isDraggingModule(mouseX, mouseY)) {
                doDrag = false;
                this.lastDraggedMod = module.hashCode();
            }
        }
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public void drawBackground() {
        this.drawRectBackground(0);
    }

    public void drawRectBackground(int tint) {
        if (this.mc.theWorld != null) {
            this.drawGradientRect(0, 0, this.width, this.height, (new Color(0, 0, 0, 120)).getRGB(), (new Color(0, 0, 0, 105)).getRGB());
        } else {
            this.drawBackground(tint);
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
