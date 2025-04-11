package me.munchii.igloolib.nms;

import me.munchii.igloolib.nms.service.*;
import org.jetbrains.annotations.NotNull;

/**
 * The NMSFactory interface provides methods to create instances of services
 * and NBT (Named Binary Tag) related objects used in server and player-related functionality.
 * This factory serves as an abstraction layer to interact with Minecraft's internal mechanisms.
 */
public interface NMSFactory {
    /**
     * Creates and returns an instance of the NBTService, which provides utilities
     * for working with Named Binary Tag (NBT) data structures in the context of
     * server and player-related functionality.
     *
     * @return a non-null instance of NBTService to manipulate NBT data.
     */
    @NotNull NBTService createNBTService();

    /**
     * Creates and returns an instance of the ItemStackService, which provides utilities
     * for handling conversions and manipulation of ItemStack objects between
     * Bukkit and NMS (net.minecraft.server) implementations.
     *
     * @return a non-null instance of ItemStackService to handle ItemStack operations.
     */
    @NotNull ItemStackService createItemStackService();

    /**
     * Creates and returns an instance of PDCService, which provides utilities for
     * manipulating PersistentDataContainer objects and converting them into
     * corresponding NBTTagCompound objects.
     *
     * @return a non-null instance of PDCService to handle PersistentDataContainer operations.
     */
    @NotNull PDCService createPDCService();

    /**
     * Creates and returns an instance of the CraftPlayerService, which provides utilities
     * for interacting with player entities, including sending network packets directly
     * to a specified player.
     *
     * @return a non-null instance of CraftPlayerService to handle player-related functionalities.
     */
    @NotNull CraftPlayerService createCraftPlayerService();

    /**
     * Creates and returns an instance of the CraftServerService, which provides utilities
     * for server-related functionalities, such as retrieving the command map associated
     * with a Bukkit server.
     *
     * @return a non-null instance of CraftServerService to handle server-related operations.
     */
    @NotNull CraftServerService createCraftServerService();


    /**
     * Creates and returns a new instance of an NbtCompound, which is a representation
     * of a compound tag structure used for storing keyed data in NBT (Named Binary Tag) format.
     *
     * @return a non-null instance of NbtCompound representing an empty compound tag.
     */
    @NotNull NbtCompound createNbtCompound();

    /**
     * Creates and returns a new instance of an NbtCompound based on an existing NBTTagCompound.
     * The returned NbtCompound is a representation of the compound tag structure provided by the
     * Minecraft NBT (Named Binary Tag) format.
     *
     * @param compound the existing NBTTagCompound input to base the newly created NbtCompound on.
     * @return a non-null instance of NbtCompound containing the data from the provided NBTTagCompound.
     */
    @NotNull NbtCompound createNbtCompound(net.minecraft.nbt.NBTTagCompound compound);
}
