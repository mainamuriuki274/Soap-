/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author hp
 */
public class SocketServer {
    String result,msgin,msgout;;
    static DataInputStream dis;
    static DataOutputStream dos;
    static ServerSocket ss;
    ServerSocket ssocket,sock;
    
    public SocketServer(int port) {
        try{
               ss = new ServerSocket(port);
               ssocket = ss;    
               result = "success";
        }
        catch(Exception e)
        {
          result = "Failed to connect to Client at Port: " + port + " " + e ;
        }
            
     }
     public ServerSocket getSock() {
        return sock;
    }

    public void setSock(ServerSocket sock) {
        this.sock = sock;
    }
    
     public SocketServer(Socket socket,String data) {
        try{
        dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF(data);
        ServerProtocol sp = new ServerProtocol("S",data);
        msgout = sp.message;           
        }
        catch(Exception e)
        {
          
        }
            
     } 
     public SocketServer(Socket socket) {
        try{
        dis = new DataInputStream(socket.getInputStream());
        msgin = dis.readUTF();
        ServerProtocol sp = new ServerProtocol(msgin);
        msgin = sp.message;
                    
        }
        catch(Exception e)
        {
         msgin = "DIS Error! " + e;
         msgin = "Client Exited";
        }
         
     } 
}
