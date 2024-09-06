package club.cyclesn.magicChopstick.items;

import club.cyclesn.magicChopstick.MagicChopstick;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class BaseItems {
    public static final String BASE_CHOPSTICK_KEY = "base_chopstick";

    //    基础魔法筷子
    static public ItemStack BaseChopstick() {
        ItemStack wand = new ItemStack(Material.STICK);
        ItemMeta meta = wand.getItemMeta();
        if (meta != null) {
            meta.setDisplayName("§6Magic Wand");
            PersistentDataContainer data = meta.getPersistentDataContainer();
            data.set(MagicChopstick.MagicChopstickKey, PersistentDataType.STRING, BASE_CHOPSTICK_KEY);
        }
        wand.setItemMeta(meta);
        return wand;
    }
}
