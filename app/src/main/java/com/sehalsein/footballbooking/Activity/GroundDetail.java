package com.sehalsein.footballbooking.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sehalsein.footballbooking.Pojo.AmenitiesDetail;
import com.sehalsein.footballbooking.Pojo.Data;
import com.sehalsein.footballbooking.Pojo.GroundInfo;
import com.sehalsein.footballbooking.Pojo.ManagerDetail;
import com.sehalsein.footballbooking.R;

public class GroundDetail extends AppCompatActivity {

    private String KEY;
    private DatabaseReference mDatabase;

    private TextView mGroundName;
    private TextView mGroundType;
    private TextView mTiming;
    private TextView mMinimumTime;
    private TextView mMaximumTime;
    private TextView mPrice;
    private TextView mManager;
    private TextView mPhoneNumber;
    private TextView mAddress;

    private ImageView mWashroom;
    private ImageView mEquipmentRental;
    private ImageView mParking;
    private ImageView mDrinkingWater;
    private ImageView mSittingArea;
    private ImageView mChangingRoom;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ground_detail);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mDatabase = FirebaseDatabase.getInstance().getReference();

        Data data = new Data();

        KEY = data.getKEY();

        init();
        initUserDetail();
        initAmenities();
        initGroundDetail();

    }

    private void initUserDetail() {

        mDatabase.child(getResources().getString(R.string.manager_list_id)).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.w("USER CHILD ", "ADDED");
                ManagerDetail user = dataSnapshot.getValue(ManagerDetail.class);
                try {
                    if (user.getKey().equals(KEY)) {
                        setUser(user);
                    }
                } catch (NullPointerException e) {

                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.w("USER CHILD ", "CHANGED");
                ManagerDetail user = dataSnapshot.getValue(ManagerDetail.class);
                try {
                    if (user.getKey().equals(KEY)) {
                        setUser(user);
                    }
                } catch (NullPointerException e) {

                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.w("USER CHILD ", "REMOVED");
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                Log.w("USER CHILD ", "MOVED");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("USER CHILD ", "CANCELEED");
            }
        });


    }

    private void initAmenities() {

        mDatabase.child(getResources().getString(R.string.amenities_list_id)).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.w("AMENITIES CHILD ", "ADDED");
                AmenitiesDetail amenities = dataSnapshot.getValue(AmenitiesDetail.class);
                try {
                    if (amenities.getKey().equals(KEY)) {
                        setAmenities(amenities);
                    }
                } catch (NullPointerException e) {

                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.w("AMENITIES CHILD ", "CHANGED");
                AmenitiesDetail amenities = dataSnapshot.getValue(AmenitiesDetail.class);
                try {
                    if (amenities.getKey().equals(KEY)) {
                        setAmenities(amenities);
                    }
                } catch (NullPointerException e) {

                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.w("AMENITIES CHILD ", "REMOVED");
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                Log.w("AMENITIES CHILD ", "MOVED");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("AMENITIES CHILD ", "CANCELEED");
            }
        });
    }

    private void initGroundDetail() {

        mDatabase.child(getResources().getString(R.string.ground_list_id)).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.w("GROUND CHILD ", "ADDED");
                GroundInfo ground = dataSnapshot.getValue(GroundInfo.class);
                try {
                    if (ground.getKey().equals(KEY)) {
                        setGround(ground);
                    }
                } catch (NullPointerException e) {

                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.w("GROUND CHILD ", "CHANGED");
                GroundInfo ground = dataSnapshot.getValue(GroundInfo.class);
                try {
                    if (ground.getKey().equals(KEY)) {
                        setGround(ground);
                    }
                } catch (NullPointerException e) {

                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.w("GROUND CHILD ", "REMOVED");
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                Log.w("GROUND CHILD ", "MOVED");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("GROUND CHILD ", "CANCELEED");
            }
        });
    }

    private void setAmenities(AmenitiesDetail amenities) {
        if (amenities.isWashroom()) {
            mWashroom.setImageResource(R.drawable.vector_available);
        } else {
            mWashroom.setImageResource(R.drawable.vector_unavailable);
        }
        if (amenities.isEquipmentRental()) {
            mEquipmentRental.setImageResource(R.drawable.vector_available);
        } else {
            mEquipmentRental.setImageResource(R.drawable.vector_unavailable);
        }
        if (amenities.isChangingRoom()) {
            mChangingRoom.setImageResource(R.drawable.vector_available);
        } else {
            mChangingRoom.setImageResource(R.drawable.vector_unavailable);
        }
        if (amenities.isDrinkingWater()) {
            mDrinkingWater.setImageResource(R.drawable.vector_available);
        } else {
            mDrinkingWater.setImageResource(R.drawable.vector_unavailable);
        }
        if (amenities.isParking()) {
            mParking.setImageResource(R.drawable.vector_available);
        } else {
            mParking.setImageResource(R.drawable.vector_unavailable);
        }
        if (amenities.isSittingArea()) {
            mSittingArea.setImageResource(R.drawable.vector_available);
        } else {
            mSittingArea.setImageResource(R.drawable.vector_unavailable);
        }
    }

    private void setUser(ManagerDetail user) {
        mManager.setText(user.getFirstName() + " " + user.getLastName());
        mPhoneNumber.setText(user.getPhoneNumber());
        //mKey = user.getKey();
    }

    private void setGround(GroundInfo ground) {
        toolbar.setTitle(ground.getGroundName());
        mGroundType.setText(ground.getGroundType());
        String opening = "AM";
        String closing = "AM";
        int openingHour = ground.getOpeningHour();
        int closingHour = ground.getClosingHour();
        if (openingHour > 12) {
            openingHour = openingHour - 12;
            opening = "PM";
        }
        if (closingHour > 12) {
            closingHour = closingHour - 12;
            closing = "PM";
        }
        mTiming.setText(openingHour + ":" + ground.getOpeningMinute() + " " + opening + " - " + closingHour + ":" + ground.getClosingMinute() + " " + closing);
        //mMaximumTime.setText("30 mins");
        mMinimumTime.setText("30 mins");
        mPrice.setText(ground.getPrice() + "");
        mAddress.setText(ground.getAddress());
    }

    private void init() {
        mGroundType = (TextView) findViewById(R.id.text_ground_type);
        mTiming = (TextView) findViewById(R.id.text_timing);
        mMinimumTime = (TextView) findViewById(R.id.text_minimum_time);
        mMaximumTime = (TextView) findViewById(R.id.text_maximum_time);
        mPrice = (TextView) findViewById(R.id.text_price);
        mManager = (TextView) findViewById(R.id.text_manager);
        mPhoneNumber = (TextView) findViewById(R.id.text_phone_number);
        mAddress = (TextView) findViewById(R.id.text_address);

        mWashroom = (ImageView) findViewById(R.id.image_washroom);
        mEquipmentRental = (ImageView) findViewById(R.id.image_equipment_rental);
        mParking = (ImageView) findViewById(R.id.image_parking);
        mSittingArea = (ImageView) findViewById(R.id.image_sitting_area);
        mDrinkingWater = (ImageView) findViewById(R.id.image_drinking_water);
        mChangingRoom = (ImageView) findViewById(R.id.image_changing_room);
    }

    public void book(View view) {
        startActivity(new Intent(GroundDetail.this, Booking.class));
    }

}
