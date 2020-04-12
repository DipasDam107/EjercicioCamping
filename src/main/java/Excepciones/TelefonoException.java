
package Excepciones;

public class TelefonoException extends Exception {
    @Override
    public String getMessage() {
        return "El Telefono introducido no es correcto";
    }
}
