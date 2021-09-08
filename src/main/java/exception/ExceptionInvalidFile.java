/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author tduthil
 */
public class ExceptionInvalidFile extends Exception {
    /**
     * Constructeur de la classe ExceptionInvalidFile
     * @param s, le message
     */
    public ExceptionInvalidFile(String s){
        System.out.println(s);
    }

}
