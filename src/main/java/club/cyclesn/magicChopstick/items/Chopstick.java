package club.cyclesn.magicChopstick.items;

import club.cyclesn.magicChopstick.MagicChopstick;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public abstract class Chopstick {
    private final String NAME_KEY;
    private final int COOL_TICKS;
    private final String displayName;
    private Material material = Material.STICK;
    public Chopstick(String NAME_KEY, int COOL_TICKS, String displayName) {
        this.NAME_KEY = NAME_KEY;
        this.COOL_TICKS = COOL_TICKS;
        this.displayName = displayName;
    }
    public Chopstick(String NAME_KEY, int COOL_TICKS, String displayName, Material material) {
        this.NAME_KEY = NAME_KEY;
        this.COOL_TICKS = COOL_TICKS;
        this.displayName = displayName;
        this.material = material;
    }

    public ItemStack getItem() {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(displayName);
            PersistentDataContainer data = meta.getPersistentDataContainer();
            data.set(MagicChopstick.MagicChopstickKey, PersistentDataType.STRING, this.NAME_KEY);
        }
        item.setItemMeta(meta);
        return item;
    }

    public boolean isEquals(ItemStack item) {
        return ItemUtils.isCustomItem(item, NAME_KEY);
    }

    public abstract void skill(@NotNull Player player, ItemStack item);

    public void useSkill(@NotNull Player player, @NotNull ItemStack item) {
        if (player.hasCooldown(item.getType())) {
            return;
        }
        player.setCooldown(item.getType(), COOL_TICKS);
        skill(player, item);
    }
}
