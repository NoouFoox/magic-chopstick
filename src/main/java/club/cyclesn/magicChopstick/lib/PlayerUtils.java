package club.cyclesn.magicChopstick.lib;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlayerUtils {
    static public void SendBarTitle(@NotNull Player player, String msg) {
        player.spigot().sendMessage(
                ChatMessageType.ACTION_BAR,
                new TextComponent(msg)
        );
    }
}
