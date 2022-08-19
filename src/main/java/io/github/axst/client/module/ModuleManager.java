package io.github.axst.client.module;

import io.github.axst.client.module.misc.FPS;
import io.github.axst.client.module.misc.FPS2;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModuleManager {
    @Getter
    private final List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        addModule(
                new FPS(),
                new FPS2()
        );
    }

    /**
     * Add module
     *
     * @param module Module to add.
     */
    public void addModule(Module... module) {
        modules.addAll(Arrays.asList(module));
    }

    public void renderModules() {
        modules.forEach(mod -> {
            if (mod.isEnabled() && mod instanceof ModuleRenderer) ((ModuleRenderer) mod).drawInGame();
        });
    }
}
