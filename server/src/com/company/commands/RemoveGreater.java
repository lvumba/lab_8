/*
package com.company.commands;

import com.company.Ticket;
import com.company.serv.Pak;

import java.util.ArrayList;
import java.util.Iterator;

public class RemoveGreater implements Command{
    @Override
    public String run(ArrayList<Ticket> collection, Pak pak) {
        Ticket tIn = pak.ticket;

        int i = 0;

        Iterator<Ticket> iterator = collection.iterator();

        while (iterator.hasNext()) {
            Ticket t = iterator.next();
            if (t.hashCode() > tIn.hashCode()) {
                iterator.remove();
                i += 1;
            }
        }

        if (i > 0){
            return "Удалил\n";
        } else {
            return "Таких элементов нет\n";
        }
    }

    @Override
    public CommandType getName() {
        return CommandType.REMOVE_GREATER;
    }
}
*/
