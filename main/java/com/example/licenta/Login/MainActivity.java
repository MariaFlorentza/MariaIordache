package com.example.licenta.Login;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.licenta.AddActivityMenu;
import com.example.licenta.CreateAccountActivity;
import com.example.licenta.R;
import com.example.licenta.WelcomeActivity;
import com.example.licenta.database.DatabaseHelper;
import com.example.licenta.util.Car;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabAdd;

    private ActivityResultLauncher<Intent> addLauncher;

    private final List<Car> cars = new ArrayList<>();
    private EditText usernameField;
    private EditText passwordField;
    private Button loginBtn;
    private Button btnLog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

    }

    private void initComponents() {
        fabAdd = findViewById(R.id.main_fab_add);
        fabAdd.setOnClickListener(getAddEvent());
        usernameField = findViewById(R.id.username_field);
        passwordField = findViewById(R.id.password_field);
        loginBtn = findViewById(R.id.login_button);
        btnLog = findViewById(R.id.btn_log);
        btnLog.setOnClickListener(getCreateEvent());

        loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String username = usernameField.getText().toString();
                String password = passwordField.getText().toString();
                DatabaseHelper dbHelper = new DatabaseHelper(this);
                if(dbHelper.checkUser(username, password)) {
                    Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Nume de utilizator si parola incorecte.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
            }
    private View.OnClickListener getCreateEvent() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CreateAccountActivity.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener getAddEvent() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddActivityMenu.class);
                startActivity(intent);
            }
        };
    }
}