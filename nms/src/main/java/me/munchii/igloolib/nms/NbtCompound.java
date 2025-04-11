package me.munchii.igloolib.nms;

import me.munchii.igloolib.nms.service.ItemStackService;
import me.munchii.igloolib.nms.service.NBTService;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Represents an abstract wrapper for NBT (Named Binary Tag) compounds.
 * This class provides a high-level interface to manipulate NBT data commonly used in Minecraft.
 * It serves as a bridge between Bukkit's {@code ItemStack}, {@code ItemMeta}, and Minecraft's native
 * NBT handling, supporting various data types.
 *
 * An NBT compound is essentially a mapping of keys to values, where each key is a {@code String} and
 * can be associated with a value of various types including primitive types, arrays, or other compounds.
 *
 * This class provides utility methods to store, retrieve, and manipulate a variety of data types in an
 * underlying NBT structure, as well as integration for converting between native and Bukkit data structures.
 * Subclasses must implement abstract methods relating to Bukkit {@code PersistentDataContainer} conversions.
 *
 * Note: This class relies heavily on the {@link NBTService} and {@link ItemStackService} abstractions
 * to interact with NBT data. Actual implementations of these services are provided through
 * a {@link FactoryHolder}.
 */
public abstract class NbtCompound {
    private static final NBTService NBT = FactoryHolder.getFactory().createNBTService();
    private static final ItemStackService ITEM_STACK = FactoryHolder.getFactory().createItemStackService();

    protected net.minecraft.nbt.NBTTagCompound compound;

    /**
     * Constructs a new NbtCompound instance with an empty internal NBTTagCompound.
     * This is a wrapper for the net.minecraft nbt system, facilitating integration
     * and manipulation of NBTTagCompound data in custom implementations.
     */
    public NbtCompound() {
        this.compound = new net.minecraft.nbt.NBTTagCompound();
    }

    /**
     * Constructs a new NbtCompound instance by wrapping the provided
     * {@link net.minecraft.nbt.NBTTagCompound} object. This allows for extended
     * manipulation and integration with the Minecraft NBT system.
     *
     * @param compound The NBTTagCompound instance to wrap. Must not be null.
     */
    public NbtCompound(net.minecraft.nbt.NBTTagCompound compound) {
        this.compound = compound;
    }

    /**
     * Creates and returns an empty {@link NbtCompound} instance.
     * This method utilizes the {@link NMSFactory} to generate a new instance
     * of an NbtCompound with no pre-existing data.
     *
     * @return A new, empty {@link NbtCompound} instance.
     */
    public static NbtCompound empty() {
        return FactoryHolder.getFactory().createNbtCompound();
    }

    /**
     * Converts the given Bukkit ItemStack into an NbtCompound instance.
     * This method retrieves the NBT data associated with the provided ItemStack
     * and creates an NbtCompound representation based on it using the NMSFactory.
     *
     * @param stack The Bukkit ItemStack to be converted. Must not be null.
     * @return A non-null NbtCompound representation of the NBT data of the given ItemStack.
     */
    public static NbtCompound of(org.bukkit.inventory.@NotNull ItemStack stack) {
        return FactoryHolder.getFactory().createNbtCompound(ITEM_STACK.getNBT(stack));
    }

    /**
     * Converts the given Minecraft ItemStack into an NbtCompound instance.
     * This method retrieves the NBT data associated with the provided ItemStack
     * and creates an NbtCompound representation based on it using the NMSFactory.
     *
     * @param stack The Minecraft ItemStack to be converted. Must not be null.
     * @return A non-null NbtCompound representation of the NBT data of the given ItemStack.
     */
    public static NbtCompound of(net.minecraft.world.item.@NotNull ItemStack stack) {
        return FactoryHolder.getFactory().createNbtCompound(ITEM_STACK.getNBT(stack));
    }

    /**
     * Creates a new {@link NbtCompound} instance based on the provided {@link NbtCompound}.
     * This method utilizes the {@link FactoryHolder#getFactory()} to generate the new instance,
     * replicating the internal data of the given compound.
     *
     * @param compound The source NbtCompound instance to replicate. Must not be null.
     * @return A new instance of NbtCompound with data copied from the provided compound.
     */
    public static NbtCompound of(NbtCompound compound) {
        return FactoryHolder.getFactory().createNbtCompound(compound.compound);
    }

    /**
     * Creates a new {@link NbtCompound} instance based on the provided {@link net.minecraft.nbt.NBTTagCompound}.
     * This method wraps the given NBTTagCompound, allowing for enhanced manipulation and integration
     * with the Minecraft NBT system.
     *
     * @param compound The NBTTagCompound to wrap. Must not be null.
     * @return A new instance of NbtCompound wrapping the provided NBTTagCompound.
     */
    public static NbtCompound of(net.minecraft.nbt.NBTTagCompound compound) {
        return FactoryHolder.getFactory().createNbtCompound(compound);
    }

