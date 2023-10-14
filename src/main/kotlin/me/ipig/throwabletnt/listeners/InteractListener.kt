package me.ipig.throwabletnt.listeners

import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.TNTPrimed
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.util.Vector

class InteractListener:Listener {
    @EventHandler
    fun onInteract(event: PlayerInteractEvent) {
        if (event.action.equals(Action.RIGHT_CLICK_AIR) && event.player.itemInHand?.itemMeta?.displayName.equals("§aThrowable TNT")) {
            val p = event.player
            var direction = p.location.direction
            val tnt = p.world.spawnEntity(p.location, EntityType.PRIMED_TNT) as TNTPrimed
            tnt.fuseTicks = 20
            tnt.location.direction = direction
            tnt.velocity = direction.multiply(2)

            if (p.gameMode != GameMode.CREATIVE) {
                if (p.itemInHand.amount > 1) {
                    p.itemInHand.amount -= 1
                } else {
                    p.inventory.remove(p.itemInHand)
                }
            }

        }
    }
}