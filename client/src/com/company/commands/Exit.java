package com.company.commands;
import com.company.Otvet;

import java.util.LinkedList;
import java.util.Scanner;

public class Exit implements Command {
    Scanner in = new Scanner(System.in);

    @Override
    public Otvet run(String s, String login, String password) {
        if (s.contains("exit")) {
            System.exit(0);

        }
        return new Otvet();
    }
}
