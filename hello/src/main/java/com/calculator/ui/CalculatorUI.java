package com.calculator.ui;

import com.calculator.core.Calculator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * CalculatorUI - A professional Swing-based Calculator GUI.
 * Provides a user-friendly interface for performing arithmetic operations.
 */
public class CalculatorUI extends JFrame implements ActionListener {
    private static final Logger logger = LogManager.getLogger(CalculatorUI.class);
    private Calculator calculator;
    private JTextField displayField;
    private JButton[] numberButtons;
    private JButton[] operationButtons;
    private JButton equalsButton, clearButton, deleteButton;
    private JPanel buttonPanel;
    private String currentOperation = "";
    private double firstNumber = 0;
    private boolean isNewNumber = true;

    public CalculatorUI() {
        calculator = new Calculator();
        setTitle("Calculator Application v1.0");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        initializeUI();
        logger.info("Calculator UI initialized successfully");
    }

    /**
     * Initialize all UI components
     */
    private void initializeUI() {
        // Display Panel
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());
        displayPanel.setBackground(new Color(50, 50, 50));
        displayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        displayField = new JTextField("0");
        displayField.setFont(new Font("Arial", Font.BOLD, 24));
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setEditable(false);
        displayField.setBackground(new Color(30, 30, 30));
        displayField.setForeground(new Color(0, 255, 0));
        displayField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        displayPanel.add(displayField, BorderLayout.CENTER);

        // Button Panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4, 5, 5));
        buttonPanel.setBackground(new Color(60, 60, 60));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create number buttons (0-9)
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = createButton(String.valueOf(i), new Color(100, 100, 100));
        }

        // Create operation buttons
        operationButtons = new JButton[4];
        operationButtons[0] = createButton("+", new Color(150, 100, 0));
        operationButtons[1] = createButton("-", new Color(150, 100, 0));
        operationButtons[2] = createButton("*", new Color(150, 100, 0));
        operationButtons[3] = createButton("/", new Color(150, 100, 0));

        // Create special buttons
        equalsButton = createButton("=", new Color(0, 100, 150));
        clearButton = createButton("C", new Color(150, 0, 0));
        deleteButton = createButton("DEL", new Color(150, 50, 0));
        JButton decimalButton = createButton(".", new Color(100, 100, 100));
        JButton sqrtButton = createButton("√", new Color(100, 150, 0));
        JButton powButton = createButton("^", new Color(100, 150, 0));

        // Add buttons to panel in grid layout
        buttonPanel.add(clearButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(new JLabel()); // Empty space
        buttonPanel.add(operationButtons[3]); // /

        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(operationButtons[2]); // *

        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(operationButtons[1]); // -

        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(operationButtons[0]); // +

        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(decimalButton);
        buttonPanel.add(sqrtButton);
        buttonPanel.add(powButton);

        buttonPanel.add(equalsButton);
        buttonPanel.add(new JLabel()); // Empty space
        buttonPanel.add(new JLabel()); // Empty space
        buttonPanel.add(new JLabel()); // Empty space

        // Add panels to frame
        add(displayPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * Create a styled button
     */
    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        button.setFocusPainted(false);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String buttonText = source.getText();

        try {
            if (Character.isDigit(buttonText.charAt(0))) {
                handleNumberInput(buttonText);
            } else if (buttonText.equals(".")) {
                handleDecimalInput();
            } else if (buttonText.equals("+") || buttonText.equals("-") || 
                       buttonText.equals("*") || buttonText.equals("/")) {
                handleOperation(buttonText);
            } else if (buttonText.equals("=")) {
                handleEquals();
            } else if (buttonText.equals("C")) {
                handleClear();
            } else if (buttonText.equals("DEL")) {
                handleDelete();
            } else if (buttonText.equals("√")) {
                handleSquareRoot();
            } else if (buttonText.equals("^")) {
                handlePower();
            }
        } catch (Exception ex) {
            logger.error("Error in button action: ", ex);
            displayField.setText("Error");
        }
    }

    private void handleNumberInput(String number) {
        if (isNewNumber) {
            displayField.setText(number);
            isNewNumber = false;
        } else {
            displayField.setText(displayField.getText() + number);
        }
    }

    private void handleDecimalInput() {
        String current = displayField.getText();
        if (!current.contains(".")) {
            displayField.setText(current + ".");
            isNewNumber = false;
        }
    }

    private void handleOperation(String operation) {
        firstNumber = Double.parseDouble(displayField.getText());
        currentOperation = operation;
        isNewNumber = true;
        logger.info("Operation selected: {}", operation);
    }

    private void handleEquals() {
        try {
            double secondNumber = Double.parseDouble(displayField.getText());
            double result = 0;

            switch (currentOperation) {
                case "+":
                    result = calculator.add(firstNumber, secondNumber);
                    break;
                case "-":
                    result = calculator.subtract(firstNumber, secondNumber);
                    break;
                case "*":
                    result = calculator.multiply(firstNumber, secondNumber);
                    break;
                case "/":
                    result = calculator.divide(firstNumber, secondNumber);
                    break;
                case "^":
                    result = calculator.power(firstNumber, secondNumber);
                    break;
                default:
                    return;
            }

            displayField.setText(formatResult(result));
            isNewNumber = true;
            currentOperation = "";
        } catch (ArithmeticException ex) {
            displayField.setText("Error: " + ex.getMessage());
            logger.error("Arithmetic error: ", ex);
            isNewNumber = true;
        }
    }

    private void handleClear() {
        displayField.setText("0");
        calculator.clear();
        firstNumber = 0;
        currentOperation = "";
        isNewNumber = true;
        logger.info("Calculator cleared");
    }

    private void handleDelete() {
        String current = displayField.getText();
        if (current.length() > 1) {
            displayField.setText(current.substring(0, current.length() - 1));
        } else {
            displayField.setText("0");
            isNewNumber = true;
        }
    }

    private void handleSquareRoot() {
        try {
            double value = Double.parseDouble(displayField.getText());
            double result = calculator.squareRoot(value);
            displayField.setText(formatResult(result));
            isNewNumber = true;
        } catch (IllegalArgumentException ex) {
            displayField.setText("Error: " + ex.getMessage());
            logger.error("Square root error: ", ex);
            isNewNumber = true;
        }
    }

    private void handlePower() {
        firstNumber = Double.parseDouble(displayField.getText());
        currentOperation = "^";
        isNewNumber = true;
        logger.info("Power operation selected");
    }

    private String formatResult(double value) {
        if (value == (long) value) {
            return String.format("%d", (long) value);
        } else {
            return String.format("%.6f", value).replaceAll("0+$", "").replaceAll("\\.$", "");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorUI::new);
    }
}
