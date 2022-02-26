package rcode.chat.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import rcode.chat.Main;
import rcode.chat.config.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ChatListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        ConsoleCommandSender d = Bukkit.getConsoleSender();
        String wersja = Main.getInstance().getDescription().getVersion();
        try {
            URL url = new URL("https://api.spigotmc.org/legacy/update.php?resource=100273");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            if (!wersja.equals(bufferedReader.readLine())) {
                e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&cNew version of plugin &arChat &cis on spigot"));
                e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYour version: &e"+wersja));
                e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&cLatest version: &2"+bufferedReader.readLine()));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    @EventHandler(priority = EventPriority.NORMAL)
    public void onChat(AsyncPlayerChatEvent event) {
        if (!event.isCancelled()) {
            Data data = new Data(Main.getInstance().getConfig());
            if (data.getChat() == false) {
                if (!event.getPlayer().hasPermission(data.getMsg("permissiontoWriteifDisabled"))) {
                    event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', data.getMsg("chatisOFF")));
                    event.setCancelled(true);
                    return;
                }
            }
        }
    }

}
