package com.padwolf.minecraft.t1d;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent e) {
    	T1D.GLOBALS.preInit();
    	MinecraftForge.EVENT_BUS.register(new AddDrops());
    }

    public void init(FMLInitializationEvent e) {
    	T1D.GLOBALS.init();
    	NetworkRegistry.INSTANCE.registerGuiHandler(T1D.instance, new com.padwolf.minecraft.t1d.GuiHandler());
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
    
    public void openSyringeGui(){}
}
