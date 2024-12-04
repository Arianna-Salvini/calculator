package com.example.calculator.rest.service;

import org.springframework.stereotype.Service;


@Service
public class CalculatorService {

    /**
     * Add the two integers.
     *
     * @param a first integer (numerator)
     * @param b second integer (denominator)
     * @return the sum of a and b
     */
    public int sum(int a, int b) {
        return a + b;
    }

    /**
     * Subtract the second integer from the first one.
     *
     * @param a first integer (numerator)
     * @param b second integer (denominator)
     * @return the resul of a minus b
     */
    public int subtraction(int a, int b) {
        return a - b;
    }

    /**
     * Multiply the two integers.
     *
     * @param a first integer (numerator)
     * @param b second integer (denominator)
     * @return the product of a and b
     */
    public int multiplication(int a, int b) {
        return a * b;
    }

    /**
     * Divide first integer by the second one.
     * .
     * If the second integer (denominator) is zero, an ArithmeticException is caught,
     * an error message is printed and zero is returned as result.
     *
     * @param a first integer (numerator)
     * @param b second integer (denominator)
     * @return the resul of a by b, or 0 if division is by 0
     */
    public int division(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {

            // handle division when denominator is 0: print an error message and 0 as result
            System.out.println("Error: Division by zero");
            return 0 ;

        }

    }

}
