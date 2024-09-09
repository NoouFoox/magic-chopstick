package club.cyclesn.magicChopstick.commands;

import club.cyclesn.magicChopstick.MagicChopstick;
import club.cyclesn.magicChopstick.items.Chopstick;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MagicCommandCompleter implements TabCompleter {
    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("givechopstick") && args.length == 1) {
            List<String> choices = MagicChopstick.chopsticks.stream().map(Chopstick::getNAME_KEY).toList();
            List<String> completions = new ArrayList<>();
            for (String wand : choices) {
                if (wand.toLowerCase().startsWith(args[0].toLowerCase())) {
                    completions.add(wand);
                }
            }
            return completions;
        }
        return null;
    }
}
