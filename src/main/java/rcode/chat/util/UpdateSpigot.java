package rcode.chat.util;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import rcode.chat.Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UpdateSpigot {

    public static final void start() {
        ConsoleCommandSender d = Bukkit.getConsoleSender();
        String wersja = Main.getInstance().getDescription().getVersion();
        try {
            URL url = new URL("https://api.spigotmc.org/legacy/update.php?resource=100273");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            if (wersja.equals(bufferedReader.readLine())) {
                d.sendMessage(" ");
                d.sendMessage("§8============== §e< §9RCode.pro §e> §8=============");
                d.sendMessage(" ");
                d.sendMessage(" §7Plugin ~~~~~>  §arChat");
                d.sendMessage(" §7Version ~~~~> §e§l"+wersja + "§8 [§aLATEST§8]");
                d.sendMessage(" §7Support ~~~~>  https://discord.gg/UMmku5fka7");
                d.sendMessage(" ");
                d.sendMessage(" §eSpigot §7~~~~~>  https://spigot.rcode.pro");
                d.sendMessage(" §7Plugins ~~~~> rHelpop, RTP (Random teleport), ExtraLobby");
                d.sendMessage(" ");
                d.sendMessage("§8============== §e< §9RCode.pro §e> §8=============");
                d.sendMessage(" ");
            } else {
                d.sendMessage(" ");
                d.sendMessage("§8============== §e< §9RCode.pro §e> §8=============");
                d.sendMessage(" ");
                d.sendMessage(" §7Plugin ~~~~~>  §arChat");
                d.sendMessage(" §7Version ~~~~> §e§l"+wersja + "§8 [§cOUTDATED§8] §4Update: §bhttps://chat.rcode.pro");
                d.sendMessage(" §7Support ~~~~>  https://discord.gg/UMmku5fka7");
                d.sendMessage(" ");
                d.sendMessage(" §eSpigot §7~~~~~>  https://spigot.rcode.pro");
                d.sendMessage(" §7Plugins ~~~~> rHelpop, RTP (Random teleport), ExtraLobby");
                d.sendMessage(" ");
                d.sendMessage("§8============== §e< §9RCode.pro §e> §8=============");
                d.sendMessage(" ");
            }
        } catch (Exception exception) {
            for (int c = 0; c < 12; c++) {
                System.err.println("Problem with Connect to SpigotAPI");
            }
        }
    }
}
