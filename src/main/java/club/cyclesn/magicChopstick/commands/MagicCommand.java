package club.cyclesn.magicChopstick.commands;
import club.cyclesn.magicChopstick.items.BaseChopstick;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MagicCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player){
//            player.getInventory().addItem(new BaseChopstick().getItem());
            player.sendMessage("§6获得了一个基础魔法筷子");
            return true;
        }
        return false;
    }
}
