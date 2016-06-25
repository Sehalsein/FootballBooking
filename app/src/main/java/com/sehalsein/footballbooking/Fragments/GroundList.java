package com.sehalsein.footballbooking.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sehalsein.footballbooking.Activity.Booking;
import com.sehalsein.footballbooking.Activity.GroundDetail;
import com.sehalsein.footballbooking.Pojo.Data;
import com.sehalsein.footballbooking.Pojo.GroundInfo;
import com.sehalsein.footballbooking.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GroundList extends Fragment {

    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;
    private String TAG = "GROUND LIST ";

    public GroundList() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ground_list, container, false);
        initrecycler(view);
        return view;
    }

    private void initrecycler(View view) {
        mRecycler = (RecyclerView) view.findViewById(R.id.recycler_Ground_List);
        mRecycler.setHasFixedSize(true);
        mManager = new LinearLayoutManager(getContext());
        mManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(mManager);
    }

    @Override
    public void onStart() {
        super.onStart();

        DatabaseReference mGroundRef = mRootRef.child(getResources().getString(R.string.ground_list_id));
        FirebaseRecyclerAdapter<GroundInfo, GroundListViewHolder> adapter = new FirebaseRecyclerAdapter<GroundInfo, GroundListViewHolder>(
                GroundInfo.class,
                R.layout.card_ground_list,
                GroundListViewHolder.class,
                mGroundRef
        ) {
            @Override
            protected void populateViewHolder(GroundListViewHolder viewHolder, final GroundInfo model, int position) {
                viewHolder.mGroundName.setText(model.getGroundName());
                viewHolder.mGroundType.setText(model.getGroundType());

                final Data data = new Data();
                viewHolder.mBooking.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        data.setKEY(model.getKey());
                        //Toast.makeText(getContext(), "Book Now" + model.getKey(), Toast.LENGTH_SHORT).show();
                        Log.d(TAG, " Book clicked");
                        startActivity(new Intent(getActivity(), Booking.class));
                    }
                });
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        data.setKEY(model.getKey());
                        Log.d(TAG, " Ground detail clicked");
                        //Toast.makeText(getContext(), "Ground Detial" + model.getKey(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getActivity(), GroundDetail.class));
                    }
                });
            }
        };
        mRecycler.setAdapter(adapter);
    }

    public static class GroundListViewHolder extends RecyclerView.ViewHolder {

        private ImageView mGroundImage;
        private TextView mGroundName;
        private TextView mGroundType;
        private Button mBooking;

        public GroundListViewHolder(View itemView) {
            super(itemView);

            mGroundName = (TextView) itemView.findViewById(R.id.text_ground_name);
            mGroundType = (TextView) itemView.findViewById(R.id.text_ground_type);
            mGroundImage = (ImageView) itemView.findViewById(R.id.image_ground_image);
            mBooking = (Button) itemView.findViewById(R.id.button_book);

        }
    }

}
