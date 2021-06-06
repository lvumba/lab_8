package com.company;

import com.company.serv.Pak;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyCollection {
    private ArrayList<Ticket> collection;
    private PostgreSQL database;


    public MyCollection(PostgreSQL database){
        this.collection = database.show();
        this.database = database;



    }

    public boolean add(Ticket ticket){
        try {
            database.add(ticket);
            collection.add(ticket);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();

            return false;

        }

    }

    @Override
    public String toString() {
        String s = "";
        for (Ticket t : collection){
            s += t.toString() + "\n";
        }
        return s;
    }

    public String toString(Pak pak){
        String s = "";
        String creator = pak.login;
        for (Ticket t : collection){
            if (creator.equals(t.getCreatorName())){
                s += "+";
            }else{
                s += "-";
            }
            s += " ";
            s += t.toString() + "\n";
        }
        return s;

    }

    public int size(){
        return collection.size();
    }

    public String remove(long id, String userLogin){
        Iterator<Ticket> iterator = collection.iterator();

        while (iterator.hasNext()) {
            Ticket t = iterator.next();

            if (id == t.getId()) {
                if (userLogin.equals(t.getCreatorName())){

                    if (database.remove(id)){
                        iterator.remove();
                        return "Удалил\n";
                    }else{
                        return "Чёт, какая-то фигня с удалением из баы данных\n";
                    }



                }else{
                    return "Вы не можете удалить чужой объект\n";
                }

            }
        }

        return "Такого id нет\n";

    }


    public String update(long id, Pak pak){

        Optional<Ticket> tt = collection.stream().filter(x -> x.getId() == id).findAny();
        Ticket t = tt.orElse(null);

        if (t == null) {
            return "Такого id нет\n";
        }

        if (! pak.login.equals(t.getCreatorName())){
            return "Вы не можете редактировать этот объект, так как не вы его создали\n";
        }

        Ticket ticket = pak.ticket;
        ticket.setCreatorName(pak.login);
        if (database.update(id, ticket)){

            t.setName(ticket.getName());
            t.setCoordinates(ticket.getCoordinates());
            t.setCreationDate(ticket.getCreationDate());
            t.setPrice(ticket.getPrice());

            t.setDiscount(ticket.getDiscount());
            t.setComment(ticket.getComment());
            t.setType(ticket.getType());
            t.setVenue(ticket.getVenue());
            t.setCreatorName(pak.login);

            return "Обновил";

        }
        return "Не получилость обновить объект в базе данных\n";
    }

    public ArrayList<Ticket> getCollection() {
        ArrayList<Ticket> o = new ArrayList<Ticket>();
        for (Ticket t: this.collection){
            o.add(t);
        }
        return o;

    }

    public String clear(String login){
        if (database.clear(login)){
            this.collection = database.show();
            return "Нужные билеты удалены";
        }
        else{
            return "Не получилось удалить билеты " + login + " из базы данных";
        }
    }
}
