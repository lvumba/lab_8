package com.company.serv;

import com.company.Otvet;
import com.company.commands.Command;

import java.io.*;
import java.net.Socket;

public class Connect {
    //private static String ADDR = "192.168.1.102";
    private static String ADDR = "localhost";
    private static int PORT = 4998;
    private static Socket s ;
    private static ObjectOutputStream objectOutputStream;
    private static ObjectInputStream objectInputStream;

    public Connect(){
        try {
            s = new Socket(ADDR, PORT);
            OutputStream o = s.getOutputStream();
            objectOutputStream = new ObjectOutputStream(o);

            InputStream input  = s.getInputStream();
            objectInputStream  = new ObjectInputStream(input);

        }catch( IOException e){
            System.out.println("Что-то пошло не так");

        }
    }

    public static boolean send(Pak pak) {
        try {
            objectOutputStream.writeObject(pak);
            return true;
        }catch (IOException e){
            return false;
        }

    }

    public static Otvet read(){
        try {

            Object obj = objectInputStream.readObject();

            Otvet otvet = (Otvet) obj;



            return otvet;
        }catch(IOException e){
            System.out.println("Что-то не так");
            e.printStackTrace();
        }catch (ClassNotFoundException c){ System.out.println("Такого класса нет"); }return null;
    }


}
