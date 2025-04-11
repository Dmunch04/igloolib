package me.munchii.igloolib.nms;

import me.munchii.igloolib.nms.service.ItemStackService;
import me.munchii.igloolib.nms.service.NBTService;

public interface NMSFactory {
    NBTService createNBTService();
    ItemStackService createItemStackService();
}
