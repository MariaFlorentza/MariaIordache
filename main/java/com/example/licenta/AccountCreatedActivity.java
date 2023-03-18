package com.example.licenta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.licenta.Login.MainActivity;

public class AccountCreatedActivity extends AppCompatActivity {
    private Button btn_created;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_created);

        initComponents();
    }

    private void initComponents() {
        btn_created=findViewById(R.id.btn_created);
        btn_created.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountCreatedActivity.this, MainActivity.class);
                startActivity(intent);
                }
        });
    }


}