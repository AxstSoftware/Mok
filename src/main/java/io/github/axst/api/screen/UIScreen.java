package io.github.axst.api.screen;

import lombok.Getter;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class UIScreen extends GuiScreen {

    public final List<UIComponent> components = new ArrayList<>();

    @Getter
    public ScaledResolution sr;

    public void initComponent(int mouseX, int mouseY, boolean shouldRender) {
    }

    public void renderScreen(int mouseX, int mouseY, boolean shouldRender) {
    }

    @Override
    public void initGui() {
        this.components.clear();
        sr = new ScaledResolution(mc);
        initComponent(mc.mouseHelper.deltaX, mc.mouseHelper.deltaY, mc.theWorld != null);
        super.initGui();
    }

    public void draw(UIComponent... components) {
        Collections.addAll(this.components, components);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        renderScreen(mouseX, mouseY, mc.theWorld != null);
        components.forEach(e -> {
            if (e.isVisible()) e.drawComponent(mouseX, mouseY, mc.theWorld != null);
        });
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
