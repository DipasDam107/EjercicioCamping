package Logica;

import Parametros.Param;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Caravana extends Parcela {

    Caravana(){
        super();
    }
    @Override
    public double checkOut(Param param) {
        int dias = (int) ChronoUnit.DAYS.between(fechaOcupado, LocalDateTime.now());
        
        //Estancia minima de 10 dias, en caso contrario no hay checkout
        if (this.ocupado && dias >= Param.CARAVANA_MINIMO_DIAS_ESTANCIA) {
            int mes = LocalDateTime.now().getMonthValue();
            super.checkOut(param);
           
            //Si sale en agosto paga mas
            if(mes == 8) 
                return dias * Param.CARAVANA_PRECIO_DIARIO_SALIDA_AGOSTO;
            else 
                return dias * Param.CARAVANA_PRECIO_DIARIO_RESTO;
            

        }else 
            return -1d;
        
    }
    
    @Override
    public String toString(){
       return "Caravana. Estado: " + super.toString();
    }

}
