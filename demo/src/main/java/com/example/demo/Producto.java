package com.example.demo;


public class Producto {
    
    private int id;
    private String nombreProducto;

    public Producto (int id,String nombreProducto){
    this.id = id;
    this.nombreProducto = nombreProducto;
    }

public int getId() {
    return id;
}

public String getNombreProducto() {
    return nombreProducto;
}

}
