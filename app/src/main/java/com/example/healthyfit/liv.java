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


public class liv extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private exAdapter mRecyclerAdapter;
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
                Intent intent = new Intent(liv.this, home.class);
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

        mRecyclerAdapter = new exAdapter();

        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        mexItems = new ArrayList<>();
        mexItems.add(new exItem(R.drawable.level1_1, "댄스 다이어트 끝판왕 \n 체중감량 운동 다이어트 댄스 에어로빅"));
        mexItems.add(new exItem(R.drawable.level1_2, "초보자를 위한 살빠지는 댄스 다이어트"));
        mexItems.add(new exItem(R.drawable.level1_3, "왕초보 탈출 - 전신운동 초보 홈트 여자"));
        mexItems.add(new exItem(R.drawable.level1_4, "허벅지 안쪽살을 빼고싶다면 이동작을 해보세요! \n " +
                "다리라인이 달라집니다!"));
        mexItems.add(new exItem(R.drawable.level1_5, "층간 소음 걱정 없이 체중 감량 보장! \n" +
                "딱 5분 운동!"));



        mRecyclerAdapter.setmList(mexItems);

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){

            @Override

            public boolean onNavigationItemSelected (MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.mbtn1) {
                    Intent Intent1 = new Intent(liv.this, liv0.class);
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
                    Intent Intent2 = new Intent(liv.this, liv.class);
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
                    Intent Intent3 = new Intent(liv.this, liv2.class);
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
                    Intent Intent4 = new Intent(liv.this, liv3.class);
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




