package dev.cosinusjay.lpGlobalPrefix.listeners

import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
import net.luckperms.api.LuckPerms
import net.luckperms.api.LuckPermsProvider
import net.luckperms.api.model.group.Group
import net.luckperms.api.model.user.User
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

class PlayerChatListener : Listener {
    private val luckPerms: LuckPerms = LuckPermsProvider.get()
    private val miniMessage: MiniMessage = MiniMessage.miniMessage()
    private val legacySerializer: LegacyComponentSerializer = LegacyComponentSerializer.legacySection()

    @EventHandler
    fun onPlayerChat(event: AsyncPlayerChatEvent) {
        val player = event.player
        val user: User = luckPerms.userManager.getUser(player.uniqueId) ?: return
        val primaryGroupName = user.primaryGroup
        val group: Group? = luckPerms.groupManager.getGroup(primaryGroupName)
        val prefix = group?.cachedData?.metaData?.prefix ?: ""


        val rawMessage = "$prefix${player.name}: ${event.message}"
        val component = miniMessage.deserialize(rawMessage)

        // Honestly no idea why this works. Does not show up correctly unless done like this
        val formattedMessage = legacySerializer.serialize(component)

        // Format message
        event.format = formattedMessage.replace("%", "%%")
    }
}
