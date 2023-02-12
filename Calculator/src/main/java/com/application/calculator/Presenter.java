package com.application.calculator;

public class Presenter implements CalculatorContract.CalculatorListener {

    private final Model model;
    private final CalculatorContract.CalculatorView calculatorView;

    public Presenter(CalculatorContract.CalculatorView calculatorView) {
        this.calculatorView = calculatorView;
        this.model = new Model(this);
    }

    public void calculateResult(CalculationData calculationData) {
        this.model.calculate(calculationData);
    }

    @Override
    public void onFailed(String message) {
        calculatorView.onFailed(message);
    }

    @Override
    public void onSuccess(double result) {
        calculatorView.onSuccess(result);
    }
}
