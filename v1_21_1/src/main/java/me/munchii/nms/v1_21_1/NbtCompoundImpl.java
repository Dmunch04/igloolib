package me.munchii.nms.v1_21_1;

import me.munchii.igloolib.nms.FactoryHolder;
import me.munchii.igloolib.nms.NbtCompound;
import me.munchii.igloolib.nms.service.NBTService;
import net.minecraft.nbt.NBTTagCompound;
import org.bukkit.craftbukkit.v1_21_R1.persistence.CraftPersistentDataContainer;
import org.bukkit.craftbukkit.v1_21_R1.persistence.CraftPersistentDataTypeRegistry;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.jetbrains.annotations.NotNull;

public class NbtCompoundImpl extends NbtCompound {
    private static final NBTService NBT = FactoryHolder.getFactory().createNBTService();

    public NbtCompoundImpl() {
        super();
    }

    public NbtCompoundImpl(NBTTagCompound compound) {
        super(compound);
    }

    @Override
    public void copyInto(@NotNull ItemMeta itemMeta) {
        ((CraftPersistentDataContainer) itemMeta.getPersistentDataContainer()).putAll(this.compound);
    }

    @Override
    public @NotNull PersistentDataContainer toPersistentDataContainer() {
        CraftPersistentDataContainer pdc = new CraftPersistentDataContainer(new CraftPersistentDataTypeRegistry());
        pdc.putAll(this.compound);

        return pdc;
    }
}
