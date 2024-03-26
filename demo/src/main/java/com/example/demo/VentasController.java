package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentasController {
    
    private List<Ventas> ventas = new ArrayList<>();


    public VentasController() {

        // Inicializar la lista con datos

        ventas.add(new Ventas(1, "25","03","2024",
                              Arrays.asList(new Producto(001,"Comida Gatos"), 
                                            new Producto(002, "Collar Antipulgas"),
                                            new Producto(003, "Comida Perro")),
                            llenarListaVentas("Comida Gatos",1000,5000,10000)));

        ventas.add(new Ventas(2, "20","03","2024",
                            Arrays.asList(new Producto(001,"Comida Gatos"), 
                                          new Producto(002, "Collar Antipulgas"),
                                          new Producto(003, "Comida Perro")),
                          llenarListaVentas("Comida Perro",3000,1000,2000)));

        ventas.add(new Ventas(3, "18","02","2024",
                            Arrays.asList(new Producto(001,"Comida Gatos"), 
                                          new Producto(002, "Collar Antipulgas"),
                                          new Producto(003, "Comida Perro")),
                            llenarListaVentas("Collar Antipulgas",500,10000,6000)));

         ventas.add(new Ventas(4, "05","12","2023",
                            Arrays.asList(new Producto(001,"Comida Gatos"), 
                                          new Producto(002, "Collar Antipulgas"),
                                          new Producto(003, "Comida Perro")),
                            llenarListaVentas("Comida Perro",3000,2500,7000)));

    }

     private Map<String, List<Integer>> llenarListaVentas(String producto,
      Integer venta1, Integer venta2, Integer venta3){

        Map<String, List<Integer>> retorno = new HashMap<String, List<Integer>>();

        List<Integer> ventaProducto = Arrays.asList(venta1, venta2, venta3);

        retorno.put(producto, ventaProducto);

        return retorno;

    }

@GetMapping("/ventas")

    public List<Ventas> getVentas() {

        return ventas;

    }

@GetMapping("/ventas/{id}")

    public Ventas getVentasById(@PathVariable int id) {

        for (Ventas ventaProducto : ventas) {

            if (ventaProducto.getId() == id) {

                return ventaProducto;

            }
        }
        return null;
    }



@GetMapping(path = "/ventas/{idVentas}/montoTotales/{nombreProducto}")

    public Integer listarPorProducto(@PathVariable("idVentas") Integer idVentas,

            @PathVariable("nombreProducto") String nombreProducto) {

                Integer montoTotal = 0;

        for (Ventas ventaProducto : ventas) {

            if (ventaProducto.getId() == idVentas) {

                List<Integer> ventas = ventaProducto.getVentasPorProducto().get(nombreProducto);

                Integer sumatoria = 0;

                for (Integer venta : ventas) {
      
                    sumatoria = sumatoria + venta;
                }
                montoTotal = sumatoria;
            }
        }
        return montoTotal;

    }




    @GetMapping(path = "/ventas/dia/{diaVenta}")

    public Integer listarVentasDiarias(@PathVariable("diaVenta") String diaVenta) {

                Integer montoTotal = 0;

        for (Ventas ventaProducto : ventas) {

            if (ventaProducto.getDiaVenta().equals(diaVenta)) {

                List<Integer> ventas = ventaProducto.getVentasPorProducto().get(diaVenta);

                Integer sumatoria = 0;

                for (Integer venta : ventas) {
      
                    sumatoria = sumatoria + venta;
                }
                montoTotal = sumatoria;
            }
        }
        return montoTotal;

    }

    @GetMapping("/ventas/dias/{diaVenta}")

    public Ventas getVentasByDia(@PathVariable String diaVenta) {

        for (Ventas ventaProducto : ventas) {

            if (ventaProducto.getDiaVenta().equals(diaVenta)) {

                return ventaProducto;

            }
        }
        return null;
    }



}
