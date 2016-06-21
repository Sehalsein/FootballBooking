package com.sehalsein.footballbooking.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sehalsein.footballbooking.Activity.Booking;
import com.sehalsein.footballbooking.Adapters.GroundListAdapter;
import com.sehalsein.footballbooking.ClickListener.GroundDetailClickListener;
import com.sehalsein.footballbooking.Activity.GroundDetail;
import com.sehalsein.footballbooking.Pojo.PojoTest;
import com.sehalsein.footballbooking.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GroundList extends Fragment implements GroundDetailClickListener {


    public GroundList() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ground_list, container, false);

        initRecycler(view);

        return view;
    }

    private void initRecycler(View view) {
        RecyclerView recycler = (RecyclerView) view.findViewById(R.id.recycler_Ground_List);
        recycler.setHasFixedSize(true);
        LinearLayoutManager linearlayout = new LinearLayoutManager(getContext());
        linearlayout.setOrientation(LinearLayoutManager.VERTICAL);
        GroundListAdapter adapter = new GroundListAdapter(getActivity(), createList());
        adapter.setClickListener(this);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(linearlayout);
    }

    private List<PojoTest> createList() {
        List<PojoTest> list = null;
        try {
            String Name[] = {"Al Wahda", "Khalidiya Park", "ADGAS", "Muncipality"};
            String Type = "Football";
            list = new ArrayList<PojoTest>();
            for (int i = 0; i < Name.length; i++) {
                PojoTest pojo = new PojoTest();
                pojo.setName(Name[i]);
                pojo.setType(Type);
                list.add(pojo);
            }
        } catch (Exception e) {
            System.out.print(e);
        }
        return list;
    }

    @Override
    public void onClick(String name) {

        switch (name) {
            case "BOOK":
                startActivity(new Intent(getActivity(), Booking.class));
                break;
            case "DETAIL":
                startActivity(new Intent(getActivity(), GroundDetail.class));
                break;

        }
        Toast.makeText(getContext(), "CLICK " + name, Toast.LENGTH_SHORT).show();

    }
}
