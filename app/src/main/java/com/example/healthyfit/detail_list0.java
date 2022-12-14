package com.example.healthyfit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class detail_list0 extends AppCompatActivity {
    private Intent intent;
    private int number;
    private String name;
    private ImageView imageView;
    private TextView txt, title, cal;
    private Button btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex_detail);

        intent = getIntent();
        number = intent.getIntExtra("number", -1);
        name = intent.getStringExtra("name");

        title = findViewById(R.id.ex_detail_title);
        imageView = findViewById(R.id.ex_detail_img);
        txt = findViewById(R.id.ex_detail_txt);
        cal = findViewById(R.id.ex_detail_cal);

        btn = findViewById(R.id.play);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(view.getContext(), play_api0.class);
                intent.putExtra("number", number);
                startActivity(intent);
            }
        });

        switch(number)
        {
            case 0:
                title.setText(name);
                imageView.setImageResource(R.drawable.level0_1);
                txt.append("\uD83D\uDCCC'날씬바디 붓기제거 전신 스트레칭' 순서\uD83D\uDCCC\n" +
                                "1. 승모근 스트레칭                 \n" +
                                "2. 어깨/팔 스트레칭\n" +
                                "3. 상체/등 스트레칭     \n" +
                                "4. 옆구리 스트레칭\n" +
                                "5. 허리/복근 스트레칭                 \n" +
                                "6. 상하체 시원하게 풀어주는 스트레칭\n" +
                                "7. 하체/골반 시원한 스트레칭 (좌)                    \n" +
                                "8. 하체/골반 시원한 스트레칭 (우)\n" +
                                "9. 골반/힙/종아리 스트레칭 (좌)\n" +
                                "10. 하체/골반 스트레칭 (좌)\n" +
                                "11. 골반/힙/종아리 스트레칭 (우)\n" +
                                "12. 하체/골반 스트레칭 (우)\n" +
                                "13. 전신을 시원하게 풀어주는 스트레칭                            \n" +
                                "14. 종아리알 스트레칭\n" +
                                "15. 전신을 시원하게 풀어주는 스트레칭");
                cal.append("10Kcal");
                break;

            case 1:
                title.setText(name);
                imageView.setImageResource(R.drawable.level0_2);
                txt.append("\uD83D\uDCCC '운동 전 최고의 스트레칭! \n10분만 따라해도 운동효과 대박!'\uD83D\uDCCC \n" +
                        "          운동 전 10분 스트레칭");
                cal.append("10Kcal");
                break;
        }
    }
}
