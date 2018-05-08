package com.example.android.test1;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;
public class MainActivity extends AppCompatActivity {
    //global variables
    int price = 0;
    int piper_amt = generateRandomInt(20);
    TextView mpiperPrice;
    Button resetButton;
    View linLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mpiperPrice = (TextView) findViewById(R.id.price);
        mpiperPrice.setText(String.valueOf(piper_amt));
        linLayout = findViewById(R.id.backgroundControl);
        resetButton = (Button) findViewById(R.id.Reset);
    }
    //Denomination methods
    public void increase_1(View view)
    {
        increment(1);
        check_payment(price,piper_amt);
    }

    public void increase_2(View view)
    {
        increment(2);
        check_payment(price,piper_amt);
    }

    public void increase_5(View view)
    {
        increment(5);
        check_payment(price,piper_amt);
    }

    public void increase_10(View view)
    {
        increment(10);
        check_payment(price,piper_amt);
    }
    //to restart the payment:
    public void restart(View view)
    {
         price = 0;
         piper_amt = generateRandomInt(20);
         mpiperPrice.setText(String.valueOf(piper_amt));
         linLayout.setBackgroundColor(getResources().getColor(R.color.backgroundInit));
         resetButton.setEnabled(true);
         increment(0);
    }

    public void reset(View view)
    {
        increment(0);
    }

    public void check_payment(int paid, int toPay)                                        //To check if the required amount is paid
    {
            if(paid == toPay){
                linLayout.setBackgroundColor(getResources().getColor(R.color.backgrounFinal));
                resetButton.setEnabled(false);}
    }


    public void increment(int denomination)                                             //method that controls denomination wise payment
    {
        TextView paid =  (TextView) findViewById(R.id.price_paid);
        price+=denomination;
        if(denomination==0)
            price = 0;                                             //Prevents reset even after money is paid
        paid.setText(String.valueOf(price)+" Rs PAID");
    }
    //random Generator using Java.util.Random
    public int generateRandomInt(int limit)
    {
        Random number = new Random();
        int a=number.nextInt(limit);
        if(a!=0)//To avoid random number being zero
            return a;
        else
            return number.nextInt(limit);
    }
}
