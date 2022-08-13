package io.github.axst.api.screen;

import net.minecraft.client.gui.GuiScreen;

import java.util.ArrayList;
import java.util.Collections;

public abstract class UIScreen extends GuiScreen {

    public final ArrayList<UIComponent> components = new ArrayList<>();

    public abstract void initComponent(int mouseX, int mouseY, boolean shouldRender);

    public abstract void renderScreen(int mouseX, int mouseY, boolean shouldRender);

    @Override
    public void initGui() {
        this.components.clear();
        initComponent(mc.mouseHelper.deltaX, mc.mouseHelper.deltaY, mc.theWorld != null);
        super.initGui();
    }

    public void draw(UIComponent... components) {
        Collections.addAll(this.components, components);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        components.forEach(e -> {
            if (e.isVisible()) e.drawComponent(mouseX, mouseY, mc.theWorld != null);
        });
        renderScreen(mouseX, mouseY, mc.theWorld != null);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