    /**
     * Copies the data from this {@link NbtCompound} into the provided {@link org.bukkit.inventory.meta.ItemMeta}.
     *
     * @param itemMeta The target {@link org.bukkit.inventory.meta.ItemMeta} instance into which the data from this
     *                 NbtCompound should be copied. Must not be null.
     */
    public abstract void copyInto(org.bukkit.inventory.meta.@NotNull ItemMeta itemMeta);

    /**
     * Converts the current NbtCompound instance into a PersistentDataContainer representation.
     * This method facilitates the transformation of NBT data into a Bukkit-compatible data container,
     * allowing seamless integration with Bukkit API features that rely on PersistentDataContainer.
     *
     * @return A non-null PersistentDataContainer representation of the current NbtCompound.
     */
    public abstract @NotNull org.bukkit.persistence.PersistentDataContainer toPersistentDataContainer();
    
    /**
     * Inserts an NbtCompound into the current compound under the specified key.
     * This method allows nesting of NBT data by associating an entire NbtCompound
     * instance as a value under the given key.
     *
     * @param key      The key under which the NbtCompound will be stored. Must not be null.
     * @param compound The NbtCompound instance to be inserted. Must not be null.
     */
    public void putCompound(@NotNull String key, @NotNull NbtCompound compound) {
        NBT.putCompound(this.compound, key, compound.getCompound());
    }
    
    /**
     * Inserts an {@link net.minecraft.nbt.NBTTagCompound} into the current compound under the specified key.
     * This allows nested storage of NBT data by associating an entire NBTTagCompound with the given key.
     *
     * @param key      The key under which the NBTTagCompound will be stored. Must not be null.
     * @param compound The NBTTagCompound instance to be inserted. Must not be null.
     */
    public void putCompound(@NotNull String key, @NotNull net.minecraft.nbt.NBTTagCompound compound) {
        NBT.putCompound(this.compound, key, compound);
    }

    /**
     * Inserts a byte value into the current NbtCompound under the specified key.
     * This allows associating the provided byte value with the given key in the compound's data.
     *
     * @param key   The key under which the byte value will be stored. Must not be null.
     * @param value The byte value to store in the compound.
     */
    public void putByte(@NotNull String key, byte value) {
        NBT.putByte(this.compound, key, value);
    }
    
    /**
     * Inserts a short value into the current NbtCompound under the specified key.
     * This allows associating the provided short value with the given key in the compound's data.
     *
     * @param key   The key under which the short value will be stored. Must not be null.
     * @param value The short value to store in the compound.
     */
    public void putShort(@NotNull String key, short value) {
        NBT.putShort(this.compound, key, value);
    }
    
    /**
     * Inserts an integer value into the current NbtCompound under the specified key.
     * This method allows associating the provided integer value with the given key in the compound's data.
     *
     * @param key   The key under which the integer value will be stored. Must not be null.
     * @param value The integer value to store in the compound.
     */
    public void putInt(@NotNull String key, int value) {
        NBT.putInt(this.compound, key, value);
    }
    
    /**
     * Inserts a long value into the current NbtCompound under the specified key.
     * This allows associating the provided long value with the given key
     * in the compound's data.
     *
     * @param key   The key under which the long value will be stored. Must not be null.
     * @param value The long value to store in the compound.
     */
    public void putLong(@NotNull String key, long value) {
        NBT.putLong(this.compound, key, value);
    }
    
    /**
     * Inserts a UUID value into the current NbtCompound under the specified key.
     * This method allows associating the provided UUID value with the given key in the compound's data.
     *
     * @param key  The key under which the UUID value will be stored. Must not be null.
     * @param uuid The UUID value to store in the compound. Must not be null.
     */
    public void putUUID(@NotNull String key, @NotNull UUID uuid) {
        NBT.putUUID(this.compound, key, uuid);
    }
    
    /**
     * Inserts a float value into the current NbtCompound under the specified key.
     * This allows associating the provided float value with the given key in the compound's data.
     *
     * @param key   The key under which the float value will be stored. Must not be null.
     * @param value The float value to store in the compound.
     */
    public void putFloat(@NotNull String key, float value) {
        NBT.putFloat(this.compound, key, value);
    }
    
