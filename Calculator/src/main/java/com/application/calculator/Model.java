package com.application.calculator;

public class Model {

    private final CalculatorContract.CalculatorListener calculatorListener;

    public Model(CalculatorContract.CalculatorListener calculatorListener) {
        this.calculatorListener = calculatorListener;
    }

    public void calculate(CalculationData calculationData) {
        double number1 = calculationData.getNumber1();
        double number2 = calculationData.getNumber2();
        char operator = calculationData.getOperator();

        switch (operator) {
            case '+' -> {
                calculatorListener.onSuccess(number1 + number2);
                return;
            }
            case '-' -> {
                calculatorListener.onSuccess(number1 - number2);
                return;
            }
            case '*' -> {
                calculatorListener.onSuccess(number1 * number2);
                return;
            }
            case '/' -> {
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

}
