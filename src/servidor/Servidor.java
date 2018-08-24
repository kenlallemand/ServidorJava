/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor extends Thread {

int puerto;
ServerSocket sc;
Socket so;
DataOutputStream salida;
String mensaje;

public Servidor(int port){
    this.puerto = port;
}

 public  void run(){
                iniServer();
            }

public void iniServer(){
    try{
        
        DataInputStream entrada;
        sc = new ServerSocket(this.puerto);
        System.out.println("Servidor: Esperando cliente");
        so=sc.accept();
        System.out.println("Servidor: Un cliente se ha conectado");
        entrada = new DataInputStream(so.getInputStream());
        
        salida=new DataOutputStream(so.getOutputStream());
        salida.writeUTF("Servidor: conexion exitosa, envía mensaje");
        mensaje = entrada.readLine();
        System.out.println("Servidor: el cliente dijo: "+mensaje);
        System.out.println("Cerrando.....");
        sc.close();
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
}

}