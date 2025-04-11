package me.munchii.igloolib.nms.service;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface NBTService {
    /**
     * Inserts a nested NBTTagCompound into the specified NBTTagCompound under the given key.
     *
     * @param nbt   The NBTTagCompound within which the nested compound will be inserted. Must not be null.
     * @param key   The key under which the nested compound will be stored. Must not be null.
     * @param value The nested NBTTagCompound to be inserted. Can be an empty NBTTagCompound but must not be null.
     */
    void putCompound(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, net.minecraft.nbt.NBTTagCompound value);

    /**
     * Stores a byte value in the specified NBTTagCompound with the given key.
     *
     * @param nbt   The NBTTagCompound where the byte value will be stored. Must not be null.
     * @param key   The key under which the byte value will be stored. Must not be null.
     * @param value The byte value to store in the NBTTagCompound.
     */
    void putByte(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, byte value);

    /**
     * Stores a short value in the specified NBTTagCompound with the given key.
     *
     * @param nbt   The NBTTagCompound where the short value will be stored. Must not be null.
     * @param key   The key under which the short value will be stored. Must not be null.
     * @param value The short value to store in the NBTTagCompound.
     */
    void putShort(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, short value);

    /**
     * Stores an integer value in the specified NBTTagCompound with the given key.
     *
     * @param nbt   The NBTTagCompound where the integer value will be stored. Must not be null.
     * @param key   The key under which the integer value will be stored. Must not be null.
     * @param value The integer value to store in the NBTTagCompound.
     */
    void putInt(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, int value);

    /**
     * Stores a long value in the specified NBTTagCompound with the given key.
     *
     * @param nbt   The NBTTagCompound where the long value will be stored. Must not be null.
     * @param key   The key under which the long value will be stored. Must not be null.
     * @param value The long value to store in the NBTTagCompound.
     */
    void putLong(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, long value);

    /**
     * Stores a UUID value in the specified NBTTagCompound with the given key.
     *
     * @param nbt   The NBTTagCompound where the UUID value will be stored. Must not be null.
     * @param key   The key under which the UUID value will be stored. Must not be null.
     * @param value The UUID value to store in the NBTTagCompound. Can be null to represent an absent value.
     */
    void putUUID(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, UUID value);

    /**
     * Stores a float value in the specified NBTTagCompound with the given key.
     *
     * @param nbt   The NBTTagCompound where the float value will be stored. Must not be null.
     * @param key   The key under which the float value will be stored. Must not be null.
     * @param value The float value to store in the NBTTagCompound.
     */
    void putFloat(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, float value);

    /**
     * Stores a double value in the specified NBTTagCompound with the given key.
     *
     * @param nbt   The NBTTagCompound where the double value will be stored. Must not be null.
     * @param key   The key under which the double value will be stored. Must not be null.
     * @param value The double value to store in the NBTTagCompound.
     */
    void putDouble(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, double value);

    /**
     * Stores a string value in the specified NBTTagCompound with the given key.
     *
     * @param nbt   The NBTTagCompound where the string value will be stored. Must not be null.
     * @param key   The key under which the string value will be stored. Must not be null.
     * @param value The string value to store in the NBTTagCompound. Can be null to represent an absent value.
     */
    void putString(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, String value);

    /**
     * Stores a byte array in the specified NBTTagCompound with the given key.
     *
     * @param nbt   The NBTTagCompound where the byte array will be stored. Must not be null.
     * @param key   The key under which the byte array will be stored. Must not be null.
     * @param value The byte array to store in the NBTTagCompound. Can be an empty array but must not be null.
     */
    void putByteArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, byte[] value);

    /**
     * Stores a list of bytes in the specified NBTTagCompound with the given key.
     *
     * @param nbt   The NBTTagCompound where the byte list will be stored. Must not be null.
     * @param key   The key under which the byte list will be stored. Must not be null.
     * @param value The list of bytes to store in the NBTTagCompound. Must not be null, but can be empty.
     */
    void putByteArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, List<Byte> value);

    /**
     * Stores an integer array in the specified NBTTagCompound with the given key.
     *
     * @param nbt   The NBTTagCompound where the integer array will be stored. Must not be null.
     * @param key   The key under which the integer array will be stored. Must not be null.
     * @param value The integer array to store in the NBTTagCompound. Can be an empty array but must not be null.
     */
    void putIntArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, int[] value);

    /**
     * Stores a list of integers in the specified NBTTagCompound with the given key.
     *
     * @param nbt   The NBTTagCompound where the integer list will be stored. Must not be null.
     * @param key   The key under which the integer list will be stored. Must not be null.
     * @param value The list of integers to store in the NBTTagCompound. Must not be null, but can be empty.
     */
    void putIntArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, List<Integer> value);

    /**
     * Stores a long array in the specified NBTTagCompound with the given key.
     *
     * @param nbt   The NBTTagCompound where the long array will be stored. Must not be null.
     * @param key   The key under which the long array will be stored. Must not be null.
     * @param value The long array to store in the NBTTagCompound. Can be an empty array but must not be null.
     */
    void putLongArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, long[] value);

    /**
     * Stores a list of long values in the specified NBTTagCompound with the given key.
     *
     * @param nbt  The NBTTagCompound where the long array will be stored. Must not be null.
     * @param key  The key under which the long array will be stored. Must not be null.
     * @param value The list of long values to be stored. Must not be null.
     */
    void putLongArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, List<Long> value);

    /**
     * Inserts a boolean value into the provided NBTTagCompound with the specified key.
     *
     * @param nbt the NBTTagCompound where the boolean value will be stored; must not be null
     * @param key the key associated with the boolean value; must not be null
     * @param value the boolean value to store in the NBTTagCompound
     */
    void putBoolean(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, boolean value);

    /**
     * Retrieves a nested NBTTagCompound from the given NBTTagCompound using the specified key.
     *
     * @param nbt The NBTTagCompound from which to retrieve the nested compound.
     * @param key The key corresponding to the nested NBTTagCompound to be retrieved.
     * @return The nested NBTTagCompound associated with the specified key.
     */
    net.minecraft.nbt.@NotNull NBTTagCompound getCompound(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key);

    /**
     * Retrieves a byte value associated with the specified key from the given NBTTagCompound.
     *
     * @param nbt the NBTTagCompound from which the byte value is to be retrieved; must not be null
     * @param key the key whose associated byte value is to be returned; must not be null
     * @return the byte value associated with the specified key
     */
    byte getByte(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key);

    /**
     * Retrieves a short value associated with the specified key from the given NBTTagCompound.
     *
     * @param nbt The NBTTagCompound to retrieve the value from, must not be null.
     * @param key The key whose associated short value is to be retrieved, must not be null.
     * @return The short value associated with the specified key in the NBTTagCompound.
     */
    short getShort(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key);

    /**
     * Retrieves an integer value associated with the specified key from the given NBTTagCompound.
     *
     * @param nbt the NBTTagCompound object to retrieve the integer from; must not be null
     * @param key the key associated with the integer value to retrieve; must not be null
     * @return the integer value associated with the specified key
     */
    int getInt(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key);

    /**
     * Retrieves a long value from the given NBTTagCompound using the specified key.
     *
     * @param nbt the NBTTagCompound from which the long value will be retrieved, must not be null
     * @param key the key used to identify the long value in the NBTTagCompound, must not be null
     * @return the long value associated with the specified key in the NBTTagCompound
     */
    long getLong(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key);

    /**
     * Retrieves a UUID from the specified NBTTagCompound using the provided key.
     *
     * @param nbt the NBTTagCompound from which the UUID should be retrieved
     * @param key the key associated with the UUID in the NBTTagCompound
     * @return the UUID associated with the specified key in the given NBTTagCompound
     *         if it exists and is valid
     */
    @NotNull UUID getUUID(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key);

    /**
     * Retrieves a float value associated with the specified key from the provided NBTTagCompound.
     *
     * @param nbt the NBTTagCompound object containing the data
     * @param key the key for the float value to be retrieved
     * @return the float value associated with the specified key
     */
    float getFloat(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key);

    /**
     * Retrieves a double value associated with the specified key from the given NBTTagCompound.
     *
     * @param nbt the NBTTagCompound from which the double value is to be retrieved
     * @param key the key associated with the double value to retrieve
     * @return the double value associated with the specified key, or 0.0 if the key does not exist or is not a double
     */
    double getDouble(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key);

    /**
     * Retrieves a string value associated with the specified key from the given NBTTagCompound.
     *
     * @param nbt the NBTTagCompound from which the string value is to be retrieved
     * @param key the key associated with the string value
     * @return the string value associated with the specified key
     */
    @NotNull String getString(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key);

    /**
     * Retrieves a byte array associated with the specified key from the given NBTTagCompound.
     *
     * @param nbt the NBTTagCompound to retrieve the byte array from, must not be null
     * @param key the key associated with the byte array, must not be null
     * @return the byte array corresponding to the specified key, or null if the key does not exist or is not a byte array
     */
    byte[] getByteArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key);

    /**
     * Retrieves an integer array from the specified NBTTagCompound based on the given key.
     *
     * @param nbt the NBTTagCompound from which to retrieve the integer array, must not be null
     * @param key the key associated with the integer array, must not be null
     * @return the integer array corresponding to the given key, or an empty array if the key does not exist or is invalid
     */
    int[] getIntArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key);

    /**
     * Retrieves a long array from the specified NBTTagCompound using the given key.
     *
     * @param nbt the NBTTagCompound instance from which the long array is to be retrieved; must not be null
     * @param key the key under which the long array is stored in the NBTTagCompound; must not be null
     * @return the long array associated with the key in the provided NBTTagCompound,
     *         or an empty array if the key does not exist or does not contain a long array
     */
    long[] getLongArray(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key);

    /**
     * Retrieves a boolean value from the given NBTTagCompound associated with the specified key.
     *
     * @param nbt the non-null NBTTagCompound from which the boolean is fetched
     * @param key the non-null key to retrieve the boolean value associated with it
     * @return the boolean value associated with the specified key in the NBTTagCompound
     */
    boolean getBoolean(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key);

    /**
     * Checks if the given NBTTagCompound contains the specified key.
     *
     * @param nbt the NBTTagCompound to check for the key, must not be null
     * @param key the key to look for, must not be null
     * @return true if the NBTTagCompound contains the specified key, false otherwise
     */
    boolean hasKey(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key);

    /**
     * Checks if the specified NBTTagCompound contains a specific key with the given type.
     *
     * @param nbt the NBTTagCompound to check
     * @param key the key to search for in the NBTTagCompound
     * @param type the type of the value associated with the key
     * @return true if the key exists in the NBTTagCompound with the specified type, false otherwise
     */
    boolean has(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key, int type);

    /**
     * Retrieves the NBTBase associated with the specified key from the provided NBTTagCompound.
     *
     * @param nbt the NBTTagCompound to retrieve the value from, must not be null.
     * @param key the key associated with the desired NBTBase, must not be null.
     * @return an Optional containing the NBTBase if the key exists, or an empty Optional if the key does not exist.
     */
    Optional<net.minecraft.nbt.NBTBase> getBase(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key);

    /**
     * Retrieves the size of the specified NBTTagCompound.
     *
     * @param nbt the NBTTagCompound whose size is to be retrieved; must not be null
     * @return the size of the NBTTagCompound
     */
    int getSize(net.minecraft.nbt.@NotNull NBTTagCompound nbt);

    /**
     * Retrieves the set of keys from the given NBTTagCompound.
     *
     * @param nbt the NBTTagCompound from which to extract the keys
     * @return a set of strings representing the keys in the provided NBTTagCompound
     */
    Set<String> getKeySet(net.minecraft.nbt.@NotNull NBTTagCompound nbt);

    /**
     * Removes a key-value pair from the specified NBTTagCompound.
     *
     * @param nbt the NBTTagCompound from which the key-value pair will be removed. Must not be null.
     * @param key the key identifying the value to remove. Must not be null.
     */
    void remove(net.minecraft.nbt.@NotNull NBTTagCompound nbt, @NotNull String key);

    /**
     * Checks if the given NBTTagCompound is empty.
     *
     * @param nbt the NBTTagCompound to check; must not be null
     * @return true if the NBTTagCompound is empty, otherwise false
     */
    boolean isEmpty(net.minecraft.nbt.@NotNull NBTTagCompound nbt);

    /**
     * Copies the data from one NBTTagCompound to another.
     *
     * @param from the source NBTTagCompound containing the original data to be copied
     * @param to the target NBTTagCompound where the data should be copied to
     * @return the target NBTTagCompound containing the copied data
     */
    net.minecraft.nbt.@NotNull NBTTagCompound copy(net.minecraft.nbt.@NotNull NBTTagCompound from, net.minecraft.nbt.@NotNull NBTTagCompound to);
}
