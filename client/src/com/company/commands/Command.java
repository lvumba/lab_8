package com.company.commands;

import com.company.Otvet;
import com.company.Ticket;

import java.util.ArrayList;

/**
 * Основной интерфейс для всех команд
 */
public interface Command {

    public Otvet run(String s, String login, String password);
}