    /**
     * Inserts a double value into the current NbtCompound under the specified key.
     * This method allows associating the provided double value with the given key in the compound's data.
     *
     * @param key   The key under which the double value will be stored. Must not be null.
     * @param value The double value to store in the compound.
     */
    public void putDouble(@NotNull String key, double value) {
        NBT.putDouble(this.compound, key, value);
    }
    
    /**
     * Adds a string value to the compound using the specified key.
     *
     * @param key The key to associate with the string value. Must not be null.
     * @param value The string value to store. Must not be null.
     */
    public void putString(@NotNull String key, @NotNull String value) {
        NBT.putString(this.compound, key, value);
    }
    
    /**
     * Stores a byte array in the NBT compound with the specified key.
     *
     * @param key the key under which the byte array will be stored; must not be null
     * @param value the byte array to store
     */
    public void putByteArray(@NotNull String key, byte[] value) {
        NBT.putByteArray(this.compound, key, value);
    }
    
    /**
     * Stores a list of bytes in the compound structure associated with the given key.
     *
     * @param key the non-null key under which the byte list will be stored
     * @param value the non-null list of bytes to be stored
     */
    public void putByteArray(@NotNull String key, @NotNull List<Byte> value) {
        NBT.putByteArray(this.compound, key, value);
    }
    
    /**
     * Stores an integer array in the NBT compound with the specified key.
     *
     * @param key The non-null key under which the integer array will be stored.
     * @param value The integer array to be stored in the NBT compound.
     */
    public void putIntArray(@NotNull String key, int[] value) {
        NBT.putIntArray(this.compound, key, value);
    }
    
    /**
     * Stores a list of integers into the compound using the specified key.
     *
     * @param key   the key associated with the integer array, must not be null
     * @param value the list of integers to store, must not be null
     */
    public void putIntArray(@NotNull String key, @NotNull List<Integer> value) {
        NBT.putIntArray(this.compound, key, value);
    }
    
    /**
     * Stores a long array into the underlying compound structure with the specified key.
     *
     * @param key the key under which the long array will be stored; must not be null
     * @param value the long array to be stored
     */
    public void putLongArray(@NotNull String key, long[] value) {
        NBT.putLongArray(this.compound, key, value);
    }
    
    /**
     * Stores a list of Long values in the compound NBT structure with the specified key.
     *
     * @param key the key with which the specified list of Long values is to be associated
     * @param value the list of Long values to be stored in the NBT compound
     */
    public void putLongArray(@NotNull String key, @NotNull List<Long> value) {
        NBT.putLongArray(this.compound, key, value);
    }
    
    /**
     * Stores a boolean value in a compound under the specified key.
     *
     * @param key The non-null key under which the boolean value will be stored.
     * @param value The boolean value to store.
     */
    public void putBoolean(@NotNull String key, boolean value) {
        NBT.putBoolean(this.compound, key, value);
    }
    
    /**
     * Retrieves the NBT compound associated with the specified key.
     *
     * @param key The key identifying the NBT compound. Must not be null.
     * @return The NbtCompound associated with the provided key.
     */
    public NbtCompound getCompound(@NotNull String key) {
        return NbtCompound.of(NBT.getCompound(this.compound, key));
    }
    
    /**
     * Retrieves the raw NBTTagCompound associated with the specified key.
     *
     * @param key the key used to locate the desired NBTTagCompound. Must not be null.
     * @return the NBTTagCompound corresponding to the given key. Never returns null.
     */
    public @NotNull net.minecraft.nbt.NBTTagCompound getRawCompound(@NotNull String key) {
        return NBT.getCompound(this.compound, key);
    }
    
    /**
     * Retrieves the byte value associated with the specified key from the compound.
     *
     * @param key the key used to look up the byte value, must not be null
     * @return the byte value corresponding to the specified key
     */
    public byte getByte(@NotNull String key) {
        return NBT.getByte(this.compound, key);
    }
    
    /**
     * Retrieves a short value associated with the specified key from the compound.
     *
     * @param key the key whose associated short value is to be returned; must not be null
     * @return the short value associated with the specified key
     */
    public short getShort(@NotNull String key) {
        return NBT.getShort(this.compound, key);
    }
    
    /**
     * Retrieves an integer value associated with the specified key from the compound data.
     *
     * @param key the key for which the integer value should be retrieved; must not be null
     * @return the integer value corresponding to the given key
     */
    public int getInt(@NotNull String key) {
        return NBT.getInt(this.compound, key);
    }
    
    /**
     * Retrieves a long value associated with the given key from the compound.
     *
     * @param key the key whose associated long value is to be returned, must not be null
     * @return the long value associated with the specified key
     */
    public long getLong(@NotNull String key) {
        return NBT.getLong(this.compound, key);
    }
    
