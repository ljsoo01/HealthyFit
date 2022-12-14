package com.example.healthyfit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private EditText user_emailID, user_pw;
    private Button btn_login;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        user_emailID = findViewById(R.id.login_emailID);
        user_pw = findViewById(R.id.login_pw);


        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = user_emailID.getText().toString();
                String userPw = user_pw.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            //로그인 성공 시
                            if(success){
                                Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();

                                String userEmail = jsonObject.getString("userEmail");
                                String userPw = jsonObject.getString("userPw");
                                String userMemo = jsonObject.getString("userMemo");
                                String userDate = jsonObject.getString("userDate");
                                String userWeight = jsonObject.getString("userWeight");
                                String userHeight = jsonObject.getString("userHeight");
                                String userBMI = jsonObject.getString("userBMI");
                                String userETC = jsonObject.getString("userETC");

                                Intent intent = new Intent(LoginActivity.this, home.class);
                                intent.putExtra("userEmail", userEmail);
                                intent.putExtra("userPw", userPw);
                                intent.putExtra("userMemo", userMemo);
                                intent.putExtra("userDate", userDate);
                                intent.putExtra("userHeight", userHeight);
                                intent.putExtra("userWeight", userWeight);
                                intent.putExtra("userBMI", userBMI);
                                intent.putExtra("userETC", userETC);

                                startActivity(intent);
                            }
                            else{ //로그인 실패 시
                                Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT ).show();
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(userEmail, userPw, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });
    }
}