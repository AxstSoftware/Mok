package io.github.axst.api.screen;

import net.minecraft.client.gui.GuiScreen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class UIScreen extends GuiScreen {

    public final List<UIComponent> components = new ArrayList<>();

    public abstract void initComponent(int mouseX, int mouseY, boolean shouldRender);

    @Override
    public void initGui() {
        initComponent(mc.mouseHelper.deltaX, mc.mouseHelper.deltaY, mc.theWorld != null);
    }

    public void draw(UIComponent... components) {
        this.components.addAll(Arrays.asList(components));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        components.forEach(c -> c.drawComponent(mouseX, mouseY, mc.theWorld != null));
    }
}
