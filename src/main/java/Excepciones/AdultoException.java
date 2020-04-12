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
public class AdultoException extends Exception {
    @Override
    public String getMessage() {
        return "Para hacer Checkin debes ser mayor de edad";
    }
}
