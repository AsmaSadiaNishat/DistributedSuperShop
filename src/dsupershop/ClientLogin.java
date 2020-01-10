/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsupershop;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shahid
 */
public class ClientLogin {

    int sendData(String user, String pass) {
        int temp=0;
        try {
            Socket s = new Socket("127.0.0.1", 6666);
            PrintStream p = new PrintStream(s.getOutputStream());
            p.println(user);
            p.println(pass);

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
