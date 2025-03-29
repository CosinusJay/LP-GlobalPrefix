package dev.cosinusjay.lpGlobalPrefix.listeners

import net.kyori.adventure.text.minimessage.MiniMessage
import net.luckperms.api.LuckPerms
import net.luckperms.api.LuckPermsProvider
import net.luckperms.api.model.group.Group
import net.luckperms.api.model.user.User
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoinListener : Listener {
    private val luckPerms: LuckPerms = LuckPermsProvider.get()
    private val miniMessage: MiniMessage = MiniMessage.miniMessage()

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        val user: User = luckPerms.userManager.getUser(player.uniqueId) ?: return
        val primaryGroupName = user.primaryGroup
        val group: Group? = luckPerms.groupManager.getGroup(primaryGroupName)
        val prefix = group?.cachedData?.metaData?.prefix ?: ""

        // Combine prefix and player name
        val combined = "$prefix${player.name}"

        // Use minimessage for HEX code support
        val component = miniMessage.deserialize(combined)

        // Actually set the players name
        player.playerListName(component)
    }
}
