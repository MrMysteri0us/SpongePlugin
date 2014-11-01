package de.mrmysteri0us.spongeplugin;

import org.spongepowered.api.event.SpongeEventHandler;
import org.spongepowered.api.event.state.PreInitializationEvent;
import org.spongepowered.api.event.state.ServerStoppingEvent;
import org.spongepowered.api.plugin.Plugin;
import org.apache.log4j.Logger;

/**
 * Created by robin on 01/11/2014
 */

@Plugin(id = "SpongePlugin", name = "SpongePlugin", version = "1.0", dependencies = "after:b;before:c")
public class SpongePlugin {
    private Logger log;

    @SpongeEventHandler
    public void onInit(PreInitializationEvent event) {
        // TODO -> start plugin: load config, assign variables
        log = event.getPluginLog();
        log.info("Plugin enabled.");
    }

    @SpongeEventHandler
    public void onStop(ServerStoppingEvent event) {
        // TODO -> stop plugin: save config (if changed), clean up
        log.info("Plugin disabled.");
    }
}
