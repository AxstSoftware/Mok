package io.github.axst.api.render;

import io.github.axst.api.screen.UIComponent;
import io.github.axst.util.RenderUtils;
import lombok.Getter;

import java.awt.*;

@Getter
public class UIButton extends UIComponent {

    public int buttonId;
    public String text;
    public boolean hovered;

    public UIButton(int buttonId, int x, int y, int width, int height, String text) {
        super(x, y, width, height);
        this.buttonId = buttonId;
        this.text = text;
    }

    @Override
    public void drawComponent(int mouseX, int mouseY, boolean shouldRender) {
        this.hovered = (mouseX >= this.getX() && mouseY >= this.getY() && mouseX < this.getX() + this.getWidth() && mouseY < this.getY() + this.getHeight());
        RenderUtils.drawRoundedOutline(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.getHeight(), 5, 2, new Color(164, 172, 180, 255).getRGB());
        RenderUtils.drawRoundedRect(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.getHeight(), 5, new Color(164, 172, 180, 64).getRGB());
        mc.fontRendererObj.drawString(this.getText(), this.getX() + (this.getWidth() >> 1), this.getY() + ((this.getHeight() - 8) >> 1) + 4, -1);
    }
}
