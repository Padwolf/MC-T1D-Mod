package com.padwolf.minecraft.t1d.refs;

import com.padwolf.minecraft.t1d.items.ItemImpureInsulin;
import com.padwolf.minecraft.t1d.items.ItemPancreas;
import com.padwolf.minecraft.t1d.items.ItemSyringe;
import com.padwolf.minecraft.t1d.items.ItemSyringeFilled;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class T1DItems {
	public Item pancreas, impureInsulin, syringe, syringeFilled;
	
	public void preInit(){
		pancreas  = new ItemPancreas();
		GameRegistry.registerItem(pancreas, "Pancreas");
		impureInsulin = new ItemImpureInsulin();
		GameRegistry.registerItem(impureInsulin, "impureInsulin");
		syringe = new ItemSyringe();
		GameRegistry.registerItem(syringe, "Syringe");
		syringeFilled = new ItemSyringeFilled();
		GameRegistry.registerItem(syringeFilled, "filledSyringe");
	}
	
	public void init(){
		GameRegistry.addShapelessRecipe(new ItemStack(impureInsulin, 1, 0), new Object[]{pancreas, Items.glass_bottle});
		GameRegistry.addShapedRecipe(new ItemStack(syringe, 9), new Object[]{"  i", " g ", "g  ", 'i', Items.iron_ingot, 'g', Blocks.glass});
		GameRegistry.addShapedRecipe(new ItemStack(syringe, 9), new Object[]{"i  ", " g ", "  g", 'i', Items.iron_ingot, 'g', Blocks.glass});
	}
	
}
