package rcode.chat.config;

import org.bukkit.configuration.file.FileConfiguration;

public class Data {

    private FileConfiguration configuration;

    public Data(FileConfiguration configuration) {
        this.configuration = configuration;
    }


    public String getMsg(String msg) {
        return this.configuration.getString(msg);
    }

    public void setChat(Boolean chat) {
        this.configuration.set("chatEnabled", chat);
    }

    public boolean getChat() {
        return this.configuration.getBoolean("chatEnabled");
    }

}
