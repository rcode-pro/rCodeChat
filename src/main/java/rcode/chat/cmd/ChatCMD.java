package rcode.chat.cmd;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import rcode.chat.Main;

public class ChatCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        boolean zwrot = true;
        Player p = (Player)sender;
        if (!p.hasPermission(Main.getInstance().getConfig().getString("permission"))) {
            String msg = Main.getInstance().getConfig().getString("nopermMSG");
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
            return false;
        }
        String clearp, clear;
        clearp = Main.getInstance().getConfig().getString("succesClearChatMessageToExecutor");
        clear = Main.getInstance().getConfig().getString("succesClearChatMessageToPlayers");
        switch (args[0].toLowerCase()) {
            case "clear":
            case "cc":
                Bukkit.getOnlinePlayers().forEach(player -> {
                    player.sendMessage(new String[100]);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', clear));
                });
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', clearp));
                break;
            case "off":
                if (Main.chat.equals(0)) {
                    return false;
                }
                Main.chat.clear();
                Main.chat.add(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
                break;
            case "on":
                if (Main.chat.equals(1)) {
                    return false;
                }
                Main.chat.clear();
                Main.chat.add(1);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
                break;
            default:
                String usage = Main.getInstance().getConfig().getString("usage");
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', usage));
                break;
        }
        return zwrot;
    }
}
