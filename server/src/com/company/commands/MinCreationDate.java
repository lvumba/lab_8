/*
package com.company.commands;

import com.company.Ticket;
import com.company.serv.Pak;

import java.util.ArrayList;
import java.util.Optional;

public class MinCreationDate implements Command{
    @Override
    public String run(ArrayList<Ticket> collection, Pak pak) {
        Ticket min = collection.stream().min((t1, t2) -> t1.hashCode() - t2.hashCode()).orElse(null);
        if (min == null){
            return "В коллекции нет элементов\n";
        }
        return min.toString() + "\n";
    }

    @Override
    public CommandType getName() {
        return CommandType.MIN_CREATION_DATE;
    }
}
*/
