package Logica;

import java.time.LocalDate;

public class Cliente {
    String nombre;
    String dni;
    String telefono;
    LocalDate fecNac;
    
    public Cliente(String nombre, String dni, String telefono, LocalDate fecNac){
        this.nombre=nombre;
        this.dni=dni;
        this.fecNac=fecNac;
        this.telefono=telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public LocalDate getfecNac() {
        return fecNac;
    }
    
    //Esto iria al grafico
    
    
}
