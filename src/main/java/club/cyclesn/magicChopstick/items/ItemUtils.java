package club.cyclesn.magicChopstick.items;

import club.cyclesn.magicChopstick.MagicChopstick;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class ItemUtils {
    static public boolean isCustomItem(@NotNull ItemStack item, String type) {
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer data = null;
        if (meta != null) {
            data = meta.getPersistentDataContainer();
        }
        if (data != null) {
            return type.equals(data.get(MagicChopstick.MagicChopstickKey, PersistentDataType.STRING));
        }
        return false;
    }

    static public boolean isMagicChopstick(ItemStack item) {
        if (item == null || !item.hasItemMeta()) {
            return false;
        }
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            PersistentDataContainer data = meta.getPersistentDataContainer();
            return data.has(MagicChopstick.MagicChopstickKey, PersistentDataType.STRING);
        }
        return false;
    }
}
