package me.fadegor05.badgescraft;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class BadgesCraft extends JavaPlugin {

    private static final Logger logger = Logger.getLogger("Minecraft");

    private static BadgesCraft plugin;

    public static BadgesCraft getPlugin() { return plugin; }

    @Override
    public void onEnable() {
        plugin = this;

        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }

        logger.info("BadgesCraft 1.0 has been enabled!");

    }

}
