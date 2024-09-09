package club.cyclesn.magicChopstick.commands;

import club.cyclesn.magicChopstick.MagicChopstick;
import club.cyclesn.magicChopstick.items.Chopstick;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MagicCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player) {
            if (strings.length > 0) {
                String type = strings[0].toLowerCase();
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
