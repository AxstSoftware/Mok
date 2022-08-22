package io.github.axst.client.module;

import io.github.axst.client.module.settings.Settings;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class Module {

    private final String name;
    private final List<Settings> settings = new ArrayList<>();
    private final Minecraft mc = Minecraft.getMinecraft();
    @Setter
    private boolean enabled;
    @Setter
    private boolean favourite;

    public Module(String name) {
        this.name = name;
        this.enabled = true;
    }

    public void addSettings(Settings... addSettings) {
        settings.addAll(Arrays.asList(addSettings));
    }
}
