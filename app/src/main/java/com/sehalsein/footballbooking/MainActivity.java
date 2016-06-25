package com.sehalsein.footballbooking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sehalsein.footballbooking.Activity.Home;

public class MainActivity extends AppCompatActivity {

    TextView condition;
    Button sunny;
    Button foggy;
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mGroundRef = mRootRef.child("ground");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        condition = (TextView) findViewById(R.id.textCondition);
        sunny = (Button) findViewById(R.id.buttonSunny);
        foggy = (Button) findViewById(R.id.buttonFoggy);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void groundlist(View view) {
        startActivity(new Intent(MainActivity.this, Home.class));
    }
}
