package com.example.healthyfit;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

//고급
public class liv3 extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private exAdapter3 mRecyclerAdapter;
    private ArrayList<exItem> mexItems;
    private Button logobtn;
    private static final int CALL_BACK = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        //값받아오기
        Intent intent = getIntent();

        String userMemo = intent.getStringExtra("userMemo");
        String userDate = intent.getStringExtra("userDate");
        String userEmail = intent.getStringExtra("userEmail");
        String userPw = intent.getStringExtra("userPw");
        String userWeight = intent.getStringExtra("userWeight");
        String userHeight = intent.getStringExtra("userHeight");
        String userBMI = intent.getStringExtra("userBMI");
        String userETC = intent.getStringExtra("userETC");

        logobtn = findViewById(R.id.logobtn);
        logobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(liv3.this, home.class);
                intent.putExtra("userMemo", userMemo);
                intent.putExtra("userDate", userDate);
                intent.putExtra("userEmail", userEmail);
                intent.putExtra("userPw", userPw);
                intent.putExtra("userHeight", userHeight);
                intent.putExtra("userWeight", userWeight);
                intent.putExtra("userETC", userETC);
                intent.putExtra("userBMI", userBMI);
                startActivityForResult(intent, CALL_BACK);
            }
        });

        mRecyclerView = findViewById(R.id.recyclerView);

        mRecyclerAdapter = new exAdapter3();

        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        //고급
        mexItems = new ArrayList<>();
        mexItems.add(new exItem(R.drawable.level3_1, "전신 다이어트 최고의 운동 \n [칼소폭 찐 핵핵매운맛]"));
        mexItems.add(new exItem(R.drawable.level3_2, "(층간소음 X) 진짜 역대급 20분루틴\nㅣ전신올인원 I 힙으뜸 유산소운동"));
        mexItems.add(new exItem(R.drawable.level3_3, "살이 너무 빠지는 죽음의 타바타 운동 (no 층간소음)"));
        mexItems.add(new exItem(R.drawable.level3_4, "온몸에 땀 터지는 20분 고강도 전신 운동 루틴 "));
        mexItems.add(new exItem(R.drawable.level3_5, "앞벅지 볼록, 뒷벅지 셀룰라이트, 허벅지 안쪽살 모조리 불태우고\uD83D\uDD25 \n[여리탄탄 일자 허벅지] 되는 7일 루틴 "));

        mRecyclerAdapter.setmList(mexItems);

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){

            @Override

            public boolean onNavigationItemSelected (MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.mbtn1) {
                    Intent Intent1 = new Intent(liv3.this, liv0.class);
                    Intent1.putExtra("userMemo", userMemo);
                    Intent1.putExtra("userDate", userDate);
                    Intent1.putExtra("userEmail", userEmail);
                    Intent1.putExtra("userPw", userPw);
                    Intent1.putExtra("userWeight", userWeight);
                    Intent1.putExtra("userETC", userETC);
                    Intent1.putExtra("userBMI", userBMI);
                    Intent1.putExtra("userHeight", userHeight);
                    startActivity(Intent1);
                }
                if (id == R.id.mbtn2) {
                    Intent Intent2 = new Intent(liv3.this, liv.class);
                    Intent2.putExtra("userMemo", userMemo);
                    Intent2.putExtra("userDate", userDate);
                    Intent2.putExtra("userEmail", userEmail);
                    Intent2.putExtra("userPw", userPw);
                    Intent2.putExtra("userWeight", userWeight);
                    Intent2.putExtra("userETC", userETC);
                    Intent2.putExtra("userBMI", userBMI);
                    Intent2.putExtra("userHeight", userHeight);
                    startActivity(Intent2);
                }
                if (id == R.id.mbtn3) {
                    Intent Intent3 = new Intent(liv3.this, liv2.class);
                    Intent3.putExtra("userMemo", userMemo);
                    Intent3.putExtra("userDate", userDate);
                    Intent3.putExtra("userEmail", userEmail);
                    Intent3.putExtra("userPw", userPw);
                    Intent3.putExtra("userWeight", userWeight);
                    Intent3.putExtra("userETC", userETC);
                    Intent3.putExtra("userBMI", userBMI);
                    Intent3.putExtra("userHeight", userHeight);
                    startActivity(Intent3);
                }
                if (id == R.id.mbtn4) {
                    Intent Intent4 = new Intent(liv3.this, liv3.class);
                    Intent4.putExtra("userMemo", userMemo);
                    Intent4.putExtra("userDate", userDate);
                    Intent4.putExtra("userEmail", userEmail);
                    Intent4.putExtra("userPw", userPw);
                    Intent4.putExtra("userWeight", userWeight);
                    Intent4.putExtra("userETC", userETC);
                    Intent4.putExtra("userBMI", userBMI);
                    Intent4.putExtra("userHeight", userHeight);
                    startActivity(Intent4);
                }


                return true;
            }
        });

    }
}
