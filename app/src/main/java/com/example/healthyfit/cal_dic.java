package com.example.healthyfit;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class cal_dic extends AppCompatActivity {
    ListView listView;
    calListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal_dic);

        listView = (ListView)findViewById(R.id.cal_listview);
        adapter = new calListAdapter();

        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.rice),"쌀밥","(100g/143kcal)");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.tb),"떡볶이","(100g/300kcal)");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.cb),"닭가슴살","(100g/165kcal)");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.rm),"라면","(100g/350kcal)");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.kim),"김치","(100g/21kcal)");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.pork),"삼겹살","(100g/518kcal)");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.chicken),"치킨","(100g/246kcal)");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.banana),"바나나","(100g/89kcal)");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.yogurt),"요거트","(100g/59kcal)");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.sand),"샌드위치","(100g/304kcal)");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.pizza),"피자","(100g/266kcal)");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.zza),"짜장면","(100g/102kcal)");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.jab),"잡채","(100g/146kcal)");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.don),"돈가스","(100g/140kcal)");
        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.hambuger),"햄버거","(100g/295kcal)");
//        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.a)"");
//        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.a)"");
//        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.a)"");
//        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.a)"");
//        adapter.addItem(ContextCompat.getDrawable(this,R.drawable.a)"");

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                cal_dicListItem calListView = (cal_dicListItem)adapterView.getItemAtPosition(i);
            }
        });








        Intent intent = getIntent();

        String userMemo = intent.getStringExtra("userMemo");
        String userDate = intent.getStringExtra("userDate");
        String userEmail = intent.getStringExtra("userEmail");
        String userPw = intent.getStringExtra("userPw");
        String userWeight = intent.getStringExtra("userWeight");
        String userHeight = intent.getStringExtra("userHeight");
        String userBMI = intent.getStringExtra("userBMI");
        String userETC = intent.getStringExtra("userETC");





        BottomNavigationView bottomNavigationView = findViewById(R.id.bottombar);
        bottomNavigationView.setItemIconTintList(null);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.tab1) {
                    Intent Intent1 = new Intent(cal_dic.this, cal_dic.class);
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
                if (id == R.id.tab2) {
                    Intent Intent2 = new Intent(cal_dic.this, home.class);
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
                if (id == R.id.tab3) {
                    Intent Intent3 = new Intent(cal_dic.this, checklist.class);
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
                if (id == R.id.tab4) {
                    Intent Intent4 = new Intent(cal_dic.this, mypage.class);
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

                return false;
            }
        });


    }
}