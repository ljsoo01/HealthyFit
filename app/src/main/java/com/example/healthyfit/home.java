package com.example.healthyfit;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class home extends AppCompatActivity {


    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    TableLayout tableLayout;

    ViewPager mbtn1;

    TextView dateText;
    DatePickerDialog datePickerDialog;
    Button btn_update;
    EditText memo, height, weight, etc;
    TextView bmi, email;

    private LineChart lineChart;

    private static final int CALL_BACK = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        memo = findViewById(R.id.memotxt);
        dateText = findViewById(R.id.datetext);
        email = findViewById(R.id.email);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        etc = findViewById(R.id.etc);
        bmi = findViewById(R.id.bmi);

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

        memo.setText(userMemo);
        dateText.setText(userDate);
        email.setText(userEmail);
        height.setText(userHeight);
        weight.setText(userWeight);
        etc.setText(userETC);
        bmi.setText(userBMI);

        @SuppressLint("WrongViewCast") final DrawerLayout drawerLayout = findViewById(R.id.home);


        findViewById(R.id.imgbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);


        //업데이트 버튼 클릭 시
        btn_update = findViewById(R.id.update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userMemo = memo.getText().toString();
                String userDate = dateText.getText().toString();
                String userEmail = email.getText().toString();
                String userWeight = weight.getText().toString();
                String userETC = etc.getText().toString();
                String userHeight = height.getText().toString();


                String strNum = height.getText().toString();
                double num1 = Integer.parseInt(strNum); // height
                strNum = weight.getText().toString();
                double num2 = Integer.parseInt(strNum); // weight
                double result = num2/num1/num1 * 10000;
                strNum = String.format("%.2f", result);
                bmi.setText(strNum);



                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            //수정 성공
                            if (success) {
                                Toast.makeText(getApplicationContext(), "수정에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                String userMemo = jsonObject.getString("userMemo");
                                String userDate = jsonObject.getString("userDate");
                                String userHeight = jsonObject.getString("userHeight");
                                String userWeight = jsonObject.getString("userWeight");
                                String userETC = jsonObject.getString("userETC");
                                String userBMI = jsonObject.getString("userBMI");

                                //수정 성공하면 계속해서 같은 화면>>마이페이지로 전달하는 값도 표현한다고 생각했는데,,
                                Intent intent = new Intent(home.this, home.class);
                                intent.putExtra("userMemo", userMemo);
                                intent.putExtra("userDate", userDate);
                                intent.putExtra("userEmail", userEmail);
                                intent.putExtra("userHeight", userHeight);
                                intent.putExtra("userWeight", userWeight);
                                intent.putExtra("userETC", userETC);
                                intent.putExtra("userBMI", userBMI);
                                startActivityForResult(intent, CALL_BACK);

                            } else {
                                Toast.makeText(getApplicationContext(), "수정에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                //updaterequest 호출
                MainUpdateRequest mainUpdateRequest = new MainUpdateRequest(userMemo, userDate, userEmail, userHeight, userWeight, userETC, responseListener);
                RequestQueue queue = Volley.newRequestQueue(home.this);
                queue.add(mainUpdateRequest);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){

            @Override

            public boolean onNavigationItemSelected (MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.mbtn1) {
                    Intent Intent1 = new Intent(home.this, liv0.class);
                    String userMemo = memo.getText().toString();
                    String userDate = dateText.getText().toString();
                    String userWeight = weight.getText().toString();
                    String userETC = etc.getText().toString();
                    String userBMI = bmi.getText().toString();
                    String userHeight = height.getText().toString();
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
                    Intent Intent2 = new Intent(home.this, liv.class);
                    String userMemo = memo.getText().toString();
                    String userDate = dateText.getText().toString();
                    String userWeight = weight.getText().toString();
                    String userETC = etc.getText().toString();
                    String userBMI = bmi.getText().toString();
                    String userHeight = height.getText().toString();
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
                    Intent Intent3 = new Intent(home.this, liv2.class);
                    String userMemo = memo.getText().toString();
                    String userDate = dateText.getText().toString();
                    String userWeight = weight.getText().toString();
                    String userETC = etc.getText().toString();
                    String userBMI = bmi.getText().toString();
                    String userHeight = height.getText().toString();
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
                    Intent Intent4 = new Intent(home.this, liv3.class);
                    String userMemo = memo.getText().toString();
                    String userDate = dateText.getText().toString();
                    String userWeight = weight.getText().toString();
                    String userETC = etc.getText().toString();
                    String userBMI = bmi.getText().toString();
                    String userHeight = height.getText().toString();
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

        //메뉴네비게이션

//        dateText = findViewById(R.id.datetext);


//        SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd");
//        String dtext = format.format(Calendar.getInstance().getTime());
//        dateText.setText("Today\n" + dtext);

        //현재날짜

        Button datePickerBtn = findViewById(R.id.calendar);
        datePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();
                int pYear = calendar.get(Calendar.YEAR);
                int pMonth = calendar.get(Calendar.MONTH);
                int pDay = calendar.get(Calendar.DAY_OF_MONTH);


                DecimalFormat decimalFormat = new DecimalFormat("00");

                datePickerDialog = new DatePickerDialog(home.this, R.style.DatePickerDialogTheme,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                                month = month + 1;
                                String date = year + "/" + month + "/" + day;

                                dateText.setText(date);
//                                  dateText.setText(String.format("%d/%d/%d", pYear, pMonth + 1, pDay));


                            }
                        },
                        pYear, pMonth, pDay);
                datePickerDialog.show();
            } //달력
        });

        // 달력

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottombar);
        bottomNavigationView.setItemIconTintList(null);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.tab1) {
                    Intent Intent1 = new Intent(home.this, cal_dic.class);
                    String userMemo = memo.getText().toString();
                    String userDate = dateText.getText().toString();
                    String userWeight = weight.getText().toString();
                    String userETC = etc.getText().toString();
                    String userBMI = bmi.getText().toString();
                    String userHeight = height.getText().toString();
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
                    Intent Intent2 = new Intent(home.this, home.class);
                    String userMemo = memo.getText().toString();
                    String userDate = dateText.getText().toString();
                    String userWeight = weight.getText().toString();
                    String userETC = etc.getText().toString();
                    String userBMI = bmi.getText().toString();
                    String userHeight = height.getText().toString();
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
                    Intent Intent3 = new Intent(home.this, checklist.class);
                    String userMemo = memo.getText().toString();
                    String userDate = dateText.getText().toString();
                    String userBMI = bmi.getText().toString();
                    String userWeight = weight.getText().toString();
                    String userETC = etc.getText().toString();
                    String userHeight = height.getText().toString();
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
                    Intent Intent4 = new Intent(home.this, mypage.class);
                    String userMemo = memo.getText().toString();
                    String userDate = dateText.getText().toString();
                    String userWeight = weight.getText().toString();
                    String userETC = etc.getText().toString();
                    String userBMI = bmi.getText().toString();
                    String userHeight = height.getText().toString();
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
        //하단바

        lineChart = (LineChart) findViewById(R.id.linechart);

        ArrayList<Entry> chart = new ArrayList<>();

        LineData chartData = new LineData();

        chart.add(new Entry(1, 60));
        chart.add(new Entry(2, 59));
        chart.add(new Entry(3, 58));
        chart.add(new Entry(4, 57));
        chart.add(new Entry(5, 58));
        chart.add(new Entry(6, 56));

        LineDataSet lineDataSet1 = new LineDataSet(chart, "몸무게");

        lineDataSet1.setColor(Color.parseColor("#465AB4"));
        lineDataSet1.setLineWidth(3);
        lineDataSet1.setDrawCircles(false);
        lineDataSet1.setValueTextSize(9);


        chartData.addDataSet(lineDataSet1);

        lineChart.setData(chartData); // 차트에 DataSet을 넣음

        lineChart.invalidate(); // 차트 업데이트
        lineChart.setTouchEnabled(false);

        //차트
    }
}