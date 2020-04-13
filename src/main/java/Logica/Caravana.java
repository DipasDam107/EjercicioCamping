package Logica;

import Parametros.Param;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import static Ficheros.Ficheros.*;
public class Caravana extends Parcela {

    Caravana(int numero){
        super(numero);
    }
    @Override
    public double checkOut(Param param) {
        int dias = (int) ChronoUnit.DAYS.between(fechaOcupado, LocalDateTime.now());
        if(dias==0) dias=10;
        //Estancia minima de 10 dias, en caso contrario no hay checkout
        if (this.ocupado && dias >= param.CARAVANA_MINIMO_DIAS_ESTANCIA) {
            int mes = LocalDateTime.now().getMonthValue();
            
            double importe;
            //Si sale en agosto paga mas
            if(mes == 8) 
                importe= dias * param.CARAVANA_PRECIO_DIARIO_SALIDA_AGOSTO;
            else 
                importe= dias * param.CARAVANA_PRECIO_DIARIO_RESTO;
            
            guardarEntrada(this, importe);
            super.checkOut(param);
            return importe;
        }else 
            return -1d;
        
    }
    
    @Override
    public String toString(){
       return "Caravana. Estado: " + super.toString();
    }

}
