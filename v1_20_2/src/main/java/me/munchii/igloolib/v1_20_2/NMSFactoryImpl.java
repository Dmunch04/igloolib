package me.munchii.igloolib.v1_20_2;

import me.munchii.igloolib.nms.NbtCompound;
import me.munchii.igloolib.nms.service.*;
import me.munchii.igloolib.nms.NMSFactory;
import me.munchii.igloolib.v1_20_2.service.*;
import net.minecraft.nbt.NBTTagCompound;
import org.jetbrains.annotations.NotNull;

public class NMSFactoryImpl implements NMSFactory {
    private static final NBTService NBT_SERVICE = new NBTServiceImpl();
    private static final ItemStackService ITEM_STACK_SERVICE = new ItemStackServiceImpl();
    private static final PDCService PDC_SERVICE = new PDCServiceImpl();
    private static final CraftPlayerService CRAFT_PLAYER_SERVICE = new CraftPlayerServiceImpl();
    private static final CraftServerService CRAFT_SERVER_SERVICE = new CraftServerServiceImpl();

    @Override
    public @NotNull NBTService createNBTService() {
        return NBT_SERVICE;
    }

    @Override
    public @NotNull ItemStackService createItemStackService() {
        return ITEM_STACK_SERVICE;
    }

    @Override
    public @NotNull PDCService createPDCService() {
        return PDC_SERVICE;
    }

    @Override
    public @NotNull CraftPlayerService createCraftPlayerService() {
        return CRAFT_PLAYER_SERVICE;
    }

    @Override
    public @NotNull CraftServerService createCraftServerService() {
        return CRAFT_SERVER_SERVICE;
    }

    @Override
    public @NotNull NbtCompound createNbtCompound() {
        return NbtCompoundImpl.empty();
    }

    @Override
    public @NotNull NbtCompound createNbtCompound(NBTTagCompound compound) {
        return NbtCompoundImpl.of(compound);
    }
}
