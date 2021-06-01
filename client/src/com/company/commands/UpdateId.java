
package com.company.commands;
import com.company.Otvet;
import com.company.Ticket;
import com.company.serv.Connect;
import com.company.serv.Pak;

import java.util.Scanner;



public class UpdateId {


    public static Otvet run(long id, Ticket ticket, String login, String password) {

        Pak pak = new Pak();
        pak.type = CommandType.UPDATE;
        pak.id = id;
        pak.ticket = ticket;
        pak.login = login;
        pak.password = password;
        Connect.send(pak);
        return Connect.read();


    }
}




