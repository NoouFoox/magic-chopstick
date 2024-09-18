package club.cyclesn.magicChopstick.commands;

import club.cyclesn.magicChopstick.MagicChopstick;
import club.cyclesn.magicChopstick.items.Chopstick;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;


public class MagicCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        ItemStack itemStack = new ItemStack(Material.GOLDEN_HELMET);
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            NamespacedKey key = new NamespacedKey(MagicChopstick.plugin, "attr-scale");
            AttributeModifier modifier = new AttributeModifier(
                    key,
                    -0.9,
                    AttributeModifier.Operation.ADD_SCALAR,
                    EquipmentSlotGroup.HEAD
            );
            meta.setDisplayName("§6缩小帽");
            meta.addAttributeModifier(Attribute.GENERIC_SCALE, modifier);
            itemStack.setItemMeta(meta);
            if (commandSender instanceof Player player) {
                player.getInventory().addItem(itemStack);
            }
        }
        if (commandSender instanceof Player player) {
            if (strings.length > 0) {
                String type = strings[0].toLowerCase();
                player.sendMessage("§6正在尝试获取法杖" + type);
                Chopstick chopstick = MagicChopstick.chopsticks.stream().filter(c -> c.isEquals(type)).findFirst().orElse(null);
                if (chopstick != null) {
                    player.getInventory().addItem(chopstick.getItem());
                    player.sendMessage("§6获得了一个" + chopstick.getDisplayName());
                } else {
                    player.sendMessage("§c未找到该法杖");
                }
                return true;
            }
            player.sendMessage("§c请正确使用指令");
        }
        return false;
    }
}
