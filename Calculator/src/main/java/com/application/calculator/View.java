package com.application.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class View implements Initializable, CalculatorContract.CalculatorView {

    @FXML
    private Button add;
    @FXML
    private TextField display;
    @FXML
    private Button div;
    @FXML
    private Button dot;
    @FXML
    private Button eight;
    @FXML
    private Button equal;
    @FXML
    private Button erase;
    @FXML
    private Button five;
    @FXML
    private Button four;
    @FXML
    private Button mul;
    @FXML
    private Button nine;
    @FXML
    private Button one;
    @FXML
    private Button pn;
    @FXML
    private Button seven;
    @FXML
    private Button six;
    @FXML
    private Button sub;
    @FXML
    private Button three;
    @FXML
    private Button two;
    @FXML
    private Button zero;
    @FXML
    private Button sqrt;
    @FXML
    private Button log;

    private double rs;
    private double n1;
    private double n2;
    private String op;
    private int point;

    private Presenter presenter;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        presenter = new Presenter(this);
        rs = 0;

        // Initialize clear and equal buttons
        erase.setOnAction(this::resetCalculator);
        equal.setOnAction(this::calculateBinary);
    }

    @FXML
    private void handleNumberButton(ActionEvent event) {
        if(event.getSource() == one) {
            display.appendText("1");
        }
        else if(event.getSource() == two) {
            display.appendText("2");
        }
        else if(event.getSource() == three) {
            display.appendText("3");
        }
        else if(event.getSource() == four) {
            display.appendText("4");
        }
        else if(event.getSource() == five) {
            display.appendText("5");
        }
        else if(event.getSource() == six) {
            display.appendText("6");
        }
        else if(event.getSource() == seven) {
            display.appendText("7");
        }
        else if(event.getSource() == eight) {
            display.appendText("8");
        }
        else if(event.getSource() == nine) {
            display.appendText("9");
        }
        else if(event.getSource() == zero) {
            display.appendText("0");
        }
        else if(event.getSource() == dot && point == 0) {
            display.appendText(".");
            point = 1;
        }
    }

    @FXML
    private void handleOperatorButton(ActionEvent event) {
        if(event.getSource() == add) {
            n1 = Double.parseDouble(display.getText());
            display.setText("");
            op = "+";
            point = 0;
        }
        else if(event.getSource() == sub) {
            n1 = Double.parseDouble(display.getText());
            display.setText("");
            op = "-";
            point = 0;
        }
        else if(event.getSource() == mul) {
            n1 = Double.parseDouble(display.getText());
            display.setText("");
            op = "*";
            point = 0;
        }
        else if(event.getSource() == div) {
            n1 = Double.parseDouble(display.getText());
            display.setText("");
            op = "/";
            point = 0;
        }
        else if(event.getSource() == pn) {
            n1 = Double.parseDouble(display.getText());
            n1 = n1 * (-1);
            display.setText(String.valueOf(n1));
            point = 0;
        }
        else if(event.getSource() == log) {
            n1 = Double.parseDouble(display.getText());
            op = "log";
            point = 0;
            calculateUnary();
        }
        else if(event.getSource() == sqrt) {
            n1 = Double.parseDouble(display.getText());
            op = "sqrt";
            point = 0;
            calculateUnary();
        }
    }

    private void calculateUnary() {
        UnaryCalculationData unaryCalculationData = new UnaryCalculationData();
        unaryCalculationData.setNumber(n1);
        unaryCalculationData.setOperator(op);

        presenter.calculateUnaryOperation(unaryCalculationData);
    }

    @FXML
    private void resetCalculator(ActionEvent event) {
        n1 = 0;
        n2 = 0;
        display.setText("");
        op = "";
        point = 0;
    }

    @FXML
    private void calculateBinary(ActionEvent event) {
        n2 = Double.parseDouble(display.getText());

        BinaryCalculationData binaryCalculationData = new BinaryCalculationData();
        binaryCalculationData.setNumber1(n1);
        binaryCalculationData.setNumber2(n2);
        binaryCalculationData.setOperator(op);

        presenter.calculateBinaryOperation(binaryCalculationData);
    }

    @Override
    public void onFailed(String message) {
        display.setText(message);
    }

    @Override
    public void onSuccess(double result) {
        rs = result;
        display.setText(String.valueOf(rs));
    }
}
