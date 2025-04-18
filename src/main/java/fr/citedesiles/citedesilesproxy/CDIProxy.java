package fr.citedesiles.citedesilesproxy;

import fr.citedesiles.citedesilesproxy.runnable.NightRunnable;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class CDIProxy extends Plugin {

    public static List<UUID> playerAllowed = new ArrayList<>();
    private static CDIProxy instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Enabling CDI Proxy...");
        getProxy().getScheduler().schedule(this, new NightRunnable(), 1, 1, TimeUnit.SECONDS);
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabling CDI Proxy...");
    }

    public static CDIProxy getInstance() {
        return instance;
    }
}
