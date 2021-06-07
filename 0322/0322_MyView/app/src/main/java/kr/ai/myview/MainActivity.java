package kr.ai.myview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNum1;
    EditText etNum2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // activity_main.xml의 editText와 연결
        etNum1 = findViewById(R.id.etNumber);
        etNum2 = findViewById(R.id.etNumber2);
        textView = findViewById(R.id.textView);
    }

    public void onButtonClicked(View view)
    {
        String num1, num2;
        Integer res;
        Double resD;

        switch (view.getId())
        {
            case R.id.btAdd:
                //etNumber 입력된 값 읽기
                num1 = etNum1.getText().toString();
                num2 = etNum2.getText().toString();
                res = Integer.parseInt(num1) + Integer.parseInt(num2);

                // 결과
                textView.setText("= " + res.toString());
                break;

            case R.id.btSub:
                // 입력값 읽어 오기
                num1 = etNum1.getText().toString();
                num2 = etNum2.getText().toString();
                res = Integer.parseInt(num1) - Integer.parseInt(num2);

                // 결과
                textView.setText("= " + res.toString());
                break;

            case R.id.btMul:
                // 입력값 읽어오기
                num1 = etNum1.getText().toString();
                num2 = etNum1.getText().toString();
                res = Integer.parseInt(num1) * Integer.parseInt(num2);

                // 결과
                textView.setText("= " + res.toString());
                break;

            case R.id.btDiv:
                // 입력값 읽어오기
                num1 = etNum1.getText().toString();
                num2 = etNum2.getText().toString();
                resD = Double.parseDouble(num1) / Double.parseDouble(num2);

                // 결과
                textView.setText("= " + resD.toString());
                break;
        }
    }
}