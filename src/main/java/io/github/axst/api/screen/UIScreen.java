package io.github.axst.api.screen;

import com.google.common.collect.Lists;
import net.minecraft.client.gui.GuiScreen;

import java.util.Arrays;
import java.util.List;

public abstract class UIScreen extends GuiScreen {

    public final List<UIComponent> components = Lists.newArrayList();

    public abstract void initComponent(int mouseX, int mouseY, boolean shouldRender);

    @Override
    public void initGui() {
        this.components.clear();
        initComponent(mc.mouseHelper.deltaX, mc.mouseHelper.deltaY, mc.theWorld != null);
        super.initGui();
    }

    public void draw(UIComponent... components) {
        this.components.addAll(Arrays.asList(components));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        components.forEach(e -> {
            if (e.isVisible()) e.drawComponent(mouseX, mouseY, mc.theWorld != null);
        });
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
