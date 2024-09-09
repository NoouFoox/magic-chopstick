package club.cyclesn.magicChopstick.listeners;

import club.cyclesn.magicChopstick.items.Chopstick;
import club.cyclesn.magicChopstick.items.BaseChopstick;
import club.cyclesn.magicChopstick.items.chopsticks.WingChopstick;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;

import static club.cyclesn.magicChopstick.items.ItemUtils.isMagicChopstick;

public class MagicListener implements Listener {
    private static final EnumSet<Action> VALID_ACTIONS = EnumSet.of(Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK);
    @EventHandler
    public void onPlayerUseWand(@NotNull PlayerInteractEvent event) {
        Action action = event.getAction();
        if (!VALID_ACTIONS.contains(action)) {
            return;
        }
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (isMagicChopstick(item)) {
            ArrayList<Chopstick> chopsticks = new ArrayList<>(Arrays.asList(new BaseChopstick(), new WingChopstick()));
            chopsticks.stream().filter(c -> c.isEquals(item)).findFirst().ifPresent(chopstick -> {
                chopstick.useSkill(player, item);
            });
        }
    }
}
