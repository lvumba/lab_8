
package com.company.commands;

import com.company.MyCollection;
import com.company.Otvet;
import com.company.Ticket;
import com.company.serv.Pak;

import java.util.ArrayList;

public class Clear implements Command{

    @Override
    public Otvet run(MyCollection myCollection, Pak pak) {
        Otvet otvet = new Otvet();
        otvet.text = myCollection.clear(pak.login);
        return otvet;
    }

    @Override
    public CommandType getType() {
        return CommandType.CLEAR;
    }




}

