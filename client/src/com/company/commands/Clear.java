package com.company.commands;

import com.company.Otvet;
import com.company.serv.Connect;
import com.company.serv.Pak;

import java.util.LinkedList;

public class Clear  {

    public static Otvet run(String login, String password) {


        Pak pak = new Pak();
        pak.type = CommandType.CLEAR;
        pak.login = login;
        pak.password = password;

        Connect.send(pak);
        return Connect.read();


    }
}


