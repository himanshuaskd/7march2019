package com.example.a7march2019;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences=getSharedPreferences("com.example.a7march2019",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name",editText.getText().toString().trim());
        editor.putBoolean("bool",true);
        editor.apply();

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences=getSharedPreferences("com.example.a7march2019",MODE_PRIVATE);
                String s1=sharedPreferences.getString("name","user");
                Boolean rember=sharedPreferences.getBoolean("bool",false);
                Toast.makeText(this, "bool"+rember, Toast.LENGTH_SHORT).show();
                editText.setText(s1);

    }
}
