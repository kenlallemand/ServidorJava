/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

/**
 *
 * @author Lordken
 */
public class Main {
    public static void main(String[] args){
        Servidor server = new Servidor(5100);
        //cliente client = new cliente("localhost", 5100);
        server.start();
        //client.start();
    }
    
}
