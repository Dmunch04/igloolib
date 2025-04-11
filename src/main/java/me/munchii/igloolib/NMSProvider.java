package me.munchii.igloolib;

import me.munchii.igloolib.nms.FactoryHolder;
import me.munchii.igloolib.nms.NMSFactory;
import me.munchii.igloolib.nms.service.*;
import org.bukkit.Bukkit;

public class NMSProvider {
    public static final NMSFactory nmsFactory;

    public static final NBTService NBT;
    public static final ItemStackService ITEM_STACK;
    public static final PDCService PDC;
    public static final CraftPlayerService CRAFT_PLAYER;
    public static final CraftServerService CRAFT_SERVER;

    static {
        nmsFactory = loadFactory();
        FactoryHolder.setFactory(nmsFactory);

        NBT = nmsFactory.createNBTService();
        ITEM_STACK = nmsFactory.createItemStackService();
        PDC = nmsFactory.createPDCService();
        CRAFT_PLAYER = nmsFactory.createCraftPlayerService();
        CRAFT_SERVER = nmsFactory.createCraftServerService();
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
