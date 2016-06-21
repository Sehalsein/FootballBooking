package com.sehalsein.footballbooking.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sehalsein.footballbooking.R;


public class BookingTiming extends Fragment {

    Button mNext;

    public BookingTiming() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_booking_timing, container, false);

        mNext = (Button) view.findViewById(R.id.button_next);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookingTiming timing=new BookingTiming();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                BookingUser groundList = new BookingUser();
                transaction.replace(R.id.blankFragment, groundList, "SEARCH");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }


}
