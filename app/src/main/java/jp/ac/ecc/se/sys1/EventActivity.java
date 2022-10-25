package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Intent intent =getIntent();
        int age = intent.getIntExtra("age",25);
        //確認
        Toast.makeText(this, "年齢"+age, Toast.LENGTH_SHORT).show();

        TextView textProfile = findViewById(R.id.textProfile);
        EditText nameText = findViewById(R.id.nameText);
        EditText passText = findViewById(R.id.passText);
        Button clearN = findViewById(R.id.clearN);
        Button clearP = findViewById(R.id.clearP);
        CheckBox check10 = findViewById(R.id.check10);
        CheckBox check20 = findViewById(R.id.check20);
        CheckBox check30 = findViewById(R.id.check30);
        RadioButton radioOtoko = findViewById(R.id.radioOtoko);
        RadioButton radioOnna = findViewById(R.id.radioOnna);
        Button kakuninButton = findViewById(R.id.kakuninButton);

        clearN.setOnClickListener(this);
        clearP.setOnClickListener(this);
        kakuninButton.setOnClickListener(this);

        clearP.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                setTitle(passText.getText());
                return false;
            }
        });

        kakuninButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(radioOtoko.isChecked()==true){
                    Toast.makeText(getApplicationContext(), "男", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "女", Toast.LENGTH_SHORT).show();
                }
                finish();//画面消える
                return false;
            }
        });
    }



    @Override
    public void onClick(View view) {
        EditText nameText = findViewById(R.id.nameText);
        EditText passText = findViewById(R.id.passText);
        switch(view.getId()){
            case R.id.clearN:
                nameText.setText("");
                break;
            case R.id.clearP:
                passText.setText("");
                setTitle("練習アプリ");
                break;

            case R.id.kakuninButton:
                Toast.makeText(this,nameText.getText(), Toast.LENGTH_SHORT).show();
                break;

        }
    }
}