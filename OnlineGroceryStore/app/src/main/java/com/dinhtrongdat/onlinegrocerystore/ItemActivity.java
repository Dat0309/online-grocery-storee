package com.dinhtrongdat.onlinegrocerystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;

import com.dinhtrongdat.onlinegrocerystore.model.Recently;

import java.util.ArrayList;

public class ItemActivity extends AppCompatActivity {

    Recently recently;
    ImageView imgProduct;
    TextView txtName, txtPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        initUI();
    }

    private void initUI() {
        imgProduct = findViewById(R.id.img_product);
        txtName = findViewById(R.id.txt_product);
        txtPrice =findViewById(R.id.txt_price);

        recently = (Recently) getIntent().getSerializableExtra("index");
        imgProduct.setImageResource(recently.getImgResource());
        txtName.setText(recently.getName());
        txtPrice.setText(String.valueOf(recently.getPrice()));

        findViewById(R.id.btnBackHome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ItemActivity.this, MainActivity.class));
            }
        });
    }
}