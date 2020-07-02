/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appferreteriaconarchivosbinarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author martinos
 */
public class ArchivoBinarioProductos 
{
    public static void leer_archivo(String nomarch)
    {
        FileInputStream fis = null;
        DataInputStream entrada = null;
        //int n;
        try {
            fis = new FileInputStream(nomarch);       //"/ficheros/datos.dat");
            entrada = new DataInputStream(fis);
            while (true) {
                int clave = entrada.readInt();
                String desc = entrada.readUTF();//leer cadena o string
                double precio = entrada.readDouble();
                int cant = entrada.readInt();
                System.out.println(clave +" | "+ desc +" | "+precio+" | "+cant);
//                n = entrada.readInt();  //se lee  un entero del fichero
//                System.out.println(n);  //se muestra en pantalla
            }
        } catch (FileNotFoundException e) 
        {
            System.out.println(e.getMessage());
        } 
        catch (EOFException e) { 
            System.out.println("Fin de archivo");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void guardar_archivo(String nomarch, Producto[] prods)
    {
        //Scanner sc = new Scanner(System.in);
        FileOutputStream fos = null;
        DataOutputStream salida = null;
        //int n;
        try {                                    //AGREGAR
            fos = new FileOutputStream(nomarch);  //"datos.itl",true
            salida = new DataOutputStream(fos);
            int i = 0;

//            System.out.print("Introduce número entero. -1 para terminar: ");
//            n = sc.nextInt();
            //while (n != -1) {
            while (i < prods.length) {
                salida.writeInt(prods[i].clave);
                salida.writeUTF(prods[i].descripcion);
                salida.writeDouble(prods[i].precio);
                salida.writeInt(prods[i].cantDeProductos);
                i++;
//                salida.writeInt(n); //se escribe el número entero en el fichero
//                System.out.print("Introduce número entero. -1 para terminar: ");
//                n = sc.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally 
        {
            try {
                if (salida != null) {
                    salida.close();
                }if (fos != null) {
                    fos.close();
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    

    public static void agregar_a_archivo(String nomarch, Producto[] prods)
    {
        Scanner sc = new Scanner(System.in);
        FileOutputStream fos = null;
        DataOutputStream salida = null;
        int n;
        try {                                    //AGREGAR
            fos = new FileOutputStream(nomarch,true);  //"datos.itl",true
            salida = new DataOutputStream(fos);

            System.out.print("Introduce número entero. -1 para acabar: ");
            n = sc.nextInt();
            while (n != -1) {
                salida.writeInt(n); //se escribe el número entero en el fichero
                System.out.print("Introduce número entero. -1 para acabar: ");
                n = sc.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally 
        {
            try {
                if (salida != null) {
                    salida.close();
                }if (fos != null) {
                    fos.close();
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
}
