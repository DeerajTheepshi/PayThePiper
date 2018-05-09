package com.example.android.test1;
import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
public class MainActivity extends AppCompatActivity {
    //global variables
    int price = 0;
    int piper_amt = generateRandomInt(30);
    TextView mpiperPrice;
    Button resetButton;
    ImageView linLayout;
    Button b1 ;
    Button b2 ;
    Button b3;
    Button b4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mpiperPrice = (TextView) findViewById(R.id.price);
        mpiperPrice.setText(String.valueOf(piper_amt));
        linLayout = findViewById(R.id.backdrop);
        resetButton = (Button) findViewById(R.id.Reset);
        b4 = (Button) findViewById(R.id.b4);
        b3 = (Button) findViewById(R.id.b3);
        b2 = (Button) findViewById(R.id.b2);
        b1 = (Button) findViewById(R.id.b1);
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
         piper_amt = generateRandomInt(30);
         mpiperPrice.setText(String.valueOf(piper_amt));
         linLayout.setImageResource(R.drawable.initbackground);
         resetButton.setEnabled(true);
         b1.setEnabled(true);
         b2.setEnabled(true);
         b3.setEnabled(true);
         b4.setEnabled(true);
         increment(0);
    }

    public void reset(View view)
    {
        increment(0);
    }

    public void check_payment(int paid, int toPay)                                        //To check if the required amount is paid
    {
            if(paid == toPay){
                linLayout.setImageResource(R.drawable.paid1);
                resetButton.setEnabled(false);
                b1.setEnabled(false);
                b2.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                makeToast("You Paid The Piper!");
            }
            else if(paid > toPay)
            {
                makeToast("Payment exceeds expected amount, Use reset Button");
    }
    }


    public void increment(int denomination)                                             //method that controls denomination wise payment
    {
        TextView paid =  (TextView) findViewById(R.id.price_paid);
        price+=denomination;
        if(denomination==0)
            price = 0;                                             //Prevents reset even after money is paid
        paid.setText(String.valueOf(price)+" $ PAID");
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

                                                                    //add ons
    public void makeToast(CharSequence toastText)
    {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context,toastText,Toast.LENGTH_SHORT);
        toast.show();
    }

}

