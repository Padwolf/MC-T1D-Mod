package com.padwolf.minecraft.t1d.items;

import com.padwolf.minecraft.t1d.T1D;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemPancreas extends Item{
	
	public ItemPancreas() {
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName("pancreas");
		setTextureName(T1D.MODID + ":itemPancreas");
	}
	
}
