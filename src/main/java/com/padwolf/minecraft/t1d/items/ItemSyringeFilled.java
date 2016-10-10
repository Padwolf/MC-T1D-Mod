package com.padwolf.minecraft.t1d.items;

import com.padwolf.minecraft.t1d.T1D;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemSyringeFilled extends Item{
	public IIcon[] icons = new IIcon[5];
	int insulin;
	
	public ItemSyringeFilled(int insulin){
		super();
		setUnlocalizedName("filledSyringe");
//		setHasSubtypes(true);
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabMisc);
		
		this.insulin = (insulin > 30) ? 30 : ((insulin < 1) ? 1 : insulin);
		
		if (insulin <= 6 && insulin >= 1) setTextureName(T1D.MODID + ":itemSyringe0");
		else if (insulin > 6 && insulin <= 12) setTextureName(T1D.MODID + ":itemSyringe1");
		else if (insulin > 12 && insulin <= 18) setTextureName(T1D.MODID + ":itemSyringe2");
		else if (insulin > 18 && insulin <= 24) setTextureName(T1D.MODID + ":itemSyringe3");
		else if (insulin > 24 && insulin <= 30) setTextureName(T1D.MODID + ":itemSyringe4");
		else setTextureName(T1D.MODID + ":itemSyringe");
		
	}
	
//	@Override
//	public IIcon getIcon(ItemStack stack, int pass) {
//		if (insulin >= 6) return this.icons[0];
//		else if (insulin > 6 && insulin <= 12) return this.icons[1];
//		else if (insulin > 12 && insulin <= 18) return this.icons[2];
//		else if (insulin > 18 && insulin <= 24) return this.icons[3];
//		else if (insulin > 24 && insulin <= 30) return this.icons[4];
//		return this.icons[4];
//	}
	
//	public ItemSyringeFilled setInsulin(ItemStack stack, int amount){
//		insulin = amount;
//		if (insulin > 30) insulin = 30;
//		if (insulin >= 6) setDamage(stack, 0);
//		else if (insulin > 6 && insulin <= 12) return new ItemStack(this, 1, 1);
//		else if (insulin > 12 && insulin <= 18) return new ItemStack(this, 1, 2);
//		else if (insulin > 18 && insulin <= 24) return new ItemStack(this, 1, 3);
//		else if (insulin > 24 && insulin <= 30) return new ItemStack(this, 1, 4);
//		return new ItemStack(this, 1, 4);
//	}
	
//	@Override
//	public void registerIcons(IIconRegister reg) {
//	    for (int i = 0; i < 5; i ++) {
//	        this.icons[i] = reg.registerIcon(T1D.MODID + ":itemSyringe" + (i));
//	    }
//	}
	
//	@Override
//	public IIcon getIconFromDamage(int meta) {
//	    if (meta > 4)
//	        meta = 4;
//	    
////	    if (meta <= 6) return this.icons[0];
////		else if (meta > 6 && meta <= 12) return this.icons[1];
////		else if (meta > 6 && meta <= 12) return this.icons[2];
////		else if (meta > 6 && meta <= 12) return this.icons[3];
////		else if (meta > 6 && meta <= 12) return this.icons[4];
//	    
//	    return this.icons[meta];
//	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public void getSubItems(Item item, CreativeTabs tab, @SuppressWarnings("rawtypes") List list) {
//	    for (int i = 0; i < 5; i ++) {
//	        list.add(new ItemStack(item, 1, i));
//	    }
//	}

//	@Override
//	public String getUnlocalizedName(ItemStack stack) {
//	    return this.getUnlocalizedName() + "_" + stack.getItemDamage();
//	}
	

	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (player.isSneaking()){
			boolean insulinFound = false;
			for (ItemStack i : player.inventory.mainInventory){
				if (i != null){
					if (i.getItem() instanceof ItemImpureInsulin){
						System.out.println(i.getItemDamage());
						if (i.getItemDamage() + insulin <= 300){
							if (!player.inventory.addItemStackToInventory(new ItemStack(T1D.GLOBALS.items.syringe, 1))) break;
							i.setItemDamage(i.getItemDamage() - insulin);
							insulinFound = true;
							stack.stackSize--;
							break;
						}
					}
				}
			}
			if (!insulinFound) player.addChatMessage(new ChatComponentText("Insufficient Space"));
		} else {
			player.attackEntityFrom(new DamageSource("injecting").setDamageBypassesArmor(), 0.5f);
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
