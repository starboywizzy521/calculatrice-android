package com.example.myproject;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
public class Helpers {
    // divsion operator
    public static String division = "&divide;";
    public static boolean isZero(EditText input){
        if(Double.parseDouble(input.getText().toString()) == 0){
            return true;
        }
        return false;
    }
    //public static int getTopicId(Bundle bundle, String inputValue){
      //  int id = 0;
       // if(bundle != null){
         //   id  = bundle.getInt(inputValue);
        //}
        //return id;
    //}
}