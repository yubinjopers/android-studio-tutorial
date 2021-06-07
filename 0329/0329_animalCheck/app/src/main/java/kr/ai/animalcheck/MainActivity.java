package kr.ai.animalcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView readyTxt, pickerTxt;
    CheckBox startNowButton;
    RadioGroup radioGroup;
    RadioButton cockatooBtn, kittenBtn, grandpadogBtn;
    Button goBtn;
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // XML과 JAVA연결
        readyTxt = findViewById(R.id.readyTxt);
        pickerTxt = findViewById(R.id.pickerTxt);

        startNowButton = findViewById(R.id.startNowButton);

        radioGroup = findViewById(R.id.radioGroup);
        cockatooBtn = findViewById(R.id.cockatooBtn);
        kittenBtn = findViewById(R.id.kittenBtn);
        grandpadogBtn = findViewById(R.id.grandpadogBtn);

        goBtn = findViewById(R.id.goBtn);
        pic = findViewById(R.id.pic);

        //checkBox가 check되면 라디오버튼/버튼/이미지 보여주기
        //checkbox가 check상태 변경의 이벤트 등록
        startNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check 확인
                if(startNowButton.isChecked())
                {
                    pickerTxt.setVisibility((View.VISIBLE));
                    radioGroup.setVisibility(View.VISIBLE);
                    goBtn.setVisibility(View.VISIBLE);
                    //pic.setVisibility(View.VISIBLE);
                }
                else
                {
                    pickerTxt.setVisibility((View.INVISIBLE));
                    radioGroup.setVisibility(View.INVISIBLE);
                    goBtn.setVisibility(View.INVISIBLE);
                    //pic.setVisibility(View.INVISIBLE);
                }
            }
        });

        // 라디오 버튼 선택 후 DONE 버튼을 누르면 이미지 변경
        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 라디오 버튼 선택 확인
                // 1.라디오 그룹에서 체크 확인
                switch (radioGroup.getCheckedRadioButtonId())
                {
                    case R.id.cockatooBtn:
                        // pic의 이미지 변경
                        pic.setVisibility(View.VISIBLE);
                        pic.setImageResource(R.drawable.cockatoo);
                        break;
                    case R.id.kittenBtn:
                        pic.setVisibility(View.VISIBLE);
                        pic.setImageResource(R.drawable.kitten);
                        break;
                    case R.id.grandpadogBtn:
                        pic.setVisibility(View.VISIBLE);
                        pic.setImageResource(R.drawable.grandpadog);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Select a friend!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}