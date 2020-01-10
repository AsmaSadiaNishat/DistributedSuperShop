/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soldproduct;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class SoldProductClient 
{
    int sendData(int proID, String pronm,int custID,int qua,int pr) {
        int temp=0;
        try {
            Socket s = new Socket("localhost", 3333);
            PrintStream p = new PrintStream(s.getOutputStream());
            p.println(proID);
            p.println(pronm);
            p.println(custID);
            p.println(qua);
            p.println(pr);

            Scanner s_sc = new Scanner(s.getInputStream());
            temp = s_sc.nextInt();
            //return temp;
            
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(SoldProductClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Response:"+temp);
        return temp;
    }
}
    

