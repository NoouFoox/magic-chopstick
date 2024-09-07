package club.cyclesn.magicChopstick.items;

import club.cyclesn.magicChopstick.MagicChopstick;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class ItemUtils {
    static public boolean isCustomItem(ItemStack item, String type) {
        if (item == null || !item.hasItemMeta()) {
            return false;
        }
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
        PersistentDataContainer data = meta.getPersistentDataContainer();
            return type.equals(data.get(MagicChopstick.MagicChopstickKey, PersistentDataType.STRING));
        }
        return false;
    }
}
