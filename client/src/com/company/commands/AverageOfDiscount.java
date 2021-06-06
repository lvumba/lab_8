package com.company.commands;

import com.company.Otvet;
import com.company.serv.Connect;
import com.company.serv.Pak;

public class AverageOfDiscount {

    public static Otvet run(String login, String password) {

        Pak pak = new Pak();
        pak.type = CommandType.AVERAGE_DISCOUNT;
        pak.login = login;
        pak.password = password;
        Connect.send(pak);
        return Connect.read();
    }
}


