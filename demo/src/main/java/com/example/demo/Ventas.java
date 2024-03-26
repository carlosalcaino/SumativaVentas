package com.example.demo;

import java.util.List;
import java.util.Map;

public class Ventas {

private int id;
private String diaVenta;
private String mesVenta;
private String añoVenta;
private List<Producto> productos;
private Map<String, List<Integer>> ventasPorProducto;


public Ventas (int id, String diaVenta,String mesVenta,String añoVenta,List<Producto> productos,Map<String, List<Integer>> ventasPorProducto){
this.id = id;
this.diaVenta = diaVenta;
this.mesVenta = mesVenta;
this.añoVenta = añoVenta;
this.productos = productos;
this.ventasPorProducto = ventasPorProducto;}

public int getId() {
    return id;
}

public String getDiaVenta() {
    return diaVenta;
}

public String getMesVenta() {
    return mesVenta;
}

public String getAñoVenta() {
    return añoVenta;
}

public List<Producto> getProductos() {
    return productos;
}

public Map<String, List<Integer>> getVentasPorProducto() {
    return ventasPorProducto;
}

}
