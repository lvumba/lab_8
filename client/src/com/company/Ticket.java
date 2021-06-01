package com.company;
import java.io.Serializable;
import java.sql.Date;

public class Ticket implements Serializable {

    private long id;
    private String name;
    private Coordinates coordinates;
    private Date creationDate;
    private Integer price;
    private Long discount;
    private String comment;
    private TicketType type;
    private Venue venue;

    private String creatorName;

    public Ticket(String name, Coordinates coordinates, Integer price, Long discount, String comment, TicketType type, Venue venue){
        this.id = 0;


        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = new Date(new java.util.Date().getTime());
        this.price = price;
        this.discount = discount;
        this.comment = comment;
        this.type = type;
        this.venue = venue;





    }


    public Object[] toObjects(){
        return new Object[] {id, name, coordinates.getX(), coordinates.getY(), creationDate, price, discount, comment, type, venue.getName(), venue.getCapacity(), venue.getType(), creatorName};

    }

    @Override
    public String toString() {
        String s = "";
        s += "id: " + this.id;
        s += "; name: " + this.name ;
        s += "; coordinates: " + this.coordinates;
        s += "; creationDate: " + this.creationDate.toString();
        s += "; price: " + this.price;
        s += "; discount: " + this.discount;
        s += "; comment: " + this.comment;
        s += "; type: " + this.type;
        s += "; venue: " + this.venue;
        return s;
    }

    @Override
    public int hashCode() {
        return this.getPrice();
    }


    public void updateCreationDate(){
        this.creationDate = new Date(new java.util.Date().getTime());

    }

    public void setCreationDate(Date creationDate) {

        this.creationDate = creationDate;
    }

    public Date getCreationDate() { return creationDate; }

    public long getId() {
        return id;
    }

    public Long getDiscount() {
        if (discount == null){
            return new Long(0);
        }
        return discount;
    }

    public String getName() {
        return name;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public Coordinates getCoordinates() {
        if (coordinates == null){
            return new Coordinates();
        }
        return coordinates;
    }

    public Integer getPrice() {
        if (price == null){
            return new Integer(0);
        }
        return price;
    }



    public String getComment() {
        return comment;
    }

    public TicketType getType() {

        return type;
    }



    public Venue getVenue() {
        return venue;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setDiscount(Long discount) {
        this.discount = discount;
    }
    public void setType(TicketType type) {
        this.type = type;
    }
    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setId(long id) {
        this.id = id;

    }
}




