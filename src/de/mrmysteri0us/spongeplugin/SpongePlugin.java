package de.mrmysteri0us.spongeplugin;

import org.spongepowered.api.event.SpongeEventHandler;
import org.spongepowered.api.event.state.PreInitializationEvent;
import org.spongepowered.api.event.state.ServerStoppingEvent;
import org.spongepowered.api.plugin.Plugin;

import java.io.IOException;

/**
 * Created by robin on 01/11/2014
 * WARNING: May contain pseudo-code!
 */

@Plugin(id = "SpongePlugin", name = "SpongePlugin", version = "1.0", dependencies = "after:b;before:c")
public class SpongePlugin {
    private Config  config;
    private File    configFile;
    private String  messageInit;
    private String  messageStop;

    @SpongeEventHandler
    public void onInit(PreInitializationEvent event) {
        // TODO -> start plugin: load config, assign variables
        config = new Config();
        configFile = new File("config");

        if(!configFile.exists()) {
            System.out.println("[SpongePlugin] Could not find config! Creating default config.");
            config.addDefault("messageInit", "Plugin enabled!");
            config.addDefault("messageStop", "Plugin disabled!");

            try {
                config.save(configFile);
            } catch(IOException e) {
                System.out.println("[SpongePlugin] Could not save config!");
                e.printStackTrace();
            }
        }

        config.load(configFile);
        messageInit = config.getString("messageInit");
        messageStop = config.getString("messageStop");

        System.out.println("[SpongePlugin] " + messageInit);
    }

    @SpongeEventHandler
    public void onStop(ServerStoppingEvent event) {
        // TODO -> stop plugin: save config (if changed), clean up
        System.out.println("[SpongePlugin " + messageStop);
    }
}
