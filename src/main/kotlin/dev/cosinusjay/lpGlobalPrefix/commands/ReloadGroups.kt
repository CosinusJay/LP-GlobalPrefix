package dev.cosinusjay.lpGlobalPrefix.commands

import net.kyori.adventure.text.minimessage.MiniMessage
import net.luckperms.api.LuckPerms
import net.luckperms.api.LuckPermsProvider
import net.luckperms.api.model.group.Group
import net.luckperms.api.model.user.User
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class ReloadGroups : CommandExecutor {
    private val luckPerms: LuckPerms = LuckPermsProvider.get()
    private val miniMessage: MiniMessage = MiniMessage.miniMessage()

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (!sender.hasPermission("lpgp.command.reloadgroups")) return true

        for (player in Bukkit.getOnlinePlayers()) {
            val user: User = luckPerms.userManager.getUser(player.uniqueId) ?: continue
            val primaryGroupName = user.primaryGroup
            val group: Group? = luckPerms.groupManager.getGroup(primaryGroupName)
            val prefix = group?.cachedData?.metaData?.prefix ?: ""
            val combined = "$prefix${player.name}"

            val component = miniMessage.deserialize(combined)
            player.playerListName(component)
        }
        sender.sendMessage(("§8[§cLP-GP§8]  »  §c${Bukkit.getOnlinePlayers().size} Players have been reloaded!"))
        return true
    }
}
