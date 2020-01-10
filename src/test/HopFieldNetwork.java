/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;

/**
 *
 * @author zahid
 */
public class HopFieldNetwork {
    public static void main (String args []){
        
        Scanner in = new Scanner (System.in);
        
        int val=0, test=0;

        int th1 = 0;
        int th2 = 0;
        int th3 = 0;
        int th4 = 0;
        int th5 = 0;
        int th6 = 0;
        int th7 = 0;
        int th8 = 0;
        int th9 = 0;
        int th10 = 0;
        int th11 = 0;
        int th12 = 0;
        int th13 = 0;
        int th14 = 0;
        int th15 = 0;
        int th16 = 0;
        
        int n = 4;
        int first [][] = new int [n][n];
        int sec [][] = new int [n][n];
        int W1 [][] = new int [16][16];
        int W2 [][] = new int [16][16];
        int res [][] = new int [16][16];
        int row [] = new int [16];
        int col [] = new int [16];
        int inc [][] = new int [16][1];
        int th [][] = new int [4][4];
        
        
        
        /*
        N = 1 -1 -1 1 1 1 -1 1 1 -1 1 1 1 -1 -1 1
        */
        System.out.println ("\nInput First Character:\n");
        for (int r = 0; r < n; r++){
            for (int c = 0; c < n; c++){
                first[r][c] = in.nextInt();
            }
        }
       
        /*
        Printing the Letter: N
        */
        System.out.println ("\nPrinting input String:");
        for (int r = 0; r < n; r++){
            for (int c = 0; c < n; c++){
                if (first[r][c] == 1){
                    System.out.print("*\t");
                    //System.out.println();
                }
                else{
                    System.out.print("\t");
                    //System.out.println();
                }
            }
            System.out.println("\n");
        }
        /*
        *************************************
        */
        
        System.out.println ("\nPrinting input String:\n");
        for (int r = 0; r < n; r++){
            for (int c = 0; c < n; c++){
                System.out.print (first[r][c] +"\t");
                row[val] = first[r][c]; 
                val++;
            }
            System.out.println ();
            System.out.println ();
        }
        
        System.out.println ("\nOne-D Array:");
        for (int r = 0; r < 16; r++){
            System.out.print(row[r]+" ");
        }
        
        
        System.out.println ("\n2D array:\n");
        for (int r = 0 ; r < 16; r++){
            for (int c = 0; c < 16; c++){
                
                W1[r][c] = row[r];
                if (r == c)
                    W1[r][c] = 0;
                else
                {
                    W1[r][c] = row[r]*row[c];
                }
                System.out.print (W1[r][c] +"\t");
            }
            
            System.out.println("\n");
        }
        
        /*
        Second Letter...
        R = 1 1 1 -1 1 -1 1 -1 1 1 -1 -1 1 -1 1 -1
        */
        
        System.out.println ("\nInput Second Character:\n");
        for (int r = 0; r < n; r++){
            for (int c = 0; c < n; c++){
                sec[r][c] = in.nextInt();
            }
        }
       
        /*
        Printing the Letter: N
        */
        System.out.println ("\nPrinting input String:");
        for (int r = 0; r < n; r++){
            for (int c = 0; c < n; c++){
                if (sec[r][c] == 1){
                    System.out.print("*\t");
                    //System.out.println();
                }
                else{
                    System.out.print("\t");
                    //System.out.println();
                }
            }
            System.out.println("\n");
        }
        /*
        *************************************
        */
        
        System.out.println ("\nPrinting input String:\n");
        for (int r = 0; r < n; r++){
            for (int c = 0; c < n; c++){
                System.out.print (sec[r][c] +"\t");
                col[test] = sec[r][c]; 
                test++;
            }
            System.out.println ();
            System.out.println ();
        }
        
        System.out.println ("\nOne-D Array:");
        for (int r = 0; r < 16; r++){
            System.out.print(col[r]+" ");
        }
        
        
        System.out.println ("\n2D array:\n");
        for (int r = 0 ; r < 16; r++){
            for (int c = 0; c < 16; c++){
                
                W2[r][c] = col[r];
                if (r == c)
                    W2[r][c] = 0;
                else
                {
                    W2[r][c] = col[r]*col[c];
                }
                System.out.print (W2[r][c] +"\t");
            }
            
            System.out.println("\n");
        }
        
        /*
        Activation function...
        */
        
        System.out.println ("\nActivation Matrix:\n");
        for (int r = 0; r < 16; r++){
            for (int c = 0 ; c < 16; c++){
                res[r][c] = W1[r][c] + W2[r][c];
                System.out.print (res[r][c] +"\t");
            }
            System.out.println ("\n");
        }
        
        
        /*
        1 -1 -1 1 1 -1 -1 1 1 -1 -1 1 1 -1 -1 1
        */
        System.out.println ("Input Damaged Pattern:\n");
        
        for (int i = 0 ; i < 16; i++)
        {
            for (int j = 0; j < 1; j++)
            {
                inc[i][j] = in.nextInt();
            }
        }
            
        
        System.out.println ("Multiplying & Adding...\n");
        /*
        Threshold...
        */
        for (int r = 0; r < 16; r++){
            for (int c = 0; c < 1; c++){
                
                th1 += inc[r][0] * res[r][0];
               
            }
        }
        System.out.print (th1+"\t");
        
        for (int r = 0; r < 16; r++){
            for (int c = 1; c < 2; c++){
                
                th2 += inc[r][0] * res[r][1];
                
            }
        }
        System.out.print (th2+"\t");
        
        for (int r = 0; r < 16; r++){
            for (int c = 2; c < 3; c++){
                
                th3 += inc[r][0] * res[r][2];
                
            }
        }
        System.out.print (th3+"\t");
        
        for (int r = 0; r < 16; r++){
            for (int c = 3; c < 4; c++){
                
                th4 += inc[r][0] * res[r][3];
                
            }
        }
        System.out.print (th4+"\t");
        
        for (int r = 0; r < 16; r++){
            for (int c = 4; c < 5; c++){
                
                th5 += inc[r][0] * res[r][4];
                
            }
        }
        System.out.print (th5+"\t");
        
        for (int r = 0; r < 16; r++){
            for (int c = 5; c < 6; c++){
                
                th6 += inc[r][0] * res[r][5];
                
            }
        }
        System.out.print (th6+"\t");
        
        for (int r = 0; r < 16; r++){
            for (int c = 6; c < 7; c++){
                
                th7 += inc[r][0] * res[r][6];
                
            }
        }
        System.out.print (th7+"\t");
        
        for (int r = 0; r < 16; r++){
            for (int c = 7; c < 8; c++){
                
                th8 += inc[r][0] * res[r][7];
                
            }
        }
        System.out.print (th8+"\t");
        
        for (int r = 0; r < 16; r++){
            for (int c = 8; c < 9; c++){
                
                th9 += inc[r][0] * res[r][8];
                
            }
        }
        System.out.print (th9+"\t");
        
        for (int r = 0; r < 16; r++){
            for (int c = 9; c < 10; c++){
                
                th10 += inc[r][0] * res[r][9];
                
            }
        }
        System.out.print (th10+"\t");
        
        for (int r = 0; r < 16; r++){
            for (int c = 10; c < 11; c++){
                
                th11 += inc[r][0] * res[r][10];
                
            }
        }
        System.out.print (th11+"\t");
        
        for (int r = 0; r < 16; r++){
            for (int c = 11; c < 12; c++){
                
                th12 += inc[r][0] * res[r][11];
                
            }
        }
        System.out.print (th12+"\t");
        
        for (int r = 0; r < 16; r++){
            for (int c = 12; c < 13; c++){
                
                th13 += inc[r][0] * res[r][12];
                
            }
        }
        System.out.print (th13+"\t");
        
        for (int r = 0; r < 16; r++){
            for (int c = 13; c < 14; c++){
                
                th14 += inc[r][0] * res[r][13];
                
            }
        }
        System.out.print (th14+"\t");
        
        for (int r = 0; r < 16; r++){
            for (int c = 14; c < 15; c++){
                
                th15 += inc[r][0] * res[r][14];
                
            }
        }
        System.out.print (th15+"\t");
        
        for (int r = 0; r < 16; r++){
            for (int c = 15; c < 16; c++){
                
                th16 += inc[r][0] * res[r][15];
                
            }
        }
        System.out.print (th16+"\t");
        
        //Threshold calculation;

        th[0][0] = th1;
        th[0][1] = th2;
        th[0][2] = th3;
        th[0][3] = th4;
        th[1][0] = th5;
        th[1][1] = th6;
        th[1][2] = th7;
        th[1][3] = th8;
        th[2][0] = th9;
        th[2][1] = th10;
        th[2][2] = th11;
        th[2][3] = th12;
        th[3][0] = th13;
        th[3][1] = th14;
        th[3][2] = th15;
        th[3][3] = th16;
        
        System.out.println ("\n\nRecovered Letter:\n");
        for (int i = 0 ; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (th[i][j] < 0){
                    System.out.print ("\t");
                }
                //th[i][j] = -1;
            else
                    System.out.print ("*\t");
                //th[i][j] = 1;
            
            //System.out.print (th[i] + "\t");
            }
            
            System.out.println("\n");
        }
    }
    
}
