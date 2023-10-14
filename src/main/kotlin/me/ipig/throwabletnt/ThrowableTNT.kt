package me.ipig.throwabletnt


import me.ipig.throwabletnt.commands.gettnt
import me.ipig.throwabletnt.listeners.InteractListener
import org.bukkit.plugin.java.JavaPlugin


class ThrowableTNT : JavaPlugin() {

    override fun onEnable() {
        logger.info("kotlin hi")
        getCommand("gettnt").setExecutor(gettnt())
        server.pluginManager.registerEvents(InteractListener(), this)

    }

}
