package kr.ai.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // xml 파일과 java 연결
        CheckBox androidCheckBox = (CheckBox)findViewById(R.id.ckAndroid);
        CheckBox iPhoneCheckBox = (CheckBox)findViewById(R.id.ckiPhone);
        CheckBox windowsCheckBox = (CheckBox)findViewById(R.id.ckWindows);
        CheckBox binnerCheckBox = (CheckBox)findViewById(R.id.ckBinner);


        // 이벤트 등록(체크박스가 변경)
        androidCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked == true)
                {
                    Toast.makeText(getApplicationContext(), "android check", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "android unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });


        iPhoneCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked == true)
                {
                    Toast.makeText(getApplicationContext(), "iphone check", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "iphone unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}