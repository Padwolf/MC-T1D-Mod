package com.padwolf.minecraft.t1d;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler{
	
	public static final int SYRINGE_GUI = 0;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == SYRINGE_GUI)
			return null;
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		//if (ID == SYRINGE_GUI)
			//return new GuiSyringe();
		return null;
	}
	
}
