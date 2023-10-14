package me.ipig.throwabletnt.commands

import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class gettnt:CommandExecutor {
    override fun onCommand(
        sender: CommandSender?,
        command: Command?,
        label: String?,
        args: Array<out String>?
    ): Boolean {
        if (sender !is Player) return false
        if (sender.hasPermission("throwabletnt.use")) {
            val tnt = ItemStack(Material.TNT)
            val meta = tnt.itemMeta
            meta.displayName = "§aThrowable TNT"
            val lore = ArrayList<String>()
            lore.add("Right click to throw it")
            meta.lore = lore
            tnt.itemMeta = meta
            sender.inventory.addItem(tnt)

        }
        return true
    }
}