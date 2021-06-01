package com.company.commands;

import com.company.Otvet;
import com.company.Ticket;
import com.company.serv.Connect;
import com.company.serv.Pak;

import java.util.LinkedList;

public class Add {



    public static Otvet run(Ticket ticket, String login, String password) {
        Otvet otvet;

        Pak pak = new Pak();
        pak.type = CommandType.ADD;
        pak.ticket = ticket;
        pak.ticket.setCreatorName(login);
        pak.login = login;
        pak.password = password;
        Connect.send(pak);
        otvet = Connect.read();

        return otvet;
    }
}

