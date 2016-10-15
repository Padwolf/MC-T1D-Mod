package com.padwolf.minecraft.t1d;

import com.padwolf.minecraft.t1d.packets.MessagePacket;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent e) {
    	T1D.GLOBALS.preInit();
    	MinecraftForge.EVENT_BUS.register(new AddDrops());
    	T1D.NET_CHANNEL = NetworkRegistry.INSTANCE.newSimpleChannel(T1D.MODID);
    	T1D.NET_CHANNEL.registerMessage(MessagePacket.Handler.class, MessagePacket.class, 0, Side.SERVER);
    }

    public void init(FMLInitializationEvent e) {
    	T1D.GLOBALS.init();
    	NetworkRegistry.INSTANCE.registerGuiHandler(T1D.instance, new com.padwolf.minecraft.t1d.GuiHandler());
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
    
    public void openSyringeGui(){}
}
