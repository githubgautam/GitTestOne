package com.calculator.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Calculator class providing basic arithmetic operations.
 * Handles addition, subtraction, multiplication, and division operations.
 * Includes validation for edge cases like division by zero.
 */
public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);
    private double result = 0.0;

    /**
     * Adds two numbers and returns the result.
     *
     * @param a first number
     * @param b second number
     * @return sum of a and b
     */
    public double add(double a, double b) {
        result = a + b;
        logger.info("Addition: {} + {} = {}", a, b, result);
        return result;
    }

    /**
     * Subtracts two numbers and returns the result.
     *
     * @param a first number (minuend)
     * @param b second number (subtrahend)
     * @return difference of a and b
     */
    public double subtract(double a, double b) {
        result = a - b;
        logger.info("Subtraction: {} - {} = {}", a, b, result);
        return result;
    }

    /**
     * Multiplies two numbers and returns the result.
     *
     * @param a first number
     * @param b second number
     * @return product of a and b
     */
    public double multiply(double a, double b) {
        result = a * b;
        logger.info("Multiplication: {} * {} = {}", a, b, result);
        return result;
    }

    /**
     * Divides two numbers and returns the result.
     * Throws ArithmeticException if divisor is zero.
     *
     * @param a first number (dividend)
     * @param b second number (divisor)
     * @return quotient of a and b
     * @throws ArithmeticException if b is zero
     */
    public double divide(double a, double b) {
        if (b == 0) {
            logger.error("Division by zero attempted: {} / {}", a, b);
            throw new ArithmeticException("Cannot divide by zero");
        }
        result = a / b;
        logger.info("Division: {} / {} = {}", a, b, result);
        return result;
    }

    /**
     * Gets the current result stored in the calculator.
     *
     * @return the last calculated result
     */
    public double getResult() {
        return result;
    }

    /**
     * Clears the calculator by resetting result to zero.
     */
    public void clear() {
        result = 0.0;
        logger.info("Calculator cleared");
    }

    /**
     * Calculates the square root of a number.
     *
     * @param a the number to find square root of
     * @return square root of a
     * @throws IllegalArgumentException if a is negative
     */
    public double squareRoot(double a) {
        if (a < 0) {
            logger.error("Square root of negative number attempted: {}", a);
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        result = Math.sqrt(a);
        logger.info("Square root: sqrt({}) = {}", a, result);
        return result;
    }

    /**
     * Calculates the power of a number.
     *
     * @param base the base number
     * @param exponent the exponent
     * @return base raised to the power of exponent
     */
    public double power(double base, double exponent) {
        result = Math.pow(base, exponent);
        logger.info("Power: {} ^ {} = {}", base, exponent, result);
        return result;
    }

    /**
     * Calculates the absolute value of a number.
     *
     * @param a the number
     * @return absolute value of a
     */
    public double absoluteValue(double a) {
        result = Math.abs(a);
        logger.info("Absolute value: abs({}) = {}", a, result);
        return result;
    }

    /**
     * Calculates the reciprocal (1/x) of a number.
     *
     * @param a the number
     * @return reciprocal of a
     * @throws ArithmeticException if a is zero
     */
    public double reciprocal(double a) {
        if (a == 0) {
            logger.error("Reciprocal of zero attempted");
            throw new ArithmeticException("Cannot calculate reciprocal of zero");
        }
        result = 1.0 / a;
        logger.info("Reciprocal: 1/{} = {}", a, result);
        return result;
    }
}
