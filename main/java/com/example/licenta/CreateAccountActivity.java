package com.example.licenta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.licenta.database.DatabaseHelper;
import com.example.licenta.util.User;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class CreateAccountActivity extends AppCompatActivity {
    private TextInputEditText tiet_name;
    private TextInputEditText tiet_last_name;
    private TextInputEditText tiet_mail;
    private TextInputEditText tiet_phone;
    private TextInputEditText tiet_username;
    private TextInputEditText tiet_password;
    private Button btn_create;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        initComponents();

//        dbHelper = new DatabaseHelper(this);
//
//
//        dbHelper.addUser(new User("Iordache", "Maria", "mariaflorentza@yahoo.com",
//                "0745906497", "Maria", "Maria2001"));


//        List<User> users = dbHelper.getAllUsers();
//        for (User user : users) {
//            Log.d("MainActivity", "User: " + user.getName() + " " + user.getLast_name() +
//                    " Email" + user.getEmail() + " Phone" + user.getPhone() +
//                    " Username" + user.getUsername() + " Password" + user.getPassword());
//
//
//        }
    }

    private void initComponents() {
        tiet_name = findViewById(R.id.tiet_name);
        tiet_last_name = findViewById(R.id.tiet_last_name);
        tiet_mail = findViewById(R.id.tiet_mail);
        tiet_phone = findViewById(R.id.tiet_phone);
        tiet_username = findViewById(R.id.tiet_user);
        tiet_password = findViewById(R.id.tiet_password);
        String password = tiet_password.getText().toString();
        btn_create = findViewById(R.id.btn_create);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = tiet_name.getText().toString().trim();
                String last_name = tiet_last_name.getText().toString().trim();
                String email = tiet_mail.getText().toString().trim();
                String phone = tiet_phone.getText().toString().trim();
                String username = tiet_username.getText().toString().trim();
                String password = tiet_password.getText().toString().trim();

                DatabaseHelper dbh = new DatabaseHelper(this);
                SQLiteDatabase sqldb = dbh.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(DatabaseHelper.COLUMN_NAME, name);
                values.put(DatabaseHelper.COLUMN_LAST_NAME, last_name);
                values.put(DatabaseHelper.COLUMN_EMAIL, email);
                values.put(DatabaseHelper.COLUMN_PHONE, phone);
                values.put(DatabaseHelper.COLUMN_USERNAME, username);
                values.put(DatabaseHelper.COLUMN_PASSWORD, password);

                long id = sqldb.insert(DatabaseHelper.TABLE_USERS, null, values);
                Toast.makeText(CreateAccountActivity.this, "Utilizatorul a for inregistrat cu succes" + id, Toast.LENGTH_SHORT).show();
                sqldb.close();
//                if (TextUtils.isEmpty(name)) {
//                    tiet_name.setError("Please enter a name");
//                    return;
//                }
//
//                if (TextUtils.isEmpty(last_name)) {
//                    tiet_last_name.setError("Please enter a last_name");
//                    return;
//                }
//
//                if (TextUtils.isEmpty(email)) {
//                    tiet_mail.setError("Please enter a email");
//                    return;
//                }
//
//                if (TextUtils.isEmpty(phone)) {
//                    tiet_phone.setError("Please enter a phone");
//                    return;
//                }
//
//                if (TextUtils.isEmpty(username)) {
//                    tiet_username.setError("Please enter a username");
//                    return;
//                }
//
//                if (TextUtils.isEmpty(password)) {
//                    tiet_password.setError("Please enter a password");
//                    return;
//                }
//
//                if (dbHelper.checkUser(username, password)) {
//                    Toast.makeText(CreateAccountActivity.this, "User already exists", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                // add user to database
//                dbHelper.addUser(tiet_name, tiet_last_name, tiet_mail, tiet_phone, tiet_username, tiet_password);
//
//                Toast.makeText(CreateAccountActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
//                finish();
            }

        });
//        Intent intent = new Intent(CreateAccountActivity.this, AccountCreatedActivity.class);
//
//        startActivity(intent) ;

    }


}
