package dev.cosinusjay.lpGlobalPrefix

import dev.cosinusjay.lpGlobalPrefix.commands.ReloadGroups
import dev.cosinusjay.lpGlobalPrefix.listeners.PlayerChatListener
import dev.cosinusjay.lpGlobalPrefix.listeners.PlayerJoinListener
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    override fun onEnable() {
        logger.info("Enabling plugin...")
        server.pluginManager.registerEvents(PlayerChatListener(), this)
        server.pluginManager.registerEvents(PlayerJoinListener(), this)
        this.getCommand("reloadgroups")?.setExecutor(ReloadGroups())
    }

    override fun onDisable() {
        logger.info("Disabling plugin...")
        logger.info("Thank you and Goodbye!")
    }
}
