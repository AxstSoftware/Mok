package io.github.axst.api.screen;

import lombok.Getter;
import org.lwjgl.input.Mouse;

@Getter
public class UIDraggableComponent {

    public final int widthIn;
    public final int heightIn;
    private int x;
    private int y;
    private int lastX;
    private int lastY;
    private boolean draggingModule;

    public UIDraggableComponent(int x, int y, int widthIn, int heightIn) {
        this.x = x;
        this.y = y;
        this.widthIn = widthIn;
        this.heightIn = heightIn;
    }

    public boolean isDraggingModule(int mouseX, int mouseY) {
        if (this.draggingModule) {
            this.x = mouseX + this.lastX;
            this.y = mouseY + this.lastY;
            if (!Mouse.isButtonDown(0)) this.draggingModule = false;
        }
        boolean mouseOverX = (mouseX >= this.getX() && mouseX <= this.getX() + this.getWidthIn());
        boolean mouseOverY = (mouseY >= this.getY() && mouseY <= this.getY() + this.getHeightIn());
        if (mouseOverX && mouseOverY && !this.draggingModule && Mouse.isButtonDown(0)) {
            this.lastX = x - mouseX;
            this.lastY = y - mouseY;
            this.draggingModule = true;
        }
        return draggingModule;
    }
}
