package fr.citedesiles.citedesilesproxy;

import java.util.logging.Logger;

import javax.inject.Inject;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;

@Plugin(
    id = "citedesilesproxy",
    name="CiteDesIles-Proxy",
    version = "3.4.0"
)

public class CiteDesIlesProxyPlugin {
    @SuppressWarnings("unused")
    private final ProxyServer server;
    private final Logger logger;

    @Inject
    public CiteDesIlesProxyPlugin(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;
        logger.info("Construction du plugin...");
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        logger.info("Plugin chargé !");
    }
}
