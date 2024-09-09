package club.cyclesn.magicChopstick.items.chopsticks;

import club.cyclesn.magicChopstick.inter.MagicItem;
import club.cyclesn.magicChopstick.items.Chopstick;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
@MagicItem
public class WingChopstick extends Chopstick {
    public WingChopstick() {
        super("chopstick_wing", 3, "§c飞来杖");
    }

    @Override
    public void skill(@NotNull Player player, ItemStack item) {
        player.sendMessage("§c飞来杖");
    }
}
