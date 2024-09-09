package club.cyclesn.magicChopstick.listeners;

import club.cyclesn.magicChopstick.items.BaseChopstick;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static club.cyclesn.magicChopstick.items.ItemUtils.isMagicChopstick;

public class MagicListener implements Listener {
    @EventHandler
    public void onPlayerUseWand(@NotNull PlayerInteractEvent event) {
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        Player player = event.getPlayer();
        if (isMagicChopstick(item)) {
            player.sendMessage("§c???");
        }
//        if (isCustomItem(item, BaseItems.NAME_KEY)) {
//            Player player = event.getPlayer();
//            if(player.hasCooldown(item.getType())){
//                return;
//            }
//            player.getWorld().strikeLightning(player.getTargetBlock(null, 50).getLocation());
//            player.setCooldown(item.getType(), BASE_CHOPSTICK_COOL_DOWN_TICKS);
//        }
    }
}
