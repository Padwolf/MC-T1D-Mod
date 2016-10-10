package com.padwolf.minecraft.t1d.refs;

public class Globals {
	public final T1DItems items = new T1DItems();
	
	public void preInit(){
		items.preInit();
	}
	
	public void init(){
		items.init();
	}
}
