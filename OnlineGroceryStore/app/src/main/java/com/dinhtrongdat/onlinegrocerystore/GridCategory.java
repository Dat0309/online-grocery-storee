package com.dinhtrongdat.onlinegrocerystore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dinhtrongdat.onlinegrocerystore.adapter.AllCategoryAdapter;
import com.dinhtrongdat.onlinegrocerystore.adapter.RecentlyAdapter;
import com.dinhtrongdat.onlinegrocerystore.model.AllCategory;
import com.dinhtrongdat.onlinegrocerystore.model.Recently;

import java.util.ArrayList;

public class GridCategory extends AppCompatActivity implements AllCategoryAdapter.ListItemClickListener{

    RecyclerView allCategoryRecycle;
    AllCategoryAdapter allCategoryAdapter;
    ArrayList<AllCategory> listAllCate;
    ImageView btnBack;

    private int[] idCate = {0,1,2,3,4,5,6,7,8,9,10,11};
    private int[] imgCate = {R.drawable.ic_cookies,R.drawable.ic_dairy,R.drawable.ic_desert,R.drawable.ic_drink,
            R.drawable.ic_egg,R.drawable.ic_fish, R.drawable.ic_fruits,R.drawable.ic_juce,
            R.drawable.ic_meat,R.drawable.ic_salad,R.drawable.ic_spices, R.drawable.ic_veggies};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_category);

        initUI();
    }

    private void initUI() {
        allCategoryRecycle = findViewById(R.id.recycle_all_category);
        listAllCate = new ArrayList<>();
        for(int i = 0;i<idCate.length; i++){
            listAllCate.add(new AllCategory(idCate[i],imgCate[i]));
        }
        setRecentRecycle(listAllCate);

        findViewById(R.id.btnBackHome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GridCategory.this, MainActivity.class));
            }
        });

    }

    private void setRecentRecycle(ArrayList<AllCategory> listRecently) {
        allCategoryRecycle.setLayoutManager(new GridLayoutManager(this, 3));
        allCategoryAdapter = new AllCategoryAdapter(listRecently, this);
        allCategoryAdapter.notifyDataSetChanged();
        allCategoryRecycle.setAdapter(allCategoryAdapter);
    }

    @Override
    public void onCategoryClick(int clickedItemIndex) {

    }
}