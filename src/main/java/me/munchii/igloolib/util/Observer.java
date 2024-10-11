package me.munchii.igloolib.util;

import me.munchii.igloolib.Igloolib;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public interface Observer<T> {
    List<Observer<?>> OBSERVERS = new ArrayList<>();

    void subscribe(Consumer<T> consumer);
    void unsubscribe(Consumer<T> consumer);

    boolean didChange();

    final class BlockObserver implements Observer<Block> {
        private Location location;
        private BlockState blockState;
        private final List<Consumer<Block>> recipients = new ArrayList<>();

        public BlockObserver(Block block) {
            this.location = block.getLocation();
            this.blockState = block.getState().copy();

            OBSERVERS.add(this);

            TaskManager.registerRepeatingTask("BlockObserver_Tick_" + block.getLocation().getWorld().getName() + block.getLocation().getBlockX() + block.getLocation().getBlockY() + block.getLocation().getBlockZ(), () -> {
                if (didChange()) {
                    blockState = block.getWorld().getBlockAt(block.getLocation()).getState().copy();
                    recipients.forEach(consumer -> consumer.accept(location.getBlock()));
                }

                if (recipients.isEmpty()) {
                    // TODO: ?
                }
            }, 1, 1, TimeUnit.TICK);
        }

        public static BlockObserver observe(Block block) {
            Optional<BlockObserver> observer = Observer.OBSERVERS.stream().map(o -> (BlockObserver) o).filter(o -> o.getBlock().equals(block)).findFirst();
            return observer.orElseGet(() -> new BlockObserver(block));
        }

        @Override
        public void subscribe(Consumer<Block> consumer) {
            recipients.add(consumer);
        }

        @Override
        public void unsubscribe(Consumer<Block> consumer) {
            recipients.remove(consumer);
        }

        @Override
        public boolean didChange() {
            Block block = location.getBlock();
            return block.getType() != blockState.getType();
        }

        public BlockState getBlockState() {
            return blockState;
        }

        public Block getBlock() {
            return blockState.getBlock();
        }
    }
}
