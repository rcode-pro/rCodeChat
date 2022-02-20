package rcode.chat.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import rcode.chat.Main;
import rcode.chat.config.Data;

public class ChatListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onChat(AsyncPlayerChatEvent event) {
        if (!event.isCancelled()) {
            Data data = new Data(Main.getInstance().getConfig());
            if (data.getChat() == false) {
                if (event.getPlayer().hasPermission(data.getMsg("permissiontoWriteifDisabled"))) {
                    event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', data.getMsg("chatisOFF")));
                    event.setCancelled(true);
                    return;
                }
            }
        }
    }

}
