package com.padwolf.minecraft.t1d;

import com.padwolf.minecraft.t1d.refs.Globals;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = T1D.MODID, version = T1D.VERSION)
public class T1D
{
    public static final String MODID = "t1dmod";
    public static final String VERSION = "indev";
    public static final Globals GLOBALS = new Globals();
    
    @Instance
    public static T1D instance = new T1D();
    
    @SidedProxy(clientSide="com.padwolf.minecraft.t1d.ClientProxy", serverSide="com.padwolf.minecraft.t1d.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	proxy.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init(event);
    	
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	proxy.postInit(event);
    }
}
