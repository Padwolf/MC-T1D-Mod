package com.padwolf.minecraft.t1d.items;

import com.padwolf.minecraft.t1d.T1D;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemImpureInsulin extends Item{
	
	public int insulin;
	
	public ItemImpureInsulin() {
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("impureInsulinVial");
		setTextureName(T1D.MODID + ":itemImpureInsulin");
		setMaxStackSize(1);
		setMaxDamage(300);
		insulin = 300;
	}
	
	public boolean canRemoveInsulin(double units){
		if (insulin - units < 0) return false;
		return true;
	}
	
	public void removeInsulin(double units) {
		insulin -= units;
	}
	
	public boolean canAddInsulin(){
		if (insulin < 300) return true;
		return false;
	}
	
	public boolean canAddInsulin(double units){
		if (insulin + units > 300) return false;
		return true;
	}
	
	public boolean addInsulin(double units) {
		if (insulin + units > 300) return false;
		insulin += units;
		return true;
	}
	
}
