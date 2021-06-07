package kr.ai.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String FILE_NAME = "mydata";
    static final String KEY_NAME = "NAME";
    static final String KEY_AGE = "AGE";

    TextView tvMsg;
    EditText editText;

    RbPreferene myPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPref = new RbPreferene(this);
        // XML로 만들어진 TextView와 소스 연결
        tvMsg = (TextView)findViewById(R.id.textView);
        editText = findViewById(R.id.editTextTextPersonName);
    }

    public void onButtonClicked(View view)
    {
        String str;
        switch(view.getId())
        {
            case R.id.btSave:
                //this.save();
                tvMsg.append("\n save");
                myPref.put(RbPreferene.PREF_KEY_USER, "mydata");
                break;
            case R.id.btRead:
                //this.read();
                tvMsg.append("\n read");
                str = myPref.getBalue(RbPreferene.PREF_KEY_USER, "no");
                tvMsg.append(" " + str);;
                break;
            case R.id.btRemove:
                this.remove();
                tvMsg.append("\n remove");
                break;
            case R.id.btClear:
                this.clear();
                tvMsg.append("\n clear");
                break;
            case R.id.btEdit:
                // editText에서 데이터를 읽어서 tvMsg에 출력
                str = editText.getText().toString();
                tvMsg.append("\n et:" + str);
                break;
        }
    }

    // app sharedPreferences 저장
    private void save()
    {
        // 1. SharedPreference 가져오기
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME, Activity.MODE_PRIVATE);

        // 2. 저장하기 위한 Editor 객체를 생성
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // 3. editor를 이용하여 데이터 저장
        editor.putString(KEY_NAME, "한국it");
        editor.putInt(KEY_AGE, 30);

        // 4. 물리적 저장 (플래쉬에 저장장)
        editor.commit();
    }

    private void read()
    {
        // 1. sharedPreferences 가져오기
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME, Activity.MODE_PRIVATE);

        // 2. sharedPreferences 데이터 읽기
        String data = sharedPreferences.getString(KEY_NAME, "NO DATA");
        int age = sharedPreferences.getInt(KEY_AGE, 0);

        // 3. 확인용으로 (TextView 출력)
    tvMsg.append("name : "+data);
    tvMsg.append("name : "+age);
    }

    private void remove()
    {
        // 1. sharedPreferences 가져오기
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME, Activity.MODE_PRIVATE);

        // 2-1 editor를 가져오기
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // 2-2 삭제 (RAM 적재딘 KEY값 제)
        editor.remove(KEY_NAME);

        // 2-3 물리 저장자이 삭제
        editor.commit();
    }

    private void clear()
    {
        // 1. sharedPreferences 가져오기
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME, Activity.MODE_PRIVATE);

        // 2. saredpreferenes edit 셍성
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.clear();

        // 3. 물리 저장자이 삭제
        editor.commit();
    }

    private void edit()
    {

    }
}