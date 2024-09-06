package club.cyclesn.magicChopstick.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static club.cyclesn.magicChopstick.items.BaseItems.BASE_CHOPSTICK_KEY;
import static club.cyclesn.magicChopstick.items.ItemUtils.isCustomItem;

public class MagicListener implements Listener {
    @EventHandler
    public void onPlayerUseWand(PlayerInteractEvent event) {
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        if (isCustomItem(item, BASE_CHOPSTICK_KEY)) {
            Player player = event.getPlayer();
            player.getWorld().strikeLightning(player.getTargetBlock(null, 50).getLocation());
        }
    }
}
