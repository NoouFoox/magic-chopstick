package club.cyclesn.magicChopstick.items.chopsticks;

import club.cyclesn.magicChopstick.items.AbstractChopstick;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class WingChopstick extends AbstractChopstick {
    public WingChopstick() {
        super("chopstick_wing", 25, "§c飞来杖");
    }

    @Override
    public void skill(@NotNull Player player, ItemStack item) {
        player.sendMessage("§c飞来杖");
    }
}
