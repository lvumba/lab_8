package com.company.commands;

import com.company.Otvet;
import com.company.serv.Connect;
import com.company.serv.Pak;


public class Info implements Command {

    @Override
    public Otvet run(String s, String login, String password) {
        Otvet otvet = new Otvet();
        if (s.contains("info")){
            Pak pak = new Pak();

            pak.type = CommandType.INFO;
            pak.login = login;
            pak.password = password;
            Connect.send(pak);

            otvet = Connect.read();

        }
        return otvet;
    }
}
