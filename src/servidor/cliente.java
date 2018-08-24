/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class cliente extends Thread {
    String host;
    int puerto;
   ServerSocket sc;
   Socket so;
   DataOutputStream salida;
   DataInputStream entrada;
            
            public cliente(String host, int puerto){
                this.host = host;
                this.puerto = puerto;
                
            }
            
            @Override
            public  void run(){
                iniClient();
            }
            
            
            public void iniClient(){
                try{
                    Thread.sleep(100);
                    so = new Socket(host, puerto);
                    salida = new DataOutputStream(so.getOutputStream());
                    entrada = new DataInputStream(so.getInputStream());
                    System.out.println("Cliente: "
                                       + "el servidor dijo: "
                                       + entrada.readUTF());
                    salida.writeUTF("Hola");
                    so.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
                    
                    }
}