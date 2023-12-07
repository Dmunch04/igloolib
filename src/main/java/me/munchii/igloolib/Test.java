package me.munchii.igloolib;

import me.munchii.igloolib.chat.profanity.ProfanityFilter;
import me.munchii.igloolib.chat.profanity.ProfanityResult;
import me.munchii.igloolib.nms.IglooItem;
import me.munchii.igloolib.nms.NbtCompound;
import me.munchii.igloolib.util.SizedCache;
import net.minecraft.nbt.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_20_R2.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class Test {
    public static void main(String... args) {
        SizedCache<String, Integer> cache = new SizedCache<>(2);
        cache.put("yeet", 1);
        cache.put("yeet2", 2);
        cache.put("yeet3", 3);
        assert !cache.containsKey("yeet2");
        cache.getSafe("yeet3").ifPresent(System.out::println);

        String test = "hello you! you are a cunt.";
        ProfanityResult result = ProfanityFilter.filter(test, true);
        System.out.println(result.getSafeText("*"));

        ItemStack stack = new ItemStack(Material.ACACIA_BOAT);
        net.minecraft.world.item.ItemStack nmsStack = CraftItemStack.asNMSCopy(stack);
        NBTTagCompound tag = nmsStack.w();

        IglooItem item = IglooItem.of(stack);
        NbtCompound nbt = item.getOrCreateNbt();
        nbt.putBoolean("yeet", true);
        item.setNbt(nbt);
    }
}
