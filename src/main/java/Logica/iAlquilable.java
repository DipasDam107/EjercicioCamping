
package Logica;
import Parametros.*;

interface iAlquilable {
    // marca la parcela como ocupada
    boolean checkIn(Cliente cli);
    
    // Marca la parcela como libre y calcula el importe en funcion de los parametros.
    double checkOut(Param param);
}
