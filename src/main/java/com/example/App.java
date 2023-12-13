package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       System.out.println("server partito");

       try{

        ServerSocket server = new ServerSocket(3000);
        Socket s =server.accept();

        System.out.println("client collegato");


        BufferedReader in= new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String stringa;
        stringa=in.readLine();
         String[] parole=stringa.split(" ");

        while(!stringa.isEmpty()){

            System.out.println("la stringa é "+ stringa);

            if(parole.length==3){

                if(parole[1].startsWith("/")){

                    parole[1]=parole[1].substring(1);

                }

                File file=new File(parole[1]);

                if(file.exists()){

                    out.writeBytes("HTTP/1.1 200 OK\n");
                    out.writeBytes("Content-lenght:14\n");
                    out.writeBytes("\n");
                    out.writeBytes("il file esiste");
                    
                }
                else{

                    out.writeBytes("HTTP/1.1 200 OK\n");
                    out.writeBytes("Content-Lenght:14\n");
                    out.writeBytes("\n");
                    out.writeBytes(msg);
                   
                }
                
            }

            stringa=in.readLine();
           
        }

         s.close();

        
        //stringaArray[]=stringaPrincipale.split(" ");
      
       }catch(Exception e){


        }
    }
    
}

