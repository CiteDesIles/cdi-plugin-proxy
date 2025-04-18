package fr.citedesiles.citedesilesproxy.runnable;

import fr.citedesiles.citedesilesproxy.CDIProxy;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Collection;

public class NightRunnable implements Runnable {
    @Override
    public void run() {
        LocalTime currentTime = LocalTime.now(ZoneId.of("Europe/Paris"));
        LocalTime startTime = LocalTime.of(1, 0); // 1h du matin
        LocalTime endTime = LocalTime.of(7, 0);   // 7h du matin

        if (currentTime.isAfter(startTime) && currentTime.isBefore(endTime)) {
            Collection<ProxiedPlayer> onlinePlayers = CDIProxy.getInstance().getProxy().getPlayers();

            for (ProxiedPlayer player : onlinePlayers) {
                if (!CDIProxy.playerAllowed.contains(player.getUniqueId())) {
                    player.disconnect(new TextComponent("Le serveur est fermé de 1h à 7h du matin, Bonne nuit."));
                }
            }
        }
    }
}
