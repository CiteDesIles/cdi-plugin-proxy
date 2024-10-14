package fr.citedesiles.citedesilesproxy;

import java.util.logging.Logger;

import javax.inject.Inject;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;

@Plugin(
    id = "citedesilesproxy",
    name="CiteDesIles-Proxy",
    version = "3.4.0"
)

public class CiteDesIlesProxyPlugin {
    @Inject
    private Logger logger;

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        logger.info("Cité des Iles Proxy initialized");
    }
}
