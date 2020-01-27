package com.example.bluecloudmedicalclinic.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HP on 12/24/2019.
 */

public class SQLiteLoginHelper extends SQLiteOpenHelper {

    private  Context context;

    private static final String DATABASE_NAME ="Bluecloud.db";

//    private static  final String DATABASE_NAME= "Bluecloud_medical.db";

    private static final int DATABASE_VERSION = 1;

    private static  final String TABLE_NAME_LOGIN = "login_Table";

    private static  final String TABLE_NAME_CREATE_PROFILE = "Create_Profile_Table";

    private static final String COLUMN_ID = "id";

    private static  final String COLUMN_USERNAME = "username";

    private static  final String COLUMN_PASSWORD = "password";

    private static final String COLUMN_USER_TYPE = "user_type";



    public SQLiteLoginHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME_LOGIN + "("
                + COLUMN_ID + "INTEGER PRIMARY KEY," +
                COLUMN_USERNAME + "VARCHAR,"
                + COLUMN_PASSWORD + "VARCHAR,"
                + COLUMN_USER_TYPE + "VARCHAR" + ")";

        db.execSQL(CREATE_TABLE);


//                                      Table For Login
//        try {
//
//            db.execSQL("CREATE TABLE" + TABLE_NAME_LOGIN + "(" +
//                        "username VARCHAR," +
//                         "password VARCHAR," +
//                         "user_type VARCHAR)"
//            );
//
//
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }

//                                  Create Profile Table
//        try {
//
//            db.execSQL("CREATE TABLE" + TABLE_NAME_CREATE_PROFILE + "(" +
//                      "first_name  VARCHAR," +
//                      "last_name VARCHAR," +
//                      "date_of_birth VARCHAR," +
//                      "phone_number VARCHAR," +
//                      "username VARCHAR," +
//                      "password VARCHAR," +
//                      "user_type VARCHAR)"
//
//
//            );
//
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_LOGIN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_CREATE_PROFILE);
        onCreate(db);
    }


//    public void AddUser(String id, String username, String password, String user_type)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_ID, id);
//        values.put(COLUMN_USERNAME, username);
//        values.put(COLUMN_PASSWORD,password);
//        values.put(COLUMN_USER_TYPE, user_type);
//
//        db.insert(TABLE_NAME_LOGIN, null, values);
//        db.close();
//
//    }
//    public boolean Login(String username, String password)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues content_login = new ContentValues();
//        content_login.put(COLUMN_USERNAME, username);
//        content_login.put(COLUMN_PASSWORD, password);
//        long result = db.insert(TABLE_NAME, null, content_login);
//        if(result == -1)
//        {
//            return false;
//        }
//        else
//        {
//            return true;
//        }
//
//    }
//
//    public boolean CheckMail(String username)
//    {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("select * from login_Table where username = ?", new String[]{username});
//        if(cursor.getCount()>0 )
//            return false;
//        else
//            return true;
//    }


//    public Cursor check_duplicates_in_user_credentials(String user_name, String password, String table , String user_type) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor res = null;
//        if (table.equals(TABLE_NAME_LOGIN)) {
//            res = db.rawQuery("select * from " + TABLE_NAME_CREATE_PROFILE + " where username=? and password=?", new String[]{user_name, password});
//        } else if (table.equals(TABLE_NAME_CREATE_PROFILE)) {
//            res = db.rawQuery("select * from " + TABLE_NAME_CREATE_PROFILE + " where username=? and password=?", new String[]{user_name, password});
//
//        }
//
//        return res;
//    }
//
//    public Cursor check_duplicates_in_user_credentials(String user_name, String password, String table) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor res = null;
//        if (table.equals(TABLE_NAME_CREATE_PROFILE)) {
//            res = db.rawQuery("select * from " + TABLE_NAME_CREATE_PROFILE + " where username=? and password=?", new String[]{user_name, password});
//        }
//        return res;
//    }


//    public  boolean insert_user_credentials(String fname, String lname, String dob, String phone_number, String username, String password, String user_type)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("first_name" , fname);
//        contentValues.put("last_name", lname);
//        contentValues.put("date_of_birth", dob);
//        contentValues.put("phone_number", phone_number);
//        contentValues.put("user_type", user_type);
//        contentValues.put("username", username);
//        contentValues.put("password", password);
//
//
//
//        long l = db.insert(TABLE_NAME_CREATE_PROFILE, null, contentValues);
//
//        if (l != -1)
//        {
//            Toast.makeText(context, "New Entry Inserted", Toast.LENGTH_LONG).show();
//            return true;
//        }
//        else
//        {
//            Toast.makeText(context, "Registration Failed", Toast.LENGTH_LONG).show();
//            return false;
//        }
//    }
//

}
