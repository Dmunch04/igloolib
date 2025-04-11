package me.munchii.igloolib.v1_20_2;

import me.munchii.igloolib.nms.service.ItemStackService;
import me.munchii.igloolib.nms.service.NBTService;
import me.munchii.igloolib.nms.NMSFactory;

public class NMSFactoryImpl implements NMSFactory {
    @Override
    public NBTService createNBTService() {
        return new NBTServiceImpl();
    }

    @Override
    public ItemStackService createItemStackService() {
        return new ItemStackServiceImpl();
    }
}
