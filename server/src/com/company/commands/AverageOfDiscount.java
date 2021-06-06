
package com.company.commands;

import com.company.MyCollection;
import com.company.Otvet;
import com.company.Ticket;
import com.company.serv.Pak;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class AverageOfDiscount implements Command{

    @Override
    public Otvet run(MyCollection myCollection, Pak pak) {
        float S = 0;
        int i = myCollection.size();

        for (Ticket t: myCollection.getCollection()){
            S += t.getDiscount();
        }

        Otvet otvet = new Otvet();
        otvet.text = "Среднее значение Discount: " + S/i;

        System.out.println("в команде " + otvet.text);

        return otvet;
    }


    @Override
    public CommandType getType() {
        return CommandType.AVERAGE_DISCOUNT;
    }
}


