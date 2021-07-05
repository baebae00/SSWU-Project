package com.example.task8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //유투브로 연결
    /* public void myListener(View target) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"));
        startActivity(intent);
    } */

    //차트 메뉴로 연결
    public void myListener2(View target) {
        Intent intent = new Intent(getApplicationContext(), ChartActivity.class);
        Toast.makeText(MainActivity.this, "Music Chart", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    /* //가수 자세히 보기로 연결
    public void myListener3(View target) {
        Intent intent = new Intent(getApplicationContext(), ArtistinfoActivity.class);
        Toast.makeText(MainActivity.this, "Artist Information", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    } */
}
