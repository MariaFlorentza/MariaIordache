package com.example.licenta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AddActivityMenu extends AppCompatActivity {
    private Button btn;
    private Button backBtn;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu);

        initComponents();
        intent = getIntent();

    }

    private void initComponents() {
        btn = findViewById(R.id.add_btn);

        btn.setOnClickListener(getButtonEvent());

        backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private View.OnClickListener getButtonEvent() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isValid()) {

                }
            }
        };
    }

    private boolean isValid() {
        if(btn.getText() == null ||
               btn.getText().toString().trim().length()<1) {
            Toast.makeText(getApplicationContext(),
                    "Invalid",
                    Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}