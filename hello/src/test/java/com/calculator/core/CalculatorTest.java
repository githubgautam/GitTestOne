package com.calculator.core;

import static org.testng.Assert.*;
import org.testng.annotations.*;

/**
 * Comprehensive test suite for Calculator class.
 * Tests all arithmetic operations and edge cases.
 */
public class CalculatorTest {
    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    // ===== ADDITION TESTS =====
    @Test(groups = "addition")
    public void testAddPositiveNumbers() {
        double result = calculator.add(5, 3);
        assertEquals(result, 8.0, "Addition of positive numbers failed");
    }

    @Test(groups = "addition")
    public void testAddNegativeNumbers() {
        double result = calculator.add(-5, -3);
        assertEquals(result, -8.0, "Addition of negative numbers failed");
    }

    @Test(groups = "addition")
    public void testAddMixedNumbers() {
        double result = calculator.add(10, -5);
        assertEquals(result, 5.0, "Addition of mixed numbers failed");
    }

    @Test(groups = "addition")
    public void testAddZero() {
        double result = calculator.add(5, 0);
        assertEquals(result, 5.0, "Addition with zero failed");
    }

    @Test(groups = "addition")
    public void testAddDecimalNumbers() {
        double result = calculator.add(2.5, 3.7);
        assertEquals(result, 6.2, 0.0001, "Addition of decimal numbers failed");
    }

    // ===== SUBTRACTION TESTS =====
    @Test(groups = "subtraction")
    public void testSubtractPositiveNumbers() {
        double result = calculator.subtract(10, 3);
        assertEquals(result, 7.0, "Subtraction of positive numbers failed");
    }

    @Test(groups = "subtraction")
    public void testSubtractNegativeNumbers() {
        double result = calculator.subtract(-5, -3);
        assertEquals(result, -2.0, "Subtraction of negative numbers failed");
    }

    @Test(groups = "subtraction")
    public void testSubtractMixedNumbers() {
        double result = calculator.subtract(10, -5);
        assertEquals(result, 15.0, "Subtraction of mixed numbers failed");
    }

    @Test(groups = "subtraction")
    public void testSubtractZero() {
        double result = calculator.subtract(5, 0);
        assertEquals(result, 5.0, "Subtraction with zero failed");
    }

    @Test(groups = "subtraction")
    public void testSubtractDecimalNumbers() {
        double result = calculator.subtract(10.5, 3.2);
        assertEquals(result, 7.3, 0.0001, "Subtraction of decimal numbers failed");
    }

    // ===== MULTIPLICATION TESTS =====
    @Test(groups = "multiplication")
    public void testMultiplyPositiveNumbers() {
        double result = calculator.multiply(4, 5);
        assertEquals(result, 20.0, "Multiplication of positive numbers failed");
    }

    @Test(groups = "multiplication")
    public void testMultiplyNegativeNumbers() {
        double result = calculator.multiply(-4, -5);
        assertEquals(result, 20.0, "Multiplication of negative numbers failed");
    }

    @Test(groups = "multiplication")
    public void testMultiplyMixedNumbers() {
        double result = calculator.multiply(-4, 5);
        assertEquals(result, -20.0, "Multiplication of mixed numbers failed");
    }

    @Test(groups = "multiplication")
    public void testMultiplyByZero() {
        double result = calculator.multiply(5, 0);
        assertEquals(result, 0.0, "Multiplication by zero failed");
    }

    @Test(groups = "multiplication")
    public void testMultiplyDecimalNumbers() {
        double result = calculator.multiply(2.5, 4.0);
        assertEquals(result, 10.0, 0.0001, "Multiplication of decimal numbers failed");
    }

    // ===== DIVISION TESTS =====
    @Test(groups = "division")
    public void testDividePositiveNumbers() {
        double result = calculator.divide(20, 4);
        assertEquals(result, 5.0, "Division of positive numbers failed");
    }

    @Test(groups = "division")
    public void testDivideNegativeNumbers() {
        double result = calculator.divide(-20, -4);
        assertEquals(result, 5.0, "Division of negative numbers failed");
    }

    @Test(groups = "division")
    public void testDivideMixedNumbers() {
        double result = calculator.divide(-20, 4);
        assertEquals(result, -5.0, "Division of mixed numbers failed");
    }

    @Test(groups = "division")
    public void testDivideDecimalNumbers() {
        double result = calculator.divide(10.5, 2.0);
        assertEquals(result, 5.25, 0.0001, "Division of decimal numbers failed");
    }

    @Test(groups = "division", expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(5, 0);
    }

    @Test(groups = "division")
    public void testDivideResultsInDecimal() {
        double result = calculator.divide(5, 2);
        assertEquals(result, 2.5, 0.0001, "Division resulting in decimal failed");
    }

