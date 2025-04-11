package me.munchii.igloolib;

import me.munchii.igloolib.nms.service.ItemStackService;
import me.munchii.igloolib.nms.service.NBTService;
import me.munchii.igloolib.nms.NMSFactory;
import org.bukkit.Bukkit;

public class NMSProvider {
    private static final NMSFactory nmsFactory;

    public static final NBTService NBT;
    public static final ItemStackService ITEM_STACK;

    static {
        nmsFactory = loadFactory();

        NBT = nmsFactory.createNBTService();
        ITEM_STACK = nmsFactory.createItemStackService();
    }

    private static NMSFactory loadFactory() {
        String version = VersionUtil.getDetectedVersion();
        try {
            String className = "me.munchii.igloolib.nms." + version + ".NMSFactoryImpl";
            Class<?> factoryClass = Class.forName(className);
            return (NMSFactory) factoryClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load NMSFactory for version " + version, e);
        }
    }

    protected static boolean isSupportedVersion() {
        return nmsFactory != null;
    }

    public static class VersionUtil {
        private static final String detectedVersion;

        static {
            String packageName = Bukkit.getServer().getClass().getPackage().getName();
            detectedVersion = packageName.substring(packageName.lastIndexOf('.') + 1).replace("R", "");
        }

        public static String getDetectedVersion() {
            return detectedVersion;
        }
    }
}
