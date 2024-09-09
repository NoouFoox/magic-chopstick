package club.cyclesn.magicChopstick.listeners;

import club.cyclesn.magicChopstick.items.Chopstick;
import club.cyclesn.magicChopstick.items.BaseChopstick;
import club.cyclesn.magicChopstick.items.chopsticks.WingChopstick;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

import static club.cyclesn.magicChopstick.items.ItemUtils.isMagicChopstick;

public class MagicListener implements Listener {
    @EventHandler
    public void onPlayerUseWand(@NotNull PlayerInteractEvent event) {
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        Player player = event.getPlayer();
        if (isMagicChopstick(item)) {
            ArrayList<Chopstick> chopsticks = new ArrayList<>(Arrays.asList(new BaseChopstick(), new WingChopstick()));
            chopsticks.stream().filter(c -> c.isEquals(item)).findFirst().ifPresent(chopstick -> {
                chopstick.useSkill(player, item);
            });
        }
    }
}
