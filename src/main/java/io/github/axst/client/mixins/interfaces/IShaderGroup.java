package io.github.axst.client.mixins.interfaces;

import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.shader.ShaderGroup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ShaderGroup.class)
public interface IShaderGroup {

    @Accessor("mainFramebuffer")
    Framebuffer getFramebuffer();

}
