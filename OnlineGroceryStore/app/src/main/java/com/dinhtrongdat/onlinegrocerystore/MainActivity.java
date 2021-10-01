package com.dinhtrongdat.onlinegrocerystore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dinhtrongdat.onlinegrocerystore.adapter.CategoryAdapter;
import com.dinhtrongdat.onlinegrocerystore.adapter.DiscounterAdapter;
import com.dinhtrongdat.onlinegrocerystore.adapter.RecentlyAdapter;
import com.dinhtrongdat.onlinegrocerystore.model.Category;
import com.dinhtrongdat.onlinegrocerystore.model.DiscounterProduct;
import com.dinhtrongdat.onlinegrocerystore.model.Recently;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DiscounterAdapter.ListItemClickListener, CategoryAdapter.ListItemClickListener, RecentlyAdapter.ListItemClickListener {

    /**
    * Resource list of Discounter Product
    * */
    private int[] ids = {0,1,2};
    private int[] imgResource = {R.drawable.discountberry,R.drawable.discountbrocoli,R.drawable.discountmeat};

    /**
     * Resource list of Category
     * */
    private int[] idCate = {0,1,2,3,4,5,6,7,8,9,10,11};
    private int[] imgCate = {R.drawable.ic_cookies,R.drawable.ic_dairy,R.drawable.ic_desert,R.drawable.ic_drink,
                            R.drawable.ic_egg,R.drawable.ic_fish, R.drawable.ic_fruits,R.drawable.ic_juce,
                            R.drawable.ic_meat,R.drawable.ic_salad,R.drawable.ic_spices, R.drawable.ic_veggies};

    /**
     * Resource list of Recently
     */
    private String[] names = {"Kiwi", "Dâu tây","Đu đủ","Dưa hấu"};
    private String[] des={"Kiwi tươi mát tốt cho sức khỏe",
                    "Dâu tây hơi chua nhưng mà nó sang",
                    "Đủ đủ ăn nhiều bị no",
                    "Không nên ăn dưa hấu vào buổi tối"};
    private double[] price={20000,80000,30000,15000};
    private String[] unit={"KG","KG","KG","KG"};
    private int[] imgRecent = {R.drawable.card1,R.drawable.card2,R.drawable.card3,R.drawable.card4};

    RecyclerView discounterRecycle, categoryRecycle, recentlyRecycle;
    DiscounterAdapter discounterAdapter;
    CategoryAdapter categoryAdapter;
    RecentlyAdapter recentlyAdapter;
    ArrayList<DiscounterProduct> listDiscounter;
    ArrayList<Category> listCategory;
    ArrayList<Recently> listRecently;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initUI();
    }

    private void initUI() {
        discounterRecycle = findViewById(R.id.recycle_discount);
        listDiscounter = new ArrayList<>();
        for (int i=0;i<ids.length; i++){
            listDiscounter.add(new DiscounterProduct(ids[i],imgResource[i]));
        }
        setDiscounterRecycler(listDiscounter);

        categoryRecycle = findViewById(R.id.recycle_category);
        listCategory = new ArrayList<>();
        for(int i=0; i<idCate.length; i++){
            listCategory.add(new Category(idCate[i],imgCate[i]));
        }
        setCategoryRecycler(listCategory);

        recentlyRecycle = findViewById(R.id.recycle_recently);
        listRecently = new ArrayList<>();
        for(int i=0;i<names.length;i++){
            listRecently.add(new Recently(names[i],des[i],price[i],unit[i],imgRecent[i]));
        }
        setRecentRecycle(listRecently);
    }

    private void setRecentRecycle(ArrayList<Recently> listRecently) {
        recentlyRecycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        recentlyAdapter = new RecentlyAdapter(listRecently, this);
        recentlyAdapter.notifyDataSetChanged();
        recentlyRecycle.setAdapter(recentlyAdapter);
    }

    private void setCategoryRecycler(ArrayList<Category> listCategory) {
        categoryRecycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoryAdapter = new CategoryAdapter(listCategory, this);
        categoryAdapter.notifyDataSetChanged();
        categoryRecycle.setAdapter(categoryAdapter);
    }

    private void setDiscounterRecycler(ArrayList<DiscounterProduct> listDiscounter) {
        discounterRecycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        discounterAdapter = new DiscounterAdapter(listDiscounter, this);
        discounterAdapter.notifyDataSetChanged();
        discounterRecycle.setAdapter(discounterAdapter);
    }

    @Override
    public void onDiscounterClick(int clickedItemIndex) {

    }

    @Override
    public void onCategoryClick(int clickedItemIndex) {

    }

    @Override
    public void onRecentlyClick(int clickedItemIndex) {

    }
}