package com.example.restaurant_pos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Restaurant.db";
    public static final String TABLE_EMPLOYEES_NAME = "Employees_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "PHONE_NUMBER";
    public static final String COL_4 = "ADDRESS";
    public static final String COL_5 = "WAGE";
    public static final String COL_6 = "PAYMENT_TYPE";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_EMPLOYEES_NAME +
                "(ID INTEGER PRIMARY KEY, NAME TEXT, PHONE_NUMBER INTEGER, ADDRESS TEXT, WAGE INTEGER, PAYMENT_TYPE TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEES_NAME);
        onCreate(db);
    }

    public boolean insertData (String ID, String Name, String PhoneNumber, String Address,
                               String Wage, String PaymentType){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, ID);
        contentValues.put(COL_2, Name);
        contentValues.put(COL_3, PhoneNumber);
        contentValues.put(COL_4, Address);
        contentValues.put(COL_5, Wage);
        contentValues.put(COL_6, PaymentType);
        long result = db.insert(TABLE_EMPLOYEES_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
}
