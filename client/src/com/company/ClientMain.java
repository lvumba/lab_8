package com.company;

import com.company.commands.*;
import com.company.serv.Connect;
import com.company.serv.Pak;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ClientMain {

    public static void main(String[] args) {

        //Connect connect = new Connect();

        Venue detsad = new Venue("Детский сад", 26, VenueType.LOFT);
        Ticket t1 = new Ticket("Tick", new Coordinates(), new Integer(10), new Long(15), "no comments", TicketType.VIP, detsad);
        Ticket t2 = new Ticket("Tick2", new Coordinates(), new Integer(40), new Long(30), "no comments", TicketType.VIP, detsad);


        Command[] commands = new Command[7];
        /*commands[0] = new Show();
        commands[1] = new Help();
        commands[2] = new Add();
        commands[3] = new Exit();
        commands[4] = new Info();
        commands[5] = new RemoveById();
        commands[6] = new UpdateId();*/

        /*
        commands[5] = new UpdateId();
        commands[6] = new RemoveById();
        commands[7] = new Clear();
        commands[8] = new Reorder();
        commands[9] = new PrintAscending();
        commands[10] = new MinByCreationDate();
        commands[11] = new AverageOfDiscount();
        commands[12] = new RemoveLower();
        commands[13] = new RemoveGreater();*/

        /*String ADDR = "localhost";
        int PORT = 4998;


        try {






        }catch (IOException | InterruptedException e){
            System.out.println("Что за?");
        }*/
        /*Pak pak = new Pak();
        Connect.send();*/






        Scanner in = new Scanner(System.in);

        System.out.print("Введите логин: ");
        String login = in.nextLine();
        System.out.print("Введите пароль: ");
        String password = in.nextLine();





        Otvet otvet;

        boolean log = true;

        String s;

        while (true) {
            if (log){
                s = "show";
                log = false;
            }else{
                s = in.nextLine();

            }



            for (int i = 0; i < commands.length; i++) {

                otvet = commands[i].run(s, login, password);

                System.out.print(otvet.text);

                if (otvet.incorrect){
                    System.out.println("Вы хотите зарегистрироваться? y/n");

                    String r = in.nextLine().toLowerCase();

                    System.out.print("Введите логин: ");
                    login = in.nextLine();
                    System.out.print("Введите пароль: ");
                    password = in.nextLine();

                    if (r.equals("y") || r.equals("yes") || r.equals("да") || r.equals("конечно")){
                        Pak pak = new Pak();
                        pak.login = login;
                        pak.password = password;
                        pak.register = true;

                        Connect.send(pak);
                        System.out.print(Connect.read().text);

                    }

                    log = true;

                }

            }

        }
    }
}

