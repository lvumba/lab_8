package com.company.commands;

import com.company.MyCollection;
import com.company.Otvet;
import com.company.Ticket;
import com.company.serv.Pak;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;


public class RemoveById implements Command{

    @Override
    public Otvet run(MyCollection myCollection, Pak pak) {
        Otvet otvet = new Otvet();
        otvet.text = myCollection.remove(pak.id, pak.login);
        return otvet;
    }



    @Override
    public CommandType getType() {
        return CommandType.REMOVE_BY_ID;
    }
}
