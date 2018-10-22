package com.example.rizvyahmed.phonebook;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    final static String DATABASE_NAME="phonebook";
    final static int DATABASE_VERSION=1;

    final static String TABLE_CONTACT="contact";
    final static String CONTACT_ID="_id";
    final static String CONTACT_NAME="name";
    final static String CONTACT_PHONE="phone";

    final static String QUERY_CREATE_CONTACT= "CREATE TABLE IF NOT EXISTS "+ TABLE_CONTACT +"("+ CONTACT_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+ CONTACT_NAME +" TEXT,"+ CONTACT_PHONE +" TEXT)";

    final static String QUERY_DROP_CONTACT="DELETE TABLE IF EXISTS "+ TABLE_CONTACT ;
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QUERY_CREATE_CONTACT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(QUERY_DROP_CONTACT);

    }
    public long  insertContact(ContactHolder values){
        SQLiteDatabase db=getWritableDatabase();

        ContentValues val=new ContentValues();
        val.put(CONTACT_NAME,values.name);
        val.put(CONTACT_PHONE,values.phone);

       long ret= db.insert(TABLE_CONTACT,null,val);

       return ret;

    }
}
