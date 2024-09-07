package club.cyclesn.magicChopstick;

import club.cyclesn.magicChopstick.commands.MagicCommand;
import club.cyclesn.magicChopstick.lib.MagicTimerHash;
import club.cyclesn.magicChopstick.listeners.MagicListener;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class MagicChopstick extends JavaPlugin {
    public static MagicChopstick plugin;
    public static NamespacedKey MagicChopstickKey;
    public static MagicTimerHash magicTimerHash;
    @Override
    public void onLoad() {
        plugin = this;
        magicTimerHash = new MagicTimerHash();
        MagicChopstickKey = new NamespacedKey(this, "magic_chopstick");
        getServer().getPluginManager().registerEvents(new MagicListener(), this);
        Objects.requireNonNull(getServer().getPluginCommand("givechopstick")).setExecutor(new MagicCommand());
        System.out.println("MagicChopstick loaded");
    }
    @Override
    public void onEnable() {
        System.out.println("MagicChopstick enabled");
    }
    @Override
    public void onDisable() {
        System.out.println("MagicChopstick disabled");
    }
}
