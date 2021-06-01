package com.company.serv;

import com.company.Ticket;
import com.company.commands.CommandType;

import java.io.Serializable;

public class Pak implements Serializable {

    public String login = null;
    public String password = null;
    public boolean register = false;

    public CommandType type = null;
    public Ticket ticket = null;
    public long id;


}
