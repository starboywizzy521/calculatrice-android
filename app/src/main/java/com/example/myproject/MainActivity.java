package com.example.myproject;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.pm.ActivityInfo;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myproject.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView screen;
    private String Input = "";
    private String inputToBeParsed = "";
    private Calculator mCalculator;
    private Button button0, button1, button2,button3,button4,button5,button6,button7,
            button8,button9,buttonDelete, buttonDivision,buttonMultiplication,buttonSoustraction,
            buttonAddition, buttonEqual, buttonDot, closeParenthesis, openParenthesis,
            buttonDeleteAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylayout);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mCalculator = new Calculator();
        screen= (TextView)findViewById(R.id.screen);
        screen.setText("");
        button0 = (Button)findViewById(R.id.n0);
        button1 = (Button)findViewById(R.id.n1);
        button2 = (Button)findViewById(R.id.n2);
        button3 = (Button)findViewById(R.id.n3);
        button4 = (Button)findViewById(R.id.n4);
        button5 = (Button)findViewById(R.id.n5);
        button6 = (Button)findViewById(R.id.n6);
        button7 = (Button)findViewById(R.id.n7);
        button8 = (Button)findViewById(R.id.n8);
        button9 = (Button)findViewById(R.id.n9);
        buttonDivision = (Button)findViewById(R.id.division);
        buttonMultiplication = (Button)findViewById(R.id.multiplication);
        buttonSoustraction = (Button)findViewById(R.id.soustraction);
        buttonAddition = (Button)findViewById(R.id.additi);
        buttonDot = (Button)findViewById(R.id.dot);
        closeParenthesis = (Button)findViewById(R.id.parentheseW);
        openParenthesis = (Button)findViewById(R.id.parentheseL);
        buttonDivision.setText(Html.fromHtml(Helpers.division));
        buttonDeleteAll = (Button)findViewById(R.id.deleteAll);
        buttonDelete = (Button)findViewById(R.id.delete);
        buttonEqual = (Button)findViewById(R.id.equals);

// Appeler les listners
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);
        buttonMultiplication.setOnClickListener(this);
        buttonSoustraction.setOnClickListener(this);
        buttonAddition.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        closeParenthesis.setOnClickListener(this);
        openParenthesis.setOnClickListener(this);
        buttonDeleteAll.setOnClickListener(this);

    }
    // switch sur les valeurs d'input
    private void InputValeurs(String input){
        switch (input){
            case "0":
                Input += "0";
                inputToBeParsed += "0";
                break;
            case "1":

                Input += "1";
                inputToBeParsed += "1";
                break;
            case "2":

                Input += "2";
                inputToBeParsed += "2";
                break;
            case "3":

                Input += "3";
                inputToBeParsed += "3";
                break;
            case "4":

                Input += "4";
                inputToBeParsed += "4";
                break;
            case "5":
                 Input += "5";
                inputToBeParsed += "5";

                break;
            case "6":
                Input += "6";
                inputToBeParsed += "6";

                break;
            case "7":
                Input += "7";
                inputToBeParsed += "7";
                break;
            case "8":
                Input += "8";
                inputToBeParsed += "8";
                break;
            case "9":
                Input += "9";
                inputToBeParsed += "9";
                break;
            case ".":
                Input += ".";
                inputToBeParsed += ".";
                break;
            case "+":
                Input += "+";
                inputToBeParsed += "+";
                break;
            case "-":
                Input += "-";
                inputToBeParsed += "-";
                break;
            case "÷":
                Input += "÷";
                inputToBeParsed += "/";
                break;
            case "*":
                Input += "*";
                inputToBeParsed += "*";
                break;
            case "(":
                Input += "(";
                inputToBeParsed += "(";
                break;
            case ")":
                Input += ")";
                inputToBeParsed += ")";
                break;

        }
        screen.setText(Input);
    }
    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        Toast.makeText(this, "Click " + data, Toast.LENGTH_LONG).show();
        if(data.equals("CE")){
            screen.setText("");
            Input = "";
            inputToBeParsed = "";
        }
        else if(data.equals("=")){
            String enteredInput = screen.getText().toString();
            // call a function that will return the result of the calculate.
            String resultObject = mCalculator.getResult(Input, inputToBeParsed);
            screen.setText(removeTrailingZero(resultObject));
        }else if(data.equals("DEL")){
            String InputToDel = screen.getText().toString();
            if(InputToDel.length() >= 0){
                InputToDel = InputToDel.substring(0, Input.length() - 1);
                Input = InputToDel;
                inputToBeParsed = InputToDel;
                screen.setText(Input);
            }
        }

        else{
            InputValeurs(data);
        }
    }
    private String removeTrailingZero(String Input){
        if(!Input.contains(".")){
            return Input;
        }
        int dotPosition = Input.indexOf(".");
        String newValue = Input.substring(dotPosition, Input.length());
        if(newValue.equals(".0")){
            return Input.substring(0, dotPosition);
        }
        return Input;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
