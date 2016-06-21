package com.sehalsein.footballbooking.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.sehalsein.footballbooking.Fragments.BookingTiming;
import com.sehalsein.footballbooking.Fragments.BookingUser;
import com.sehalsein.footballbooking.R;


public class Booking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        Button mNext = (Button) findViewById(R.id.button_next);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookingTiming timing = new BookingTiming();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                BookingUser groundList = new BookingUser();
                transaction.add(R.id.blankFragment, groundList, "SEARCH");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

    }

}
