package com.application.calculator;

public interface CalculatorContract {

    interface CalculatorListener {
        void onFailed(String message);

        void onSuccess(double result);
    }

    interface CalculatorView {

        void onFailed(String message);

        void onSuccess(double result);

    }

}
