/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.jas.com.logforwarder.main.nettyImpl;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 *
 * @author sundhar
 */
public class SimpleTCPServer {

    private int port;
    private SimpleTCPServerHandler serverHandler;
    private final EventLoopGroup boss = new NioEventLoopGroup();
    private final EventLoopGroup worker = new NioEventLoopGroup();
    
    public SimpleTCPServer(int portNumber, SimpleTCPServerHandler tcpHandler) {
        try{
            this.port = portNumber;
            ServerBootstrap serverStrap = new ServerBootstrap();
            serverStrap.group(boss,worker)
                       .channel(NioServerSocketChannel.class)
                       .handler(new LoggingHandler(LogLevel.DEBUG))
                       .childHandler(new SimpleTCPServerInitializer(tcpHandler))
                       .option(ChannelOption.SO_KEEPALIVE, true)
                       .option(ChannelOption.TCP_NODELAY, true);
            this.serverHandler = tcpHandler;
            serverStrap.bind(portNumber);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
     public SimpleTCPServerHandler getServerHandler() {
        return serverHandler;
    }

    public void shutDown() {
        try {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
}
