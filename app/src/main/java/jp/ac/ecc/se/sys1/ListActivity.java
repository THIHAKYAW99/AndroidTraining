package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        String[] curryList = {"ドライカレー","カツカレー","チーズカレー","スープカレー"};

        Intent preferenceIntent = new Intent(this,PreferencesActivity.class);


        ListView listView = findViewById(R.id.curryList);


        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,curryList);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tv = (TextView)view;
                String st = (String) adapterView.getItemAtPosition(i);
//              Toast.makeText(getApplicationContext(),tv.getText(),Toast.LENGTH_SHORT).show();
//              Toast.makeText(getApplicationContext(),Integer.toString(i),Toast.LENGTH_SHORT).show();
//              Toast.makeText(getApplicationContext(),st,Toast.LENGTH_SHORT).show();
//              Toast.makeText(getApplicationContext(),(String) adapterView.getItemAtPosition(i),Toast.LENGTH_SHORT).show();


                preferenceIntent.putExtra("curry",i);

                startActivity(preferenceIntent);
            }
        });




    }
}