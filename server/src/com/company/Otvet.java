package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Otvet implements Serializable {
    public String text = "";
    public ArrayList<Ticket> tickets;
    public boolean incorrect = false;
}
