package com.example.cs478_sp2020_project3_a2beta;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver_A2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context arg0, Intent arg1) {
        // TODO Auto-generated method stub
        Log.i("Received message!", "Programmic Receiver 1 called into action.") ;
        Toast.makeText(arg0, "Programmatic receiver in action! ",
                Toast.LENGTH_LONG).show() ;
    }

}
