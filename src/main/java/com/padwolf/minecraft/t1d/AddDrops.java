package com.padwolf.minecraft.t1d;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class AddDrops {
	
	@SubscribeEvent
	public void addCowDrop(LivingDropsEvent event)
	{
	    if (event.entityLiving instanceof EntityCow)
	    {
	        if (new Random().nextInt() % 3 == 0)
	    	event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, new ItemStack(T1D.GLOBALS.items.pancreas)));
	    }
	}
	
	@SubscribeEvent
	public void addPigDrop(LivingDropsEvent event)
	{
	    if (event.entityLiving instanceof EntityPig)
	    {
	    	if (new Random().nextInt() % 3 == 0)
	    	event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, new ItemStack(T1D.GLOBALS.items.pancreas)));
	    }
	}
}
