package Logica;

import Parametros.Param;
import java.time.LocalDateTime;
import static Logica.cosas.*;
import java.io.Serializable;

public abstract class Parcela implements iAlquilable, Serializable {

    boolean ocupado;
    LocalDateTime fechaOcupado;
    Cliente cliente;

    Parcela() {
        this.ocupado=false;
        this.fechaOcupado = null;
        this.cliente = null;
    }

    @Override
    public boolean checkIn(Cliente cli) {  
        if (!ocupado) {
            ocupado = true;
            fechaOcupado = LocalDateTime.now();
           
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double checkOut(Param param) {
        ocupado = false;
        fechaOcupado = null;
        cliente= null;
        return 0d;
    }
    
    @Override
    public String toString(){
       if(ocupado) return "Ocupado";
       else return "Libre";
    }
}
