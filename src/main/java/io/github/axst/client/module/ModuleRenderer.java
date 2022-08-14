package io.github.axst.client.module;

import io.github.axst.api.screen.DraggableComponent;

public abstract class ModuleRenderer extends Module {

    private DraggableComponent component;

    protected ModuleRenderer(String name) {
        super(name);
    }

    public void initComponent(int x, int y) {
        component = new DraggableComponent(x, y, getWidth(), getHeight());
    }

    public abstract void drawOnScreen();

    public abstract void drawInGame(int mouseX, int mouseY);

    public abstract int getWidth();

    public abstract int getHeight();

    public int getX() {
        return component.getX();
    }

    public int getY() {
        return component.getY();
    }

}
