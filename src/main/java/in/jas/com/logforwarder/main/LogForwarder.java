/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.jas.com.logforwarder.main;

import in.jas.com.logforwarder.main.nettyImpl.SimpleTCPServer;
import in.jas.com.logforwarder.main.nettyImpl.SimpleTCPServerHandler;

/**
 *
 * @author sundhar
 * cat Backup/FrwrdGit.txt | ncat localhost 5055
 */

public class LogForwarder {
    
    private SimpleTCPServer tcpServer;

    public static void main(String[] args) {
          LogForwarder logFrwdr = new LogForwarder();
          logFrwdr.startServers();
    }
    
    
    public void startServers(){
        SimpleTCPServer tcpServer =  new SimpleTCPServer(5055, new SimpleTCPServerHandler());
        this.tcpServer = tcpServer;
    }
    
    public void shutdown(){
        this.tcpServer.shutDown();
    }
}
