package com.company;

import java.io.Serializable;


public class Coordinates implements Serializable {
    private Long x; //Максимальное значение поля: 503, Поле не может быть null
    private float y;

    public Coordinates(){
        x = new Long(0);
        y = 0.0f;

    }

    public Coordinates(Long x, float y){
        this.x = x;
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}