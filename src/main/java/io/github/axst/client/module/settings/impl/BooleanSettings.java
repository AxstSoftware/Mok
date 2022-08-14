package io.github.axst.client.module.settings.impl;

import io.github.axst.client.module.settings.Settings;
import lombok.Getter;
import lombok.Setter;

public class BooleanSettings extends Settings {

    @Setter @Getter
    public boolean enabled;

    public BooleanSettings(String name, boolean enable) {
        super(name);
        this.enabled = enable;
    }
}
