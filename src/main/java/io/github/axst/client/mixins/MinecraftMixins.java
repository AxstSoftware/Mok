package io.github.axst.client.mixins;

import io.github.axst.Mok;
import io.github.axst.client.minecraft.screen.SplashProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixins {

    @Inject(method = "startGame", at = @At(value = "RETURN"))
    public void injectStartGame(CallbackInfo ci) {
        Mok.getInstance().startClient();
    }


    @Redirect(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;drawSplashScreen(Lnet/minecraft/client/renderer/texture/TextureManager;)V"))
    private void showSplashScreen(Minecraft minecraft, TextureManager textureManagerInstance) {
        SplashProgress.drawSplash(minecraft.getTextureManager());
    }

    @Inject(method = "shutdownMinecraftApplet", at = @At("RETURN"))
    public void injectShutdownMinecraftApplet(CallbackInfo ci) {
        Mok.getInstance().stopClient();
    }

}
