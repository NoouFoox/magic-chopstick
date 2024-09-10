package club.cyclesn.magicChopstick.items;

import club.cyclesn.magicChopstick.MagicChopstick;
import club.cyclesn.magicChopstick.lib.PlayerUtils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class Chopstick {
    private final String NAME_KEY;
    private final int COOL_SECONDS;
    ;
    private final String displayName;
    private Material material = Material.STICK;

    public String getNAME_KEY() {
        return NAME_KEY;
    }

    public Chopstick(String NAME_KEY, int COOL_SECONDS, String displayName) {
        this.NAME_KEY = NAME_KEY;
        this.COOL_SECONDS = COOL_SECONDS;
        this.displayName = displayName;
    }

    public Chopstick(String NAME_KEY, int COOL_SECONDS, String displayName, Material material) {
        this.NAME_KEY = NAME_KEY;
        this.COOL_SECONDS = COOL_SECONDS;
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

    public String getDisplayName() {
        return displayName;
    }

    public boolean isEquals(ItemStack item) {
        return ItemUtils.isCustomItem(item, NAME_KEY);
    }

    public boolean isEquals(String displayName) {
        return this.NAME_KEY.equals(displayName);
    }

    public abstract void skill(@NotNull Player player, ItemStack item, PlayerEvent event);

    public void useSkill(@NotNull Player player, @NotNull ItemStack item, PlayerEvent event) {
        UUID playerId = player.getUniqueId();
        long currentTime = System.currentTimeMillis();
        int coolTime = this.COOL_SECONDS * 1000;
        Map<String, Long> playerCools = MagicChopstick.cooldowns.getOrDefault(playerId, new HashMap<>());
        if (playerCools.containsKey(this.NAME_KEY)) {
            long lastUsed = playerCools.get(this.NAME_KEY);
            double coldRemaining = (double) (coolTime - (currentTime - lastUsed)) / 1000;
            if (coldRemaining > 0) {
                String formattedCool = String.format("%.2f", coldRemaining);
                PlayerUtils.SendBarTitle(player, "§e冷却中: " + formattedCool + " 秒");
                return;
            }
        }
        playerCools.put(this.NAME_KEY, currentTime);
        MagicChopstick.cooldowns.put(playerId, playerCools);
        skill(player, item, event);
    }
}
