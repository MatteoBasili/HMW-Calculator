package com.application.calculator;

public class Model {

    private final CalculatorContract.CalculatorListener calculatorListener;

    public Model(CalculatorContract.CalculatorListener calculatorListener) {
        this.calculatorListener = calculatorListener;
    }

    public void calculateBinaryOp(BinaryCalculationData binaryCalculationData) {
        double number1 = binaryCalculationData.getNumber1();
        double number2 = binaryCalculationData.getNumber2();
        String operator = binaryCalculationData.getOperator();

        switch (operator) {
            case "+" -> {
                calculatorListener.onSuccess(number1 + number2);
                return;
            }
            case "-" -> {
                calculatorListener.onSuccess(number1 - number2);
                return;
            }
            case "*" -> {
                calculatorListener.onSuccess(number1 * number2);
                return;
            }
            case "/" -> {
                if (number2 == 0) {
                    calculatorListener.onFailed("Error");
                } else {
                    calculatorListener.onSuccess(number1 / number2);
                }
                return;
            }
        }

        calculatorListener.onFailed("Error");
    }

    public void calculateUnaryOp(UnaryCalculationData unaryCalculationData) {
        double number = unaryCalculationData.getNumber();
        String operator = unaryCalculationData.getOperator();

        switch (operator) {
            case "log" -> {
                if (number <= 0) {
                    calculatorListener.onFailed("Error");
                } else {
                    calculatorListener.onSuccess(Math.log10(number));
                }
                return;
            }
            case "sqrt" -> {
                if (number < 0) {
                    calculatorListener.onFailed("Error");
                } else {
                    calculatorListener.onSuccess(Math.sqrt(number));
                }
                return;
            }
        }

        calculatorListener.onFailed("Error");
    }

}
