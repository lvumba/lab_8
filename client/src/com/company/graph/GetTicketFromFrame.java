package com.company.graph;

import com.company.*;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import javax.swing.*;

public class GetTicketFromFrame {

    public static Ticket getTicket(MainFrame mainFrame, AddFrame addFrame) throws ValueException{
        return process(addFrame.getTexts(), mainFrame);

    }
    public static Ticket getTicket(MainFrame mainFrame, UpdateFrame updateFrame) throws ValueException{
        return process(updateFrame.getTexts(), mainFrame);
    }

    public static Ticket process(String[] str, MainFrame mainFrame) throws ValueException{
        String name;
        Long x;
        float y;
        Integer price;
        Long discount;
        String comment;
        TicketType ticketType;
        String venueName;
        Integer venueCapacity;
        VenueType venueType;

        name = str[0];

        try {
            x = Long.parseLong(str[1]);
        } catch (IllegalArgumentException exception) {
            JOptionPane.showMessageDialog(mainFrame, "Введите корректное значение x");
            throw new ValueException("");
        }

        try{
            y = Float.parseFloat(str[2]);
        }catch (IllegalArgumentException exception){
            JOptionPane.showMessageDialog(mainFrame, "Введите корректное значение y");
            throw new ValueException("");
        }
        try{
            price = Integer.parseInt(str[3]);
        }catch (IllegalArgumentException exception){
            JOptionPane.showMessageDialog(mainFrame, "Введите корректное значение Price");
            throw new ValueException("");
        }

        try{
            discount = Long.parseLong(str[4]);
        }catch (IllegalArgumentException exception){
            JOptionPane.showMessageDialog(mainFrame, "Введите корректное значение Discount");
            throw new ValueException("");
        }

        comment = str[5];

        try{
            ticketType = TicketType.valueOf(str[6]);
        }catch (IllegalArgumentException exception){
            JOptionPane.showMessageDialog(mainFrame, "Введите корректное значение TicketType");
            throw new ValueException("");
        }

        venueName = str[7];

        try{
            venueCapacity = Integer.parseInt(str[8]);
        }catch (IllegalArgumentException exception){
            JOptionPane.showMessageDialog(mainFrame, "Введите корректное значение VenueCapacity");
            throw new ValueException("");
        }

        try{
            venueType = com.company.VenueType.valueOf(str[9]);
        }catch (IllegalArgumentException exception){
            JOptionPane.showMessageDialog(mainFrame, "Введите корректное значение VenueType");
            throw new ValueException("");
        }


        return new Ticket(name, new Coordinates(x, y), price, discount, comment, ticketType, new Venue(venueName, venueCapacity,venueType));
    }
}
