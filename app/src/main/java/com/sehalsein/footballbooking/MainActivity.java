package com.sehalsein.footballbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sehalsein.footballbooking.Activity.Home;

public class MainActivity extends AppCompatActivity {

    TextView condition;
    Button sunny;
    Button foggy;
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionRef = mRootRef.child("condition");

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


        mConditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                condition.setText("" + value);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        sunny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mConditionRef.setValue("Sunny");
            }
        });
        foggy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mConditionRef.setValue("Foggy");
            }
        });
    }

    public void groundlist(View view) {
        startActivity(new Intent(MainActivity.this, Home.class));
    }
}
