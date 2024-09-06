package club.cyclesn.magicChopstick;

import club.cyclesn.magicChopstick.listeners.MagicListener;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public final class MagicChopstick extends JavaPlugin {
    public static MagicChopstick plugin;
    public static NamespacedKey MagicChopstickKey;
    @Override
    public void onLoad() {
        plugin = this;
        MagicChopstickKey = new NamespacedKey(this, "magic_chopstick");
        getServer().getPluginManager().registerEvents(new MagicListener(), this);
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
