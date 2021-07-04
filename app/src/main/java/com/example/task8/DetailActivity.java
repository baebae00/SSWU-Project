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
    private ArtistDTO artistData;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artistdetail);

        artistData = (ArtistDTO) getIntent().getSerializableExtra("item");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        image = findViewById(R.id.img_chart);
        txt_name = findViewById(R.id.txt_Name);
        txt_debut = findViewById(R.id.txt_Debut);
        txt_agency = findViewById(R.id.txt_Agency);
        txt_Award = findViewById(R.id.txt_Award);

        Bundle bundle = getIntent().getExtras();
        artistData = bundle.getParcelable("item");

        Log.d("artistData!!!", artistData.getName() + " / " + artistData.getImage());

        // 전달받은 artistData 객체의 접근자로 필드값을 하나씩 읽어온 후, 뷰의 속성 값들에 지정
        //image.setImageDrawable(artistData.getImage());

        selectImage();
        txt_name.setText(artistData.getName());
        txt_debut.setText(artistData.getDebut());
        txt_agency.setText(artistData.getAgency());
        txt_Award.setText(artistData.getAward());
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

    public void selectImage() {
        if(artistData.getName().equals("아이유")) {
            image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.iu2));
        }
        else if(artistData.getName().equals("볼빨간사춘기")) {
            image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bb2));
        }
        else if(artistData.getName().equals("오마이걸")) {
            image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.o2));
        }
        else if(artistData.getName().equals("방탄소년단")) {
            image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bts2));
        }
        else if(artistData.getName().equals("Apink")) {
            image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.apink2));
        }
        else {
            return;
        }
    }
}
