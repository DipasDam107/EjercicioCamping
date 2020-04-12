
package Logica;

import Parametros.Param;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Tienda extends Parcela{

     Tienda(){
         super();
     }
     
    @Override
    public double checkOut(Param param) {
        if(this.ocupado){
            int dias = (int)ChronoUnit.DAYS.between(fechaOcupado, LocalDateTime.now());
            super.checkOut(param);
            if(dias>Param.TIENDA_DIAS_LARGA_ESTANCIA){
                double desc = Param.TIENDA_DESCUENTO_LARGA_ESTANCIA / 100;
                double precio = (double)((Param.TIENDA_PRECIO_DIARIO + Param.TIENDA_PRECIO_ELECTRICIDAD_DIARIO) * dias);
                return precio - (precio*desc);
            }
                
            else
                return (double)((Param.TIENDA_PRECIO_DIARIO + Param.TIENDA_PRECIO_ELECTRICIDAD_DIARIO) * dias);
            
            
        }
        else return -1;
    }
    @Override
    public String toString(){
       return "Tienda. Estado: " + super.toString();
    }
}
