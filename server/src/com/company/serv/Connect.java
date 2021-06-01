package com.company.serv;

import com.company.Otvet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.ServerSocketChannel;

public class Connect {

    String ADDR = "192.168.1.106";
    //private static String ADDR = "localhost";
    int PORT = 4998;

    //Socket socket = new Socket(ADDR, PORT);
/*OutputStream outputStream = socket.getOutputStream();
ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
objectOutputStream.writeObject(new Pak());*/
    public static Socket socket( int PORT) {




        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            ServerSocket serverSocket = new ServerSocket(PORT);

            Socket socket = serverSocket.accept();

            return socket;

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




        return null;
    }

    public static ObjectOutputStream out(Socket socket) {
        ObjectOutputStream objectOutputStream = null;
        try {
            OutputStream outputStream = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objectOutputStream;
    }

    public static boolean send(ObjectOutputStream objectOutputStream, Otvet otvet) {
        try {
            objectOutputStream.writeObject(otvet);
            return true;
        } catch (IOException e) {
            return false;

        }
    }

    public static ObjectInputStream in(Socket socket) {
        ObjectInputStream objectInputStream = null;
        try {
            InputStream inputStream = socket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectInputStream;
    }

    public static Pak read(ObjectInputStream objectInputStream) {
        Pak a;
        try {
            Object obj = objectInputStream.readObject();
            a = (Pak) obj;
            return a;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}