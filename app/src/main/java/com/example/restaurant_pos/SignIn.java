package com.example.restaurant_pos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignIn extends AppCompatActivity {

    private EditText ID;
    private Button SignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        ID = (EditText)findViewById(R.id.ID);
        SignIn = (Button) findViewById(R.id.SignInButton);

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String id = ID.getText().toString();
                if (id == "98"){
                    Intent intent = new Intent(SignIn.this, AddEmployee.class);
                    startActivity(intent);
                }
                else{
                    Log.d("bad", "error");
                }

            }
        });
    }
}
