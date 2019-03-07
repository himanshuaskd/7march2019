package com.example.a7march2019;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button button;
    String s1,s2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user username.getText().toString().trim();
                String pass password.getText().toString().trim());
                if (user.equals(s1) && ;pass.equals(s2))
                {
                    Toast.makeText(MainActivity.this, "user name very good", Toast.LENGTH_SHORT).show();
                }
                else   {
                    Toast.makeText(MainActivity.this, "user name or  password not correct", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences=getSharedPreferences("com.example.a7march2019",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("username",username.getText().toString().trim());
        editor.putString("passwords",password.getText().toString().trim());
        editor.putBoolean("bool",true);
        editor.apply();

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences=getSharedPreferences("com.example.a7march2019",MODE_PRIVATE);
                s1=sharedPreferences.getString("username","pappu");
                s2=sharedPreferences.getString("password","papa");
                Boolean rember=sharedPreferences.getBoolean("bool",false);
                Toast.makeText(this, "bool"+rember, Toast.LENGTH_SHORT).show();
                username.setText(s1);
                password.setText(s2);


    }
}
