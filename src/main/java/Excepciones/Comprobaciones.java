/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

import Parametros.Param;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;

public class Comprobaciones {
    public static boolean comprobarDNI(String dni){ 
        
        if(dni.length()!=9) return false;
        else{
            try{
                String letras = "trwagmyfpdxbnjzsqvhlcke";
                int numeros = Integer.valueOf(dni.substring(0,8));
                char letra = dni.charAt(8);
                int modulo = numeros%23;
                if(Character.toUpperCase(letras.charAt(modulo))==letra) return true;
                else return false;
            
            }catch(Exception e){
                return false;
            }
        }
    }
    
    public static boolean comprobarEdadCliente(String edad){
        try{
            LocalDate fecNac = LocalDate.parse(edad);
            int anios = (int)ChronoUnit.YEARS.between(fecNac, LocalDate.now());
            if(anios < 18 || anios>120)
                return false;
            else return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static boolean comprobarEdad(String edad){
        try{
            LocalDate fecNac = LocalDate.parse(edad);
            int anios = (int)ChronoUnit.YEARS.between(fecNac, LocalDate.now());
            if(anios < 0 || anios>120)
                return false;
            else return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static boolean comprobarTelefono(String telefono){
        if(telefono.length()!=9) return false;
        else{
            int cont=0;
            boolean correcto=true;
            while(correcto && cont<telefono.length()){
                if(!Character.isDigit(telefono.charAt(cont))){
                    return false;
                }
                else cont++;
            }
        }
        return true;
    }
    
    public static boolean comprobarNumPersonas(String num, Param param){
        try{
            int numPersonas=Integer.valueOf(num);
            if(numPersonas>param.BUNGALOW_MAX_ACOMPANIANTES || numPersonas < 0) return false;
            else return true;
        }catch(Exception e){
            return false;
        }
    }
    public static boolean comprobarNombre(String nombre){
        if(nombre.length()==0) return false;
        else{
            int cont=0;
            boolean correcto=true;
            while(correcto && cont<nombre.length()){
                if(!Character.isLetter(nombre.charAt(cont))){
                    return false;
                }
                else cont++;
            }
        }
            
        return true;
    }
}
