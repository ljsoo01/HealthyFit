package com.example.healthyfit;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;
import org.json.JSONObject;

public class mypage extends AppCompatActivity {
    EditText pw_get;
    TextView name_get;
    Button btn_update, btn_delete;

    private static final int CALL_BACK = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);

        //edittext에 불러온 걸 넣는 부분
        name_get = findViewById(R.id.name);
        pw_get = findViewById(R.id.pw);

        Intent intent = getIntent();

        String userMemo = intent.getStringExtra("userMemo");
        String userDate = intent.getStringExtra("userDate");
        String userEmail = intent.getStringExtra("userEmail");
        String userPw = intent.getStringExtra("userPw");
        String userWeight = intent.getStringExtra("userWeight");
        String userHeight = intent.getStringExtra("userHeight");
        String userBMI = intent.getStringExtra("userBMI");
        String userETC = intent.getStringExtra("userETC");

        name_get.setText(userEmail);
        pw_get.setText(userPw);

        //수정하기 버튼 클릭 시 나타나는 이벤트
        btn_update = findViewById(R.id.mypage);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //받아오기
                String userEmail = name_get.getText().toString();
                String userPw = pw_get.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            //수정 성공
                            if(success){
                                Toast.makeText(getApplicationContext(), "회원 수정에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                String userEmail = jsonObject.getString("userEmail");
                                String userPw = jsonObject.getString("userPw");

                                //수정 성공하면 계속해서 같은 화면>>마이페이지로 전달하는 값도 표현한다고 생각했는데,,
                                Intent intent = new Intent(mypage.this, mypage.class);
                                intent.putExtra("userEmail", userEmail);
                                intent.putExtra("userPw", userPw);
                                startActivityForResult(intent, CALL_BACK);

                            } else {
                                Toast.makeText(getApplicationContext(), "회원 수정에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch(JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                //updaterequest 호출
                UpdateRequest updateRequest = new UpdateRequest(userEmail, userPw, responseListener);
                RequestQueue queue = Volley.newRequestQueue(mypage.this);
                queue.add(updateRequest);

            }

        });



        // 회원 탈퇴 이벤트
        btn_delete = findViewById(R.id.membership);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //호출
                showDialog();
            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottombar);
        bottomNavigationView.setItemIconTintList(null);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.tab1) {
                    Intent Intent1 = new Intent(mypage.this, cal_dic.class);
                    String userEmail = name_get.getText().toString();
                    String userPw = pw_get.getText().toString();
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
                    Intent Intent2 = new Intent(mypage.this, home.class);
                    String userEmail = name_get.getText().toString();
                    String userPw = pw_get.getText().toString();
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
                    Intent Intent3 = new Intent(mypage.this, checklist.class);
                    String userEmail = name_get.getText().toString();
                    String userPw = pw_get.getText().toString();
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
                    //마이페이지에서 마이페이지로 이동할 때도 정보가 유지되도록 하기 위해서!
                    Intent Intent4 = new Intent(mypage.this, mypage.class);
                    String userEmail = name_get.getText().toString();
                    String userPw = pw_get.getText().toString();
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

    // 호출되는 부분
    void showDialog() {
        AlertDialog.Builder delBuilder = new AlertDialog.Builder(this)
                .setTitle("회원탈퇴") //알림창 제목
                .setMessage("탈퇴하시겠습니까?") // 알림창 질문
                .setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) { //'예'를 누르면 생기는 일
                        String userEmail = name_get.getText().toString(); // userEmail, userPw 불러냄
                        String userPw = pw_get.getText().toString();

                        Response.Listener<String> responseListener = new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    boolean success = jsonObject.getBoolean("success");

                                    //탈퇴 성공 시
                                    if (success) {
                                        Toast.makeText(getApplicationContext(), "탈퇴 성공", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(mypage.this, SignupActivity.class); // 탈퇴 성공 시, 회원가입 페이지로 넘어감
                                        startActivity(intent);
                                    } else { //탈퇴 실패 시
                                        Toast.makeText(getApplicationContext(), "탈퇴 실패", Toast.LENGTH_SHORT).show();
                                        return;
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        };
                        DeleteRequest deleteRequest = new DeleteRequest(userEmail, userPw, responseListener);
                        RequestQueue queue = Volley.newRequestQueue(mypage.this);
                        queue.add(deleteRequest);
                    }
                })
                .setNegativeButton("아니오", new DialogInterface.OnClickListener() { //'아니오' 선택
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mypage.this, "취소하였습니다.", Toast.LENGTH_SHORT).show(); //탈퇴 번복
                    }
                });
        AlertDialog msgDlg = delBuilder.create();
        msgDlg.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        mypage.super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case CALL_BACK :
                if(resultCode == RESULT_OK) {
                    String email = data.getStringExtra("userEmail");
                    String passw = data.getStringExtra("userPw");

                    pw_get.setText(passw);
                    name_get.setText(email);
                }
                break;
        }
    }
}
