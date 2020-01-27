package com.example.bluecloudmedicalclinic.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HP on 12/24/2019.
 */

public class SQLiteCreateProfileHelper   extends SQLiteOpenHelper {


    private  static final int DATABASE_VERSION = 1;

    private static  final String DATABASE_NAME= "Bluecloud.db";

//    private static  final String DATABASE_NAME= "Bluecloud_medical.db";

//    private static  final String DATABASE_NAME_FOR_NEXUS_EMULATOR = "Bluecloud_medical.db";

   private static  final String TABLE_NAME_CREATE_PROFILE = "Create_Patient_Table";

   private static final String COLUMN_ID = "id";

    private static  final String COLUMN_FIRST_NAME = "first_name";

    private static  final String COLUMN_LAST_NAME = "last_name";

    private static  final String COLUMN_DATE_OF_BIRTH = "date_of_birth";

    public static  final String COLUMN_GENDER = "gender";

   private static  final String COLUMN_MOBILE_NO = "mobile_no";

    private static  final String COLUMN_USERNAME = "email";

    private static  final String COLUMN_PASSWORD = "password";

    private static final String COLUMN_USER_TYPE = "user_type";

    private static final String COLUMN_FEMALE = "female";

    private static final String COLUMN_MALE = "male";



    public SQLiteCreateProfileHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME_CREATE_PROFILE + "("
                + COLUMN_ID + "INTEGER PRIMARY KEY, "
                + COLUMN_FIRST_NAME + " TEXT,"
                + COLUMN_LAST_NAME + " TEXT,"
                + COLUMN_DATE_OF_BIRTH + " VARCHAR,"
                + COLUMN_MOBILE_NO + " VARCHAR,"
                + COLUMN_USERNAME + " VARCHAR, "
                + COLUMN_PASSWORD + " VARCHAR,"
                + COLUMN_USER_TYPE + "VARCHAR,"
                + COLUMN_FEMALE + "VARCHAR,"
                + COLUMN_MALE + "VARCHAR" + ")";

        db.execSQL(CREATE_TABLE);

//        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME_CREATE_PROFILE +"(" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
//                + COLUMN_FIRST_NAME + "TEXT," + COLUMN_LAST_NAME + "TEXT," +
//                COLUMN_DATE_OF_BIRTH + "VARCHAR," + COLUMN_MOBILE_NO + "VARCHAR," +
//                COLUMN_USERNAME + "VARCHAR," + COLUMN_PASSWORD + "VARCHAR," +
//                COLUMN_USER_TYPE + "VARCHAR)";
////                COLUMN_FEMALE + "VARCHAR," + COLUMN_MALE + "VARCHAR )";
//        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_CREATE_PROFILE);
        onCreate(db);
    }

//    public boolean insertData(String first_name, String last_name, String date_of_birth, String mobile_number, String email, String password)
//    {
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COLUMN_FIRST_NAME, first_name);
//        contentValues.put(COLUMN_LAST_NAME, last_name);
//        contentValues.put(COLUMN_DATE_OF_BIRTH, date_of_birth);
//        contentValues.put(COLUMN_MOBILE_NO, mobile_number);
//        contentValues.put(COLUMN_EMAIL, email);
//        contentValues.put(COLUMN_PASSWORD, password);
//
//        long result =  db.insert(TABLE_NAME, null, contentValues);
//
//        if (result == -1)
//        {
//            return false;
//        }
//        else
//        {
//            return true;
//        }
//
//    }


//    public Cursor check_duplicates_in_user_credentials(String email, String password, String table) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor res = null;
//        if (table.equals(TABLE_NAME_CREATE_PROFILE)) {
//            res = db.rawQuery("select * from " + TABLE_NAME_CREATE_PROFILE + " where email=? and password=?", new String[]{email, password});
//        }
//        return res;
//    }

//
//    @Override
//    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.setVersion(DATABASE_VERSION);
//    }
//
//    public Cursor check_duplicates_in_user_credentials(String user_name, String password, String table) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor res = null;
//        if (table.equals(TABLE_NAME_CREATE_PROFILE)) {
//            res = db.rawQuery("select * from " + TABLE_NAME_CREATE_PROFILE + " where email=? and password=?", new String[]{user_name, password});
//        }
//        return res;
//    }


    public boolean checkUser(String email, String password)
    {


        String[] columns =
                {
                        COLUMN_USERNAME, COLUMN_PASSWORD

                };

        SQLiteDatabase db = this.getReadableDatabase();

//        String selectQuery = "Select * from " + TABLE_NAME_CREATE_PROFILE + "where email=? and password =?" ;

        String selection = COLUMN_USERNAME  + " =? " + " and " + COLUMN_PASSWORD + " =? ";


//        String selectionpass = COLUMN_PASSWORD + "=?";


//        String Q = "SELECT * FROM " + TABLE_NAME_CREATE_PROFILE + "where email =? and password=?";

//        String selectionpassword = COLUMN_PASSWORD + " =?";

        String[] selectionArgs = {email, password};

//        Cursor cursor = db.rawQuery(Q,
//                selectionArgs,
//                selection,
//                null
//                );

//        Cursor cursor = db.rawQuery(selectQuery, null);

        Cursor cursor = db.query(TABLE_NAME_CREATE_PROFILE,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null
                );

        int cursorCount = cursor.getCount();
        cursor.close();

        return cursorCount > 0;
    }


}