    /**
     * Retrieves the UUID associated with the specified key from the compound.
     *
     * @param key the key used to retrieve the UUID, must not be null
     * @return the UUID associated with the specified key, never null
     */
    public @NotNull UUID getUUID(@NotNull String key) {
        return NBT.getUUID(this.compound, key);
    }
    
    /**
     * Retrieves a float value from the compound object using the specified key.
     *
     * @param key the key to look up in the compound. Must not be null.
     * @return the float value associated with the given key in the compound.
     */
    public float getFloat(@NotNull String key) {
        return NBT.getFloat(this.compound, key);
    }
    
    /**
     * Retrieves a double value associated with the specified key from the compound.
     *
     * @param key the key to look up in the compound; must not be null
     * @return the double value associated with the specified key
     */
    public double getDouble(@NotNull String key) {
        return NBT.getDouble(this.compound, key);
    }
    
    /**
     * Retrieves the string value associated with the specified key from the compound object.
     *
     * @param key the key whose associated string value is to be returned; cannot be null
     * @return the string value associated with the specified key; never null
     */
    public @NotNull String getString(@NotNull String key) {
        return NBT.getString(this.compound, key);
    }

    /**
     * Retrieves the byte array associated with the specified key from the compound.
     *
     * @param key the key used to look up the byte array, must not be null
     * @return the byte array linked to the specified key
     */
    public byte[] getByteArray(@NotNull String key) {
        return NBT.getByteArray(this.compound, key);
    }

    /**
     * Retrieves an integer array associated with the specified key from the compound.
     *
     * @param key the key used to identify the integer array within the compound; must not be null
     * @return the integer array associated with the provided key
     */
    public int[] getIntArray(@NotNull String key) {
        return NBT.getIntArray(this.compound, key);
    }

    /**
     * Retrieves a long array associated with the given key from the compound.
     *
     * @param key the key used to access the long array, must not be null
     * @return the long array associated with the specified key
     */
    public long[] getLongArray(@NotNull String key) {
        return NBT.getLongArray(this.compound, key);
    }
    
    /**
     * Retrieves a boolean value associated with the specified key from the compound.
     *
     * @param key the key whose associated boolean value is to be returned; must not be null
     * @return the boolean value associated with the given key
     */
    public boolean getBoolean(@NotNull String key) {
        return NBT.getBoolean(this.compound, key);
    }
    
    /**
     * Checks if the given key exists within the compound.
     *
     * @param key the key to check for existence, must not be null
     * @return true if the key exists, false otherwise
     */
    public boolean contains(@NotNull String key) {
        return NBT.hasKey(this.compound, key);
    }
    
    /**
     * Checks if the specified compound contains an entry with the given key and type.
     *
     * @param key the key to look for in the compound, must not be null
     * @param type the type of the entry to look for
     * @return true if the compound contains an entry with the given key and type, false otherwise
     */
    public boolean contains(@NotNull String key, int type) {
        return NBT.has(this.compound, key, type);
    }
    
    /**
     * Removes the specified key from the compound using the NBT utility.
     *
     * @param key The key to remove from the compound. Must not be null.
     */
    public void remove(@NotNull String key) {
        NBT.remove(this.compound, key);
    }

    /**
     * Retrieves the size of the compound structure.
     *
     * @return the number of elements within the compound.
     */
    public int size() {
        return NBT.getSize(this.compound);
    }
    
    /**
     * Retrieves the set of keys present in the compound.
     *
     * @return a non-null set of strings representing the keys in the compound.
     */
    public @NotNull Set<String> keySet() {
        return NBT.getKeySet(this.compound);
    }
    
    /**
     * Copies data from the given {@code NbtCompound} into the current instance.
     *
     * @param compound the {@code NbtCompound} instance from which data is copied; must not be null
     */
    public void copyFrom(@NotNull NbtCompound compound) {
        this.compound = NBT.copy(this.compound, compound.getCompound());
    }
    
    /**
     * Copies the data from the given NBTTagCompound into the current instance's compound.
     *
     * @param compound the source NBTTagCompound from which data will be copied; must not be null
     */
    public void copyFrom(@NotNull net.minecraft.nbt.NBTTagCompound compound) {
        this.compound = NBT.copy(this.compound, compound);
    }

    /**
     * Checks if the compound object is empty.
     *
     * @return true if the compound is empty, false otherwise.
     */
    public boolean isEmpty() {
        return NBT.isEmpty(this.compound);
    }

    /**
     * Retrieves the NBTTagCompound associated with this object.
     *
     * @return the NBTTagCompound instance, never null
     */
    public @NotNull net.minecraft.nbt.NBTTagCompound getCompound() {
        return this.compound;
    }
}
