package com.padwolf.minecraft.t1d.packets;

import com.padwolf.minecraft.t1d.refs.Functions;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

public class MessagePacket implements IMessage{
	
	public MessagePacket(){}
	
	String data = "";
	public MessagePacket(String msg){
		this.data = msg;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		data = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, data);
		
	}
	
	public class Handler implements IMessageHandler<MessagePacket, IMessage> {
		
		public Handler() {}

		@Override
		public IMessage onMessage(MessagePacket message, MessageContext ctx) {
			Functions.sendChatMessage(ctx.getServerHandler().playerEntity, String.format("Received %s from %s", message.data, ctx.getServerHandler().playerEntity.getDisplayName()));
            return null; // no response in this case
		}
		
	}

}
