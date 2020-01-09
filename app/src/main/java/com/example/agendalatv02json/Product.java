package com.example.agendalatv02json;

public class Product {
    private int imageid;
    private String nombre;

    public Product(int imageid, String nombre) {
        this.imageid = imageid;
        this.nombre = nombre;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
