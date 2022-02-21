package rcode.chat.cmd;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import rcode.chat.Main;
import rcode.chat.config.Data;

public class ChatCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        boolean zwrot = true;
        Player p = (Player)sender;
        Data data = new Data(Main.getInstance().getConfig());
        if (!p.hasPermission(data.getMsg("permission"))) {
            String msg = data.getMsg("nopermMSG");
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
            return false;
        }
        String clearp, clear;
        clearp = data.getMsg("succesClearChatMessageToExecutor");
        clear = data.getMsg("succesClearChatMessageToPlayers");
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
                if (!data.getChat()) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', data.getMsg("chatisAlreadyDisabled")));
                break;
                }
                data.setChat(false);
                Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage(ChatColor.translateAlternateColorCodes('&', data.getMsg("succesOFFChatMessageToPlayers"))));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', data.getMsg("succesOFFChatMessageToExecutor")));
                break;
            case "on":
                if (data.getChat()) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', data.getMsg("chatisAlreadyEnabled")));
                    break;
                }
                data.setChat(true);
                Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage(ChatColor.translateAlternateColorCodes('&', data.getMsg("succesONChatMessageToPlayers"))));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', data.getMsg("succesONChatMessageToExecutor")));
                break;
            default:
                String usage = data.getMsg("usage");
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', usage));
                break;
        }
        return zwrot;
    }
}
