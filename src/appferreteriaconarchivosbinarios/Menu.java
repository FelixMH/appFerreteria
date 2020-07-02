/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appferreteriaconarchivosbinarios;

import java.util.Scanner;

/**
 *
 * @author mosva
 */
public class Menu {
    //Metodo de clase
    public static char Opciones()
    {
       System.out.println(" ARCHIVOS BINARIOS ");
       System.out.println("1) Abrir ");
       System.out.println("2) Guardar");
       System.out.println("3) Agregar ");
       System.out.println("4) Salir ");
        System.out.print(" Tu Opcion : ");
       Scanner scan = new Scanner(System.in);
       char opc = scan.next().charAt(0);
       return opc;
    }
}
