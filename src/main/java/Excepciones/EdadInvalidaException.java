/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author User
 */
public class EdadInvalidaException extends Exception {
    public String getMessage() {
        return "La edad introducida no es valida. Comprueba la fecha de nacimiento";
    }
}
