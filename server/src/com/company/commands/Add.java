package com.company.commands;

import com.company.MyCollection;
import com.company.Otvet;

import com.company.serv.Pak;


public class Add implements Command{

    @Override
    public Otvet run(MyCollection myCollection, Pak pak) {
        Otvet otvet = new Otvet();
        if (myCollection.add(pak.ticket)){
            otvet.text = "Добавил\n";
            return otvet;
        }
        otvet.text = "Не удалось добавить\n";
        return otvet;
    }

    @Override
    public CommandType getType() {
        return CommandType.ADD;
    }


}
