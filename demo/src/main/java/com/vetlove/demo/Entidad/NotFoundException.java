package com.vetlove.demo.Entidad;

public class NotFoundException extends Exception {
    
    private int id;

    public NotFoundException(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}