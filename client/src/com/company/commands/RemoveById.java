package com.company.commands;

import com.company.Otvet;
import com.company.serv.Connect;
import com.company.serv.Pak;

import java.util.Iterator;


public class RemoveById {


    public static Otvet run(long id, String login, String password) {

        Pak pak = new Pak();
        pak.type = CommandType.REMOVE_BY_ID;
        pak.id = id;
        pak.login = login;
        pak.password = password;
        Connect.send(pak);

        return Connect.read();


    }
}
