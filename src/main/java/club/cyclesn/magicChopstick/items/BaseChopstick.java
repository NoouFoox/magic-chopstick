package club.cyclesn.magicChopstick.items;


import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class BaseChopstick extends AbstractChopstick {
    public BaseChopstick() {
        super("chopstick_base", 20, "§6基础魔法筷子");
    }
    @Override
    public void skill(@NotNull Player player, ItemStack item) {
        player.sendMessage("§6Fast as wind");
    }
}
