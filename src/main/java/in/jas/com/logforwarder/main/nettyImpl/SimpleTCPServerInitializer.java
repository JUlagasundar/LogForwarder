/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.jas.com.logforwarder.main.nettyImpl;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 *
 * @author sundhar
 */
public class SimpleTCPServerInitializer extends ChannelInitializer {

    private SimpleTCPServerHandler serverHandler;
    
    public SimpleTCPServerInitializer(SimpleTCPServerHandler serverHandler) {
        this.serverHandler = serverHandler;
    }

    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline channelPipe = channel.pipeline();
        channelPipe.addLast("encoder",new StringEncoder());
        channelPipe.addLast("decoder",new StringDecoder());
        channelPipe.addLast(new ChannelHandler[] {serverHandler});
    }
    
}
