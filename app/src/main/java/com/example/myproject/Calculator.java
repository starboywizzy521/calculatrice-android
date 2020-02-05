package com.example.myproject;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.Function;
import com.fathzer.soft.javaluator.Parameters;

import java.util.Iterator;
public class Calculator {


    Parameters params;
    // l'evaluater ( gérer les expressions arithmétiques )
    DoubleEvaluator evaluator;
    private double previousSum = 0;
    private double currentSum = 0;
    private String Onscreen = "";
//    private boolean isRadians = false;
    public Calculator() {
        addFunctions();
        //Adds the functions to the evaluator
        evaluator = new DoubleEvaluator(params) {
            @Override
            protected Double evaluate(Function function, Iterator arguments, Object evaluationContext) {

                return super.evaluate(function, arguments, evaluationContext);
            }
        };
    }

    public void addFunctions() {
        // l'evaluater peut gérer les exp arithmétiques ( +, -, * ...)
        params = DoubleEvaluator.getDefaultParameters();

    }
    public String getResult(String OnScreen, String Parsingexpression) {
        try {
            System.out.println("Résultat" + Parsingexpression);
            // evaluation de l'expression d'input !
            currentSum = evaluator.evaluate(Parsingexpression);
            Onscreen = String.valueOf(currentSum);
        } catch (Exception e) {
            // l'ope n'est bien formé
            OnScreen = "Error !! ";
        }
        return Onscreen;
    }


}
