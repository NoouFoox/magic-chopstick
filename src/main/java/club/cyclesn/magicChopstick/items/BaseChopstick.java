package club.cyclesn.magicChopstick.items;


import club.cyclesn.magicChopstick.inter.MagicItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
@MagicItem
public class BaseChopstick extends Chopstick {
    public BaseChopstick() {
        super("chopstick_base", 20, "§6基础法杖");
    }
    @Override
    public void skill(@NotNull Player player, ItemStack item) {
        player.getWorld().strikeLightning(player.getTargetBlock(null, 50).getLocation());
        player.sendMessage("§6Fast as wind");
    }
}
