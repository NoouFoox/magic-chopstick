package club.cyclesn.magicChopstick.items.chopsticks;

import club.cyclesn.magicChopstick.inter.MagicItem;
import club.cyclesn.magicChopstick.items.Chopstick;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.Particle;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

@MagicItem
public class WingChopstick extends Chopstick {
    public WingChopstick() {
        super("chopstick_wing", 3, "§c飞来杖");
    }

    @Override
    public void skill(@NotNull Player player, ItemStack item, PlayerEvent event) {
        double range = 20.0;
        double step = 0.5;

        Location startLocation = player.getEyeLocation();
        Location currentLocation = startLocation.clone();
        for (double distance = 0; distance < range; distance += step) {
            currentLocation.add(startLocation.getDirection().multiply(step));
            player.getWorld().spawnParticle(Particle.DUST, currentLocation, 1, new Particle.DustOptions(Color.BLUE, 1));
            Entity entity = getNearbyEntity(currentLocation, player);
            if (entity != null) {
                if (entity instanceof LivingEntity livingEntity) {
                    livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 100, 1)); // 5秒漂浮
//                    player.sendMessage("§b你对 " + livingEntity.getName() + " 使用了漂浮术！");
                }
                return;
            }
        }
    }
    // 检测粒子当前位置附近的实体
    private @Nullable Entity getNearbyEntity(@NotNull Location location, Player player) {
        for (Entity entity : Objects.requireNonNull(location.getWorld()).getEntities()) {
            if (entity instanceof LivingEntity && entity != player) {
                // 检测实体是否在当前位置附近
                if (entity.getLocation().distance(location) < 1.0) { // 检测半径为1的范围
                    return entity;
                }
            }
        }
        return null; // 未找到实体
    }
}
