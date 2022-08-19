package io.github.axst.api.screen;

import io.github.axst.util.RenderUtilities;
import lombok.Getter;
import org.lwjgl.input.Mouse;

import java.awt.*;

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
        boolean hovered = mouseX >= this.getX() && mouseX <= this.getX() + this.getWidthIn() && mouseY >= this.getY() && mouseY <= this.getY() + this.getHeightIn();
        if (hovered) {
            RenderUtilities.drawHollowRect(this.getX() - 2, this.getY() - 2, this.getWidthIn() + 3, this.getHeightIn() + 2, new Color(0, 204, 255, 152).getRGB());
        } else
            RenderUtilities.drawHollowRect(this.getX() - 2, this.getY() - 2, this.getWidthIn() + 3, this.getHeightIn() + 2, new Color(170, 170, 170, 100).getRGB());
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
