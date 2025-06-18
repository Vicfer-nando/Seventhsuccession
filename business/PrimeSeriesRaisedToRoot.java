package edu.unl.cc.poo.seventhsuccession.business;

/**
 * @author Victor Fernando Roa Carrión
 * @author Joseph Adrián Aguilar Asanza
 */

import edu.unl.cc.poo.seventhsuccession.domain.Successionable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Clase que calcula la serie de primos elevados a la raíz inversa de números impares.
 * La serie es: S = 2^(1/1) + 3^(1/3) + 5^(1/5) + 7^(1/7) + 11^(1/9) + 13^(1/11) + ...
 */
public class PrimeSeriesRaisedToRoot implements Successionable {

    /**
     * Número de términos que se calcularán en la serie.
     */
    private int limit;

    private StringBuilder expression;

    public PrimeSeriesRaisedToRoot(int limit) {
        this.limit = limit;
        this.expression = new StringBuilder("S = ");
    }

    @Override
    public void setLimit(Number limit) {
        this.limit = limit.intValue();
    }

    /**
     * Calcula la suma de la serie de primos elevados a la raíz inversa de números impares.
     * También construye la cadena con la expresión matemática de la serie.
     */
    @Override
    public Number calculate() {
        int count = 0;    
        int prime = 2;    
        int odd = 1;      
        BigDecimal sum = BigDecimal.ZERO; // Acumulador de la suma total

        while (count < limit) {
            if (isPrime(prime)) {
                BigDecimal term = calculatePowerRoot(prime, odd); // Calcula primo^(1/odd)
                sum = sum.add(term); 

                // Construye la expresión textual de la serie
                expression.append(prime).append("^(1/").append(odd).append(")");
                if (count < limit - 1) {
                    expression.append(" + ");
                }

                count++;
                odd += 2; // Incrementa al siguiente número impar
            }
            prime++;
        }

        return sum;
    }

    @Override
    public Number nextTerm(Number currentTerm) {
        return null;
    }

    /**
     * Devuelve la representación en cadena de la expresión de la serie.
     */
    @Override
    public String print() {
        return expression.toString();
    }

    /**
     * Calcula el valor de base elevado a la potencia 1/rootBase (raíz inversa).
     */
    private BigDecimal calculatePowerRoot(int base, int rootBase) {
        MathContext mc = new MathContext(15, RoundingMode.HALF_UP);
        double exponent = 1.0 / rootBase;
        double result = Math.pow(base, exponent);
        return new BigDecimal(result, mc);
    }

    /**
     * Verifica si un número es primo.
     */
    private boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}

