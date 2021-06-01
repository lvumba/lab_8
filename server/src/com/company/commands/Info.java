
package com.company.commands;

import com.company.MyCollection;
import com.company.Otvet;
import com.company.PostgreSQL;

import com.company.serv.Pak;


import java.util.Date;
public class Info implements Command{
    private Date date;

    public Info(Date date){
        this.date = date;
    }




    @Override
    public Otvet run(MyCollection myCollection, Pak pak) {
        Otvet otvet = new Otvet();
        otvet.text = "Тип коллекции: ArrayList" + "; " + "дата иницилизации: " +
                this.date.toString() + " количество элементов: "+ myCollection.size() + "\n";
        return otvet;
    }

    @Override
    public CommandType getType() {
        return CommandType.INFO;
    }
}

