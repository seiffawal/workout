package com.example.workout;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static String databaseName="fitnessAppDatabase";

    private String userInfoTableCreation =
            "create table userinfo(username text primary key, "+
                    "password text, "+
                    "age integer, "+
                    "height integer, "+
                    "weight integer, "+
                    "sex text, "+
                    "userloginname text," +
                    "FOREIGN KEY(userloginname) references user(userloginname));";
    private String userTableCreation =
            "create table user(userloginname text primary key, "+
                    "password text);";

    private String mealTableCreation =
            "create table meal(mealName text primary key, "+
                    "mealCalorie integer);";

    private String foodTableCreation =
            "create table food(foodName text primary key, "+
                    "calories integer);";

    private String containsTableCreation =
            "create table contains(foodName text,"+
                    "mealName text," +
                    "FOREIGN KEY(foodName) REFERENCES food (foodName) ," +
                    "FOREIGN KEY(mealName) REFERENCES meal (mealName));";


    private SQLiteDatabase db;
    public MyDatabaseHelper(Context context){
        super(context, databaseName, null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(userInfoTableCreation);
        db.execSQL(userTableCreation);
        db.execSQL(mealTableCreation);
        db.execSQL(foodTableCreation);
        db.execSQL(containsTableCreation);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS userinfo");
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS meal");
        db.execSQL("DROP TABLE IF EXISTS food");
        db.execSQL("DROP TABLE IF EXISTS contains");
        onCreate(db);

    }
}

