package com.dinhtrongdat.onlinegrocerystore.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.dinhtrongdat.onlinegrocerystore.R;
import com.dinhtrongdat.onlinegrocerystore.model.Category;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    ArrayList<Category> categoryLocation;
    final private ListItemClickListener mOnClickListener;

    public CategoryAdapter(ArrayList<Category> categoryLocation,ListItemClickListener mOnClickListener) {
        this.categoryLocation = categoryLocation;
        this.mOnClickListener = mOnClickListener;
    }

    public CategoryViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder( CategoryAdapter.CategoryViewHolder holder, int position) {
        Category categoryHelper = categoryLocation.get(position);
        holder.imgCategory.setImageResource(categoryHelper.getImgResource());
    }

    @Override
    public int getItemCount() {
        return categoryLocation.size();
    }

    public interface ListItemClickListener{
        void onCategoryClick(int clickedItemIndex);
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imgCategory;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imgCategory = itemView.findViewById(R.id.imageView4);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onCategoryClick(clickedPosition);
        }
    }
}
