package kr.ai.a0524_listdb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    MyDB myDB;
    public static final String TAG = "MYDB";

    EditText edInsert;
    EditText edDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        edInsert = findViewById(R.id.edInsert);
        edDel = findViewById(R.id.edDelete);

        textView.setText("start");

        // db 사용하기위한 (db 글래스 생성)
        myDB = new MyDB(this);
        myDB.open();
    }

    public void onButtonClicked(View view)
    {
        switch (view.getId())
        {
            case R.id.btnInsert:
                dbPrint("INSERT ()");
                myDB.insert("Banana", 23);
                break;
            case R.id.btnSelect:
                dbPrint("SELECT ()");
                Cursor cursor = myDB.selectAll();

                while(cursor.moveToNext())
                {
                    String name = cursor.getString(cursor.getColumnIndex(MyDB.TablePerson.NAME));

                    int age = cursor.getInt(cursor.getColumnIndex(MyDB.TablePerson.AGE));
                    dbPrint(name + ", " + age);
                }

                /*
                * for(int i = 0; i != cursor.getCount(); ++i)
                {
                    cursor.moveToNext();
                    String name = cursor.getString(0);
                    int age = cursor.getInt(1);
                    dbPrint(name + ", " + age);
                }
                *
                * */

                break;
            case R.id.btnDelete:
                dbPrint("DELETE ()");
                myDB.deleteName("Lana");
                break;

            case R.id.btnInsertName:
                dbPrint("MANUAL INSERT NAME ()");
                // ed 값 읽어오기
                String name = edInsert.getText().toString();
                // db 저장하기
                myDB.insert(name, 0);
                break;
            case R.id.btnDelName:
                myDB.deleteName(edDel.getText().toString());
                break;
        }
    }

    private void dbPrint(String msg)
    {
        textView.setText(msg);
        Log.i(TAG ,msg);
    }
}