package com.dinhtrongdat.onlinegrocerystore.adapter;

import android.media.MediaDrm;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.dinhtrongdat.onlinegrocerystore.R;
import com.dinhtrongdat.onlinegrocerystore.model.Recently;

import java.util.ArrayList;

public class RecentlyAdapter extends RecyclerView.Adapter<RecentlyAdapter.RecentlyViewHolder> {

    ArrayList<Recently> recentlyLocation;
    final private ListItemClickListener mOnClickListener;

    public RecentlyAdapter(ArrayList<Recently> recentlyLocation,ListItemClickListener mOnClickListener) {
        this.recentlyLocation = recentlyLocation;
        this.mOnClickListener = mOnClickListener;
    }

    @Override
    public RecentlyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recently,parent, false);
        return new RecentlyViewHolder(view);
    }

    @Override
    public void onBindViewHolder( RecentlyAdapter.RecentlyViewHolder holder, int position) {
        Recently recently = recentlyLocation.get(position);
        holder.imgRecently.setImageResource(recently.getImgResource());
        holder.txtName.setText(recently.getName());
        holder.txtDescription.setText(recently.getDescrip());
        holder.txtPrice.setText(String.valueOf(recently.getPrice()));
        holder.txtUnit.setText(recently.getUnit());
    }

    @Override
    public int getItemCount() {
        return recentlyLocation.size();
    }

    public interface ListItemClickListener{
        void onRecentlyClick(int clickedItemIndex);
    }

    public class RecentlyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView imgRecently;
        TextView txtName, txtDescription, txtPrice, txtUnit;
        ImageView imgBuy;
        public RecentlyViewHolder( View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imgRecently = itemView.findViewById(R.id.imageView5);
            imgBuy = itemView.findViewById(R.id.imgBuy);
            txtName = itemView.findViewById(R.id.txtName);
            txtDescription = itemView.findViewById(R.id.txtDes);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtUnit = itemView.findViewById(R.id.txtUnit);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onRecentlyClick(clickedPosition);
        }
    }
}
