package io.github.axst.api.screen;

import io.github.axst.Mok;
import io.github.axst.api.fonts.CustomFontRenderer;
import io.github.axst.api.render.UIRenderPictures;
import io.github.axst.util.LoggerUtilities;
import io.github.axst.util.RenderUtilities;
import lombok.Getter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
public class UINotification extends GuiScreen {

    private static final List<UINotification> livingNotifications = new ArrayList<>();
    private String name;
    private String description;
    private String iconLocation;
    private Color color;
    private NotificationType notifications;
    private int time;

    protected void renderNotification() {
        if (notifications == NotificationType.INFO) {
            iconLocation = "icons/info.png";
            color = new Color(36, 182, 48);
        } else if (notifications == NotificationType.WARN) {
            iconLocation = "icons/warning.png";
            color = new Color(182, 36, 90);
        }
        ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
        CustomFontRenderer font = new CustomFontRenderer("font", 28.0F);
        CustomFontRenderer font2 = new CustomFontRenderer("verdana", 18.0F);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        RenderUtilities.drawLine((int) (sr.getScaledWidth() / 2 - font.getWidth(getName()) + 2), ((sr.getScaledWidth() / 2) + getTime()), font.FONT_HEIGHT + 47, (int) 3.0F, getColor().getRGB(), true);
        new UIRenderPictures((int) (sr.getScaledWidth() / 2 - font.getWidth(getName())) - 20, font.FONT_HEIGHT + 27, 16, 16, iconLocation).drawPicture();
        GL11.glEnable(GL11.GL_BLEND);
        font.drawString(getName(), (sr.getScaledWidth() >> 1) - font.getWidth(getName()), font.FONT_HEIGHT + 20, -1);
        font2.drawString(getDescription(), (sr.getScaledWidth() >> 1) - font2.getWidth(getDescription()) / 2, font2.FONT_HEIGHT + 34, new Color(255,255,255,120).getRGB());
        --time;
    }

    public boolean isLiving() {
        return this.time > 0;
    }

    public enum NotificationType {
        INFO, WARN
    }

    public static class Builder {

        private final UINotification n;

        public Builder() {
            n = new UINotification();
        }

        public static void renderInGameNotification() {
            if (!livingNotifications.isEmpty()) {
                Iterator<UINotification> iter = livingNotifications.iterator();
                while (iter.hasNext()) {
                    UINotification notification = iter.next();
                    notification.renderNotification();
                    if (livingNotifications.size() > 1) iter.remove();
                    if (!notification.isLiving()) iter.remove();
                }
            }
        }

        public Builder setName(String name) {
            n.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            n.description = description;
            return this;
        }

        public Builder setNotifications(NotificationType notificationType) {
            n.notifications = notificationType;
            return this;
        }

        public Builder setTime(int time) {
            n.time = time;
            return this;
        }

        public void build() {
            validateNotifications(n);
            livingNotifications.add(n);
        }

        public void validateNotifications(UINotification notifications) {
            if (notifications.getName() == null && notifications.getDescription() == null) {
                Mok.getInstance().getLogger().sendLog("Wrong Notifications Build.", LoggerUtilities.LogLevel.ERROR);
            }
        }
    }

}
