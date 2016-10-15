package com.padwolf.minecraft.t1d.items;

import java.util.List;
import java.util.Random;

import com.padwolf.minecraft.t1d.T1D;
import com.padwolf.minecraft.t1d.refs.Functions;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatBase;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemSyringeFilled extends Item{
	public IIcon[] icons = new IIcon[5];
	int insulin;
	
	public ItemSyringeFilled(){
		super();
		setUnlocalizedName("filledSyringe");
		setHasSubtypes(true);
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabMisc);
		
	}
	
	@Override
	public void registerIcons(IIconRegister reg) {
	    for (int i = 0; i < 5; i ++) {
	        this.icons[i] = reg.registerIcon(T1D.MODID + ":itemSyringeImpure" + (i));
	    }
	}
	
	@Override
	public IIcon getIconFromDamage(int meta) {
	    meta = (meta > 30) ? 30 : ((meta < 1) ? 1 : meta);
	    
	    if (meta <= 6) return this.icons[0];
		else if (meta > 6 && meta <= 12) return this.icons[1];
		else if (meta > 12 && meta <= 18) return this.icons[2];
		else if (meta > 18 && meta <= 24) return this.icons[3];
		else if (meta > 24 && meta <= 30) return this.icons[4];
	    
	    return icons[5];
	    
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
	    for (int i = 1; i < 31; i ++) {
	        list.add(new ItemStack(item, 1, i));
	    }
	}
	

	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		Functions.sendChatMessage(player, Boolean.toString(world.isRemote).toUpperCase());
		player.addChatMessage(new ChatComponentText("Right Clicked"));
		if (player.isSneaking()){
			boolean insulinFound = false;
			for (ItemStack i : player.inventory.mainInventory)
				if (i != null)
					if (i.getItem() instanceof ItemImpureInsulin)
						if (i.getItemDamage() - stack.getItemDamage() >= 0){
							if (world.isRemote) if (!player.inventory.addItemStackToInventory(new ItemStack(T1D.GLOBALS.items.syringe, 1))) break;
								i.setItemDamage(i.getItemDamage() - stack.getItemDamage());
								stack.stackSize--;
								insulinFound = true;
							}
				player.addChatMessage(new ChatComponentText(Boolean.toString(insulinFound).toUpperCase()));
				if (!insulinFound) player.addChatMessage(new ChatComponentText("Insufficient Space"));
		} else {
			Functions.sendChatMessage(player, "Not Sneaking");
			Functions.sendChatMessage(player, Boolean.toString(world.isRemote).toUpperCase());
			player.attackEntityFrom(new DamageSource("injecting").setDamageBypassesArmor(), 0.5f);
			if (new Random().nextInt() % 3 == 0) player.attackEntityFrom(new DamageSource("impureInsulin"), 4);
			stack.stackSize -= 1;
		}
		return super.onItemRightClick(stack, world, player);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		entity.attackEntityFrom(new DamageSource("syringe"), 0.5f);
		stack.stackSize -= 1;
		return super.onLeftClickEntity(stack, player, entity);
	}
	
}
