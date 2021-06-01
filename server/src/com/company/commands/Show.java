package com.company.commands;

import com.company.MyCollection;
import com.company.Otvet;
import com.company.PostgreSQL;
import com.company.Ticket;
import com.company.serv.Pak;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Show implements Command{

    @Override
    public Otvet run(MyCollection myCollection, Pak pak) {
        Otvet otvet = new Otvet();

        if (myCollection.size() == 0){
            otvet.text = "В коллекции нет элементов\n";
        }
        otvet.text = myCollection.toString(pak);
        otvet.tickets = myCollection.getCollection();


        return otvet;
    }

    @Override
    public CommandType getType() {
        return CommandType.SHOW;
    }

}
