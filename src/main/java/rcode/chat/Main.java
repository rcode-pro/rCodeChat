package rcode.chat;

import com.google.common.collect.Sets;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import rcode.chat.cmd.ChatCMD;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends JavaPlugin {

    private final Logger wiad = Bukkit.getLogger();

    public static Set<Integer> chat = Sets.newConcurrentHashSet();

    @Override
    public void onEnable() {
        super.onEnable();
        saveDefaultConfig();
        wiad.log(Level.INFO, "Enable plugin for Chat!");
        wiad.log(Level.INFO, "RCode plugin!");
        getCommand("chat").setExecutor(new ChatCMD());
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
