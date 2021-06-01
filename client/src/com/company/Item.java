package com.company;

import java.sql.Date;


/**
 * Класс, помогающий с чтением и записью объектов TicketType из/в .xml файл
 * Объект этого класса является хранилищем для String переменных, считанных из файла (id, name, ...)
 */
public class Item {
    public String id;
    public String name;
    public String coordinates;
    public String creationDate;
    public String price;
    public String discount;
    public String comment;
    public String type;


    public String vId;
    public String vName;
    public String vCapacity;
    public String vType;

    /**
     * Из объекта Ticket делает объект Item, тем самым превращая последнего в строку. Сам объект Ticket при этом не изменяется
     * @param ticket
     * @return
     */
    public static Item toItem(Ticket ticket){
        Item item = new Item();

        item.id = Long.toString(ticket.getId());
        item.name = ticket.getName();
        item.coordinates =  ticket.getCoordinates().toString();
        item.creationDate = Long.toString(  ticket.getCreationDate().getTime()  );
        item.price = ticket.getPrice().toString();
        item.discount = ticket.getDiscount().toString();
        item.comment = ticket.getComment();
        item.type = ticket.getType() + "";

        Venue venue = ticket.getVenue();

        item.vId = Long.toString(venue.getId());
        item.vName = venue.getName();
        item.vCapacity = venue.getCapacity().toString();
        item.vType = venue.getType() + "";

        return item;


    }

    /**
     * Создаёт из себя объект Ticket. Функция вызыввается у того объекта Item, который нужно превратить в объект Ticket.
     * Сам объект Item при этом не меняется.
     * @return
     */
    public Ticket toTicket(){
        Long id = new Long(this.id);
        String name = null;
        if (!(this.name.equals("null"))){
            name = this.name;
        }

        Coordinates coordinates = new Coordinates();  //!!!                                                  !!!
        Date creationDate = new Date(Long.parseLong(this.creationDate));
        Integer price = Integer.parseInt(this.price);
        Long discount = new Long(this.discount);
        String comment = null;
        if (!(this.comment.equals("null"))){
            comment = this.comment;
        }

        TicketType type = null;
        if (!(this.type.equals("null"))){
            type = TicketType.valueOf(this.type);
        }


        Long vId = new Long(this.vId);
        String vName = null;
        if (!(this.vName.equals("null"))){
            vName = this.vName;
        }

        Integer vCapacity = Integer.parseInt(this.vCapacity);

        VenueType vType = null;
        if (!(this.vType.equals("null"))){
            vType = VenueType.valueOf(this.vType);
        }

        Venue venue = new Venue(vName, vCapacity, vType);
        venue.setId(vId);

        Ticket ticket = new Ticket(name, coordinates, price, discount, comment, type, venue);
        ticket.setId(id);
        ticket.setCreationDate(creationDate);

        return ticket;
    }


    /**
     * Возвращает кусок xml кода, созданного на основе своих данных (id, name, ...)
     * @return
     */
    @Override
    public String toString() {
        return  "<ticket>\n" +

                "\t<id>" + id + "</id>" + "\n" +
                "\t<name>" + name + "</name>" + "\n" +
                "\t<coordinates>" + coordinates + "</coordinates>" + "\n" +
                "\t<creationDate>" + creationDate + "</creationDate>" + "\n" +
                "\t<price>" + price + "</price>" + "\n" +
                "\t<discount>" + discount + "</discount>" + "\n" +
                "\t<comment>" + comment + "</comment>" + "\n" +
                "\t<type>" + type + "</type>" + "\n\n" +

                "\t<venue>" + "\n" +
                "\t\t<id>" + vId + "</id>" + "\n" +
                "\t\t<name>" + vName + "</name>" + "\n" +
                "\t\t<capacity>" + vCapacity + "</capacity>" + "\n" +
                "\t\t<type>" + vType + "</type>" + "\n" +
                "\t</venue>" + "\n" +

                "</ticket>\n";

    }


}
