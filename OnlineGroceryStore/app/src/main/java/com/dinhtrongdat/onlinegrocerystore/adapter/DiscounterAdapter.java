package com.dinhtrongdat.onlinegrocerystore.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.dinhtrongdat.onlinegrocerystore.R;
import com.dinhtrongdat.onlinegrocerystore.model.DiscounterProduct;

import java.util.ArrayList;

public class DiscounterAdapter extends RecyclerView.Adapter<DiscounterAdapter.DiscounterViewHolder> {
    ArrayList<DiscounterProduct> discounterLocation;
    final private ListItemClickListener mOnClickListener;

    public DiscounterAdapter(ArrayList<DiscounterProduct> discounterLocation,ListItemClickListener mOnClickListener) {
        this.discounterLocation = discounterLocation;
        this.mOnClickListener = mOnClickListener;
    }

    @Override
    public DiscounterViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_discounter, parent, false);
        return new DiscounterViewHolder(view);
    }

    @Override
    public void onBindViewHolder( DiscounterAdapter.DiscounterViewHolder holder, int position) {
        DiscounterProduct discounterHelper = discounterLocation.get(position);
        holder.imgDiscounter.setImageResource(discounterHelper.getImg());
    }

    @Override
    public int getItemCount() {
        return discounterLocation.size();
    }

    public interface ListItemClickListener{
        void onDiscounterClick(int clickedItemIndex);
    }

    public class DiscounterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imgDiscounter;
        public DiscounterViewHolder( View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imgDiscounter = itemView.findViewById(R.id.imageView3);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onDiscounterClick(clickedPosition);
        }
    }
}
