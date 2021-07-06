package com.example.task8;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    private TextView txt_name, txt_debut, txt_agency, txt_Award;
    private ImageView image;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artistdetail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        image = findViewById(R.id.img_chart);
        txt_name = findViewById(R.id.txt_Name);
        txt_debut = findViewById(R.id.txt_Debut);
        txt_agency = findViewById(R.id.txt_Agency);
        txt_Award = findViewById(R.id.txt_Award);

        Bundle bundle = getIntent().getExtras();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
