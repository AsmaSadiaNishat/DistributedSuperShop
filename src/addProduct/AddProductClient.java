/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addProduct;

import soldproduct.*;
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
public class AddProductClient 
{
    int sendData(int proID, String group,String proName,String supp,String qty, int pur, int sell) {
        int temp=0;
        try {
            Socket s = new Socket("localhost", 4444);
            PrintStream p = new PrintStream(s.getOutputStream());
            
            p.println(proID);
            p.println(group);
            p.println(proName);
            p.println(supp);
            p.println(qty);
            p.println(pur);
            p.println(sell);

            System.out.print("Client OK");
            Scanner s_sc = new Scanner(s.getInputStream());
            temp = s_sc.nextInt();
            //return temp;
            
            //s.close();
            
        } catch (IOException ex) {
            Logger.getLogger(AddProductClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Response:"+temp);
        
        return temp;
        
    }
}
    

