/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author User
 */
public class Main {
    public static void main(String [] args){
        if (comprobarDNI("79340319W")) System.out.println("bien");
        else System.out.println("Mal");
                
    }
    public static boolean comprobarDNI(String dni){ 
        
        if(dni.length()!=9) return false;
        else{
            try{
                String letras = "trwagmyfpdxbnjzsqvhlcke";
                int numeros = Integer.valueOf(dni.substring(0,8));
                char letra = dni.charAt(8);
                System.out.println(numeros);
                System.out.println(letra);
                int modulo = numeros%23;
                System.out.println(letras.charAt(modulo));
                if(Character.toUpperCase(letras.charAt(modulo))==letra) return true;
                else return false;
            
            }catch(Exception e){
                return false;
            }
        }
    }
    
}
