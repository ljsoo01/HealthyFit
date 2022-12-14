package com.example.healthyfit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class detail_list2  extends AppCompatActivity {
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
                intent = new Intent(view.getContext(), play_api2.class);
                intent.putExtra("number", number);
                startActivity(intent);
            }
        });

        switch(number)
        {
            case 0:
                title.setText(name);
                imageView.setImageResource(R.drawable.level2_1);
                txt.append("\uD83D\uDCCC 'Lv.4 층간소음없이 딱! 15분 체지방 100% 녹여버리는 루틴' 운동순서 \n" +
                        "                \n 1. 스쿼트 앤 펀치 \n" +
                        "                \n 2. 런치 터치 \n" +
                        "                \n 3. 와이드 스쿼트 앤 런지 \n" +
                        "                \n 4. 백 런지 트위스트 (왼쪽) \n" +
                        "                \n 5. 백 런지 트위스트 (오른쪽) \n" +
                        "                \n 6. 스탠딩 사이드 크런치"+
                        "                \n 7. 트위스트 마운틴 클라이머 \n" +
                        "                \n 8. 플랭크 니업 \n" +
                        "                \n 9. 푸쉬업 앤 스탠드 \n" +
                        "                \n 10. 투 스쿼트 앤 푸쉬업 \n" +
                        "                \n 11. 크로스 런지\n"+
                        "                \n 12. 스쿼트 앤 펀치");
                cal.append("300Kcal");
                break;

            case 1:
                title.setText(name);
                imageView.setImageResource(R.drawable.level2_2);
                txt.append("\uD83D\uDCCC 'Get Abs in 2 WEEKS | Abs Workout Challenge' 운동순서" +
                        "                \n 1. LEG RAISE CLAP \n" +
                        "                \n 2. REVERSE CRUNCH\n" +
                        "                \n 3. SPID- MAN- PLANK \n" +
                        "                \n 4. CROSSBODY MOUNTAIN CLMBER \n" +
                        "                \n 5. RUSSIAN TWIST \n" +
                        "                \n 6. IN & OUT \n" +
                        "                \n 7. PLANK WITH HIP DIPS \n" +
                        "                \n 8. PLANK JACKS \n" +
                        "                \n 9. 100 \n" +
                        "                \n 10. CRUNCH \n" +
                        "                \n 11. UP & DOWN PLANK  \n" +
                        "                \n 12. PLANK \n" +
                        "                \n 13. HEEL TAP \n" +
                        "                \n 14. BLCYCLE CRUNCH\n" +
                        "                \n 15. REVERSE CRUNCH LEG EXTENSION \n" +
                        "                \n 16. STRAIGH LEG CRUNCH \n" +
                        "                \n 17. UP & DOWN PLANK");
                cal.append("180Kcal");
                break;

            case 2:
                title.setText(name);
                imageView.setImageResource(R.drawable.level2_3);
                txt.append("\uD83D\uDCCC '뱃살 아랫뱃살 최고의 운동' 운동순서\n" +
                        "                1. 힙 킥 [복부워밍업] \n" +
                        "                2. 푸시 크런치 [뱃살전체] \n" +
                        "                3. 리버스 크런치 [뱃살전체] \n" +
                        "                4. 크로스 토터치 [뱃살전체]\n" +
                        "                5. 플러터 홀드 [뱃살전체]\n" +
                        "                6. 시저 킥 [뱃살전체]\n" +
                        "                7. 싱글 드롭스 [뱃살전체] \n" +
                        "                8. 크런치 홀드 [뱃살전체]\n" +
                        "                9. 플러터 킥 [뱃살전체]\n" +
                        "                10. 복부스트레칭 [TOTAL ABS STRETCH] \n");
                cal.append("170Kcal");
                break;

            case 3:
                title.setText(name);
                imageView.setImageResource(R.drawable.level2_4);
                txt.append("\uD83D\uDCCC '승마살, 힙딥, 피치힙! 한방에 해결! \n 애플힙 일등공신 소미핏 중둔근운동! \n (한번만해도 효과보장!)' 운동순서 \uD83D\uDCCC\n \n" +
                        "      1.Fire hydrant pulse \n" +
                        "      2. Side cross L \n" +
                        "      3. Side Cross R \n" +
                        "      4. Side & Backraise\n" +
                        "      5. Side Raise Kick\n" +
                        "      6. Side Holding Bounce\n" +
                        "      7. Side-lying one-leg raise R \n" +
                        "      8. Side Lying One-Leg Kick R\n" +
                        "      9. Side Lying One-Leg Bike R \n" +
                        "      10. Side Lying One Leg Raise L\n" +
                        "      11. Side Lying One-Leg Kick L\n" +
                        "      12. Side Lying One-Leg Bike L \n" +
                        "      13. Lying fest-down leg bounce & Caesars");
                cal.append("120Kcal");
                break;

            case 4:
                title.setText(name);
                imageView.setImageResource(R.drawable.level2_5);
                txt.append("\uD83D\uDCCC '\uD83D\uDD25출렁이는 팔뚝살\uD83D\uDD25빨리 빼려면 1달만 이 루틴하세요.(팔뚝살빼는운동/팔뚝살 빨리 빼는법/팔뚝살 완전 제거 운동)' \uD83D\uDCCC\n \n" +
                        "      총 13가지의 운동 동작");
                cal.append("120Kcal");
                break;
        }
    }

}

