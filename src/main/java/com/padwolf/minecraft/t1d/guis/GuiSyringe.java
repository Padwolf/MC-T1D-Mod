package com.padwolf.minecraft.t1d.guis;

import com.padwolf.minecraft.t1d.T1D;
import com.padwolf.minecraft.t1d.items.ItemImpureInsulin;
import com.padwolf.minecraft.t1d.items.ItemSyringe;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;

public class GuiSyringe extends GuiScreen{
	
	GuiButton inc, dec, ok, ccl;
	ItemStack stack;
	ItemSyringe syringe;
	EntityPlayer player;
	int units;
	
	public GuiSyringe(ItemStack stack, ItemSyringe item, EntityPlayer player) {
		this.stack = stack;
		this.syringe = item;
		this.player = player;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.fontRendererObj.drawString(Integer.toString(units), width/2-(this.fontRendererObj.getStringWidth(Integer.toString(units))/2), (this.height / 5) * 2 - (this.fontRendererObj.getStringWidth(Integer.toString(units))/2), 0xFFFFFF);
		drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
	    return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void initGui() {
	    this.buttonList.add(this.inc = new GuiButton(0, this.width / 2 + 15, (this.height / 5) * 2 - 10, 20, 20, "->"));
	    this.buttonList.add(this.dec = new GuiButton(0, this.width / 2 - 35, (this.height / 5) * 2 - 10, 20, 20, "<-"));
	    this.buttonList.add(this.ok = new GuiButton(0, (this.width / 4) - 25, (this.height / 5) * 3 - 10, 50, 20, "OK"));
	    this.buttonList.add(this.ccl = new GuiButton(0, (this.width / 4) * 3 - 25, (this.height / 5) * 3 - 10, 50, 20, "Cancel"));
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		if (button == inc) if (units < 30) units++;
		if (button == dec) if (units > 0) units--;
		if (button == ok){
			if (units > 0){
				boolean foundInsulin = false;
				for (ItemStack i : player.inventory.mainInventory){
					if (i != null){
						if (i.getItem() instanceof ItemImpureInsulin){
							System.out.println(i.getItemDamage());
							if ((300-i.getItemDamage()) >= units){
								foundInsulin = true;
								i.setItemDamage(i.getItemDamage() + units);
								stack.stackSize--;
								player.inventory.addItemStackToInventory(new ItemStack(T1D.GLOBALS.items.filledSyringes[units-1], 1));
								break;
							}
						}
					}
				}
				if (!foundInsulin) player.addChatMessage(new ChatComponentText("Insufficient Insulin"));
			}
			this.mc.displayGuiScreen(null);
			if (this.mc.currentScreen == null)
	            this.mc.setIngameFocus();
		}
		if (button == ccl){
			this.mc.displayGuiScreen(null);
	        if (this.mc.currentScreen == null)
	            this.mc.setIngameFocus();
		}
	}
	
}
