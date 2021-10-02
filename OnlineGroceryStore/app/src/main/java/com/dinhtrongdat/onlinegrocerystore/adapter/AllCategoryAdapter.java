package com.dinhtrongdat.onlinegrocerystore.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.dinhtrongdat.onlinegrocerystore.R;
import com.dinhtrongdat.onlinegrocerystore.model.AllCategory;
import com.dinhtrongdat.onlinegrocerystore.model.Category;

import java.util.ArrayList;

public class AllCategoryAdapter extends RecyclerView.Adapter<AllCategoryAdapter.AllCategoryViewHolder> {
    ArrayList<AllCategory> categoryLocation;
    final private ListItemClickListener mOnClickListener;

    public AllCategoryAdapter(ArrayList<AllCategory> categoryLocation, ListItemClickListener mOnClickListener) {
        this.categoryLocation = categoryLocation;
        this.mOnClickListener = mOnClickListener;
    }

    public AllCategoryViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_all_category, parent, false);
        return new AllCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AllCategoryAdapter.AllCategoryViewHolder holder, int position) {
        AllCategory categoryHelper = categoryLocation.get(position);
        holder.imgCategory.setImageResource(categoryHelper.getImgResource());
    }

    @Override
    public int getItemCount() {
        return categoryLocation.size();
    }

    public interface ListItemClickListener{
        void onCategoryClick(int clickedItemIndex);
    }

    public class AllCategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imgCategory;

        public AllCategoryViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imgCategory = itemView.findViewById(R.id.imageView6);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onCategoryClick(clickedPosition);
        }
    }
}
