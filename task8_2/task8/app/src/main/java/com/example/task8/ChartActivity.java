package com.example.task8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;

public class ChartActivity extends AppCompatActivity {

    private ListViewAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        adapter = new ListViewAdapter();
        listView = findViewById(R.id.listView);

        //setData();

        listView.setAdapter(adapter);
    }

    /*
    // 보통 ListView는 통신을 통해 가져온 데이터를 보여줍니다.
    // arrId, titles, contents를 서버에서 가져온 데이터라고 생각하시면 됩니다.
    private void setData() {
        TypedArray arrResId = getResources().obtainTypedArray(R.array.Id);
        String[] titles = getResources().getStringArray(R.array.title);
        String[] contents = getResources().getStringArray(R.array.content);

        for (int i = 0; i < arrResId.length(); i++) {
            ListViewItem dto = new ListViewItem();
            dto.setId(arrResId.getResourceId(i, 0));
            dto.setTitle(titles[i]);
            dto.setContent(contents[i]);

            adapter.addItem(dto);
        }
    }*/
}
