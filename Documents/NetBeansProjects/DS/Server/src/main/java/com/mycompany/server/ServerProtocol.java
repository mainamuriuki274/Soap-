/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server;

/**
 *
 * @author hp
 */
public class ServerProtocol {
      String message;
    public ServerProtocol(String sender,String msg){
        message = "Server: " + msg;
    }
     public ServerProtocol(String msg){
        message = "Client: " + msg;
    }   
}
