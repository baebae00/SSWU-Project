package com.example.task8;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class ChartActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    String melon_chart_url = "https://www.jungle.co.kr/contest";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_melon_chart);

        recyclerView = findViewById(R.id.recyclerView_chart);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);

        getData();
    }

    private void getData(){
        MelonJsoup jsoupAsyncTask = new MelonJsoup();
        jsoupAsyncTask.execute();
    }

    private class MelonJsoup extends AsyncTask<Void, Void, Void> {
        ArrayList<String> listTitle = new ArrayList<>();
        ArrayList<String> listName = new ArrayList<>();
        ArrayList<String> listUrl = new ArrayList<>();
        ArrayList<String> listAlbumID = new ArrayList<>();

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document doc = Jsoup.connect(melon_chart_url).get();
                final Elements rank_list1 = doc.select("ul#contest-list.thumb_list05 li div a.thumb_title05");
                final Elements rank_list_name = doc.select("ul#contest-list.thumb_list05 li div p.list_date span.d_day.red");

                final Elements image_list1 = doc.select("ul#contest-list.thumb_list05 li a span.zoom img");

                //앨범 아이디 추출하기
                final Elements albumId_list_1 = doc.select("ul#contest-list.thumb_list05 li a");

                Log.d("CharActivity!!!", albumId_list_1.toString());

                Handler handler = new Handler(Looper.getMainLooper()); // 객체생성
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //순위정보
                        for(Element element: rank_list1) {
                            listTitle.add(element.text());
                        }
                        //가수정보
                        for (Element element : rank_list_name) {
                            listName.add(element.text());
                        }
                        // 이미지정보
                        for (Element element : image_list1){
                            // 주소에서 /contest 지우고 그 자리에 src 추가
                            listUrl.add("https://www.jungle.co.kr/" + element.attr("src"));
                        }

                        for (Element element : albumId_list_1) {
                            // 앨범 아이디만 나올 수 있도록 문자열 추출 작업
                            // <a href="javascript:melon.link.goAlbumDetail('10427559');" 에서 href 속성만 떼어내기
                            String tmp = element.attr("href");
/*
                            //그중에서도 앨범 아이디(숫자부분)만 뗴어내기
                            int tmp_num = tmp.indexOf("('") + 2;
                            String result = tmp.substring(tmp_num, (tmp.substring(tmp_num).indexOf("');") + tmp_num));

                            //앨범 아이디만 리스트에 추가
                            listAlbumID.add(result);
*/
                           /* String result = tmp.substring(tmp.indexOf("=")+1);
                            //앨범 아이디만 리스트에 추가
                            listAlbumID.add(result); */

                            String result = tmp.substring(tmp.indexOf("st")+2);
                            //앨범 아이디만 리스트에 추가
                            listAlbumID.add(result);

                        }

                        for (int i = 0; i < 10 ; i++) {
                            ChartDTO data = new ChartDTO();
                            if(listTitle.size()!= 0) {data.setTitle(listTitle.get(i));}
                            if(listUrl.size()!= 0) {data.setImageUrl(listUrl.get(i));}
                            if(listName.size()!= 0) {data.setName(listName.get(i+1));}
                            // data.setRankNum(String.valueOf(i+1));
                            // if(listTitle.size()!= 0) {data.setTitle(listTitle.get(i));}
                            if(listAlbumID.size()!= 0) {data.setAlbumID(listAlbumID.get(i));}

                            adapter.addItem(data);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}