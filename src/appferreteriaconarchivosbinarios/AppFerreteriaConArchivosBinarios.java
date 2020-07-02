/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appferreteriaconarchivosbinarios;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author The Survivor
 */
public class AppFerreteriaConArchivosBinarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] tipoDeProducto = {"Martillo", "Pinzas","Desarmador","Pala","Cuchara","Talacho","Escoba","Taladro", "Cinta Metrica", "Coples"};
        String [] tipo = {"No.1","No.2","No.3","No.4"};
        String [] marca = {"Trupper","Pretul","Urrea","ToolCraft","Stanley"};
        
        Random random  = new Random();
        DecimalFormat  formatoD = new DecimalFormat("0.##");
        
        Producto [] productos = new Producto[10];
        for (int i = 0; i < productos.length; i++) 
        {
            double p = random.nextDouble() * 1000;
            double  precio = Double.parseDouble(formatoD.format(p).toString());
            
            productos[i] = new Producto(random.nextInt(9000)+1000,
                                                              tipoDeProducto[random.nextInt(5)+5]+"  "+
                                                              tipo[random.nextInt(4)]+"  "+marca[random.nextInt(4)],
                                                              precio, random.nextInt(11));
        }
        
        //uso del FOR EACH de Java para escribir
        for (Producto p: productos) {
            System.out.println(p.clave +" | "+ p.descripcion +" | "+p.precio+" | "+p.cantDeProductos);
        }
        
//        for (int i = 0; i < productos.length; i++) {
//            System.out.println(productos[i].clave +" | "+ productos[i].descripcion +" | "+productos[i].precio+" | "+productos[i].cantDeProductos);
//        }

        char opcion;
        Scanner sc = new Scanner(System.in);
        String nomarch;
        boolean band = true;
        while(band)
        //while(true)
        {
           opcion = Menu.Opciones();
           switch(opcion)
           {     // 49   
               case '1': {
                          System.out.print("NOMBRE DEL ARCHIVO : ");
                          nomarch = sc.nextLine();
                          ArchivoBinarioProductos.leer_archivo(nomarch);
                        }
                         break;
                  //'2'      
               case '2':{
                         System.out.print("NOMBRE DEL ARCHIVO : ");
                          nomarch = sc.nextLine();
                          ArchivoBinarioProductos.guardar_archivo(nomarch, productos);
                        }
                        break;
               case '3':{
                         System.out.print("NOMBRE DEL ARCHIVO : ");
                          nomarch = sc.nextLine();
                          ArchivoBinarioProductos.agregar_a_archivo(nomarch, productos);
                        }
                        break;
               case '4': band = false;
                        // System.exit(0);
                         break;
           }
           
        }
        
        
        
        

    }
    
}
