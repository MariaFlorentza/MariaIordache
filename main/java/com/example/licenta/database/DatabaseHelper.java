package com.example.licenta.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "users.db";
    public static final String TABLE_USERS = "users";
    private static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_LAST_NAME = "last_name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";



    public DatabaseHelper(View.OnClickListener context) {
        super((Context) context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " +
                TABLE_USERS + "(" +
                COLUMN_ID + "INTEGER PRIMARY KEY, " +
                COLUMN_NAME + "TEXT, " +
                COLUMN_LAST_NAME + "TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_PHONE + " TEXT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT" + ")";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    public SQLiteDatabase openDatabase() throws SQLException {
        SQLiteDatabase db = this.getWritableDatabase();

        return db;
    }

//    public boolean addUser(User user) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_NAME, user.getName());
//        values.put(COLUMN_LAST_NAME, user.getLast_name());
//        values.put(COLUMN_EMAIL, user.getEmail());
//        values.put(COLUMN_PHONE, user.getPhone());
//        values.put(COLUMN_USERNAME, user.getUsername());
//        values.put(COLUMN_PASSWORD, user.getPassword());
//
//        long insert = db.insert(TABLE_USERS, null, values);
//        db.close();
//        return true;
//    }

    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

         Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username = ? AND password= ?",
                 new String[] {username, password});

         int count = cursor.getCount();

         cursor.close();
         db.close();

         if(count >0) {
             return true;
         }else {
             return false;
         }

    }

    public void addUser(TextInputEditText tiet_name, TextInputEditText tiet_last_name, TextInputEditText tiet_username, TextInputEditText tiet_password, TextInputEditText tietUsername, TextInputEditText tietPassword) {
    }

//    public List<User> getAllUsers() {
//        List<User> userList = new ArrayList<User>();
//        for (User user : users) {
//            userList.add(user);
//        }
//        return userList;
//    }
}
    


//    public User authenticateUser(TextInputEditText tiet_name, TextInputEditText tiet_last_name, TextInputEditText tiet_mail, TextInputEditText tiet_phone, TextInputEditText tiet_username, TextInputEditText tiet_password) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query(TABLE_USERS, new String[]{COLUMN_NAME, COLUMN_LAST_NAME, COLUMN_EMAIL, String.valueOf(COLUMN_PHONE), COLUMN_USERNAME, COLUMN_PASSWORD},
//                COLUMN_USERNAME + "=? AND" + COLUMN_PASSWORD + "=?", new String[]{String.valueOf(tiet_username), String.valueOf(tiet_password)}, null, null, null);
//        if (cursor != null && cursor.moveToFirst()) {
//            User user = new User(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getLong(4), cursor.getString(5), cursor.getString(6));
//            cursor.close();
//            return user;
//        }
//        return null;
//    }
//
//    public List<User> getAllUsers() {
//        List<User> users = new ArrayList<>();
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        String query = "SELECT * FROM " + TABLE_USERS;
//
//
//        SQLiteDatabase dbs = this.getWritableDatabase();
//
//        String[] columns = {"name", "last_name", "email", "phone", "username", "password"};
//
//        String selection = "username=? AND password=?";
//
//        String[] selectionArgs = {COLUMN_USERNAME, COLUMN_PASSWORD};
//
//        Cursor cursor = db.query("users", columns, selection, selectionArgs, null, null, null);
//
//        if (cursor.moveToFirst()) {
//            // autentificare cu succes
//        } else {
//            // autentificare eșuată
//        }
//        cursor.close();
//
//        return users;
//    }

