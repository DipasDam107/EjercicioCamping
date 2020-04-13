package Logica;

import Parametros.Param;
import java.util.ArrayList;
import static Logica.cosas.*;
import static Ficheros.Ficheros.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Bungalow extends Parcela {

    ArrayList<Cliente> acompaniantes;

    Bungalow(int numero) {
        super(numero);
        acompaniantes = null;
    }

    @Override
    public double checkOut(Param param) {
        if (this.ocupado) {
            //Sabemos que quien lo alquila es mayor de edad
            double total = param.BUNGALOW_PRECIO_INDIVIDUAL;
            int noches = (int) ChronoUnit.DAYS.between(fechaOcupado, LocalDateTime.now());
            if(noches==0) noches=1; //Si haces checkout el mismo dia, se paga uno minimo
            double desc = param.BUNGALOW_PORCENTAJE_RECARGO / 100d;
            for (Cliente acomp : acompaniantes) {
                int edad = (int) ChronoUnit.YEARS.between(acomp.getfecNac(), LocalDate.now());

                if (edad > param.BUNGALOW_EDAD_MAYOR_INFANTIL) {
                    total += param.BUNGALOW_PRECIO_INDIVIDUAL;
                } else {
                    total += param.BUNGALOW_PRECIO_INFANTIL;
                }

            }
            if (noches <= param.BUNGALOW_NOCHES_RECARGO) {
                total += total + (total * desc);
            }

            guardarEntrada(this, total);
            super.checkOut(param);
            acompaniantes = null;
            return total;
        } else {
            return -1d;
        }
    }

    public void addAcompaniantes(ArrayList<Cliente> acomp) {
        acompaniantes = new ArrayList<>();
        for (Cliente x : acomp) {
            acompaniantes.add(x);
        }
    }

    public ArrayList<Cliente> getAcompaniantes() {
        return acompaniantes;
    }

    @Override
    public String toString() {
        return "Bungalow. Estado: " + super.toString();
    }
}
