package com.company.commands;

import com.company.Otvet;
import com.company.serv.Connect;
import com.company.serv.Pak;


public class Info  {

    public static Otvet run(String login, String password) {
        Otvet otvet = new Otvet();

        Pak pak = new Pak();

        pak.type = CommandType.INFO;
        pak.login = login;
        pak.password = password;
        Connect.send(pak);

        otvet = Connect.read();


        return otvet;
    }
}
