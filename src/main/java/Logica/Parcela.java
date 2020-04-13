package Logica;

import Parametros.Param;
import java.time.LocalDateTime;
import static Logica.cosas.*;
import java.io.Serializable;

public abstract class Parcela implements iAlquilable, Serializable {
    int numero;
    boolean ocupado;
    LocalDateTime fechaOcupado;
    Cliente cliente;

    Parcela(int numero) {
        this.ocupado=false;
        this.fechaOcupado = null;
        this.cliente = null;
        this.numero=numero;
    }

    @Override
    public boolean checkIn(Cliente cli) {  
        if (!ocupado) {
            ocupado = true;
            fechaOcupado = LocalDateTime.now();
            this.cliente=new Cliente(cli.dni,cli.nombre,cli.telefono,cli.fecNac);
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

    public boolean isOcupado() {
        return ocupado;
    }

    public LocalDateTime getFechaOcupado() {
        return fechaOcupado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public void setFechaOcupado(LocalDateTime fechaOcupado) {
        this.fechaOcupado = fechaOcupado;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }
    
    @Override
    public String toString(){
       if(ocupado) return "Ocupado";
       else return "Libre";
    }
}
