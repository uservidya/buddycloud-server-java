package org.buddycloud.channelserver.packetprocessor.iq.namespace.register;

import java.util.concurrent.BlockingQueue;

import org.buddycloud.channelserver.Configuration;
import org.buddycloud.channelserver.channel.ChannelManager;
import org.buddycloud.channelserver.packetprocessor.PacketProcessor;
import org.buddycloud.channelserver.packetprocessor.iq.namespace.AbstractNamespace;
import org.xmpp.packet.IQ;
import org.xmpp.packet.Packet;

public final class JabberRegister extends AbstractNamespace {

	public static final String NAMESPACE_URI = "jabber:iq:register";
	
	private final PacketProcessor<IQ> setProcessor;
	
	public JabberRegister(BlockingQueue<Packet> outQueue, Configuration conf, ChannelManager channelManager) {
		super(outQueue, conf, channelManager);
		this.setProcessor = new JabberRegisterSet(outQueue, channelManager);
	}

    @Override
    protected PacketProcessor<IQ> get() {
        return null;
    }

    @Override
    protected PacketProcessor<IQ> set() {
        return setProcessor;
    }

    @Override
    protected PacketProcessor<IQ> result() {
        return null;
    }

    @Override
    protected PacketProcessor<IQ> error() {
        return null;
    }
}
