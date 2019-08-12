/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.jas.com.logforwarder.main.nettyImpl;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 *
 * @author sundhar
 */
  @ChannelHandler.Sharable
public class SimpleTCPServerHandler extends SimpleChannelInboundHandler{

    @Override
    protected void channelRead0(ChannelHandlerContext chc, Object objVal) throws Exception {
         String message = (String) objVal;
        if (message != null && !message.isEmpty()) {
            
            System.out.println("Message : "+message);
        }else
             System.out.println("Message not received : "+message);
    }
    
}
