package io.github.axst.client.module.settings.impl;

import io.github.axst.client.module.settings.Settings;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BooleanSettings extends Settings {

    public boolean enabled;

    public BooleanSettings(String name, boolean enable) {
        super(name);
        this.enabled = enable;
    }
}
