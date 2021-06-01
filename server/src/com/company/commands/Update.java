package com.company.commands;

import com.company.MyCollection;
import com.company.Otvet;
import com.company.Ticket;
import com.company.serv.Pak;

import java.util.ArrayList;
import java.util.Optional;


public class Update implements Command{
    @Override
    public CommandType getType() {
        return CommandType.UPDATE;
    }

    @Override
    public Otvet run(MyCollection myCollection, Pak pak) {
        Otvet otvet = new Otvet();
        otvet.text = myCollection.update(pak.id, pak);

        return otvet;


    }


}














