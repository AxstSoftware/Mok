package io.github.axst.client.minecraft.screen;

import io.github.axst.api.fonts.CustomFontRenderer;
import io.github.axst.api.render.UIRenderPictures;
import io.github.axst.util.RenderUtilities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.awt.*;

/**
 * egold555 on github.
 */
public class SplashProgress {

    public static final Minecraft mc = Minecraft.getMinecraft();
    private static int progress = 0;
    private static String current = "";
    private static ResourceLocation splash;
    private static CustomFontRenderer ufr;

    private SplashProgress() {}

    public static void update() {
        if (mc == null || mc.getLanguageManager() == null) {
            return;
        }
        drawSplash(mc.getTextureManager());
    }

    public static void newMessage(String givenText) {
        ++progress;
        current = givenText;
        update();
    }

    public static void drawSplash(TextureManager tm) {

        ScaledResolution scaledresolution = new ScaledResolution(mc);
        int scaleFactor = scaledresolution.getScaleFactor();

        Framebuffer framebuffer = new Framebuffer(scaledresolution.getScaledWidth() * scaleFactor, scaledresolution.getScaledHeight() * scaleFactor, true);
        framebuffer.bindFramebuffer(false);

        GlStateManager.matrixMode(GL11.GL_PROJECTION);
        GlStateManager.loadIdentity();
        GlStateManager.ortho(0.0D, scaledresolution.getScaledWidth(), scaledresolution.getScaledHeight(), 0.0D, 1000.0D, 3000.0D);
        GlStateManager.matrixMode(GL11.GL_MODELVIEW);
        GlStateManager.loadIdentity();
        GlStateManager.translate(0.0F, 0.0F, -2000.0F);
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        GlStateManager.disableDepth();
        GlStateManager.enableTexture2D();

        if (splash == null) {
            splash = new ResourceLocation("mok/background/bg.png");
        }

        tm.bindTexture(splash);

        GlStateManager.resetColor();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        Gui.drawScaledCustomSizeModalRect(0, 0, 0, 0, mc.displayWidth, mc.displayHeight, scaledresolution.getScaledWidth(), scaledresolution.getScaledHeight(), 1920, 1080);
        drawProgress();
        framebuffer.unbindFramebuffer();
        framebuffer.framebufferRender(scaledresolution.getScaledWidth() * scaleFactor, scaledresolution.getScaledHeight() * scaleFactor);

        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1F);

        mc.updateDisplay();
    }

    private static void clearMenu() {
        ScaledResolution scaledresolution = new ScaledResolution(mc);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, scaledresolution.getScaledWidth(), scaledresolution.getScaledHeight(), 0.0, 1000.0, 3000.0);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -2000.0f);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_FOG);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
    }

    private static void drawProgress() {

        clearMenu();

        if (mc.gameSettings == null || mc.getTextureManager() == null) {
            return;
        }

        if (ufr == null) {
            ufr = new CustomFontRenderer("font", 20);
        }

        ScaledResolution sr = new ScaledResolution(mc);

        double scaledWidth = sr.getScaledWidth_double();
        double scaledHeight = sr.getScaledHeight_double();

        float width = 160.0f;
        float height = 80.0F;
        float x = (float) scaledWidth / 2.0f - 80.0f;
        float y = (float) scaledHeight - 40.0f;

        GlStateManager.resetColor();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        int max = 7;
        float loadedWidth = width * ((float) progress / max);

        RenderUtilities.drawRoundedRect(x - 40, y - 76, x + width + 40, y - height + 15, 9, new Color(80, 80, 80, 221).getRGB());
        RenderUtilities.drawRoundedOutline((int) x - 40, (int) y - 76, (int) (x + width) + 40, (int) (y - height + 15), 9, 1, new Color(0, 0, 0, 255).getRGB());
        String step = "Mods (" + progress + "/" + max + ")";
        ufr.drawString(step, (sr.getScaledWidth() >> 1) + 20 - ufr.getWidth(step), sr.getScaledHeight() - 145, new Color(255, 255, 255).getRGB());
        new UIRenderPictures(sr.getScaledWidth() / 2 - 85, sr.getScaledHeight() / 2 - 75, 64, 64, "logo/logo.png").drawPicture();
        RenderUtilities.drawRoundedRect(x - 40, y - 75.5f, x + loadedWidth + 40, y - height + 14.5f, 9, new Color(255, 255, 255).getRGB());
        ufr.drawString(current, (sr.getScaledWidth() >> 1) + 35 - ufr.getWidth(current), sr.getScaledHeight() - 130, new Color(255, 255, 255).getRGB());
        clearMenu();
    }
}