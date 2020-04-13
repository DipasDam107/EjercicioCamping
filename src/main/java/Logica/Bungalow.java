
package Logica;

import Parametros.Param;
import java.util.ArrayList;
import static Logica.cosas.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Bungalow extends Parcela{
    ArrayList <Cliente> acompaniantes;
   
    Bungalow(){
        super();
        acompaniantes=new ArrayList<>();
    }
    
    @Override
    public boolean checkIn(Cliente cli) {
        super.checkIn(cli);
        int acompaniantes;
        System.out.println("Cuantos acompañantes tienes: ");
        acompaniantes=teclado.nextInt();
        teclado.nextLine();
        
        for (int i = 0; i < acompaniantes; i++) {
            Cliente acomp;
            do{
                acomp=cosas.introducirCliente();
            }while(acomp==null);
        }
        return true;
    }

    @Override
    public double checkOut(Param param) {
        
        if(this.ocupado){
        //Sabemos que quien lo alquila es mayor de edad
        double total=param.BUNGALOW_PRECIO_INDIVIDUAL;
        int noches = (int)ChronoUnit.DAYS.between(fechaOcupado, LocalDateTime.now());
        double desc = param.BUNGALOW_PORCENTAJE_RECARGO /100d;
        for(Cliente acomp : acompaniantes){
            int edad = (int)ChronoUnit.YEARS.between(acomp.getfecNac(), LocalDate.now());
       
            
            if(edad > param.BUNGALOW_EDAD_MAYOR_INFANTIL)  total+=param.BUNGALOW_PRECIO_INDIVIDUAL;
            else total+=param.BUNGALOW_PRECIO_INFANTIL;
            
            
        }
        if(noches <= param.BUNGALOW_NOCHES_RECARGO) total += total +(total * desc);
        
        return total;
        }
        else return -1d;
        }

    public ArrayList<Cliente> getAcompaniantes() {
        return acompaniantes;
    }
    
    
    @Override
    public String toString(){
       return "Bungalow. Estado: " + super.toString();
    }
}
