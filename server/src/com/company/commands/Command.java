package com.company.commands;

import com.company.MyCollection;
import com.company.Otvet;
import com.company.PostgreSQL;

import com.company.serv.Pak;


public interface Command {
    public Otvet run(MyCollection myCollection, Pak pak);
    public CommandType getType();
}
