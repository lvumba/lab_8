package com.company;

import java.io.Serializable;

public class Venue implements Serializable {
    private long last_id = 0;
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Integer capacity; //Значение поля должно быть больше 0
    private VenueType type; //Поле может быть null

    public Venue(String name, Integer capacity, VenueType type){
        this.id = last_id + 1;
        this.last_id = this.id;

        this.name = name;
        this.capacity = capacity;
        this.type = type;


    }

    @Override
    public String toString() {
        String s = "";

        s += this.name  + "{";
        s += "capacity: "+ this.capacity;
        s += ", type: " + this.type + "}";

        return s;
    }

    public void setId(long id) {
        this.id = id;
        if (last_id < id){
            last_id = id;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setLast_id(long last_id) {
        this.last_id = last_id;
    }

    public void setType(VenueType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Integer getCapacity() {
        if (capacity == null){
            return new Integer(0);
        }
        return capacity;
    }

    public long getId() {
        return id;
    }

    public VenueType getType() {
        return type;
    }

}
