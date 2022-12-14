package com.example.healthyfit;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class checklist extends AppCompatActivity{

    public String readDay = null;
    public String str = null;
    public CalendarView calendarView;
    public Button cha_Btn, del_Btn, plus_Btn, ok_Btn;
    public TextView textView2, textView3, name_get;
    public EditText contextEditText, pw_get;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist);

        calendarView = findViewById(R.id.calendarView);
        plus_Btn = findViewById(R.id.plus_Btn);
        del_Btn = findViewById(R.id.del_Btn);
        cha_Btn = findViewById(R.id.cha_Btn);
        ok_Btn = findViewById(R.id.ok_Btn);
        textView2 = findViewById(R.id.textView2);
        contextEditText = findViewById(R.id.contextEditText);


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
                    Intent Intent1 = new Intent(checklist.this, cal_dic.class);
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
                    Intent Intent2 = new Intent(checklist.this, home.class);
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
                    Intent Intent3 = new Intent(checklist.this, checklist.class);
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
                    Intent Intent4 = new Intent(checklist.this, mypage.class);
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





        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)
            {
                plus_Btn.setVisibility(View.VISIBLE);
                contextEditText.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.INVISIBLE);
                cha_Btn.setVisibility(View.INVISIBLE);
                ok_Btn.setVisibility(View.INVISIBLE);
                del_Btn.setVisibility(View.INVISIBLE);
                contextEditText.setText("");
                checkDay(year, month, dayOfMonth);



            }
        });
        plus_Btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                saveDiary(readDay);
                str = contextEditText.getText().toString();
                textView2.setText(str);
                plus_Btn.setVisibility(View.INVISIBLE);
                cha_Btn.setVisibility(View.VISIBLE);
                ok_Btn.setVisibility(View.INVISIBLE);
                del_Btn.setVisibility(View.VISIBLE);
                contextEditText.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.VISIBLE);

                String content = contextEditText.getText().toString();
                byte[] date = readDay.getBytes();

                String dates = new String(date);

                Intent intent = getIntent();

                String userEmail = intent.getStringExtra("userEmail");


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            if(success){
                                Toast.makeText(getApplicationContext(), "할일 등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();


                            } else {
                                Toast.makeText(getApplicationContext(), "할일 등록에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }

                        } catch(JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                checklistRequest checklistRequest = new checklistRequest(userEmail, content, dates, responseListener);
                RequestQueue queue = Volley.newRequestQueue(checklist.this);
                queue.add(checklistRequest);


            }
        });
    }


    public void checkDay(int cYear, int cMonth, int cDay)
    {
        readDay = "" + cYear + "-" + (cMonth + 1) + "" + "-" + cDay + ".txt";
        FileInputStream fis;

        try {
            fis = openFileInput(readDay);

            byte[] fileData = new byte[fis.available()];
            fis.read(fileData);
            fis.close();

            str = new String(fileData);

            contextEditText.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.VISIBLE);
            textView2.setText(str);

            plus_Btn.setVisibility(View.INVISIBLE);
            cha_Btn.setVisibility(View.VISIBLE);
            ok_Btn.setVisibility(View.INVISIBLE);
            del_Btn.setVisibility(View.VISIBLE);


//            String content = contextEditText.getText().toString();
////            contextEditText.setText(str);
////            byte[] date = readDay.getBytes();
////
////            String dates = new String(date);
//
//            Intent intent = getIntent();
//
//            String userEmail = intent.getStringExtra("userEmail");
//
//
//            Response.Listener<String> responseListener = new Response.Listener<String>() {
//                @Override
//                public void onResponse(String response) {
//
//                    try {
//                        JSONObject jsonObject = new JSONObject(response);
//                        boolean success = jsonObject.getBoolean("success");
//
//                        if (success) {
//                            Toast.makeText(getApplicationContext(), "할일 수정에 성공하였습니다.", Toast.LENGTH_SHORT).show();
//
//                        } else {
//                            Toast.makeText(getApplicationContext(), "할일 수정에 실패하였습니다.", Toast.LENGTH_SHORT).show();
//                            return;
//                        }
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            };
//
//            selectRequest selectRequest = new selectRequest(userEmail, content, responseListener);
//            RequestQueue queue = Volley.newRequestQueue(checklist.this);
//            queue.add(selectRequest);






            cha_Btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    contextEditText.setVisibility(View.VISIBLE);
                    textView2.setVisibility(View.INVISIBLE);
                    contextEditText.setText(str);

                    plus_Btn.setVisibility(View.VISIBLE);
                    cha_Btn.setVisibility(View.INVISIBLE);
                    ok_Btn.setVisibility(View.VISIBLE);
                    del_Btn.setVisibility(View.VISIBLE);
                    textView2.setText(contextEditText.getText());

                    String content = contextEditText.getText().toString();
                    String date = readDay.getBytes().toString();

                }
            });

            ok_Btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    saveDiary(readDay);
                    str = contextEditText.getText().toString();
                    textView2.setText(str);
                    contextEditText.setVisibility(View.INVISIBLE);
                    textView2.setVisibility(View.VISIBLE);
                    contextEditText.setText(str);

                    plus_Btn.setVisibility(View.INVISIBLE);
                    cha_Btn.setVisibility(View.VISIBLE);
                    ok_Btn.setVisibility(View.INVISIBLE);
                    del_Btn.setVisibility(View.VISIBLE);
                    textView2.setText(contextEditText.getText());

                    String content = contextEditText.getText().toString();

                    byte[] date = readDay.getBytes();

                    String dates = new String(date);


                    Intent intent = getIntent();

                    String userEmail = intent.getStringExtra("userEmail");


                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                boolean success = jsonObject.getBoolean("success");

                                //수정 성공
                                if (success) {
                                    Toast.makeText(getApplicationContext(), "할일 수정에 성공하였습니다.", Toast.LENGTH_SHORT).show();

//                                    String content = jsonObject.getString("content");
//
//                                    Intent intent = new Intent(checklist.this, checklist.class);
//                                    intent.putExtra("contextEditText", content);

                                } else {
                                    Toast.makeText(getApplicationContext(), "할일 수정에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };

                    todoupdateRequest todoupdateRequest = new todoupdateRequest(userEmail, content, dates, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(checklist.this);
                    queue.add(todoupdateRequest);

                }
            });




            del_Btn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    removeDiary(readDay);
                    textView2.setVisibility(View.INVISIBLE);
                    contextEditText.setText("");
                    contextEditText.setVisibility(View.VISIBLE);
                    plus_Btn.setVisibility(View.VISIBLE);
                    cha_Btn.setVisibility(View.INVISIBLE);
                    del_Btn.setVisibility(View.INVISIBLE);


