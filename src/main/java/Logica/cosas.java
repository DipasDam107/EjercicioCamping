/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import Excepciones.*;

public class cosas {
    static Scanner teclado = new Scanner(System.in);
    
    public static Cliente introducirCliente(){
        boolean correcto=true;
        String nombre, telefono, dni;
        LocalDate fecNac;
        try{
            System.out.println("Dime Nombre: ");
            nombre=teclado.nextLine();
            System.out.println("Dime Telefono: ");
            telefono=teclado.nextLine();
            if(telefono.length()!=9) throw new TelefonoException();
            System.out.println("Dime DNI: ");
            dni=teclado.nextLine();
            if(dni.length()!=9) throw new DNIException();
            System.out.println("Dime fecNac (aaaa-mm-dd): ");
            fecNac=LocalDate.parse(teclado.nextLine());
            if(fecNac.isAfter(LocalDate.now())) throw new EdadInvalidaException();
        }catch(InputMismatchException e){
            System.out.println("Dato introducido incorrecto");
            return null;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
            
            return new Cliente(nombre, dni, telefono,fecNac);
        
    }
}
