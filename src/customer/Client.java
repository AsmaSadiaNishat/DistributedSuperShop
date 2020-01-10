/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import dsupershop.ClientLogin;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zahid
 */
public class Client {
    
    int sendData(String id, String name, String phone, String add) {
        int temp=0;
        try {
            Socket s = new Socket("127.0.0.1", 9999);
            PrintStream p = new PrintStream(s.getOutputStream());
            p.println(id);
            p.println(name);
            p.println(phone);
            p.println(add);

            Scanner s_sc = new Scanner(s.getInputStream());
            temp = s_sc.nextInt();
            //return temp;
            
        } catch (IOException ex) {
            Logger.getLogger(ClientLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Response:"+temp);
        return temp;
    }
}
