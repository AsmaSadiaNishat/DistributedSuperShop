/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dsupershop.First_Program;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author success
 */
class Login {

}

public class JDBCTest {

    public static Connection conn = null;
    public static PreparedStatement ps = null;
    public static ResultSet rs = null;

    static void login() {

        conn = First_Program.First_Program();
        String sql, u, p;

        Scanner in = new Scanner(System.in);

        System.out.print("User name:\t");
        u = in.next();
        System.out.print("Password:\t");
        p = in.next();

        
        try {

            sql = "SELECT * FROM LOGIN WHERE USER_NAME = ? AND PASSWORD = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, u);
            ps.setString(2, p);
            rs = ps.executeQuery();
            if (rs.next()) {
                
                    System.out.println("Login Successfull");
                } else {
                    System.out.println("Login Denied");
                }
            

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[]) {

        login();

    }
}
