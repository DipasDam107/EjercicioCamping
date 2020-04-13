
package Logica;

import Parametros.Param;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import static Ficheros.Ficheros.*;

public class Tienda extends Parcela{

     Tienda(int numero){
         super(numero);
     }
     
    @Override
    public double checkOut(Param param) {
        double total=-1;
        if(this.ocupado){
            int dias = (int)ChronoUnit.DAYS.between(fechaOcupado, LocalDateTime.now());
            if(dias==0) dias=1; //Si haces checkout el mismo dia, se paga uno minimo
            
            if(dias>param.TIENDA_DIAS_LARGA_ESTANCIA){
                double desc = param.TIENDA_DESCUENTO_LARGA_ESTANCIA / 100;
                double precio = (double)((param.TIENDA_PRECIO_DIARIO + param.TIENDA_PRECIO_ELECTRICIDAD_DIARIO) * dias);
                total = precio - (precio*desc);
            }
                
            else
                total= (double)((param.TIENDA_PRECIO_DIARIO + param.TIENDA_PRECIO_ELECTRICIDAD_DIARIO) * dias);
            
            guardarEntrada(this, total);
            super.checkOut(param);
            return total;
            
        }
        else return -1;
    }
    @Override
    public String toString(){
       return "Tienda. Estado: " + super.toString();
    }
}
