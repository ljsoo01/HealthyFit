package com.example.healthyfit;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SignupActivity extends AppCompatActivity {
    // signup.xml에 edittext에 준 id 값이랑 button에 준 id
    private EditText emailID, name, pw, sex, birth, height;
    private TextView mTextViewResult;
    private Button logsi, logsign, check_btn;
    private AlertDialog dialog;
    private boolean validate = false;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        //id 찾아서 값 저장
        emailID = findViewById(R.id.emailID);
        name = findViewById(R.id.name);
        pw = findViewById(R.id.pw);
        sex = findViewById(R.id.sex);
        birth = findViewById(R.id.birth);
        height = findViewById(R.id.height);
        mTextViewResult = (TextView)findViewById(R.id.textView_main_result);


        mTextViewResult.setMovementMethod(new ScrollingMovementMethod());

        //로그인 창으로 가게끔
        logsign = findViewById(R.id.logsign);
        logsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        //아이디 중복 체크용
        check_btn = findViewById(R.id.check_btn);
        check_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String userEmail = emailID.getText().toString();
                if (validate) {
                    return; // 검증함
                }

                if (userEmail.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                    dialog = builder.setMessage("이메일을 입력하세요").setPositiveButton("확인", null).create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                                dialog = builder.setMessage("사용할 수 있는 이메일입니다.").setPositiveButton("확인", null).create();
                                dialog.show();
                                emailID.setEnabled(false); //이메일값 고정임
                                validate = true; //검증 완료함
//                                check_btn.setBackgroundColor(getResources().getColor(R.color.colorGray));
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                                dialog = builder.setMessage("이미 존재하는 이메일입니다.").setNegativeButton("확인", null).create();
                                dialog.show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                ValidateRequest validateRequest = new ValidateRequest(userEmail, responseListener);
                RequestQueue queue = Volley.newRequestQueue(SignupActivity.this);
                queue.add(validateRequest);
            }
        });




        //가입하기 버튼 누르면 실행되는 부분
        logsi = findViewById(R.id.logsi);
        logsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = emailID.getText().toString();
                String userName = name.getText().toString();
                String userPw = pw.getText().toString();
                String userGender = sex.getText().toString();
                String userBirth = birth.getText().toString();
                String userHeight = height.getText().toString();


                //이메일 중복체크 확인용
                if (!validate) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                    dialog = builder.setMessage("중복된 이메일이 있는지 확인하세요").setNegativeButton("확인", null).create();
                    dialog.show();
                    return;
                }

                //한 칸이라도 입력 안했을 경우에
                if (userEmail.equals("") || userName.equals("") || userPw.equals("") || userGender.equals("") || userBirth.equals("") || userHeight.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                    dialog = builder.setMessage("모두 입력해주세요.").setNegativeButton("확인", null).create();
                    dialog.show();
                    return;
                }





                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            //회원가입 성공
                            if(success){
                                Toast.makeText(getApplicationContext(), "회원 등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();

                                //가입하면 로그인 화면으로 전환
                                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(getApplicationContext(), "회원 등록에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }

                        } catch(JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                SignupRequest signupRequest = new SignupRequest(userEmail, userName, userPw, userGender, userBirth, userHeight, responseListener);
                RequestQueue queue = Volley.newRequestQueue(SignupActivity.this);
                queue.add(signupRequest);

            }
        });
    }
    

}
