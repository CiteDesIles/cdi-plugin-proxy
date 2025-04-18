package fr.citedesiles.citedesilesproxy.commands;

import fr.citedesiles.citedesilesproxy.CDIProxy;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class PAdminCommand extends Command {

    public PAdminCommand() {
        super("padmin");
    }
    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (strings.length == 0) {
            commandSender.sendMessage("Usage: /padmin <add|remove> <player>");
            return;
        }

        if(commandSender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) commandSender;
            if(CDIProxy.playerAllowed.contains(player.getUniqueId())) {
                if(strings[0].equals("add")) {
                    if(strings.length < 2) {
                        player.sendMessage("Usage: /padmin add <player>");
                        return;
                    }
                    ProxiedPlayer target = CDIProxy.getInstance().getProxy().getPlayer(strings[1]);
                    if(target == null) {
                        player.sendMessage("Player not found.");
                        return;
                    }
                    CDIProxy.playerAllowed.add(target.getUniqueId());
                    player.sendMessage("Player " + target.getName() + " has been added to the admin list.");
                }
                if(strings[0].equals("remove")) {
                    if(strings.length < 2) {
                        player.sendMessage("Usage: /padmin remove <player>");
                        return;
                    }
                    ProxiedPlayer target = CDIProxy.getInstance().getProxy().getPlayer(strings[1]);
                    if(target == null) {
                        player.sendMessage("Player not found.");
                        return;
                    }
                    CDIProxy.playerAllowed.remove(target.getUniqueId());
                    player.sendMessage("Player " + target.getName() + " has been removed from the admin list.");
                }
            } else {
                player.sendMessage("You are not allowed to use this command.");
                return;
            }
        }
    }
}
