package rcode.chat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import rcode.chat.cmd.ChatCMD;
import rcode.chat.listeners.ChatListener;
import rcode.chat.util.UpdateSpigot;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends JavaPlugin {

    private final Logger wiad = Bukkit.getLogger();

    @Override
    public void onEnable() {
        super.onEnable();
        saveDefaultConfig();
        UpdateSpigot.start();
        wiad.log(Level.INFO, "RCode plugin!");
        getCommand("chat").setExecutor(new ChatCMD());
        Bukkit.getPluginManager().registerEvents(new ChatListener(),this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
        wiad.log(Level.INFO, "Disable plugin for Chat!");
        wiad.log(Level.INFO, "RCode plugin!");
    }


    public static Main getInstance() {
        return Main.getPlugin(Main.class);
    }
}
