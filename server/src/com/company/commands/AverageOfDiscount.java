/*
package com.company.commands;

import com.company.Ticket;
import com.company.serv.Pak;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class AverageOfDiscount implements Command{
    @Override
    public String run(ArrayList<Ticket> collection, Pak pak) {

        Stream<Long> stream = collection.stream().map(t -> t.getDiscount());
        double n = collection.stream().count();
        Long S = stream.reduce((l1, l2) -> l1 + l2 ).orElse(new Long(0));


        return "Среднее значение discount: " + (S / n);


    }

    @Override
    public CommandType getName() {
        return CommandType.AVERAGE_DISCOUNT;
    }
}

*/
