/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appferreteriaconarchivosbinarios;

/**
 *
 * @author The Survivor
 */
public class Producto {
    int clave;
    String descripcion;
    double precio;
    int cantDeProductos; //en almacen o bodega
    
    public Producto(int cve, String desc, double p, int cant)
    {
        clave = cve;
        descripcion = desc;
        precio = p;
        cantDeProductos = cant;
    }
}
