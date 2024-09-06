package club.cyclesn.magicChopstick.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static club.cyclesn.magicChopstick.items.BaseItems.BaseChopstick;

public class MagicCommands implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player){
            player.getInventory().addItem(BaseChopstick());
            player.sendMessage("§6获得了一个基础魔法筷子");
            return true;
        }
        return false;
    }
}
