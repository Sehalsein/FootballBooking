package com.sehalsein.footballbooking.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sehalsein.footballbooking.ClickListener.GroundDetailClickListener;
import com.sehalsein.footballbooking.Pojo.PojoTest;
import com.sehalsein.footballbooking.R;

import java.util.List;

/**
 * Created by sehalsein on 24/06/16.
 */
public class GroundListAdapter extends RecyclerView.Adapter<GroundListAdapter.ViewHolder> {

    private Context context;
    private List<PojoTest> list;
    private GroundDetailClickListener clickListener;

    public GroundListAdapter() {
    }

    public GroundListAdapter(Context context, List<PojoTest> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_ground_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        PojoTest pojoTest = list.get(position);

        holder.mGroundName.setText("" + pojoTest.getName());
        holder.mGroundType.setText("" + pojoTest.getType());
        holder.mBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null) {
                    clickListener.onClick("BOOK");
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setClickListener(GroundDetailClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mGroundImage;
        private TextView mGroundName;
        private TextView mGroundType;
        private Button mBooking;


        public ViewHolder(View itemView) {
            super(itemView);

            mGroundName = (TextView) itemView.findViewById(R.id.text_ground_name);
            mGroundType = (TextView) itemView.findViewById(R.id.text_ground_type);
            mGroundImage = (ImageView) itemView.findViewById(R.id.image_ground_image);
            mBooking = (Button) itemView.findViewById(R.id.button_book);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onClick("DETAIL");
            }
        }
    }
}
