/*
package com.company.commands;

import com.company.Sort;
import com.company.Ticket;
import com.company.serv.Pak;

import java.util.ArrayList;
import java.util.Collections;

public class Reorder implements Command{
    public Sort sort = new Sort();

    public Reorder(){    }
    public Reorder(int order){
        this.sort.order = order;

    }

    @Override
    public String run(ArrayList<Ticket> collection, Pak pak) {

        if (collection.size() == 0){
            return "В колекции нет элементов\n";
        }

        Collections.sort(collection,sort);
        sort.inverse();

        return "Отсортировано\n";


    }



    @Override
    public CommandType getName() {
        return CommandType.REORDER;
    }
}
*/
