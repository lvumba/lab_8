/*
package com.company.commands;

import com.company.Ticket;
import com.company.serv.Pak;

import java.util.ArrayList;
import java.util.stream.Stream;

public class PrintAscending implements Command{
    @Override
    public String run(ArrayList<Ticket> collection, Pak pak) {
        String s = collection.stream().sorted((t1, t2) -> t1.hashCode() - t2.hashCode())
                .reduce("", (t1, t2) -> t1 + "\n" + t2, String::concat);

        return s + "\n";
    }

    @Override
    public CommandType getName() {
        return CommandType.PRINT_ASCENDING;
    }
}
*/
