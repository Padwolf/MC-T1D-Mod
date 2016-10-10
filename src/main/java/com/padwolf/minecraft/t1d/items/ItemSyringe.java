package com.padwolf.minecraft.t1d.items;

import com.padwolf.minecraft.t1d.T1D;
import com.padwolf.minecraft.t1d.guis.GuiSyringe;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemSyringe extends Item{
	public IIcon icon;
	
	IIcon[] Textures = new IIcon[2];
	
	public ItemSyringe(){
		
		setCreativeTab(CreativeTabs.tabTools);
		setUnlocalizedName("syringe");
		setTextureName(T1D.MODID + ":itemSyringe");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		GuiSyringe gui = new GuiSyringe(itemStack, this, player);
		if (world.isRemote) Minecraft.getMinecraft().displayGuiScreen(gui);
		return super.onItemRightClick(itemStack, world, player);
	}
	
	
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
       icon = reg.registerIcon(T1D.MODID + ":itemSyringe");
    }
	
	@Override
	public IIcon getIconFromDamage(int p_77617_1_) {
		return icon;
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		entity.attackEntityFrom(new DamageSource("syringe"), 0.5f);
		stack.stackSize -= 1;
		return super.onLeftClickEntity(stack, player, entity);
	}
}
