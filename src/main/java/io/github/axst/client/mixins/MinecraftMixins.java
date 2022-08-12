package io.github.axst.client.mixins;

import io.github.axst.Mok;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixins {

    @Inject(method = "startGame", at = @At(value = "RETURN"))
    public void injectStartGame(CallbackInfo ci) {
        Mok.getInstance().startClient();
    }

    @Inject(method = "shutdownMinecraftApplet", at = @At("RETURN"))
    public void injectShutdownMinecraftApplet(CallbackInfo ci) {
        Mok.getInstance().stopClient();
    }

}
