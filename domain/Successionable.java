/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.unl.cc.poo.seventhsuccession.domain;

/**
 * @author Victor Fernando Roa Carrión
 * @author Joseph Adrián Aguilar Asanza
 */

public interface Successionable extends Printable{
    /**
     * Generates the next term in the series based on the current term.
     * @param currentTerm The current term in the series
     * @return The next term in the series
     */
    Number nextTerm(Number currentTerm);

    /**
     * Setter the limit in the series
     * @param limit
     */
    void setLimit(Number limit);

    /**
     * Calculate the result, if the necessary in the serie. The main method
     * @return the result of the calculate
     */
    Number calculate();

}
