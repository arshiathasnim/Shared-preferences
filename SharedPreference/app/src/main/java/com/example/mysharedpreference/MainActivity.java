package com.example.mysharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText key;
    EditText val;
    Button store;
    Button show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        key=(EditText)findViewById(R.id.name);
        val=(EditText)findViewById(R.id.roll_no);
        store=(Button)findViewById(R.id.store);
        show=(Button)findViewById(R.id.show);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=getSharedPreferences("test",MODE_PRIVATE);
                SharedPreferences.Editor edit=sp.edit();
                edit.putString(key.getText().toString(),val.getText().toString());
                edit.commit();
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=getSharedPreferences("test",MODE_PRIVATE);
                String value=sp.getString(key.getText().toString(),"not exists");
                val.setText(value);
            }
        });
    }
}
