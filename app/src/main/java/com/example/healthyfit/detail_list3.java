package com.example.healthyfit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class detail_list3 extends AppCompatActivity {
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
                intent = new Intent(view.getContext(), play_api3.class);
                startActivity(intent);
            }
        });

        switch(number)
        {
            case 0:
                title.setText(name);
                imageView.setImageResource(R.drawable.level3_1);
                txt.append("\uD83D\uDCCC '전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]' 운동순서 \n" +
                        "              1. 레터럴 잭 [전신유산소]                                  \n" +
                        "              2. 스피드 니업 [뱃살/허벅지살] \n" +
                        "              3. 푸쉬 잭 [전신유산소]                             \n" +
                        "              4. 스쿼트&힐터치 [허벅지살] \n" +
                        "              5. 스탠딩 바이시클 [뱃살/옆구리살]                      \n" +
                        "              6. 사이드 점프 [전신유산소]\n" +
                        "              7. 업프론트 잭 [전신유산소]                          \n" +
                        "              8. 슈퍼 스쿼트 [허벅지살/상체] \n" +
                        "              9. 스케이터&리치암 [전신유산소]                        \n" +
                        "              10. 니업&암리치 [뱃살/상하체] \n" +
                        "              11. 스타피쉬 잭 [전신유산소]                   \n" +
                        "              12. 와이드스쿼트&터치 [허벅지살/상체]\n" +
                        "              13. 엑스 잭 [전신유산소] \n" +
                        "              14. TOTAL BODY STRETCH [전신스트레칭]");
                cal.append("250Kcal");
                break;

            case 1:
                title.setText(name);
                imageView.setImageResource(R.drawable.level3_2);
                txt.append("\uD83D\uDCCC '(층간소음 X) 진짜 역대급 20분루틴ㅣ전신올인원 I 힙으뜸 유산소운동' 운동순서\n\n" +
                                "   1. SQUAT + HIGH KNEE TOUCH  \n" +
                                "   2. JUMPING JACK \n" +
                                "   3. ARM WALKING \n" +
                                "   4. PALNK JACK \n" +
                                "   5-1. KNEE TO ELBOW(R) \n" +
                                "   5-2. KNEE TO ELBOW(L) \n" +
                                "   6. BUTT KICK \n" +
                                "   7. SQUAT + FRONT KICK \n" +
                                "   8. REVERSE FLY + HIP EXTENSION \n" +
                                "   9. BURPEES \n" +
                                "   10. MOUNTAIN CLIMBER \n" +
                                "   11. SWIMMING \n" +
                                "   12. HIGH KNEE \n" +
                                "   13. WIDE SQUAT \n" +
                                "   14. SQUAT IN & OUT \n" +
                                "   15. CROSS BODY TOUCH \n" +
                                "   16. [STANDING] TWIST CRUNCH \n" +
                                "   17. AIR BICYCLE \n" +
                                "   18. FLUTTER KICK \n" +
                                "   19. UP/DOWN PLANK \n" +
                                "   20.STRETCH    \n" +
                                "   20-1. SHAKING \n" +
                                "   20-2. REST POSITION");
                cal.append("100Kcal");
                break;

            case 2:
                title.setText(name);
                imageView.setImageResource(R.drawable.level3_3);
                txt.append("\uD83D\uDCCC '살이 너무 빠지는 죽음의 타바타 운동 (no 층간소음)' 운동순서\n" +
                        "                \n 워밍업 \n" +
                        "                \n 1. warmup A-1 4세트 \n" +
                        "                \n 2. warmup B-1 4세트 \n" +
                        "                \n 본 동작 \n" +
                        "                \n 1. MOVE A 4세트 (한 세트 하고 10초 간 휴식)" +
                        "                \n 2. MOVE B 4세트 (한 세트 하고 10초 간 휴식)" +
                        "                \n 3. MOVE C 5세트 (한 세트 하고 10초간 휴식)" +
                        "                \n 4. MOVE D 4세트 (한 세트 하고 10초간 휴식)" +
                        "                \n 5. MOVE E  5세트 (한 세트 하고 10초간 휴식) " +
                        "                \n 6. MOVE F  5세트 (한 세트 하고 10초간 휴식)"+
                        "                \n 7. MOVE G 4세트 (한 세트 하고 10초간 휴식)");
                cal.append("250Kcal");
                break;

            case 3:
            title.setText(name);
            imageView.setImageResource(R.drawable.level3_4);
            txt.append("\uD83D\uDCCC '온몸에 땀 터지는 20분 고강도 전신 운동 루틴' 운동순서 \uD83D\uDCCC\n" +
                    "                \n 1. 암워킹 & 웨이브 푸쉬업 (상체, 코어 강화) x 10번          \n" +
                    "                \n 2. 런지 & 힙 익스텐션 (하체, 코어 강화)  x (한 쪽 다리 당) 20번  \n" +
                    "                \n 3. 니업 (힙업, 코어 강화) (한쪽 다리 당) x 10번 \n" +
                    "                \n 4. 스쿼트 & 트위스드 (하체 옆구라 강화) x 20번 \n" +
                    "                \n 5. 크리스 크로스 (옆구리 코어 강화) x 20번 \n" +
                    "                \n 6. 씨저스 (코어 하체 유연성) x 20번 \n"+
                    "                \n 7. 마운틴 클라이머 (전신 코어 강화) x 20번 \n"+
                    "                \n 2세트 반복 \n");
            cal.append("200Kcal");
            break;

            case 4:
                title.setText(name);
                imageView.setImageResource(R.drawable.level3_5);
                txt.append("\uD83D\uDCCC '앞벅지 볼록, 뒷벅지 셀룰라이트, 허벅지 안쪽살 모조리 불태우고\uD83D\uDD25 \n[여리탄탄 일자 허벅지] 되는 7일 루틴 ' 운동순서 \uD83D\uDCCC\n" +
                        "                \n ROUND 1. STRETCHING \n\n" +
                        "                \n ROUND 2. MAIN A  \n\n" +
                        "                \n ROUND 3. STRETCHING \n\n" +
                        "                \n ROUND 4. MAIN B \n\n" +
                        "                \n ROUND 5. CORE & BALANCE \n\n");
                cal.append("180Kcal");
                break;
        }
    }
}

