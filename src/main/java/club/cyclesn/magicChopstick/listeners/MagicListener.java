package club.cyclesn.magicChopstick.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import static club.cyclesn.magicChopstick.items.BaseItems.BASE_CHOPSTICK_KEY;
import static club.cyclesn.magicChopstick.items.ItemUtils.isCustomItem;

public class MagicListener implements Listener {
    // 冷却时间
    private static final int BASE_CHOPSTICK_COOL_DOWN_TICKS = 100;
    @EventHandler
    public void onPlayerUseWand(@NotNull PlayerInteractEvent event) {
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        if (isCustomItem(item, BASE_CHOPSTICK_KEY)) {
            Player player = event.getPlayer();
            if(player.hasCooldown(item.getType())){
                return;
            }
            player.getWorld().strikeLightning(player.getTargetBlock(null, 50).getLocation());
            player.setCooldown(item.getType(), BASE_CHOPSTICK_COOL_DOWN_TICKS);
        }
    }
}