//                    String content = contextEditText.getText().toString();

                    byte[] date = readDay.getBytes();

                    String dates = new String(date);


                    Intent intent = getIntent();

                    String userEmail = intent.getStringExtra("userEmail");


                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                boolean success = jsonObject.getBoolean("success");

                                if (success) {
                                    Toast.makeText(getApplicationContext(), "삭제 성공", Toast.LENGTH_SHORT).show();
                                    String userMemo = jsonObject.getString("userMemo");
                                    String userDate = jsonObject.getString("userDate");
                                    String userEmail = jsonObject.getString("userEmail");
                                    String userHeight = jsonObject.getString("userHeight");
                                    String userWeight = jsonObject.getString("userWeight");
                                    String userETC = jsonObject.getString("userETC");
                                    String userBMI = jsonObject.getString("userBMI");

                                    Intent intent = new Intent(checklist.this, checklist.class);
                                    intent.putExtra("userMemo", userMemo);
                                    intent.putExtra("userDate", userDate);
                                    intent.putExtra("userEmail", userEmail);
                                    intent.putExtra("userHeight", userHeight);
                                    intent.putExtra("userWeight", userWeight);
                                    intent.putExtra("userETC", userETC);
                                    intent.putExtra("userBMI", userBMI);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(getApplicationContext(), "삭제 실패", Toast.LENGTH_SHORT).show();
                                    return;
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    tododeleteRequest tododeleteRequest = new tododeleteRequest(userEmail, dates, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(checklist.this);
                    queue.add(tododeleteRequest);

                }
            });



            if (textView2.getText() == null)
            {
                textView2.setVisibility(View.INVISIBLE);
                plus_Btn.setVisibility(View.VISIBLE);
                cha_Btn.setVisibility(View.INVISIBLE);
                ok_Btn.setVisibility(View.INVISIBLE);
                del_Btn.setVisibility(View.INVISIBLE);
                contextEditText.setVisibility(View.VISIBLE);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @SuppressLint("WrongConstant")
    public void removeDiary(String readDay)
    {
        FileOutputStream fos;
        try
        {
            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content = "";
            fos.write((content).getBytes());
            fos.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @SuppressLint("WrongConstant")
    public void saveDiary(String readDay)
    {
        FileOutputStream fos;
        try
        {
            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
//            Intent intent = getIntent();
//
//            String userEmail = intent.getStringExtra("userEmail");
            String content = contextEditText.getText().toString();
            fos.write((content).getBytes());
            fos.close();


//            Response.Listener<String> responseListener = new Response.Listener<String>() {
//                @Override
//                public void onResponse(String response) {
//
//                    try {
//                        JSONObject jsonObject = new JSONObject(response);
//                        boolean success = jsonObject.getBoolean("success");
//
//                        if (success) {
//                            Toast.makeText(getApplicationContext(), "할일 수정에 성공하였습니다.", Toast.LENGTH_SHORT).show();
//
//                        } else {
//                            Toast.makeText(getApplicationContext(), "할일 수정에 실패하였습니다.", Toast.LENGTH_SHORT).show();
//                            return;
//                        }
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            };
//
//            selectRequest selectRequest = new selectRequest(userEmail, content, responseListener);
//            RequestQueue queue = Volley.newRequestQueue(checklist.this);
//            queue.add(selectRequest);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}