    // ===== SQUARE ROOT TESTS =====
    @Test(groups = "advanced")
    public void testSquareRootPositiveNumber() {
        double result = calculator.squareRoot(16);
        assertEquals(result, 4.0, "Square root of positive number failed");
    }

    @Test(groups = "advanced")
    public void testSquareRootZero() {
        double result = calculator.squareRoot(0);
        assertEquals(result, 0.0, "Square root of zero failed");
    }

    @Test(groups = "advanced")
    public void testSquareRootDecimal() {
        double result = calculator.squareRoot(2.25);
        assertEquals(result, 1.5, 0.0001, "Square root of decimal failed");
    }

    @Test(groups = "advanced", expectedExceptions = IllegalArgumentException.class)
    public void testSquareRootNegativeNumber() {
        calculator.squareRoot(-4);
    }

    // ===== POWER TESTS =====
    @Test(groups = "advanced")
    public void testPowerPositiveBase() {
        double result = calculator.power(2, 3);
        assertEquals(result, 8.0, "Power with positive base failed");
    }

    @Test(groups = "advanced")
    public void testPowerWithZeroExponent() {
        double result = calculator.power(5, 0);
        assertEquals(result, 1.0, "Power with zero exponent failed");
    }

    @Test(groups = "advanced")
    public void testPowerWithNegativeExponent() {
        double result = calculator.power(2, -2);
        assertEquals(result, 0.25, 0.0001, "Power with negative exponent failed");
    }

    @Test(groups = "advanced")
    public void testPowerNegativeBase() {
        double result = calculator.power(-2, 2);
        assertEquals(result, 4.0, "Power with negative base failed");
    }

    // ===== ABSOLUTE VALUE TESTS =====
    @Test(groups = "advanced")
    public void testAbsoluteValuePositive() {
        double result = calculator.absoluteValue(5);
        assertEquals(result, 5.0, "Absolute value of positive number failed");
    }

    @Test(groups = "advanced")
    public void testAbsoluteValueNegative() {
        double result = calculator.absoluteValue(-5);
        assertEquals(result, 5.0, "Absolute value of negative number failed");
    }

    @Test(groups = "advanced")
    public void testAbsoluteValueZero() {
        double result = calculator.absoluteValue(0);
        assertEquals(result, 0.0, "Absolute value of zero failed");
    }

    // ===== RECIPROCAL TESTS =====
    @Test(groups = "advanced")
    public void testReciprocalPositive() {
        double result = calculator.reciprocal(2);
        assertEquals(result, 0.5, 0.0001, "Reciprocal of positive number failed");
    }

    @Test(groups = "advanced")
    public void testReciprocalNegative() {
        double result = calculator.reciprocal(-4);
        assertEquals(result, -0.25, 0.0001, "Reciprocal of negative number failed");
    }

    @Test(groups = "advanced", expectedExceptions = ArithmeticException.class)
    public void testReciprocalZero() {
        calculator.reciprocal(0);
    }

    // ===== RESULT TRACKING TESTS =====
    @Test(groups = "result")
    public void testGetResult() {
        calculator.add(5, 3);
        double result = calculator.getResult();
        assertEquals(result, 8.0, "Get result failed");
    }

    @Test(groups = "result")
    public void testClearResets() {
        calculator.add(5, 3);
        calculator.clear();
        double result = calculator.getResult();
        assertEquals(result, 0.0, "Clear should reset result to 0");
    }

    // ===== CHAINED OPERATIONS TESTS =====
    @Test(groups = "chained")
    public void testChainedOperations() {
        double result1 = calculator.add(5, 3);
        double result2 = calculator.multiply(result1, 2);
        assertEquals(result2, 16.0, "Chained operations failed");
    }

    @Test(groups = "chained")
    public void testComplexCalculation() {
        // (10 + 5) * 2 - 8 / 4 = 30 - 2 = 28
        double step1 = calculator.add(10, 5);
        double step2 = calculator.multiply(step1, 2);
        double step3 = calculator.divide(8, 4);
        double step4 = calculator.subtract(step2, step3);
        assertEquals(step4, 28.0, 0.0001, "Complex calculation failed");
    }

    // ===== EDGE CASE TESTS =====
    @Test(groups = "edgecases")
    public void testVeryLargeNumbers() {
        double result = calculator.add(1e100, 1e100);
        assertEquals(result, 2e100, "Addition of very large numbers failed");
    }

    @Test(groups = "edgecases")
    public void testVerySmallNumbers() {
        double result = calculator.add(1e-100, 1e-100);
        assertEquals(result, 2e-100, 1e-100, "Addition of very small numbers failed");
    }
}
