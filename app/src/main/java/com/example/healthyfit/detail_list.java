package com.example.healthyfit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class detail_list extends AppCompatActivity {
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
                intent = new Intent(view.getContext(), play_api.class);
                intent.putExtra("number", number);
                startActivity(intent);
            }
        });

        switch(number)
        {
            case 0:
                title.setText(name);
                imageView.setImageResource(R.drawable.level1_1);
                txt.append("\uD83D\uDCCC '댄스 다이어트 끝판왕 체중감량 운동 다이어트 댄스 에어로빅' 운동순서 \n" +
                        "                \n 1. 싸이드 스텝 \n" +
                        "                \n 2. 니 업 \n" +
                        "                \n 3. 킥 & 리치 \n" +
                        "                \n 4. 킥 백 & 풀 다운 \n" +
                        "                \n 5. 싸이드 스텝 & 플라이 \n" +
                        "                \n 6. 엘보우 투 니즈 1 \n" +
                        "                \n 7. 엘보우 투 니즈 2 \n " +
                        "                \n 킥 백 & 풀 \n " +
                        "               \n 워킹 & 푸쉬");
                cal.append("50Kcal");
                break;

            case 1:
                title.setText(name);
                imageView.setImageResource(R.drawable.level1_2);
                txt.append("\uD83D\uDCCC '초보자를 위한 살빠지는 댄스 다이어트' 운동순서" +
                        "                \n 1. 사이드스텝 [워밍업] \n" +
                        "                \n 2. 레그컬 [허벅지살]\n" +
                        "                \n 3. 컬&암레이즈 [팔뚝살/다리살] \n" +
                        "                \n 4. 프론트킥 [허벅지살] \n" +
                        "                \n 5. 킥&암레이즈 [팔뚝살/다리살] \n" +
                        "                \n 6. 하이킥&리치암 [뱃살/전신] \n" +
                        "                \n 7. 텝스텝 [다리살] \n" +
                        "                \n8. 텝스텝&펀치 [상체/다리살] \n" +
                        "                \n9. 텝스텝&어퍼펀치 [상체/다리살] \n" +
                        "                \n10. 텝스텝&스케이트 [다리살/전신] \n" +
                        "                \n11. 텝스텝&딥스케이트 [다리살/전신] \n" +
                        "                \n12. 밸리 밤 [뱃살] \n" +
                        "                \n13. 텝스텝&플라이 [가슴/다리살] \n" +
                        "                \n14. 텝스텝&더블암 [상체/다리살]\n" +
                        "                \n15. 텝스텝&엘보우 [상체/다리살] \n" +
                        "                \n16. 엘보우투니 [옆구리살/뱃살]\n" +
                        "                \n17. 사이드스텝 [쿨다운]");
                cal.append("100Kcal");
                break;

            case 2:
                title.setText(name);
                imageView.setImageResource(R.drawable.level1_3);
                txt.append("\uD83D\uDCCC '왕초보 탈출 - 전신운동 초보 홈트' 운동순서" +
                        "                \n 1. 니 드라이브 \n" +
                        "                \n 2. 킥 백 \n" +
                        "                \n 3. 스쿼트 \n" +
                        "                \n 4. 스탠딩 크런치 \n" +
                        "                \n 5. 레그 드랍 \n" +
                        "                \n 6. 브릿지 \n" +
                        "                \n 7. 니 드라이브 \n " +
                        "                \n 2세트 반복");
                cal.append("70Kcal");
                break;

            case 3:
                title.setText(name);
                imageView.setImageResource(R.drawable.level1_4);
                txt.append("\uD83D\uDCCC '허벅지 안쪽살을 빼고싶다면 이 동작을 해보세요! \n 다리라인이 달라집니다!' 운동순서 \uD83D\uDCCC\n" +
                        "                \n 1. 라잉 어덕터 [허벅지 안쪽살/11자다리/다리 붓기제거]\n" +
                        "                \n 2. 에어 바이시클 [다리전체/11자다리/다리 붓기제거] \n" +
                        "                \n 3. 이너싸이 리프트 [허벅지 안쪽살/11자다리/다리 붓기제거] \n" +
                        "                \n 4. 시저스 크로스 [허벅지 안쪽살/11자다리/다리 붓기제거] \n" +
                        "                \n 5. 레그 드롭스 [허벅지 안쪽살/11자다리/다리 붓기제거] \n" +
                        "                \n 6. 아잉 어덕터 [허벅지 안쪽살/11자다리/다리 붓기제거]");
                cal.append("20Kcal");
                break;

            case 4:
                title.setText(name);
                imageView.setImageResource(R.drawable.level1_5);
                txt.append("\uD83D\uDCCC '층간 소음 걱정 없이 체중 감량 보장! 딱 5분 운동!' \n 운동순서 \uD83D\uDCCC\n" +
                        "                \n 1. 바운스 바운스 \n" +
                        "                \n 2. 상체 트위스트 스텝 \n" +
                        "                \n 3. 크로스 니업 \n" +
                        "                \n 4. 트위스트 크로스 니업 \n" +
                        "                \n 2회 반복");
                cal.append("30Kcal");
                break;
        }
    }
}
