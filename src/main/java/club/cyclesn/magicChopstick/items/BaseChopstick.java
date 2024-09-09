package club.cyclesn.magicChopstick.items;

import club.cyclesn.magicChopstick.MagicChopstick;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class BaseChopstick {
    public final String NAME_KEY = "base_chopstick";
    public int COOL_TICKS = 20;
    public final String displayName = "§6Magic Wand";
    public Material material = Material.STICK;

    public ItemStack getItem() {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(displayName);
            PersistentDataContainer data = meta.getPersistentDataContainer();
            data.set(MagicChopstick.MagicChopstickKey, PersistentDataType.STRING, NAME_KEY);
        }
        item.setItemMeta(meta);
        return item;
    }

    public boolean isEquals(ItemStack item) {
        return ItemUtils.isCustomItem(item, NAME_KEY);
    }

    public void skill(@NotNull Player player, ItemStack item) {
        player.sendMessage("§6You used the magic wand");
    }

    public void useSkill(@NotNull Player player, @NotNull ItemStack item) {
        if (player.hasCooldown(item.getType())) {
            return;
        }
        skill(player, item);
        player.setCooldown(item.getType(), COOL_TICKS);
    }
}
