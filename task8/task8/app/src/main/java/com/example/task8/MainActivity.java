package com.example.task8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void myListener(View target) {
        Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
        Toast.makeText(MainActivity.this, "Search Music", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void myListener2(View target) {
        Intent intent = new Intent(getApplicationContext(), ChartActivity.class);
        Toast.makeText(MainActivity.this, "Music Chart", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}
