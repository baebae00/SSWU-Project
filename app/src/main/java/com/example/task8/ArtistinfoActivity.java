package com.example.task8;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.load.engine.Resource;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class ArtistinfoActivity extends AppCompatActivity {

    ListView listview ;
    ArtistViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artistinfo);

        // Adapter 생성
        adapter = new ArtistViewAdapter() ;

        Initialization(adapter);

        // 리스트뷰 참조 및 Adapter달기
        listview = findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        // 위에서 생성한 listview에 클릭 이벤트 핸들러 정의.
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                // get item
                ArtistDTO item = (ArtistDTO) parent.getItemAtPosition(position) ;
                Log.d("click_item!!!!!", item.getName()  + " / "+ item.getImage());

                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("item", item);
                view.getContext().startActivities(new Intent[]{intent});
            }
        }) ;
    }

    public void Initialization(ArtistViewAdapter adapter) {
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.iu),"아이유", "2008년 미니 앨범", "EDAM엔터테인먼트", "2018년 제32회 골든디스크 어워즈 디지털음원부문 대상");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.bb),"볼빨간사춘기", "2016년 EP 앨범", "쇼파르뮤직", "2020년 제9회 가온차트 뮤직 어워즈 디지털음원부문 올해의 가수상 4월");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.omygirl),"오마이걸","2015 미니 앨범", "WM엠터테인먼트", "2019 대한민국 퍼스트브랜드 대상");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.bts),"방탄소년단", "2013년 싱글 앨범", "빅히트 엔터테인먼트", "2020 제 29회 하이원 서울가요대상 앨범부문 대상");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.apink),"Apink", "2011 EP 앨범", "플레이엠엔터테인먼트", "2016 제30회 골든디스크 어워즈 음반부문 본상");
    }
}
