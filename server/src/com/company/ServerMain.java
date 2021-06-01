package com.company;


import com.company.threads.Computer;
import com.company.threads.Reader;
import com.company.threads.Sender;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;


public class ServerMain {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {





        PostgreSQL base = new PostgreSQL("tti");
        MyCollection myCollection = new MyCollection(base);

        /*base.update(18, new Ticket("AAAAAAA", new Coordinates(), new Integer(0), new Long(0), "", TicketType.BUDGETARY,
                new Venue("", new Integer(0), VenueType.BAR)));*/



        /*System.out.println(myCollection.add(new Ticket("ww", new Coordinates(), new Integer(1), new Long(22), "eeeee", TicketType.BUDGETARY,
                new Venue("erf", new Integer(23), VenueType.BAR))));*/

        //System.out.print(myCollection);



        int PORT = 4998;

        ServerSocket ss = new ServerSocket(PORT);
        Socket s = ss.accept();
        InputStream in = s.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(in);

        OutputStream out = s.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);



        Sender sender = new Sender(objectOutputStream);
        Computer computer = new Computer(sender, myCollection);
        Reader reader = new Reader(computer, sender, objectInputStream);

        System.out.println("Соединение установлено, жду пакета");


        new ForkJoinPool().invoke(reader);





        /*CommandManager manager = new CommandManager();


        /*
        ServerSocket ss;
        Socket s;
        OutputStream out;
        ObjectOutputStream objectOutputStream;
        InputStream inputStream;
        ObjectInputStream objectInputStream;


        while (true) {

            System.out.println("Жду соединения");

            ss = new ServerSocket(PORT);
            s = ss.accept();
            out = s.getOutputStream();
            objectOutputStream = new ObjectOutputStream(out);

            inputStream = s.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);

            Pak pak;

            System.out.println("Соединение установлено");
            System.out.println("Жду команд\n");


            while (true) {

                try {

                    Object obj = objectInputStream.readObject();

                    pak = (Pak) obj;
                    System.out.println("Команда " + pak.type + ":");

                    Otvet otvet = manager.otvet(pak);
                    System.out.println(otvet.text);

                    objectOutputStream.writeObject(otvet);



                } catch (SocketException es) {
                    System.out.println("Соединение разорвано");
                    break;
                } catch (EOFException e) {
                    System.out.println("Соединение разорвано\n");
                    pak = new Pak();
                    pak.type = CommandType.SAVE;
                    manager.otvet(pak);

                    ss.close();
                    break;
                }

            }


        }*/


    }
}
