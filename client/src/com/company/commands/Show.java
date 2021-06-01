package com.company.commands;

import com.company.Otvet;
import com.company.Ticket;
import com.company.serv.Connect;
import com.company.serv.Pak;

import java.util.ArrayList;

public class Show  {

    public static Otvet run(String login, String password) {
        Otvet otvet = new Otvet();
        otvet.text = "";

        Pak pak = new Pak();
        pak.type = CommandType.SHOW;
        pak.login = login;
        pak.password = password;

        Connect.send(pak);
        otvet = Connect.read();






        return otvet;
    }
}
