package io.github.axst.client.mixins;

import io.github.axst.Mok;
import io.github.axst.api.screen.UINotification;
import net.minecraft.client.gui.GuiIngame;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiIngame.class)
public class GuiIngameMixins {

    @Inject(method = "renderGameOverlay", at = @At("RETURN"))
    private void runTick(CallbackInfo info) {
        Mok.getInstance().getModuleManager().renderModules();
        UINotification.Builder.renderInGameNotification();
    }

}
