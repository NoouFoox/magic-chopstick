package club.cyclesn.magicChopstick.lib;

import club.cyclesn.magicChopstick.inter.MagicItem;
import club.cyclesn.magicChopstick.items.Chopstick;
import org.jetbrains.annotations.NotNull;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PluginUtils {
    public static @NotNull List<Class<?>> getAnnotatedItemClasses(Class<? extends Annotation> annotation) {
        List<Class<?>> itemClasses = new ArrayList<>();
        Reflections reflections = new Reflections("club.cyclesn.magicChopstick"); // 替换为实际的包名
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(annotation);
        for (Class<?> clazz : classes) {
            if (!Modifier.isAbstract(clazz.getModifiers())) {
                itemClasses.add(clazz);
            }
        }
        return itemClasses;
    }

    public static ArrayList<Chopstick> getAllChopsticks() {
        ArrayList<Chopstick> chopsticks = new ArrayList<>();
        List<Class<?>> itemClasses = getAnnotatedItemClasses(MagicItem.class);
        for (Class<?> clazz : itemClasses) {
            try {
                Chopstick chopstick = (Chopstick) clazz.getDeclaredConstructor().newInstance();
                chopsticks.add(chopstick);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return chopsticks;
    }

    ;
}
