package io.github.axst.client.module;

import io.github.axst.api.screen.UIDraggableComponent;
import lombok.Getter;

public abstract class ModuleRenderer extends Module {

    @Getter
    private UIDraggableComponent component;

    protected ModuleRenderer(String name) {
        super(name);
    }

    public void initComponent(int x, int y) {
        component = new UIDraggableComponent(x, y, getWidth(), getHeight());
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
